package ab.demo;
import java.util.*;
import java.util.Random;
import ab.demo.Teoria;
import ab.demo.Estado;
import ab.demo.Chancho;
import ab.demo.JSON;

public class Solver {
	private List<Teoria> teorias;
	
	public Solver() {
		this.teorias = new ArrayList<Teoria>();
	}
	public void grabar() {
		JSON.write(this.teorias);
	}

	//Genera una teoria navie y para un determinado estado.
	public void generarTeoriaNaive(Estado estado_inicial) {
		Teoria teoria_inicial = new Teoria(estado_inicial);
		teoria_inicial.setCantidadFinal(estado_inicial.getCantidadInicial() - 1);
		teoria_inicial.setExitos(0);
		teoria_inicial.setUsos(1);
		//Setear maximo en lista
		int limite = 0;
		if ( estado_inicial.getCantidadInicial() > Estado.limite) {		
			limite = Estado.limite;
		} else {
			limite = estado_inicial.getCantidadInicial();
		}
		System.out.println("LIMITE :"+limite);
		boolean chancho_dummie = true;
		int random=0;
		List<Chancho> chanchosList = estado_inicial.getChanchos();
		while (chancho_dummie) {
			Random randomGenerator = new Random();
			random = randomGenerator.nextInt(limite);
			if (chanchosList.get(random).getValue() != Chancho.dummie) {
				chancho_dummie = false;
			}
		}
		teoria_inicial.setAccion(random);
		this.agregarTeoria(teoria_inicial);
	}
	//Aca hay q hacer la magia de combinar teorias
	public void agregarTeoria(Teoria teoria_nueva) {
		Iterator<Teoria> iTeoria = this.teorias.iterator();
		Teoria teoria;
		while (iTeoria.hasNext()) {
			teoria = iTeoria.next();
			if (teoria.esIgual(teoria_nueva)) {
				System.out.println("Ya existia esa teoria");
				return;
			}
		}
		this.teorias.add(teoria_nueva);
	}
	public Teoria getTeoria(Estado estado) {
		//Generar teoria Naive para este estado
		System.out.println("----TEORIAS: "+ this.teorias.size());
		this.generarTeoriaNaive(estado);
		//Con este estado buscar la mejor teoria
		Iterator<Teoria> iTeoria = this.teorias.iterator();
		Teoria teoria;
		Teoria teoria_elegida = null;
		while (iTeoria.hasNext()) {
			teoria = iTeoria.next();
			if (teoria.getEstado().Igual(estado)) {
				if (teoria.mejorQue(teoria_elegida)) {
					teoria_elegida = teoria;
				}
			}
		}
		System.out.println("TEORIA :  ACCION:"+ teoria_elegida.getAccion() + " EXITOS:"+teoria_elegida.getExitos() +" USOS:"+teoria_elegida.getUsos());
		return teoria_elegida;
	}
}
