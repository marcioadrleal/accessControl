package br.com.controle.acesso.resources.person;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void>  insert(@Valid @RequestBody TelephoneType telephoneType ){
	  telephoneType.setId(null);	
	  telephoneType = telephoneTypeService.insert(telephoneType);	
	  URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(telephoneType.getId()).toUri();
	  return ResponseEntity.created(uri).build();
	} 
	
	/*
	 
	  
	  @RequestMapping(method=RequestMethod.POST)
  public ResponseEntity<Void> insert(@Valid @RequestBody CategoriaDTO objDto ){
	Categoria obj = service.fromDTO(objDto);
	obj = service.insert(obj);  
	URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
	return ResponseEntity.created(uri).build();
  }
	  
	 	
	 */
	

}
