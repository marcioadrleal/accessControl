package br.com.controle.acesso.resources.person;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.controle.acesso.database.domain.person.TelephoneType;
import br.com.controle.acesso.service.person.TelephoneTypeService;

@RestController
@RequestMapping(value="/telephonetype")
public class TelephoneTypeResource {
	
	
	@Autowired
	private TelephoneTypeService telephoneTypeService;
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<TelephoneType> find(@PathVariable Integer id){
	  TelephoneType tel = telephoneTypeService.find(id);
	  return ResponseEntity.ok().body(tel);
	}
	
	
	/*@RequestMapping(value="/{id}" , method=RequestMethod.GET)	
	  public ResponseEntity<Categoria> find(@PathVariable Integer id) {
		Categoria obj = service.find(id); 
		return ResponseEntity.ok().body(obj); 
	  } */	
	

}
