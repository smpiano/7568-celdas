package ab.demo;
import java.util.*;
import ab.vision.ABObject;
import ab.vision.ABType;
import ab.vision.Vision;
import ab.demo.Chancho;
import java.awt.Point;

public class Sensor{
	private List<ABObject> pigs;
	private int cantidad_inicial;
	private ABType birdType;

	public Sensor(List<ABObject> pigs, ABType birdType) {
		this.cantidad_inicial = pigs.size();
		this.birdType = birdType;
		this.pigs = pigs;
	}
	public void setPigs(List<ABObject> pigs) {
		this.pigs = pigs;
	}
	//Ordenar lista de chanchos
	public List<Chancho> getChanchos() {
		List<Chancho> chanchos = new ArrayList<Chancho>();
		Iterator<ABObject> iPigs = this.pigs.iterator();
		ABObject chancho=null;
		int suma= 0;
		int iterator=0;
		Point _tpt;
		while (iPigs.hasNext()) {
			iterator++;
			chancho = iPigs.next();
			_tpt = chancho.getCenter();
			suma = suma + _tpt.x;
		}
		int centro_x = suma/iterator;
		iPigs = this.pigs.iterator();
		iterator = 0;
		while (iPigs.hasNext()) {
			chancho = iPigs.next();
			_tpt = chancho.getCenter();
			chanchos.add(new Chancho(iterator,(this.abs(_tpt.x - centro_x))/5));
			iterator++;
		}
		//Agrego chanchos falsos para llegar a la cantidad limite
		while(chanchos.size() < Estado.limite) {
			chanchos.add(new Chancho(0,Chancho.dummie));
		}
		//Ordenar por value
		Collections.sort(chanchos);
		//Sacar Chanchos que sobran
		while(chanchos.size() > Estado.limite) {
			chanchos.remove(chanchos.size()-1);
		}
		return chanchos;
	}

	public int getCantidad() {
		return this.pigs.size();
	}
	public ABType getBird() {
		return this.birdType;
	}
	
	private int abs (int numero) {
      return numero > 0 ? numero : -numero;
	}
}
