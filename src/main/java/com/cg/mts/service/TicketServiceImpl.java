package com.cg.mts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.exception.TicketNotFoundException;
import com.cg.mts.pojo.Booking;
import com.cg.mts.pojo.Customer;
import com.cg.mts.pojo.Seat;
import com.cg.mts.pojo.Ticket;
import com.cg.mts.repository.BookingRepository;
import com.cg.mts.repository.CustomerRepository;
import com.cg.mts.repository.SeatRepository;
import com.cg.mts.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService {

	private TicketRepository ticketRepository;

	public TicketServiceImpl(TicketRepository ticketRepository) {
		this.ticketRepository = ticketRepository;
	}
	
	@Autowired
	private SeatRepository seatRepository;
	
	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private CustomerRepository customerRepo;
	
	@Override
	public Ticket addTicket(Ticket ticket,Integer transactionId,int customerId) throws TicketNotFoundException {
		Booking booking=new Booking();
		Customer customer = new Customer();
		if(transactionId!=null) {
			booking=bookingRepository.findById(transactionId).get();
			customer= customerRepo.getOne(customerId);
			List<Ticket> ticketList = customer.getCart().getTicketList();
			booking.setTransactionStatus("Completed");
			ticket.setBooking(booking);
			ticketList.add(ticket);
			customer.getCart().setTicketList(ticketList);
		}
		ticketRepository.saveAndFlush(ticket);
		/*
		 * for(Seat s:ticket.getSeats()) { s.setTickett(ticket);
		 * seatRepository.saveAndFlush(s); }
		 */
		customerRepo.saveAndFlush(customer);
		return ticket;
	}

	@Override
	public List<Ticket> viewTicketList() throws TicketNotFoundException {
		List<Ticket> ti = ticketRepository.findAll();
		if (ti.size() == 0)
			throw new TicketNotFoundException("No tickets are avaliable");
		return ti;
	}

	@Override
	public Ticket findTicket(int ticketId) {
		// TODO Auto-generated method stub
		return ticketRepository.findById(ticketId).get();
	}

}
