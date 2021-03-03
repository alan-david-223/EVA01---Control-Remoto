public class Televisor {

	public final char ENTRADA_TELEVISION_DE_AIRE = 'A';
	public final char ENTRADA_TELEVISION_POR_CABLE = 'C';
	public final char ENTRADA_HDMI1 = '1';
	public final char ENTRADA_HDMI2 = '2';
	public final char ENTRADA_USB = 'U';
	public char entrada; 	//entrada actual
	private boolean botonPower; // controla si el televisor está encendido

	long nroDeSerie = 3000000000l;
	private short canalMaximoTelevisionAbierta; 	// Atributo constructor
	private short canalMaximoTelevisionPorCable; 	// Atributo constructor
	private short claveControlParental; 	// Atributo constructor
	private short canalParaMayoresInicial; 	// Atributo constructor
	private short canalParaMayoresFinal;	// Atributo constructor
	private short canalActualAire; 			 
	private short canalActualCable; 		
	private short canalAnteriorAire; 		
	private short canalAnteriorCable; 		
	private byte volumen; 	// Volumen Actual
	private final byte volumenMaximo = 100; // atributos de volumen
	private final byte volumenMinimo = 0; 	// atributos de volumen
	private boolean controlParentalEstado; // 
	boolean mute = false; // activa o desactiva el silencio
	byte volumenAnterior; // reserva en memoria el estado del volumen antes de silenciar

	//Constructores de Clase
	public Televisor(short canalMaximoTelevisionAbierta, short canalMaximoTelevisionPorCable, long nroDeSerie) {
		this.canalMaximoTelevisionAbierta = canalMaximoTelevisionAbierta;
		this.canalMaximoTelevisionPorCable = canalMaximoTelevisionPorCable;
		this.canalActualAire = 1;
		this.canalActualCable = 1;
		this.volumen = 10;
		this.entrada = 'A';
		this.botonPower = false;
		this.nroDeSerie = nroDeSerie;
	}
	public Televisor(short canalMaximoTelevisionAbierta, short canalMaximoTelevisionPorCable,
			short claveControlParental, short canalParaMayoresInicial, short canalParaMayoresFinal,
			long nroDeSerie) {		
		this.canalMaximoTelevisionAbierta = canalMaximoTelevisionAbierta;
		this.canalMaximoTelevisionPorCable = canalMaximoTelevisionPorCable;
		this.claveControlParental = claveControlParental;
		this.canalParaMayoresInicial = canalParaMayoresInicial;
		this.canalParaMayoresFinal = canalParaMayoresFinal;
		this.canalActualAire = 1;
		this.canalActualCable = 1;
		this.volumen = 10;
		this.entrada = 'A';
		this.botonPower = false;
		this.nroDeSerie = nroDeSerie;
		this.controlParentalEstado = true;
	}	
	// a. encenderOApagar [Botón Power]
	public void encenderOApagar() {
		if (this.botonPower == false) {
					this.botonPower = true;
					this.entrada = 'A';
		}else {
			this.botonPower = false;
		}					
	}
	// b. toString [Botón Display]: Devuelvo la información con el estado actual del televisor. 
	public String toString() {
		if (this.botonPower == true) {
			switch (this.entrada) {
			case 'A':
				return "CH " + this.canalActualAire + " - " + "TV Aire" + " - VOL " + this.volumen;
			case 'C':
				return "CH " + this.canalActualCable + " - " + "TV Cable" + " - VOL " + this.volumen;
			case '1':
				this.entrada = this.ENTRADA_HDMI1;
				return "HDMI1" + " - VOL " + this.volumen;
			case '2':
				this.entrada = this.ENTRADA_HDMI2;
				return "HDMI2" + " - VOL " + this.volumen;
			case 'U':
				this.entrada = this.ENTRADA_USB;
				return "USB" + " - VOL " + this.volumen;
			default:
				return "Error - entrada invalida";
		}
		} else {
			return "El televisor está apagado";
		}
		
	}
	// c. seleccionarEntrada [Botón Input]: Selecciona la entrada deseada. 
	public void seleccionarEntrada(char Input) {
		if (this.botonPower == true) {
				switch (Input) {
					case 'A':
						this.entrada = this.ENTRADA_TELEVISION_DE_AIRE;
						System.out.println("TV de aire" + " - CH " + this.canalActualAire);
						break;
					case 'C':
						this.entrada = this.ENTRADA_TELEVISION_POR_CABLE;
						System.out.println("TV Cable" + " - CH " + this.canalActualCable);
						break;
					case '1':
						this.entrada = this.ENTRADA_HDMI1;
						System.out.println("HDMI1");
						break;
					case '2':
						this.entrada = this.ENTRADA_HDMI2;
						System.out.println("HDMI2");
						break;
					case 'U':
						this.entrada = this.ENTRADA_USB;
						System.out.println("USB");
						break;
				}
		} else {
			System.out.println("El televisor está apagado");
		}
	}
	// d. subirOBajarAnalogicamente [+ / - / < / >] Según lo que recibe de parámetro sube o baja el volumen o de canal
	public void subirOBajarAnalogicamente(char input) {
		if (this.botonPower == true) {
			switch (input) {
		
				case '+': //volumen +
					if(this.volumen < this.volumenMaximo) {
						volumen++;
						System.out.println("VOL " + this.volumen);
					}		
				break;
				case '-': //volumen -
					if (this.volumen > this.volumenMinimo) {
						volumen--;
						System.out.println("VOL " + this.volumen);
					}
				break;
				case '>': //canal +
					if (this.entrada == this.ENTRADA_TELEVISION_DE_AIRE) {
						if (this.canalActualAire < this.canalMaximoTelevisionAbierta) {
								this.canalAnteriorAire = this.canalActualAire;
								canalActualAire++;
						} else if (this.canalActualAire == this.canalMaximoTelevisionAbierta) {
								this.canalAnteriorAire = this.canalActualAire;
								this.canalActualAire = 1;	
						}
						System.out.println("CH " + this.canalActualAire);
						} //fin bloque tv abierta  
					
					else if(this.entrada == this.ENTRADA_TELEVISION_POR_CABLE) {
						if (this.canalActualCable < this.canalMaximoTelevisionPorCable) {							
							this.canalAnteriorCable = this.canalActualCable;
							canalActualCable++;
							if (this.controlParentalEstado == true && this.canalActualCable >= this.canalParaMayoresInicial && this.canalActualCable <= this.canalParaMayoresFinal) {
								this.canalActualCable = (short) (this.canalParaMayoresFinal+1);
							}
					} else if (this.canalActualCable == this.canalMaximoTelevisionPorCable) {
							this.canalAnteriorCable = this.canalActualCable;
							this.canalActualCable = 1;
							if (this.controlParentalEstado == true && this.canalActualCable >= this.canalParaMayoresInicial && this.canalActualCable <= this.canalParaMayoresFinal) {
								this.canalActualCable = (short) (this.canalParaMayoresFinal+1);
							}
					}
					System.out.println("CH " + this.canalActualCable);
						} // fin bloque tv cable 	
				break;
				case '<': 
					if (this.entrada == this.ENTRADA_TELEVISION_DE_AIRE) {
						if (this.canalActualAire > 1) {
								this.canalAnteriorAire = this.canalActualAire;
								canalActualAire--;	
						} else if (this.canalActualAire == 1) {
								this.canalAnteriorAire = this.canalActualAire;
								this.canalActualAire = this.canalMaximoTelevisionAbierta;
						}
						System.out.println("CH " + this.canalActualAire);
						} //fin bloque tv abierta 
					
					else if(this.entrada == this.ENTRADA_TELEVISION_POR_CABLE) {
						if (this.canalActualCable > 1) {
							this.canalAnteriorCable = this.canalActualCable;
							canalActualCable--;	
							if (this.controlParentalEstado == true && this.canalActualCable >= this.canalParaMayoresInicial && this.canalActualCable <= this.canalParaMayoresFinal) {
								this.canalActualCable = (short) (this.canalParaMayoresInicial -1);
							}
					} else if (this.canalActualCable == 1) {
							this.canalAnteriorCable = this.canalActualCable;
							this.canalActualCable = this.canalMaximoTelevisionPorCable;
					}
						if (this.controlParentalEstado == true && this.canalActualCable >= this.canalParaMayoresInicial && this.canalActualCable <= this.canalParaMayoresFinal) {
							this.canalActualCable = (short) (this.canalParaMayoresInicial -1);
						}
					System.out.println("CH " + this.canalActualCable);
					} // fin bloque tv cable	
				break;
			}//fin de switch
		} else {
				System.out.println("El televisor está apagado");
		}// fin verificación on/off
	} //fin de metodo
	//e. cambiarDeCanal: Disponible en varios formatos (Sólo disponible para las entradas de televisión de aire o cable):
	// Ingreso de 1 digito
	public void cambiarDeCanal(char input1) {
	 if (this.botonPower == true) {
		if (this.entrada == this.ENTRADA_TELEVISION_DE_AIRE) {
			 	this.canalAnteriorAire = this.canalActualAire;		
			 	this.canalActualAire = (short)(Character.getNumericValue(input1)*1);
			 	System.out.println("CH " + this.canalActualAire);
		}
		if (this.entrada == this.ENTRADA_TELEVISION_POR_CABLE) {
		 	this.canalAnteriorCable = this.canalActualCable;		
		 	this.canalActualCable = (short)(Character.getNumericValue(input1)*1);
		 	if (this.controlParentalEstado == true && this.canalActualCable >= this.canalParaMayoresInicial && this.canalActualCable <= this.canalParaMayoresFinal) {
				System.out.println("Canal bloqueado por Control Parental");
				} else {
		 	System.out.println("CH " + this.canalActualCable);
				}
		}
	} else {
		System.out.println("El televisor está apagado");
}
	}
	// Ingreso de 2 digitos
	public void cambiarDeCanal(char input1, char input2) {
		if (this.botonPower == true) {
			if (this.entrada == this.ENTRADA_TELEVISION_DE_AIRE) {
				 	this.canalAnteriorAire = this.canalActualAire;		
				 	this.canalActualAire = (short)(Character.getNumericValue(input1)*10 + Character.getNumericValue(input2)*1);
				 	System.out.println("CH " + this.canalActualAire);
			}
			if (this.entrada == this.ENTRADA_TELEVISION_POR_CABLE) {
			 	this.canalAnteriorCable = this.canalActualCable;		
			 	this.canalActualCable = (short)(Character.getNumericValue(input1)*10 + Character.getNumericValue(input2)*1);
			 	if (this.controlParentalEstado == true && this.canalActualCable >= this.canalParaMayoresInicial && this.canalActualCable <= this.canalParaMayoresFinal) {
					System.out.println("Canal bloqueado por Control Parental");
					} else {
			 	System.out.println("CH " + this.canalActualCable);
					}
			} 
		} else {
				System.out.println("El televisor está apagado");
				}
		}
	// Ingreso de 3 digitos
	public void cambiarDeCanal(char input1, char input2, char input3) {
		 if (this.botonPower == true) {
			if (this.entrada == this.ENTRADA_TELEVISION_DE_AIRE) {
				 	this.canalAnteriorAire = this.canalActualAire;		
				 	this.canalActualAire = (short)(Character.getNumericValue(input1)*100 + Character.getNumericValue(input2)*10 + Character.getNumericValue(input3)*1);
				 	System.out.println("CH " + this.canalActualAire);
			}
			if (this.entrada == this.ENTRADA_TELEVISION_POR_CABLE) {
			 	this.canalAnteriorCable = this.canalActualCable;		
			 	this.canalActualCable = (short)(Character.getNumericValue(input1)*100 + Character.getNumericValue(input2)*10 + Character.getNumericValue(input3)*1);
			 	if (this.controlParentalEstado == true && this.canalActualCable >= this.canalParaMayoresInicial && this.canalActualCable <= this.canalParaMayoresFinal) {
					System.out.println("Canal bloqueado por Control Parental");
					} else {
			 	System.out.println("CH " + this.canalActualCable);
					}
			} 
		} else {
				System.out.println("El televisor está apagado");
				}
		}
	// Ingreso de 4 digitos
	public void cambiarDeCanal(char input1, char input2, char input3, char input4) {
		if (this.botonPower == true) { 	
			if (this.entrada == this.ENTRADA_TELEVISION_DE_AIRE) {
				 	this.canalAnteriorAire = this.canalActualAire;		
				 	this.canalActualAire = (short)(Character.getNumericValue(input1)*1000 + Character.getNumericValue(input2)*100 + Character.getNumericValue(input3)*10 + Character.getNumericValue(input4)*1);
				 	System.out.println("CH " + this.canalActualAire);
			}
			if (this.entrada == this.ENTRADA_TELEVISION_POR_CABLE) {
				this.canalAnteriorCable = this.canalActualCable;		
			 	this.canalActualCable = (short)(Character.getNumericValue(input1)*1000 + Character.getNumericValue(input2)*100 + Character.getNumericValue(input3)*10 + Character.getNumericValue(input4)*1);
				if (this.controlParentalEstado == true && this.canalActualCable >= this.canalParaMayoresInicial && this.canalActualCable <= this.canalParaMayoresFinal) {
					System.out.println("Canal bloqueado por Control Parental");
					} else {
			 	System.out.println("CH " + this.canalActualCable);
					}
			}
		} else {
			System.out.println("El televisor está apagado");
		}
		}
	// f. volverAlCanalAnterior [Prev.]: Retorna al último canal seleccionado.
	public void volverAlCanalAnterior() {
		if (this.botonPower == true) {
			if (this.entrada == this.ENTRADA_TELEVISION_DE_AIRE) {
				this.canalActualAire = this.canalAnteriorAire;
				System.out.println("CH " + this.canalActualAire);
			}
			if (this.entrada == this.ENTRADA_TELEVISION_POR_CABLE) {
				if (this.controlParentalEstado == true && this.canalActualCable >= this.canalParaMayoresInicial && this.canalActualCable <= this.canalParaMayoresFinal) {
				System.out.println("Canal bloqueado por Control Parental");
				} else {
				
				this.canalActualCable = this.canalAnteriorCable;
				System.out.println("CH " + this.canalActualCable);
				}
			}			
	} else {
		System.out.println("El televisor está apagado");
		}
	}
	// g. silenciar [Mute]: Actualiza el valor del volumen en cero. 
	public void silenciar() {
		if (this.botonPower == true) {
					if(this.mute == false) {
						this.volumenAnterior = this.volumen;
						this.mute = true;
						this.volumen = this.volumenMinimo;
						System.out.println("VOL " + this.volumen);
					} else {
						this.mute = false;
						this.volumen = this.volumenAnterior;
						System.out.println("VOL " + this.volumen);
					}
		} else {
			System.out.println("El televisor está apagado");
			}			
	}
	//Set Volumen
	public void setVolumen(byte vol) {
		if (this.botonPower == true) {
			this.volumen = vol;
			System.out.println("VOL " + this.volumen);
		} else {
			System.out.println("El televisor está apagado");
			}
	}
	// Get Volumen Actual
	public void getVolumenActual() {
		if (this.botonPower == true) {
		System.out.println("VOL " + this.volumen);
		} else {
			System.out.println("El televisor está apagado");
			}
	}
	//h. activarControlParenteral ⑱: Activa la función. Recibe una contraseña de cuatro dígitos.
	public void activarControlParenterla(char digito1, char digito2, char digito3, char digito4) {
		if (this.botonPower == true) {
			short numero = (short) (Character.getNumericValue(digito1)*1000 + Character.getNumericValue(digito2)*100 + Character.getNumericValue(digito3)*10 + Character.getNumericValue(digito4));
				if (numero == this.claveControlParental) {
					this.controlParentalEstado = true;
					 System.out.println("Control parental Activado");
					 if (this.canalActualCable >= this.canalParaMayoresInicial && this.canalActualCable <= this.canalParaMayoresFinal) {
						 this.canalActualCable = (short) (this.canalParaMayoresFinal +1);
					 }
				}else {
					System.out.println( "Clave incorrecta");
			}
		} else {
			System.out.println("El televisor está apagado");
			}
	 }	
	// Desactivar Control Parental desactiva la función. Recibe una contraseña de cuatro dígitos
	public void deactivarElControlParenteral(char digito1, char digito2, char digito3, char digito4) {
		if (this.botonPower == true) {
			short numero = (short) (Character.getNumericValue(digito1)*1000 + Character.getNumericValue(digito2)*100 + Character.getNumericValue(digito3)*10 + Character.getNumericValue(digito4));
				if (numero == this.claveControlParental) {
					this.controlParentalEstado = false;
					System.out.println("Control parental Desactivado");
				}else {
					System.out.println("Clave incorrecta");
				}
		} else {
			System.out.println("El televisor está apagado");
			}
	 }
	// Get Entrada TV Aire
	public void getEntradaTelevisionDeAire() {
		if (this.botonPower == true) {
			this.entrada = this.ENTRADA_TELEVISION_DE_AIRE;
			System.out.println("TV de aire");
		} else {
			System.out.println("El televisor está apagado");
			}
	}
	// Get Entrada TV Cable
	public void  getEntradaTelevisionPorCable() {
		if (this.botonPower == true) {
			this.entrada = this.ENTRADA_TELEVISION_POR_CABLE;
			System.out.println("TV Cable");
		} else {
			System.out.println("El televisor está apagado");
			}
	}
	// Get Entrada
	public void  getEntradaHdmi1() {
		if (this.botonPower == true) {
			this.entrada = this.ENTRADA_HDMI1;
			System.out.println("HDMI1");
		} else {
			System.out.println("El televisor está apagado");
			}
	}
	// Get Entrada
	public void  getEntradaHdmi2() {
		if (this.botonPower == true) {
			this.entrada = this.ENTRADA_HDMI2;
			System.out.println("HDMI2");
		} else {
			System.out.println("El televisor está apagado");
			}
	}
	// Get Entrada
	public void  getEntradaUsb() {
		if (this.botonPower == true) {
			this.entrada = this.ENTRADA_USB;
			System.out.println("USB");
		} else {
			System.out.println("El televisor está apagado");
			}
	}
	// Get Entrada
	public String getNumeroDeSerie() {
		if (this.botonPower == true) {
			return "NRO DE SERIE: " + this.nroDeSerie;
		} else {
			return "El televisor está apagado";
			}
	}
	// Get Entrada
	public void isControlParenteralActivado() {
		if (this.botonPower == true) {
			if (this.controlParentalEstado == true) {
				System.out.println( "El control Parental se encuentra Activo");
			} else { 
				System.out.println( "El control Parental se encuentra Inactivo");
			}
		} else {
			System.out.println("El televisor está apagado");
			}
	}
	// Get Entrada
	public String isEncendido() {
		if (this.botonPower == true) {
			return "El Televisor está Encendido";
			} else {
				return "El Televisor se encuentra apagado";
		}	
	}
	// Get Entrada
	public void getCanalActual() {
		if (this.botonPower == true) {
			if (this.entrada == this.ENTRADA_TELEVISION_DE_AIRE) {
				System.out.println("CH " + this.canalActualAire);
			} else if (this.entrada == this.ENTRADA_TELEVISION_POR_CABLE) {
				System.out.println("CH " + this.canalActualCable);
			}
		} else {
			System.out.println("El televisor está apagado");
			}
	}
	// Get Entrada
	public void getEntradaActual() {
	if (this.botonPower == true) {
		switch (this.entrada) {
			case 'A':
				this.entrada = this.ENTRADA_TELEVISION_DE_AIRE;
				System.out.println("TV de aire");
				break;
			case 'C':
				this.entrada = this.ENTRADA_TELEVISION_POR_CABLE;
				System.out.println("TV Cable");
				break;
			case '1':
				this.entrada = this.ENTRADA_HDMI1;
				System.out.println("HDMI1");
				break;
			case '2':
				this.entrada = this.ENTRADA_HDMI2;
				System.out.println("HDMI2");
				break;
			case 'U':
				this.entrada = this.ENTRADA_USB;
				System.out.println("USB");
				break;
	}
	} else {
		System.out.println("El televisor está apagado");
		}
	}
} // Fin de clase