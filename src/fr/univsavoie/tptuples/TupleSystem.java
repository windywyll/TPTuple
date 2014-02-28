package fr.univsavoie.tptuples;

import java.util.Iterator;
import java.util.LinkedList;

public final class TupleSystem {
	
	////////////////
	//STATIC MEMBERS
	////////////////
	
	private static final TupleSystem instance = new TupleSystem();
	
	public TupleSystem getInstance(){
		return TupleSystem.instance;
	}
	
	///////////////
	//OBJECT MEMBER
	///////////////
	
	private LinkedList<Tuple> TupleSpace;
	private boolean reading;
	
	public Tuple in (TuplePattern pattern) {
		Iterator<Tuple> it = TupleSpace.iterator();
		while (true) {
			while (reading)
			{};
			reading = true;
			if(it.hasNext()){
				
				Tuple tp = it.next();
				if(pattern.match(tp)) {
						it.remove();
						return tp;
				}
			}
			reading = false;
		}
	}
	
	public Tuple rd (TuplePattern pattern){
		Iterator<Tuple> it = TupleSpace.iterator();
		while (true) {
			while (reading)
			{};
			reading = true;
			if(it.hasNext()) {
				Tuple tp = it.next();
				if(pattern.match(tp)) {
						return tp;
				}
			}
			reading = false;
		}
	}
	
	public Tuple in_impl (TuplePattern pattern) {
		Iterator<Tuple> it = TupleSpace.iterator();
		while (true) {
			while (reading)
			{};
			reading = true;
			if(it.hasNext()){
				
				Tuple tp = it.next();
				if(pattern.match(tp)) {
						it.remove();
						return tp;
				}
			} else {
				reading = false;
				break;
			}
			reading = false;
		}
		return null;
	}
	
	public Tuple rd_impl (TuplePattern pattern){
		Iterator<Tuple> it = TupleSpace.iterator();
		while (true) {
			while (reading)
			{};
			reading = true;
			if(it.hasNext()) {
				Tuple tp = it.next();
				if(pattern.match(tp)) {
						return tp;
				}
			} else {
				reading = false;
				break;
			}
			reading = false;
		}
		return null;
	}
	
	public void out (Tuple tuple) {
		TupleSpace.add(tuple);
	}
}
