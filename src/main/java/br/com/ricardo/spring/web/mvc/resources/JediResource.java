package br.com.ricardo.spring.web.mvc.resources;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/api/jedi/{id}")
	public ResponseEntity<Jedi> getJedi(@PathVariable("id") Long id) {
		Optional<Jedi> jedi = jediRepository.getJedi(id);
		
		if(jedi.isPresent())
			return ResponseEntity.ok(jedi.get());
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/api/jedi")
	public Jedi createJedi(@Valid @RequestBody Jedi jedi){
		return jediRepository.add(jedi);
		
	}
	
	@PutMapping("/api/jedi/{id}")
	public ResponseEntity<Jedi> updateJedi(@PathVariable("id") Long id,@Valid @RequestBody Jedi jedi) {
		Optional<Jedi> fetchedJedi = jediRepository.getJedi(id);
		
		if(fetchedJedi.isPresent()) {
			fetchedJedi.get().setName(jedi.getName());
			fetchedJedi.get().setLastName(jedi.getLastName());
			
			return ResponseEntity.ok(fetchedJedi.get());
		}
		else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
}


