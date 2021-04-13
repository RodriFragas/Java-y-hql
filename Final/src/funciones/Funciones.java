package funciones;

import java.time.LocalDate;


//import modelo.Funciones;

public class Funciones {

	public static void print(String arg) {
		System.out.println (arg);
	}
	
	//FUNCIONES PARA LOCAL DATE
	public static boolean esBisiesto(int anio) {
		boolean bisiesto = false;
		
		if((anio % 4 == 0) && !((anio % 100 == 0) && !(anio % 400 == 0))) {
			bisiesto = true;
		}
		return bisiesto;
	}
	
	public static String traerFechaCorta(LocalDate d){
		return(d.getDayOfMonth()+"/"+d.getMonth()+"/"+d.getYear());
	}
	
	public static boolean esFechaValida(int anio, int mes, int dia) {
		boolean fechaValida = false;
		
		int[] vectorMes = {31,28,31,30,31,30,31,31,30,31,30,31};
		
		if(Funciones.esBisiesto(anio)) {
			vectorMes[1] = 29;
		}
		
		if((mes-1) < 12) {
			if(vectorMes[mes-1] >= dia) {
				fechaValida=true;
			}
		}
		return fechaValida;
	}
	
}