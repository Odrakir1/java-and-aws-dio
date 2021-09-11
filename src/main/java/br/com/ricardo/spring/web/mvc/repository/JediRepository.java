package br.com.ricardo.spring.web.mvc.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.ricardo.spring.web.mvc.model.Jedi;

@Repository
public class JediRepository {

	public List<Jedi> getAllJedi(){
		List<Jedi> jedi = new ArrayList<Jedi>();
		jedi.add(new Jedi("Luke","Skywalker"));
		return jedi;
	}
}
