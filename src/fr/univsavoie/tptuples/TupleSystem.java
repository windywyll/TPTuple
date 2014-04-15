package fr.univsavoie.tptuples;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Vector;

public final class TupleSystem {
	
	////////////////
	//STATIC MEMBERS
	////////////////
	
	private static final TupleSystem instance = new TupleSystem();
	
	private TupleObservator observer;
	public static final int SLEEP = 1000;
	
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
						if(observer != null)
							observer.updateData();
						return tp;
				}
			}
			reading = false;
			try {
				Thread.sleep(TupleSystem.SLEEP);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
			try {
				Thread.sleep(TupleSystem.SLEEP);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
						if(observer != null)
							observer.updateData();
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
		if(observer != null)
			observer.updateData();
	}
	
	public Vector<Tuple> getTupleSpace() {
		return TupleSpace;
	}
	
	public static void main (String args[]) throws InterruptedException
	{		
		TupleObservator fenetre = new TupleObservator();
		fenetre.setVisible(true);
		Agent_System as = new Agent_System();
		as.start();
	}

	public TupleObservator getObserver() {
		return observer;
	}

	public void setObserver(TupleObservator observer) {
		this.observer = observer;
	}

}
