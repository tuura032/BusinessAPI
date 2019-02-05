package repository;

import org.springframework.data.repository.CrudRepository;

import entity.Message;

public interface MessageRepository extends CrudRepository<Message, Long>{

	
}
