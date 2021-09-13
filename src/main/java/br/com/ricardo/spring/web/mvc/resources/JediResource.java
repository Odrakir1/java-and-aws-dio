package br.com.ricardo.spring.web.mvc.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.ricardo.spring.web.mvc.model.Jedi;
import br.com.ricardo.spring.web.mvc.service.JediService;

@RestController
public class JediResource {
	
	@Autowired
	private JediService jediService;
	
	
	@GetMapping("/api/jedi")
	public List<Jedi> getAllJedi() {
		return jediService.getAllJedi();
	}
	
	@GetMapping("/api/jedi/{id}")
	public ResponseEntity<Jedi> getJedi(@PathVariable("id") Long id) {
		Jedi jedi = jediService.getJedi(id);
			
		return ResponseEntity.ok(jedi);
		
	}
	
	@PostMapping("/api/jedi")
	@ResponseStatus(HttpStatus.CREATED)
	public Jedi createJedi(@Valid @RequestBody Jedi jedi){
		return jediService.add(jedi);
		
	}
	
	@PutMapping("/api/jedi/{id}")
	public ResponseEntity<Jedi> updateJedi(@PathVariable("id") Long id,@Valid @RequestBody Jedi jedi) {
		Jedi updatedJedi = jediService.update(jedi,id);
		
		return ResponseEntity.ok(updatedJedi);
		
	}
	
	@DeleteMapping("/api/jedi/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteJedi(@PathVariable("id") Long id){
		jediService.delete(id);		
	}
	
}


