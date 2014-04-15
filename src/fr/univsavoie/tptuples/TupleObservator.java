package fr.univsavoie.tptuples;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class TupleObservator extends JFrame{
	
	JList<Tuple> currentTuples;
	
	TupleObservator() {
		super();
		this.setSize(400, 600);
		
		currentTuples = new JList<Tuple>();
		currentTuples.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		currentTuples.setVisibleRowCount(-1);
		
		JScrollPane currentPanel = new JScrollPane(currentTuples);
		currentPanel.setBounds(0,0,400,600);
		
		this.add(currentPanel);
		TupleSystem.getInstance().setObserver(this);
	}
	
	public void updateData() {
		TupleSystem ts = TupleSystem.getInstance();
		currentTuples.setListData(ts.getTupleSpace());
		this.update(this.getGraphics());
	}

}
