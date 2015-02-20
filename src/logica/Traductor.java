package logica;

public class Traductor {

	static int [] S = new int [256];
	static int [] K = new int [256];
	
	
	public static int [] aDecimal (String texto){
		char [] aux = texto.toCharArray();
		String [] x = new String[aux.length / 2];
		int [] y = new int [x.length];
		
		//Almaceno la clave de dos en dos
		for(int i = 0; i < aux.length / 2; i++){
			x[i] = aux[i * 2] + "" + aux[i * 2 + 1]; 
		}
		
		for(int i = 0; i < x.length; i++){
			y[i] = Integer.parseInt(x[i], 16); //pasamos de hexadecimal a decimal
		}
		
		return y;
		
	}
	
	public static String [] aHexa(int [] array){
		
		String [] y = new String[array.length];
		
		for(int i = 0; i < y.length; i++){
			y[i] = Integer.toHexString(array[i]);
		}
		
		return y;
		
	}
	
	
	public static int[] inicializar(String key){

		int [] clave = aDecimal(key);

		for(int i = 0; i < 256; i++){
			S[i] = i;
			K[i] = clave[i % clave.length]; 
			//System.out.println(clave[i]); la clave la pasa bien a decimal
		}
		
		int j = 0;
		for(int i = 0; i < 256; i++){
			j = (j + S[i] + K[i]) % 256;
			//System.out.println("j:" + j);
			intercambia(i,j);
		}	
	
		return S;
	}

	public static void intercambia(int i, int j){
		int temp = S[i];
		S[i] = S[j];
		S[j] = temp;
	}
	
	public static String prga (String mensaje, String clave){
		
		int [] aux = inicializar(clave);
		
		int [] texto = aDecimal(mensaje);
		int [] resultado = new int [texto.length];
		
		int i = 0;
		int j = 0;
	
		for (int k = 0; k < texto.length; k++){
			i = (i + 1) % 256;
			j = (j + aux[i]) % 256;
			
			intercambia(i,j);
			int t = ((aux[i] + aux[j]) % 256);
			
			
			//for (int k = 0; k < texto.length; k++){
				int txt = texto[k];
				int a = aux[t];
				resultado[k] = txt ^ a; //donde k va de 0 a mensaje-1.
			//}
		}
		
		String cadena = "";
		
		for (String s : aHexa(resultado)) {
			cadena += s;
		}

		return cadena; 
	}
	
}
