package fr.univsavoie.tptuples;

import java.util.LinkedList;
import java.util.Map.Entry;

public class TuplePattern {
	private LinkedList<TupleData> pattern;
	
	public int size() {
		return pattern.size();
	}
	
	public boolean match(Tuple tuple)	{
		if(tuple.size() != this.size())
			return false;
		for(TupleData p : tuple.getData())
		{
			
		}
		return true;
	}

	public TuplePattern(LinkedList<TupleData> pattern)
	{
		this.pattern = pattern;
	}

	public LinkedList<TupleData> getPattern() {
		return pattern;
	}

	public void setPattern(LinkedList<TupleData> pattern) {
		this.pattern = pattern;
	}
	
}
