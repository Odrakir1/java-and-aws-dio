package br.com.ricardo.spring.web.mvc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ricardo.spring.web.mvc.model.Jedi;
import br.com.ricardo.spring.web.mvc.repository.JediRepository;

@RestController
public class JediResource {
	
	@Autowired
	private JediRepository jediRepository;
	
	
	@GetMapping("/api/jedi")
	public List<Jedi> getAllJedi() {
		return jediRepository.getAllJedi();
	}
	
}


