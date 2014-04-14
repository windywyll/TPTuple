package fr.univsavoie.tptuples;

import java.util.LinkedList;

public class Transporter_get_product_from_plant {
	int transport_id, plant_id;
	
	public Transporter_get_product_from_plant(int transporter_id, int plant_id){
		this.transport_id = transporter_id;
		this.plant_id = plant_id;
	}
	
	public void run(){
		TuplePattern patternIn, patternInImpl, patternRd;
		Tuple readTuple;
		LinkedList<TupleData> infosTuple;
		LinkedList<TupleData> infosTuplePattern;
		Tuple tupleOut;
		boolean run = true;
		
		infosTuplePattern = new LinkedList<TupleData>();
		infosTuplePattern.add(new TupleData("get_product_from_plant", TupleType.STRING));
		infosTuplePattern.add(new TupleData(true));
		infosTuplePattern.add(new TupleData(true));
		infosTuplePattern.add(new TupleData(transport_id, TupleType.INTEGER));
		patternRd = new TuplePattern(infosTuplePattern);
		
		infosTuplePattern = new LinkedList<TupleData>();
		infosTuplePattern.add(new TupleData("final_product", TupleType.STRING));
		infosTuplePattern.add(new TupleData(true));
		infosTuplePattern.add(new TupleData("plant", TupleType.STRING));
		infosTuplePattern.add(new TupleData(plant_id, TupleType.INTEGER));
		patternIn = new TuplePattern(infosTuplePattern);
		
		infosTuplePattern = new LinkedList<TupleData>();
		infosTuplePattern.add(new TupleData("production_finished", TupleType.STRING));
		infosTuplePattern.add(new TupleData(plant_id, TupleType.INTEGER));
		patternInImpl = new TuplePattern(infosTuplePattern);
		
		TupleSystem ts = TupleSystem.getInstance();
		
		while(run){
			//construction patternIn
			ts.rd(patternRd);
			readTuple = ts.in(patternIn);
			
			//compute somethings;
			LinkedList<TupleData> readData = readTuple.getData();
			
			//construction tupleOut
			infosTuple = new LinkedList<TupleData>();
			infosTuple.add(new TupleData("final_product", TupleType.STRING));
			infosTuple.add(readData.get(2));
			infosTuple.add(new TupleData("warehouse", TupleType.STRING));
			infosTuple.add(new TupleData(plant_id, TupleType.INTEGER));
			tupleOut = new Tuple(infosTuple);
			
			ts.out(tupleOut);
		}
	}
}
