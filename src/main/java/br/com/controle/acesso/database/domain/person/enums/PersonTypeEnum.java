package br.com.controle.acesso.database.domain.person.enums;

public enum PersonTypeEnum {
	

	PESSOAFISICA(1,"Pessoa Física"),
	PESSOAJURIDICA(2,"Pessoa Jurídica");
	
	private int cod;
	private String descricao;
	
	
	private PersonTypeEnum(int cod , String descricao) {
	  this.cod = cod;
	  this.descricao = descricao;
		
	}


	public int getCod() {
		return cod;
	}


	public String getDescricao() {
		return descricao;
	}
	
	
	public static PersonTypeEnum toEnum(Integer cod ) {
		
	  if ( cod == null) {
		return null;  
	  }	
	  
	  for (PersonTypeEnum x : PersonTypeEnum.values() ) {
		if ( cod.equals(x.getCod() )) {
		  return x; 	
		}  
	  }
	  
	  throw new IllegalArgumentException("id inválido" + cod);
		
	}

}
