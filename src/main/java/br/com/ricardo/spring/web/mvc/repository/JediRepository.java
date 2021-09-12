package br.com.ricardo.spring.web.mvc.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.ricardo.spring.web.mvc.exception.JediNotFoundException;
import br.com.ricardo.spring.web.mvc.model.Jedi;

@Repository
public class JediRepository {
	private List<Jedi> jedi;
	
	public JediRepository() {
		jedi = new ArrayList<Jedi>();
		jedi.add(new Jedi("Luke","Skywalker"));
	};

	public List<Jedi> getAllJedi(){
		return this.jedi;
	}

	public void add(final Jedi jedi) {
		//though it isn't a good practice
		//we're just simulating an in-memory DB
		
		//doing it in repository for it won't
		//get duplicated in controller and in REST
		jedi.setId(this.jedi.size());
		this.jedi.add(jedi);
	}
	
	public Jedi getJedi(Long id){
		Optional<Jedi> jedi = this.jedi.stream().filter(j -> j.getId() == id).findFirst();
		
		if(jedi.isPresent())
			return jedi.get();
		
		throw new JediNotFoundException();
	}
}
