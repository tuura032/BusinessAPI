package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import java.time.LocalDateTime;

@Entity
public class Message {

	private final long messageId;
	private final long clientId;
	private final String message;
	private final LocalDateTime datetime;
	
	public Message(long clientId, String message) {
		this.messageId = getMessageId();
		this.clientId = clientId;
		this.message = message;
		this.datetime = LocalDateTime.now();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getMessageId() {
		return messageId;
	}

	public String getMessage() {
		return message;
	}

	public LocalDateTime getDatetime() {
		return datetime;
	}

	public long getClientId() {
		return clientId;
	}


}
