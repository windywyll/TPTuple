package fr.univsavoie.tptuples;

import java.util.LinkedList;
import java.util.Random;

public class Plant_start_production extends Thread{
	
	int id;
	
	public Plant_start_production(int plant_id){
		id = plant_id;
	}
	
	public void run(){
		TuplePattern patternIn;
		Tuple readTuple;
		LinkedList<TupleData> infosTuple;
		LinkedList<TupleData> infosTuplePattern;
		Tuple tupleOut;
		Random rng = new Random();
		
		infosTuplePattern = new LinkedList<TupleData>();
		infosTuplePattern.add(new TupleData("start_production", TupleType.STRING));
		infosTuplePattern.add(new TupleData(true));
		infosTuplePattern.add(new TupleData(true));
		infosTuplePattern.add(new TupleData(true));
		infosTuplePattern.add(new TupleData(true));
		infosTuplePattern.add(new TupleData(id, TupleType.INTEGER));
		patternIn = new TuplePattern(infosTuplePattern);
		
		TupleSystem ts = new TupleSystem();
		
		while(true){
			//construction patternIn
			readTuple = ts.in(patternIn);
			
			//compute somethings;
			LinkedList<TupleData> readData = readTuple.getData();
			
			//construction tupleOut
			infosTuple = new LinkedList<TupleData>();
			infosTuple.add(new TupleData("plant_product", TupleType.STRING));
			infosTuple.add(readData.get(5));
			infosTuple.add(readData.get(4));
			infosTuple.add(new TupleData(id, TupleType.INTEGER));
			tupleOut = new Tuple(infosTuple);
			
			ts.out(tupleOut);
		}
	}
}
