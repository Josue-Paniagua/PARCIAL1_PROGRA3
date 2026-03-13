package rabbit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import model.Transaccion;
public class RabbitProducer {
	
	public static void enviarMensaje(String cola, String mensaje) throws Exception{
		
		
		
		Connection connection = RabbitConnection.getConnection();
		
		Channel channel =  connection.createChannel();
		channel.basicQos(1);
		channel.queueDeclare(cola, true, false, false, null);
		channel.basicPublish("", cola, null, mensaje.getBytes());
		
		System.out.println("Mensaje enviado a cola  "+ cola);
		
		channel.close();
		connection.close();
			
	
		
	}
		
	
	
}
