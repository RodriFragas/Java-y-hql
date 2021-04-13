package test;

import java.time.LocalDate;
import java.time.Month;

import datos.*;
import negocio.*;

public class test {

	public static void main(String[] args) throws Exception {
		
		System.out.println("\n------------------------------------------------------");
		System.out.println("\n1)Traer contribuyente id=2 ");
		
		System.out.println(ContribuyenteABM.getInstance().traerContribuyente(2));
		
		System.out.println("\n------------------------------------------------------");
		System.out.println("\n2)Traer inspector id=1 ");
		
		System.out.println(InspectorABM.getInstance().traerInspector(1));
		
		System.out.println("\n------------------------------------------------------");
		System.out.println("\n3)Traer todos los inspectores ");
		
		for(Inspector i : InspectorABM.getInstance().traerInspector()) {
			System.out.println("\n--------------" +i.toString());
		}
		
		System.out.println("\n------------------------------------------------------");
		System.out.println("\n4)Traer automotor LLL444 ");
		
		String z = "LLL444";
		System.out.println(AutomotorABM.getInstance().traerAutomotor(z));
		
		System.out.println("\n------------------------------------------------------");
		System.out.println("\n5)Traer inspeccion id 1 ");
		
		System.out.println(InspeccionABM.getInstance().traerInspeccionID(1));
		
		System.out.println("\n------------------------------------------------------");
		System.out.println("\n6)Traer inspecciones del automotor con id 5 ");
		
		Automotor au = AutomotorABM.getInstance().traerAutomotor(5);
		for(Inspeccion cc : InspeccionABM.getInstance().traerInspeccionIdAutomotor(au)) {
			System.out.println("\n------------------" +cc.toString());
		}
		
		System.out.println("\n------------------------------------------------------");
		System.out.println("\n7)Traer inspecciones del 11/2/2019 ");
		
		LocalDate qwe = LocalDate.of(2019,02,11);
		for(Inspeccion qq : InspeccionABM.getInstance().traerInspeccionPorFecha(qwe)) {
			System.out.println("\n------------------- " +qq.toString());
		}
		
		System.out.println("\n------------------------------------------------------");
		System.out.println("\n8)Traer inspeccion del inspector con id 1 del 11/02/2019 ");
		
		Inspector t = InspectorABM.getInstance().traerInspector(1);
		System.out.println(InspeccionABM.getInstance().traerInspeccion8(t, LocalDate.of(2019, 2, 11)));
		
		System.out.println("\n------------------------------------------------------");
		System.out.println("\n9)Traer inspeccion del 11/02/2019 con estado apto ");
		
		String estado = "apto";
		for(Inspeccion ss : InspeccionABM.getInstance().traerInspeccion9(LocalDate.of(2019, 2, 11), estado)) {
			System.out.println("\n-----------------------" +ss.toString());
			
		}
		
		System.out.println("\n------------------------------------------------------");
		System.out.println("\n10)Traer inspecciones enre el 10 y el 11 del 02/2019 con estado apto");
		
		LocalDate desde = LocalDate.of(2019, 2, 10);
		LocalDate hasta = LocalDate.of(2019, 2, 11);
		
		String e = "apto";
		for(Inspeccion c : InspeccionABM.getInstance().traerInspeccion(desde, hasta, e)) {
			System.out.println("\n-------------" +c.toString());
		}
		
		
	}

}
