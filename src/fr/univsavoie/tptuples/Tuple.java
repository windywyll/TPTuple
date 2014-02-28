package fr.univsavoie.tptuples;

import java.util.List;
import java.util.Map.Entry;

public class Tuple {
	
	private List<Entry<Object,TupleType>> Data;
	
	public boolean match(TuplePattern pattern)	{
		return false;
	}
	
}
