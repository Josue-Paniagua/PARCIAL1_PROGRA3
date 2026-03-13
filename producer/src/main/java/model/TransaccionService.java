package model;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import rabbit.RabbitProducer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;



public class TransaccionService {

	private static final Logger logger = LogManager.getLogger(TransaccionService.class);

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

			TransaccionService service = new TransaccionService();
			String json = service.obtenerTransacciones();
			logger.info(json);
			
			ObjectMapper mapper = new ObjectMapper();

			Root datos = mapper.readValue(json, Root.class);

			for(Transaccion t : datos.transacciones) {
			
				String banco = t.getBancoDestino();
				t.setNombre("Josue David Paniagua Olivares");
		 		t.setCarnet("0905-24-6495");
				t.setCorreo("jpaniaguao@miumg.edu.gt");
				
				logger.info("Banco: " + t.getBancoDestino());
				logger.info("Monto: " + t.getMonto());
				
				    
					String mensaje = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(t);
					RabbitProducer.enviarMensaje(banco, mensaje);
 
				    	
				    
			}
	}
	
	public String obtenerTransacciones()throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        
        HttpRequest request = HttpRequest.newBuilder()
        		.uri(URI.create("https://hly784ig9d.execute-api.us-east-1.amazonaws.com/default/transacciones"))
        		.GET()
        		.build();
        
        HttpResponse<String> response =
        		client.send(request, HttpResponse.BodyHandlers.ofString());
			 return response.body ();
		
	}


}