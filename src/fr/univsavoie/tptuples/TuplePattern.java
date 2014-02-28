package fr.univsavoie.tptuples;

import java.util.LinkedList;
import java.util.Map.Entry;

public class TuplePattern {
	private LinkedList<Entry<Object,TupleType>> pattern;
	
	public int size() {
		return pattern.size();
	}

	public TuplePattern(LinkedList<Entry<Object,TupleType>> pattern)
	{
		this.pattern = pattern;
	}

	public LinkedList<Entry<Object, TupleType>> getPattern() {
		return pattern;
	}

	public void setPattern(LinkedList<Entry<Object, TupleType>> pattern) {
		this.pattern = pattern;
	}
	
}
