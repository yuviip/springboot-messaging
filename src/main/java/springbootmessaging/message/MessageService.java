package springbootmessaging.message;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MessageService {
	
	private static List<Message> messages = new ArrayList<>(Arrays.asList());
	
	public List<Message> getAllTopics() {
		return messages;
	}
	
	public Message getTopic(String id) {
		return messages.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public static void addMessage(Message message) {
		messages.add(message);
	}

	public void updateTopic(String id, Message message) {
		for(int i = 0; i < messages.size(); i++) {
			Message t = messages.get(i);
			if (t.getId().equals(id)) {
				messages.set(i, message);
				return;
			}
		}
	}

	public void deleteTopic(String id) {
		messages.removeIf(t -> t.getId().equals(id));
	}
	
}
