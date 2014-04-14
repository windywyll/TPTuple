package fr.univsavoie.tptuples;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Vector;

public final class TupleSystem extends Observable {
	
	////////////////
	//STATIC MEMBERS
	////////////////
	
	private static final TupleSystem instance = new TupleSystem();
	
	public static TupleSystem getInstance(){
		return TupleSystem.instance;
	}
	
	///////////////
	//OBJECT MEMBER
	///////////////
	
	private TupleSystem()
	{
		TupleSpace = new Vector<Tuple>();
		DeletedTuple = new Vector<Tuple>();
		reading = false;
	}
	
	private Vector<Tuple> TupleSpace;
	private boolean reading;
	
	private Vector<Tuple> DeletedTuple;//only used for display
	
	public Vector<Tuple> getDeletedTuple() {
		return DeletedTuple;
	}
	
	public void clearDeletedTuples()
	{
		DeletedTuple.clear();
	}

	public Tuple in (TuplePattern pattern) {
		Iterator<Tuple> it = TupleSpace.iterator();
		while (true) {
			while (reading)
			{};
			reading = true;
			if(it.hasNext()){
				
				Tuple tp = it.next();
				if(pattern.match(tp)) {
						DeletedTuple.add(tp);
						it.remove();
						setChanged();
						notifyObservers();
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
						DeletedTuple.add(tp);
						it.remove();
						setChanged();
						notifyObservers();
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
		setChanged();
		notifyObservers();
	}
	
	public Vector<Tuple> getTupleSpace() {
		return TupleSpace;
	}
	
	public static void main (String args[]) throws InterruptedException
	{
		TupleSystem ts = TupleSystem.getInstance();
		
		TupleObservator fenetre = new TupleObservator();
		fenetre.setVisible(true);
		System.out.println("here");
		LinkedList<TupleData> td = new LinkedList<TupleData>();
		td.add(new TupleData("testeuh", TupleType.STRING));
		td.add(new TupleData(435, TupleType.INTEGER));
		ts.out(new Tuple(td));
		ts.in(new TuplePattern(td));
		System.out.println("here");
	}

}
