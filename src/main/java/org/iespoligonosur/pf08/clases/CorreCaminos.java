package org.iespoligonosur.pf08.clases;

public class CorreCaminos {

	
	
	private int dado;
	
	public CorreCaminos() {
		
	}

	public CorreCaminos(int dado) {
		super();
		this.dado = dado;
	}

	/**
	 * @return the dado
	 */
	public int getDado() {
		return dado;
	}

	/**
	 * @param dado the dado to set
	 */
	public void setDado(int dado) {
		this.dado = dado;
	}
	public  void dadoCorreCamino() {
		int dado = (int) Math.floor(Math.random()*100);
		if ( dado%2==0) {
			
		}
		
		
	}
	
		
	
}
