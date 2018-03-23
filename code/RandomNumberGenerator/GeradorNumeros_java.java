/*
   <h1>Gerador de Numeros</h1>
		Geração de 10 numeros aleatorios que irão de 0 a 26, por meio da biblioteca
		java.util.random
	
	
		Autor: Bruno Barone
	*/
	
 import java.util.Random;
public class GeradorNumeros {

	public static void main(String[] args) {

		Random gerador = new Random();
	    
	    for (int i = 0; i < 10; i++) {
	    	System.out.println(gerador.nextInt(26));
		 }
	}
}
 