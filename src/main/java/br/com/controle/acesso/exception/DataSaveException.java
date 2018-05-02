package br.com.controle.acesso.exception;


public class DataSaveException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6807306076559877799L;

	public DataSaveException(String msg) {
	  super(msg);	
	}
	
	public DataSaveException(String msg , Throwable cause) {
	  super(msg, cause);	
	}
	


}
