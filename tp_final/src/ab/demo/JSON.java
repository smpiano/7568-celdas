package ab.demo;

import java.io.File;
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
	private static final String FILE_NAME = "teorias.json";
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

			JSONArray jsonArrayTeorias = new JSONArray();

			for (Teoria unaTeoria : teorias) {
			

				JSONObject unJSONObj = new JSONObject();

				int i =0;
				for (Chancho unChancho : unaTeoria.getEstado().getChanchos()){
					unJSONObj.put("chancho "+i,unChancho.getValue());
					i++;
				}
				unJSONObj.put("tipoPajaro", JSON.getID(unaTeoria.getBird()));
				unJSONObj.put("cantInicial", unaTeoria.getCantidadInicial());
				unJSONObj.put("cantFinal", unaTeoria.getCantidadFinal());
				unJSONObj.put("accion", unaTeoria.getAccion());
				unJSONObj.put("exitos", unaTeoria.getExitos());
				unJSONObj.put("usos", unaTeoria.getUsos());

				//agregar jsonobject al jsonarray
				jsonArrayTeorias.add(unJSONObj);
			
			}

			JSONObject mainJSONObj = new JSONObject();
			mainJSONObj.put("teorias",jsonArrayTeorias);
			//escribir en el archivo el json array
			FileWriter file = new FileWriter(FILE_NAME);
			file.write(mainJSONObj.toJSONString());
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
			File teo = new File(FILE_NAME);
			if (teo.exists()) System.out.println("===> Se reconoce el archivo de teorias <" + teo.getAbsolutePath() + ">");
			Object unObjeto = parser.parse(new FileReader(FILE_NAME));
			JSONObject mainJSONObj = (JSONObject) unObjeto;
			JSONArray teoriasJSON = (JSONArray) mainJSONObj.get("teorias");
			for (int i = 0, size = teoriasJSON.size(); i < size; i++){
				JSONObject unaTeoria = (JSONObject) teoriasJSON.get(i); //No estoy seguro de esta linea. O es .get(i) o .getJSONObject(i)
				List<Chancho> chanchos = new ArrayList<Chancho>();
							
			
				//Crear el birdtype
				long birdType = (Long) unaTeoria.get("tipoPajaro");
				long cantInicial = (Long) unaTeoria.get("cantInicial");	
				long cantFinal = (Long) unaTeoria.get("cantFinal");
				long accion = (Long) unaTeoria.get("accion");
				long exitos = (Long) unaTeoria.get("exitos");	
				long usos = (Long) unaTeoria.get("usos");
				Long value;		
				for (int j=0; j < Estado.limite; j++){
					value = (Long) (unaTeoria.get("chancho "+ j));					
					chanchos.add(new Chancho(0,(int) (long) value));
				}
				Collections.sort(chanchos);
				Estado estado = new Estado(chanchos,(int)cantInicial, JSON.getABType((int)birdType));
				Teoria teoria = new Teoria(estado);
				teoria.setAccion((int)accion);
				teoria.setUsos((int)usos);
				teoria.setExitos((int)exitos);
				teoria.setCantidadFinal((int)cantFinal);

				teorias.add(teoria);
			}	

	
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
