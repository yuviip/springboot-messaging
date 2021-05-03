package springbootmessaging.message;
import org.json.JSONObject;
import org.json.XML;

public class Message {
	
	private String id;	
	private String name;
	private String message;
	
	public Message() {
		
	}
	
	public Message(String id, String name, String message) {
		super();
		this.id = id;
		this.name = name;
		this.message = message;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String xml() {
		JSONObject json = new JSONObject(this.toString());
		String xml = XML.toString(json);
		return xml;
	}
	
	@Override
	public String toString() {
		return "{\"id\":\"" + id + "\", \"name\":\"" + name + "\", \"message\":\"" + message + "\"}";
		
	}
}
