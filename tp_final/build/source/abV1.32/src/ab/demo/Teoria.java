package ab.demo;
import ab.vision.ABType;
import ab.demo.Estado;

public class Teoria {
	private Estado estado_inicial;
	private int cantidad_final;
	private int accion;
	private int exitos;
	private int usos;

	public Teoria(Estado estado) {
		this.estado_inicial = estado;
	}

	//Levantar desde archivo
	public Teoria() {
	}

	public void setCantidadFinal(int newCantidad_final) {
		this.cantidad_final = newCantidad_final;
	}
	
	public void setExitos(int newExitos)  {
		this.exitos = newExitos;
	}

	public void setUsos(int newUsos) {
		this.usos = newUsos;
	}

	public void setAccion(int newAction) {
		this.accion = newAction;
	}

	public int getAccion() {
		return this.accion;
	}

	public Estado getEstado() {
		return this.estado_inicial;
	}

	//Retorna true si la teoria es mejor a la pasada
	public boolean mejorQue(Teoria teoria) {
		if (teoria == null) {
			return true;
		}
		if (teoria.getRate() < this.getRate()) {
			return true;
		}
		return false;
	}
	
	public boolean esIgual(Teoria teoria) {
		if (teoria.getEstado().Igual(this.getEstado()) && teoria.getAccion() == this.getAccion()) {
			return true;
		} else {
			return false;
		}
	}
	
	public double getRate() {
		double rate =  (this.getCantidadInicial()-this.cantidad_final) * (this.exitos * 1.0/this.usos);
		return rate;
	}

	public int getCantidadFinal() {
		return this.cantidad_final;
	}

	public int getCantidadInicial() {
		return this.estado_inicial.getCantidadInicial();
	}
	
	public int getExitos()  {
		return this.exitos;
	}

	public int getUsos() {
		return this.usos;
	}
	public ABType getBird() {
		return this.estado_inicial.getBird();
	}
}

