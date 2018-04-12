package br.com.controle.acesso.database.repositories.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.controle.acesso.database.domain.person.TelephoneType;

@Repository
public interface TelephoneTypeRepository extends  JpaRepository<TelephoneType, Integer>{
 
}
