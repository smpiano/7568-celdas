package ab.demo;

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

	public void setCantidadFinal(int cantidad_final) {
		this.cantidad_final = cantidad_final;
	}
	
	public void setExitos(int exitos)  {
		this.exitos = exitos;
	}

	public void setUsos(int usos) {
		this.usos = usos;
	}

	public void setAction(int actions) {
		this.accion = accion;
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
		if ((teoria.getCantidadInicial()-teoria.getCantidadFinal())*(teoria.getExitos()/teoria.getUsos()) < (this.getCantidadInicial()-this.cantidad_final) * (this.exitos/this.usos)) {
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
}

