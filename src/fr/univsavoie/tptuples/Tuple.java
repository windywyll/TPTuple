package fr.univsavoie.tptuples;

import java.util.LinkedList;
import java.util.Map.Entry;

public class Tuple {
	
	private LinkedList<Entry<Object,TupleType>> data;
	
	public int size() {
		return data.size();
	}

	public Tuple (LinkedList<Entry<Object,TupleType>> data) {
		this.data = data;
	}
	
	public boolean match(TuplePattern pattern)	{
		if(pattern.size() != this.size())
			return false;
		while()
	}

	public LinkedList<Entry<Object, TupleType>> getData() {
		return data;
	}

	public void setData(LinkedList<Entry<Object, TupleType>> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		String str = "Tuple [";
		for(Entry<Object,TupleType> entry : data){
			str += " "+entry.getKey();
			switch(entry.getValue())
			{
			case STRING :
				str +=", string;";
				break;
			case INTEGER :
				str +=", int;";
				break;
			case FLOAT :
				str +=", float;";
				break;
			default:
				break;
			}
		}
		str = str.substring(0, str.length()-2);
		str += "]";
		return str;
	}
}
