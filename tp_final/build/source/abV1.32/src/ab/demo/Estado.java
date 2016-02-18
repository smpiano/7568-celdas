package ab.demo;
import ab.demo.Chancho;
import ab.demo.Sensor;
import java.util.*;


public class Estado {
	private List<Chancho> chanchos;
	private int cantidad_inicial;
	public static int limite = 3;

	public Estado(Sensor sensor) {
		this.chanchos = sensor.getChanchos();
		this.cantidad_inicial = sensor.getCantidad();
	}

	//Comparar si los estados iniciales son iguales
	public boolean Igual(Estado estado) {
		if (cantidad_inicial != estado.getCantidadInicial()) {
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

}
