package com.spring.mysql.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mysql.api.dao.TicketDao;
import com.spring.mysql.api.model.Ticket;

@RestController
@RequestMapping("/ticket")
public class TicketController {

	@Autowired
	private TicketDao dao;

	// sending values

	@PostMapping("/bookTickets")
	public String bookTicket(@RequestBody List<Ticket> tickets) {

		for (int i = 0; i <= tickets.size(); i++) {

			System.out.println(i);

		}

		dao.save(tickets);

		return "ticket booked Sucessfuly: " + tickets.size();
	}

	
	// retrive values
	
	@GetMapping("/getTickets")
	public List<Ticket> getTickets() {
		return (List<Ticket>) dao.findAll();
	}
	
	// modify values
	
	/*
	 * @GetMapping("/getTickets") public List<Ticket> getModifiedTickets() { return
	 * null;
	 * 
	 * }
	 * 
	 * // delete particular id and all recod values
	 * 
	 * @GetMapping("/getTickets") public List<Ticket>deleteTickets() { return null;
	 * 
	 * }
	 * 
	 * 
	 */
	//dff
}
