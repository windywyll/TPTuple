package fr.univsavoie.tptuples;

import java.util.LinkedList;
import java.util.Map.Entry;

public class Tuple {
	
	private LinkedList<Pair<Object,TupleType>> data;
	
	public int size() {
		return data.size();
	}

	public Tuple (LinkedList<Pair<Object,TupleType>> data) {
		this.data = data;
	}

	public LinkedList<Pair<Object, TupleType>> getData() {
		return data;
	}

	public void setData(LinkedList<Pair<Object, TupleType>> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		String str = "Tuple [";
		for(Pair<Object,TupleType> p : data){
			str += " "+p.getFirst();
			switch(p.getSecond())
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
