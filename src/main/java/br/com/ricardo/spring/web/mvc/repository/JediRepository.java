package br.com.ricardo.spring.web.mvc.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

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
		this.jedi.add(jedi);
	}
}
