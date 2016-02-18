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

import ab.demo.Teoria;
import ab.demo.Chancho;
import ab.demo.Estado;

public class JSON {

	public static void write(List<Teoria> teorias){

		FileWriter file = new FileWriter("teorias.json");

		for (Teoria unaTeoria : teorias) {

			JSONObject unJSONObj = new JSONObject();

			JSONArray listaChanchos = new JSONArray();
			for (Chancho unChancho : unaTeoria.getEstado().getChanchos()){
				listaChanchos.add(unChancho.getValue());
			}
			unJSONObj.put("chanchos", listaChanchos);

			//unJSONObj.put("tipoPajaro", unaTeoria.getEstado().);
			unJSONObj.put("cantInicial", unaTeoria.getCantidadInicial());
			unJSONObj.put("cantFinal", unaTeoria.getCantidadFinal());
			unJSONObj.put("accion", unaTeoria.getAccion());
			unJSONObj.put("exitos", unaTeoria.getExitos());
			unJSONObj.put("usos", unaTeoria.getUsos());

			try {
				
				file.write(unJSONObj.toJSONString());
			} catch (IOException e) {
				e.printStackTrace();
				
			}
						

		}
		file.flush();
		file.close();
	
	}

	public static List<Teoria> read(){

		JSONParser parser = new JSONParser();

		try {
	
			Object unObjeto = parser.parse(new FileReader("teorias.json"));
	
			JSONObject unJSONObj = (JSONObject) unObjeto;
	
			JSONArray listaChanchos = (JSONArray) unJSONObj.get("chanchos");
			Iterator<int> iterator = listaChanchos.iterator();
			while (iterator.hasNext()) {
				//Crear una lista de chanchos
				}
			//Crear el birdtype
			//ABBirdType birdType = (ABBirdType) unJSONObj.get("tipoPajaro");
			int cantInicial = (Integer) unJSONObj.get("cantInicial");	
			int cantFinal = (Integer) unJSONObj.get("cantFinal");	
			int accion = (Integer) unJSONObj.get("accion");
			int exitos = (Integer) unJSONObj.get("exitos");	
			int usos = (Integer) unJSONObj.get("usos");	
			
			//

	
			} catch (FileNotFoundException e2) {
				e2.printStackTrace();
			} catch (IOException e3) {
				e3.printStackTrace();
			} catch (ParseException e4) {
				e4.printStackTrace();
			}
		

	} 
}
