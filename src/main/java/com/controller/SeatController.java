package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.Seat;

/*@Controller
@RequestMapping("/seat")
public class SeatController {
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showSeat() {
		Seat seat=new Seat();
		ModelAndView mv = new ModelAndView("employee");
		mv.addObject("seat", seat);
 
		// Add dynamic data to the Hobbies list
		List<String> availableHobbies = new ArrayList<String>();
		availableHobbies.add("Reading");
		availableHobbies.add("Dancing");
		availableHobbies.add("Singing");
		availableHobbies.add("Doing Nothing");
		mv.addObject("availseats", availableHobbies);
		return mv;
	}
}*/
