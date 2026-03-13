package rabbit;

import java.net.http.HttpClient;
import java.time.Duration;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
public class RabbitConnection {
	
	
	public static Connection getConnection() throws Exception{
		ConnectionFactory factory = new ConnectionFactory();
		
		factory.setHost("localhost");
		factory.setUsername("guest");
		factory.setPassword("guest")
		;
		
		return factory.newConnection()
;		
		
	}

}
