package fr.univsavoie.tptuples;

public class TupleData {
	public boolean query = false;
	public final Object data;
	public final TupleType type;
	
	TupleData(Object data, TupleType type) {
		this.data = data;
		this.type = type;
		this.query = false;
	}
	
	TupleData(boolean query) {
		this.data = null;
		this.type = null;
		this.query = query;
	}

	public boolean isQuery() {
		return query;
	}

	public Object getData() {
		return data;
	}

	public TupleType getType() {
		return type;
	}
	
	public boolean equals(Object other) {
    	if (other instanceof TupleData) {
    		TupleData otherTupleData = (TupleData) other;
    		return 
    		(  this.query == otherTupleData.query ) &&
    		((  this.data == otherTupleData.data ||
    			( this.data != null && otherTupleData.data != null &&
    			  this.data.equals(otherTupleData.data))) &&
    		 (	this.type == otherTupleData.type ||
    			( this.type != null && otherTupleData.type != null &&
    			  this.type.equals(otherTupleData.type))) );
    	}
    	return false;
    }
    
    public boolean match(TupleData tupleData){
    	if (query)
    		return true;
    	if(this.equals(tupleData))
    		return true;
    	return false;
    }
	
}
