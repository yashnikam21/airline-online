package com.controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dao.UserDao;


@Controller
public class InformationController {
	
	
	@RequestMapping(value = "/faq", method = RequestMethod.GET)
	public ModelAndView addflight1() {
		return new ModelAndView("faq");
	}
}