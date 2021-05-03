package springbootmessaging.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import springbootmessaging.message.Message;
import springbootmessaging.message.MessageService;
import springbootmessaging.rabbitmq.RabbitMQConfig;

@RestController
public class ConsumerController {
	
	@Autowired
	private MessageService MessageService;

	@RequestMapping("/messages")
	public List<Message> getAllTopics() {
		return MessageService.getAllTopics();
	}
	
	@RequestMapping("/messages/{id}")
	public Message getTopic(@PathVariable String id) {
		return MessageService.getTopic(id);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/messages/{id}")
	public void updateTopic(@RequestBody Message message, @PathVariable String id) {
		MessageService.updateTopic(id, message);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/messages/{id}")
	public void deleteTopic(@PathVariable String id) {
		MessageService.deleteTopic(id);
	}
	
}
