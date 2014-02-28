package fr.univsavoie.tptuples;

import java.util.LinkedList;
import java.util.Map.Entry;

public class Tuple {
	
	private LinkedList<TupleData> data;
	
	public int size() {
		return data.size();
	}

	public Tuple (LinkedList<TupleData> data) {
		this.data = data;
	}

	public LinkedList<TupleData> getData() {
		return data;
	}

	public void setData(LinkedList<TupleData> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		String str = "Tuple [";
		for(TupleData p : data){
			str += " "+p.getData();
			switch(p.getType())
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
