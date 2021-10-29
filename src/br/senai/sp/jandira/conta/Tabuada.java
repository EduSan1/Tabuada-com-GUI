package br.senai.sp.jandira.conta;

public class Tabuada {
	
	private int multiplicador;
	private int multiplicando;

	public int getMultiplicador() {

		return multiplicador;
	}

	public void setMultiplicador(String multiplicador) {

		this.multiplicador = Integer.valueOf(multiplicador);

	}

	public int getMultiplicando() {

		return multiplicando; 
	}

	public void setMultiplicando(String multiplicando) {

		this.multiplicando = Integer.valueOf(multiplicando);
	}
	
	private double conta;
	
	public void calcular(double multiplicando, int multiplicador) {
		
		conta = multiplicando*multiplicador;
		
	}
	
	public double getResultado(){
		
		return conta;
	}

}
