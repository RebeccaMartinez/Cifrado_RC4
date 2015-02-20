package logica;

public class Cifrador extends Traductor{
	
	public static String cifrar(String texto, String clave){
		
		String  mensajecifrado = (prga(texto,clave));
		
		return mensajecifrado;
	}
}
