package br.senai.sp.jandira.conta;

public class Multiplicar {
	
	private double conta;
	
	public void tabuada(double multiplicando, int multiplicador) {
		
		conta = multiplicando*multiplicador;
		
	}
	
	public double getResultado(){
		
		return conta;
	}

}
