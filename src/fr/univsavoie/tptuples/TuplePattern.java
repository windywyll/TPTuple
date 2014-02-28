package fr.univsavoie.tptuples;

import java.util.LinkedList;
import java.util.Map.Entry;

public class TuplePattern {
	private LinkedList<Pair<Object,TupleType>> pattern;
	
	public int size() {
		return pattern.size();
	}
	
	public boolean match(Tuple tuple)	{
		if(tuple.size() != this.size())
			return false;
		for(Pair p : tuple.getData())
	}

	public TuplePattern(LinkedList<Pair<Object,TupleType>> pattern)
	{
		this.pattern = pattern;
	}

	public LinkedList<Pair<Object, TupleType>> getPattern() {
		return pattern;
	}

	public void setPattern(LinkedList<Pair<Object, TupleType>> pattern) {
		this.pattern = pattern;
	}
	
}
