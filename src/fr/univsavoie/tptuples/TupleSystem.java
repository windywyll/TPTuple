package fr.univsavoie.tptuples;

public final class TupleSystem {
	
	private static final TupleSystem instance = new TupleSystem();
	
	public TupleSystem getInstance(){
		return TupleSystem.instance;
	}
	
	public Tuple in (TuplePattern pattern) {
		return new Tuple();
	}
	
	public Tuple rd (TuplePattern pattern){
		return new Tuple();
	}
	
	public void out (Tuple tuple) {
		
	}
	
	
}
