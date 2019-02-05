package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Message;
import repository.MessageRepository;

@Service
public class MessageService {

	@Autowired
	MessageRepository repo;
	
	public Iterable<Message> displayMessage() {
		return repo.findAll();
	}
	
	public void deleteMessage(Long id) {
		repo.deleteById(id);
	}
	
	
	public Message createMessage(Message message) {
		return repo.save(message);
	}
}
