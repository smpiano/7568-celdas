package ab.demo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import ab.vision.ABType;
import ab.demo.Teoria;
import ab.demo.Chancho;
import ab.demo.Estado;
import java.util.*;


public class JSON {
	//	RedBird(4), 
	//	YellowBird(5), 
	//	BlueBird(6), 
	//	BlackBird(7), 
	//	WhiteBird(8)
	public static int getID(ABType bird) {
		int retorno=0;
		switch (bird) {
			case RedBird: 
				retorno= 4;break;
			case YellowBird:
				retorno= 5;break;
			case BlackBird:
				retorno= 7;break;
			case BlueBird:
				retorno= 6;break;
			case WhiteBird:
				retorno= 8;break;
			default:
				retorno =  0;
		}
		return retorno;
	}
	public static ABType getABType(int id) {
		ABType retorno=null;
		switch (id) {
			case 4: 
				retorno= ABType.RedBird;break;
			case 5:
				retorno= ABType.YellowBird;break;
			case 7:
				retorno= ABType.BlackBird;break;
			case 6:
				retorno= ABType.BlueBird;break;
			case 8:
				retorno= ABType.WhiteBird;break;
			default:
				retorno = ABType.Unknown;
		}
		return retorno;
	}
	public static void write(List<Teoria> teorias){
		try {
			FileWriter file = new FileWriter("teorias.json");

			for (Teoria unaTeoria : teorias) {
			

				JSONObject unJSONObj = new JSONObject();

				JSONArray listaChanchos = new JSONArray();
				for (Chancho unChancho : unaTeoria.getEstado().getChanchos()){
					listaChanchos.add(unChancho.getValue());
				}

				unJSONObj.put("tipoPajaro", JSON.getID(unaTeoria.getBird()));
				unJSONObj.put("cantInicial", unaTeoria.getCantidadInicial());
				unJSONObj.put("cantFinal", unaTeoria.getCantidadFinal());
				unJSONObj.put("accion", unaTeoria.getAccion());
				unJSONObj.put("exitos", unaTeoria.getExitos());
				unJSONObj.put("usos", unaTeoria.getUsos());
				unJSONObj.put("chanchos", listaChanchos);

			
				file.write(unJSONObj.toJSONString());
				}
				file.flush();
				file.close();
			} catch (IOException e) {
				e.printStackTrace();
				
			}
	}

	public static List<Teoria> read(){

		JSONParser parser = new JSONParser();
		List<Teoria> teorias = new ArrayList<Teoria>();

		try {
	
			Object unObjeto = parser.parse(new FileReader("teorias.json"));
	
			JSONObject unJSONObj = (JSONObject) unObjeto;
	
			JSONArray listaChanchos = (JSONArray) unJSONObj.get("chanchos");
			List<Chancho> chanchos = new ArrayList<Chancho>();
			Iterator<JSONObject> iterator = listaChanchos.iterator();
			while (iterator.hasNext()) {
				//chanchos.add(new Chancho(0,iterator.next().get()));
				
			}
			Collections.sort(chanchos);
			//Crear el birdtype
			int birdType = (Integer) unJSONObj.get("tipoPajaro");
			int cantInicial = (Integer) unJSONObj.get("cantInicial");	
			int cantFinal = (Integer) unJSONObj.get("cantFinal");	
			int accion = (Integer) unJSONObj.get("accion");
			int exitos = (Integer) unJSONObj.get("exitos");	
			int usos = (Integer) unJSONObj.get("usos");	
			Estado estado = new Estado(chanchos,cantInicial, JSON.getABType(birdType));
			Teoria teoria = new Teoria(estado);
			teoria.setAccion(accion);
			teoria.setUsos(usos);
			teoria.setExitos(exitos);
			teoria.setCantidadFinal(cantFinal);
			

	
			} catch (FileNotFoundException e2) {
				e2.printStackTrace();
			} catch (IOException e3) {
				e3.printStackTrace();
			} catch (ParseException e4) {
				e4.printStackTrace();
			}
		
		return teorias;
	} 
}
