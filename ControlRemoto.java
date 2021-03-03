public class ControlRemoto {
	
	public static void main(String[] args) {
		
		Televisor sony = new Televisor((short)127, (short)32767, (short)1234, (short)4, (short)32766, 2999999999l);
		
			//encenderOApagar y To String
			System.out.println("Informacion: " + sony.toString());
			sony.encenderOApagar();
			System.out.println("Informacion: " + sony.toString() + "\n");
						
			//seleccionarEntrada
			System.out.println("Prueba de selección de entradas");
			sony.seleccionarEntrada('A');
			sony.seleccionarEntrada('C');
			sony.seleccionarEntrada('1');
			sony.seleccionarEntrada('2');
			sony.seleccionarEntrada('U');
			System.out.println(" ");
		
			//subirOBajarAnalogicamente - volumen
			System.out.println("Prueba de control de volumen");
			sony.subirOBajarAnalogicamente('+');
			sony.subirOBajarAnalogicamente('-');
			System.out.println(" ");
		 
		 	//subirOBajarAnalogicamente - canales de aire
			System.out.println("Cambiar Canales de Aire");
			sony.seleccionarEntrada('A');
			sony.getCanalActual(); // 1
			sony.subirOBajarAnalogicamente('>'); // 2
			sony.subirOBajarAnalogicamente('>'); // 3
			sony.subirOBajarAnalogicamente('<'); // 2
			sony.subirOBajarAnalogicamente('<'); // 1
			sony.subirOBajarAnalogicamente('<'); // max
			sony.subirOBajarAnalogicamente('>'); // 1
			sony.subirOBajarAnalogicamente('<'); // max
			sony.subirOBajarAnalogicamente('>'); // 1

			
			System.out.println(" "); 
		
			//subirOBajarAnalogicamente - canales de cable (Clave desactivada)
			System.out.println("Cambiar Canales de Cable");
			sony.deactivarElControlParenteral('1', '2', '3', '4');
			sony.seleccionarEntrada('C');
			sony.getCanalActual(); 		 		//1							
			sony.subirOBajarAnalogicamente('>'); //2
			sony.subirOBajarAnalogicamente('>'); //3
			sony.subirOBajarAnalogicamente('>'); //4
			sony.subirOBajarAnalogicamente('<'); //3
			sony.subirOBajarAnalogicamente('<'); //2
			sony.subirOBajarAnalogicamente('<'); //1
			sony.subirOBajarAnalogicamente('<'); //max
			sony.subirOBajarAnalogicamente('>'); //1
			sony.subirOBajarAnalogicamente('>'); //2
			sony.subirOBajarAnalogicamente('>'); //3 
			sony.subirOBajarAnalogicamente('>'); //4
			
			
			System.out.println(" "); 
		
			sony.activarControlParenterla('1', '2', '3', '4');
			
			System.out.println(" "); 
		
			sony.getCanalActual(); //32767
			sony.subirOBajarAnalogicamente('>'); //1
			sony.subirOBajarAnalogicamente('>'); //2
			sony.subirOBajarAnalogicamente('>'); //3
			sony.subirOBajarAnalogicamente('>'); // 32767
			sony.subirOBajarAnalogicamente('>'); // 1 
			sony.subirOBajarAnalogicamente('<'); // 32767
			sony.subirOBajarAnalogicamente('<'); // 3
			
			System.out.println(" "); 
		
		 //sony.subirOBajarAnalogicamente con otras entradas;
			sony.seleccionarEntrada('1');
			sony.subirOBajarAnalogicamente('>');
			sony.subirOBajarAnalogicamente('<');
			sony.getCanalActual();
			sony.seleccionarEntrada('2');
			sony.subirOBajarAnalogicamente('>');
			sony.subirOBajarAnalogicamente('<');
			sony.getCanalActual();
			sony.seleccionarEntrada('U');
			sony.subirOBajarAnalogicamente('>');
			sony.subirOBajarAnalogicamente('<'); 
			sony.getCanalActual();
			
			System.out.println(" "); 
		
			//cambiarDeCanal + volverAlCanalAnterior + Control Parental
			sony.seleccionarEntrada('A');
			sony.cambiarDeCanal('1');
			sony.cambiarDeCanal('1', '2');
			sony.cambiarDeCanal('1', '2', '3');
			sony.cambiarDeCanal('1', '2', '3', '4');
			
			System.out.println(" "); 
		
			sony.volverAlCanalAnterior();
			
			System.out.println(" ");
			
			// con control parental activo
			sony.seleccionarEntrada('C');
			sony.isControlParenteralActivado();
			sony.cambiarDeCanal('1');
			sony.cambiarDeCanal('1', '2');
			sony.cambiarDeCanal('1', '2', '3');
			sony.cambiarDeCanal('1', '2', '3', '4');
			
			System.out.println(" "); 
		
			sony.volverAlCanalAnterior();
			sony.deactivarElControlParenteral('1', '2', '3', '4');
			sony.volverAlCanalAnterior();
			
			System.out.println(" "); 
			
			//set volumen - silenciar
			sony.setVolumen((byte)50);
			sony.silenciar();
			sony.silenciar();			
	}

}
