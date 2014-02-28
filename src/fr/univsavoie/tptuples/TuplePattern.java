package fr.univsavoie.tptuples;

import java.util.Iterator;
import java.util.LinkedList;

public class TuplePattern {
	private LinkedList<TupleData> pattern;
	
	public int size() {
		return pattern.size();
	}
	
	public boolean match(Tuple tuple)	{
		if(tuple.size() != this.size())
			return false;
		Iterator<TupleData> it = this.pattern.iterator();
		for(TupleData p : tuple.getData())
		{
			if(!p.match(it.next()))
				return false;
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
