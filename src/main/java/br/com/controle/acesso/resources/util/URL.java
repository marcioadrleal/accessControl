package br.com.controle.acesso.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class URL {
	
	public static String decodeParam(String s) {
	  try {
	  	return URLDecoder.decode(s,"UTF-8");
	  } catch (UnsupportedEncodingException e) {
		return "";
	  }	
	}
	
	public static List<Integer> decodeIntList(String s){
/*	  String[]	vet = s.split(",");
	  List<Integer> lista = new ArrayList<>();
	  for(int i = 0 ; i < vet.length; i++) {
		 Integer.parseInt(vet[i]); 
	  } */
	  
	  return Arrays.asList(s.split(",")).stream().map(x -> Integer.parseInt(x)).collect(Collectors.toList());
			  
	}


}