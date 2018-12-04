package com.controller;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
/**
 * Controller to handle No of passengers during booking process
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.Seat;
import com.service.UserService;

@Controller
public class BookController {
	@Autowired
	UserService userservice;
	/**
	 * 
	 * @param request
	 * @param response
	 * @return to NoOfPassengers page
	 */
	@RequestMapping(value = "/load/{flightnumber}", method = RequestMethod.GET)
	public ModelAndView load(@PathVariable("flightnumber") String flightnumber, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("hi: " + flightnumber);
		HttpSession session = request.getSession(true);
		session.setAttribute("no1", flightnumber);
		return new ModelAndView("Loading");
	}

	/**
	 * 
	 * @param value
	 * @return ModelAndView object and value to SeatSelection page
	 */
	@RequestMapping(value = "/seat")
	public ModelAndView seat(@RequestParam("sel") String value,ModelAndView model) {
		List<Seat> al=userservice.retri();
		model.addObject("listseat",al);
		model.addObject("msg",value);
		model.setViewName("SeatSelection");
		return model;
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @return ModelAndView object to Payment page
	 */
	@RequestMapping(value = "/load1")
	public ModelAndView load1(ModelAndView model) {
		/*System.out.println("Number: "+no);*/
		model.setViewName("Loading1");
		return model;
		/*
		 * ModelAndView mav = new ModelAndView("Payment"); mav.addObject("i");
		 */
	}
	@RequestMapping(value = "/payment")
	public ModelAndView payment(ModelAndView model) {
		/*System.out.println("Number: "+no);*/
		model.setViewName("Payment");
		return model;
	}
}
