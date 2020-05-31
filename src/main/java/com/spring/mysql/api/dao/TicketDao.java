package com.spring.mysql.api.dao;

import org.springframework.data.repository.CrudRepository;
import com.spring.mysql.api.model.Ticket;

// define the service

public interface TicketDao extends CrudRepository<Ticket, Integer>{
	


}

