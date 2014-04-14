package fr.univsavoie.tptuples;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class TupleObservator extends JFrame implements Observer {
	
	JList<Tuple> currentTuples, lastDeletedTuples;
	
	TupleObservator() {
		super();
		this.setSize(800, 600);
		
		currentTuples = new JList<Tuple>();
		currentTuples.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		currentTuples.setVisibleRowCount(-1);
		
		lastDeletedTuples = new JList<Tuple>();
		lastDeletedTuples.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		lastDeletedTuples.setVisibleRowCount(-1);
		
		JScrollPane currentPanel = new JScrollPane(currentTuples), deletedPanel = new JScrollPane(lastDeletedTuples);
		currentPanel.setBounds(0,0,400,600);
		deletedPanel.setBounds(400,0,400,600);
		
		this.add(currentPanel);
		this.add(deletedPanel);
		TupleSystem.getInstance().addObserver(this);
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		TupleSystem ts = TupleSystem.getInstance();
		currentTuples.setListData(ts.getTupleSpace());
		lastDeletedTuples.setListData(ts.getDeletedTuple());
	}

}
