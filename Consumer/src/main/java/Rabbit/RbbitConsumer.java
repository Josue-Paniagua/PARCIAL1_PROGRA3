package Rabbit;

import java.net.URI;
import com.rabbitmq.client.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger; 

import com.rabbitmq.client.Channel;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.HashSet;
import java.util.Set;



public class RbbitConsumer {
	
	
	private static Set<String> idProcesado = new HashSet<>();

	private static final Logger logger = LogManager.getLogger(RbbitConsumer.class);
	private static final HttpClient client = HttpClient.newBuilder()
			.connectTimeout(Duration.ofSeconds(10))
			.build();
	
	public static void main(String[] args) throws Exception{
		
		String [] colas = {"BI","BANRURAL", "GYT", "BAC"};
		
		
		
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		chanel.queueDeclare("cola_duplicados", true, false , false, null)
		
			
		logger.info("Espernado los mensajes....");
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {

		String mensaje = new String(delivery.getBody(), "UTF-8");
		logger.info("MENSAJE RECIBDO : " + mensaje);
		
		boolean enviado = enviarPOST(mensaje);
		if (!enviado) {
			
			logger.info("Primer intento fallido ");
			for (int i = 0; i<2; i++) {
				logger.info("REINTENTANDO..." + (i+1) + "..");
				enviado = enviarPOST(mensaje);
				if (enviado) break;
			}
		}
		if (enviado) {
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
        	logger.info("Mensaje confirmado (ACK)");
        } else {
        	logger.info("No se pudo procesar tras reintentos. El mensaje se queda en la cola.");
            channel.basicNack(delivery.getEnvelope().getDeliveryTag(), false, true);
        
        }
    };
		
    for (String cola: colas) {
    	channel.queueDeclare(cola,true,false,false, null);
    	channel.basicConsume(cola, false,deliverCallback,consumerTag ->{});
    	
    	}
	
	}	

		//try catch para mandar los reusltado a la API
		
		public static boolean enviarPOST(String jsonMensaje) {
		try {
			
					
			 HttpRequest request = HttpRequest.newBuilder()
                     .uri(URI.create("https://7e0d9ogwzd.execute-api.us-east-1.amazonaws.com/default/guardarTransacciones"))
                     .header("Content-Type", "application/json")
                     .POST(HttpRequest.BodyPublishers.ofString(jsonMensaje))
                     .build();

             HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

         	logger.info("Respuesta API: ");

             if (response.statusCode() == 200 || response.statusCode() == 201) {

            	 logger.info("API: TRANSACCION GUARDADA CORRECTAMENTE");
                 return true;

             } else {

            	 logger.info("Error en API, mensaje no confirmado");
                 return false;

             }

         } catch (Exception e) {

        		logger.info("Error enviando POST");
             e.printStackTrace();
             return false;
        
         }
		
		}
		
}	
	