package springbootmessaging.controllers;


import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springbootmessaging.message.Message;
import springbootmessaging.message.MessageService;
import springbootmessaging.rabbitmq.RabbitMQConfig;

@RestController
public class ProducerController {
	
	@Autowired
	private RabbitTemplate template;
	
	@PostMapping("/addMessage")
	public String addMessage(@RequestBody Message message) {
		message.setId(UUID.randomUUID().toString());
		template.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, message.xml());
		System.out.println("new message has uploaded: " + message);
		return "Message Added Sccessfully";
	}
	

}
