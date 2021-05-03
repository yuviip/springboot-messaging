package springbootmessaging.rabbitmq;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import springbootmessaging.message.Message;
import springbootmessaging.message.MessageService;

@Component
public class MessageListener {
	
	@RabbitListener(queues = RabbitMQConfig.QUEUE)
	public void listener(String messageXml) {
		JSONObject messageJson = XML.toJSONObject(messageXml);
		Message message = new Message(messageJson.getString("id"), messageJson.getString("name"), messageJson.getString("message"));
		System.out.println("got new message: " + message);
		MessageService.addMessage(message);
	}
	

}
