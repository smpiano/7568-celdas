package ab.demo;
import ab.demo.Chancho;
import ab.demo.Sensor;
import ab.vision.ABType;
import java.util.*;


public class Estado {
	private List<Chancho> chanchos;
	private int cantidad_inicial;
	public static int limite = 3;
	private ABType birdType;

	public Estado(Sensor sensor) {
		this.chanchos = sensor.getChanchos();
		this.cantidad_inicial = sensor.getCantidad();
		this.birdType = sensor.getBird();
	}
	public Estado(List<Chancho> chanchos, int cantidad_inicial, ABType birdType) {
		this.chanchos = chanchos;
		this.cantidad_inicial = cantidad_inicial;
		this.birdType = birdType;
	}

	//Comparar si los estados iniciales son iguales
	public boolean Igual(Estado estado) {
		if (this.cantidad_inicial != estado.getCantidadInicial()) {
			return false;
		}
		if (this.birdType != estado.getBird()) {
			return false;
		}
		List<Chancho> chanchos_list = estado.getChanchos();
		Iterator<Chancho> iChanchos1 = chanchos_list.iterator();
		Iterator<Chancho> iChanchos2 = this.chanchos.iterator();
		Chancho chancho1,chancho2;
		while (iChanchos1.hasNext()) {
			chancho1 = iChanchos1.next();
			chancho2 = iChanchos2.next();
    		if (chancho1.getValue() != chancho2.getValue()) {
				return false;
			}
		}
		return true;
	}
	public int getCantidadInicial() {
		return this.cantidad_inicial;
	}
	public List<Chancho> getChanchos() {
		return this.chanchos;
	}
	public ABType getBird() {
		return this.birdType;
	}

}
