package br.com.controle.acesso.service.person;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.controle.acesso.database.domain.person.TelephoneType;
import br.com.controle.acesso.database.repositories.person.TelephoneTypeRepository;
import br.com.controle.acesso.exception.ObjectNotFoundException;

@Service
public class TelephoneTypeService {

  @Autowired	
  private TelephoneTypeRepository repo;
  
  public TelephoneType find( Integer id  ) {
	Optional<TelephoneType> tel = repo.findById(id);  
	return tel.orElseThrow(() -> new ObjectNotFoundException("Object not found id = " + id.toString() + " - " + TelephoneType.class.getName() ));
  }
  
  
	
}
