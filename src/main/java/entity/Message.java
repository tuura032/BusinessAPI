package entity;

import java.time.LocalDateTime;

public class Message {

	private final long id;
	private final String message;
	private final LocalDateTime datetime;
	
	public Message(long id, String message) {
		this.id = id;
		this.message = message;
		this.datetime = LocalDateTime.now();
		
	}

	public long getId() {
		return id;
	}

	public String getMessage() {
		return message;
	}

	public LocalDateTime getDatetime() {
		return datetime;
	}


}
