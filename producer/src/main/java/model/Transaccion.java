package model;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({

"idTransaccion",

"nombre",

"carnet",

"correo",

"monto",

"moneda",

"cuentaOrigen",

"bancoDestino",

"detalle"})
	
public class Transaccion {
	
		
		
	
	
	private String idTransaccion;
	private String Nombre;
	private String Carnet;
	private String Correo;
	private double monto;
	private String moneda;
	private String cuentaOrigen;
	private String bancoDestino;
	public Detalle detalle;

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getCarnet() {
		return Carnet;
	}

	public void setCarnet(String carnet) {
		Carnet = carnet;
	}

	public String getCorreo() {
		return Correo;
	}

	public void setCorreo(String correo) {
		Correo = correo;
	}

	


	
	public String getBancoDestino () {
		return bancoDestino;
	}
	
	public double getMonto() {
		return monto;
	}

	public String getMoneda() {
		return moneda;
	}

	
	public String getIdTransaccion() {
		return idTransaccion;
	}

	
	public String getCuentaOrigen() {
		return cuentaOrigen;
	}


}

