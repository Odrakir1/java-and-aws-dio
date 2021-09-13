package br.com.ricardo.spring.web.mvc.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.ricardo.spring.web.mvc.exception.JediNotFoundException;
import br.com.ricardo.spring.web.mvc.model.Jedi;
import br.com.ricardo.spring.web.mvc.repository.JediRepository;

@Service
public class JediService {
	
	@Autowired
	private JediRepository jediRepository;

	public Jedi getJedi(Long id) {
		Optional<Jedi> jedi = jediRepository.getJedi(id);
		
		
		if(jedi.isPresent())
			return jedi.get();
		
		throw new JediNotFoundException();
	}

	public List<Jedi> getAllJedi() {
		return jediRepository.getAllJedi();
	}

	public Jedi add(@Valid Jedi jedi) {
		return jediRepository.add(jedi);
	}

	public Jedi update(@Valid Jedi jedi,Long id) {
		Jedi fetchedJedi = this.getJedi(id);
		
		fetchedJedi.setName(jedi.getName());
		fetchedJedi.setLastName(jedi.getLastName());
		
		return jediRepository.saveJedi(fetchedJedi, id);
		
	}

	public void delete(Long id) {
		Optional<Jedi> fetchedJedi = jediRepository.getJedi(id);
		
		if(fetchedJedi.isPresent()) {
			jediRepository.deleteJedi(id);
		}
		
	}
	
}
