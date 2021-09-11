package br.com.ricardo.spring.web.mvc.controller;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.ricardo.spring.web.mvc.model.Jedi;
import br.com.ricardo.spring.web.mvc.repository.JediRepository;

@Controller
public class JediController {

	@Autowired
	private JediRepository jediRepository;
	
	@GetMapping("/jedi")
	public ModelAndView getJedi() {
		final ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("allJedi", jediRepository.getAllJedi());
		
		return modelAndView;
		
	
	}
	
	@GetMapping("/new-jedi")
	public ModelAndView getNewJedi() {
		final ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("new-jedi");
		
		modelAndView.addObject("jedi",new Jedi());
		
		return modelAndView;
	}
}
