package br.com.ricardo.spring.web.mvc.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@PostMapping("/jedi")
	public String createJedi(@Valid @ModelAttribute Jedi jedi, BindingResult result, RedirectAttributes redirectAttributes) {
		
		if(result.hasErrors())
			return "new-jedi";
		
		jediRepository.add(jedi);
		
		redirectAttributes.addFlashAttribute("message", "Jedi was successfully added.");
		
		return "redirect:jedi";
	}
}







