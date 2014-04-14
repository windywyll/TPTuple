package fr.univsavoie.tptuples;

import java.util.LinkedList;
import java.util.Random;

public class Logistic_get_agreement extends Thread{
	
	public void run(){
		TuplePattern patternIn, patternIn2;
		Tuple readTuple;
		LinkedList<TupleData> infosTuple;
		LinkedList<TupleData> infosTuplePattern, infosTuplePattern2;
		Tuple tupleOut;
		Random rng = new Random();
		
		infosTuplePattern = new LinkedList<TupleData>();
		infosTuplePattern.add(new TupleData("accept_offer", TupleType.STRING));
		infosTuplePattern.add(new TupleData(true));
		infosTuplePattern.add(new TupleData(true));
		infosTuplePattern.add(new TupleData(true));
		infosTuplePattern.add(new TupleData(true));
		infosTuplePattern.add(new TupleData(true));
		patternIn = new TuplePattern(infosTuplePattern);
		
		infosTuplePattern2 = new LinkedList<TupleData>();
		infosTuplePattern.add(new TupleData("initial_offer", TupleType.STRING));
		infosTuplePattern.add(new TupleData(true));
		infosTuplePattern.add(new TupleData(true));
		infosTuplePattern.add(new TupleData(true));
		infosTuplePattern.add(new TupleData(true));
		infosTuplePattern.add(new TupleData(true));
		patternIn2 = new TuplePattern(infosTuplePattern);
		
		TupleSystem ts = new TupleSystem();
		
		while(true){
			//construction patternIn
			readTuple = ts.in(patternIn);
			ts.in(patternIn2);
			
			//compute somethings;
			LinkedList<TupleData> readData = readTuple.getData();
			
			//construction tupleOut
			infosTuple = new LinkedList<TupleData>();
			infosTuple.add(new TupleData("start_production", TupleType.STRING));
			infosTuple.add(readData.get(2));
			infosTuple.add(readData.get(3));
			infosTuple.add(readData.get(4));
			infosTuple.add(readData.get(5));
			infosTuple.add(readData.get(6));
			tupleOut = new Tuple(infosTuple);
			
			ts.out(tupleOut);
			
			float cost = (float) readData.get(3).getData();
			
			float cost_transport = cost - rng.nextFloat()*500+1;
			if(cost_transport <= 0)
				cost_transport = cost/4 ;
			
			float cost_supplier = cost - rng.nextFloat()*500+1;
			if(cost_transport <= 0)
				cost_transport = cost/4 ;
			
			if(cost < cost_supplier + cost_transport){
				cost_supplier = cost/4;
				cost_transport = cost_supplier;
			}
			
			int time_transport = rng.nextInt(10)+1;
			int time_supplier = rng.nextInt(10)+1;
			
			infosTuple = new LinkedList<TupleData>();
			infosTuple.add(new TupleData("transporter_offer", TupleType.STRING));
			infosTuple.add(new TupleData(cost_transport ,TupleType.FLOAT));
			infosTuple.add(new TupleData(time_transport, TupleType.INTEGER));
			tupleOut = new Tuple(infosTuple);
			
			ts.out(tupleOut);
			
			infosTuple = new LinkedList<TupleData>();
			infosTuple.add(new TupleData("supplier_offer", TupleType.STRING));
			infosTuple.add(new TupleData(cost_supplier ,TupleType.FLOAT));
			infosTuple.add(new TupleData(time_supplier, TupleType.INTEGER));
			tupleOut = new Tuple(infosTuple);
			
			ts.out(tupleOut);
		}
	}
}
