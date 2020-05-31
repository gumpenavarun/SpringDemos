package com.spring.mysql.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable int id) {
		if (dao.findOne(id) != null) {
			dao.delete(id);

		} else {
			System.out.println("Id not present");
			return "id not present";
		}

		// System.out.println("id has been deleted");
		return "This Id has been deleted " + id;
	}

	@PutMapping("/{id}")
	public String updateStudent(@RequestBody Ticket ticket, @PathVariable int id) {
		Optional<Ticket> studentOptional = Optional.ofNullable(dao.findOne(id));

		if (!studentOptional.isPresent())
		{
			ticket.setId(id);
			dao.save(ticket);
		} else {
			return "Entered id is not present in DB";
		}
		return "Entered " + id + " is not present in DB";
//thi
		//new line adding for commit

	}

}
