package fr.univsavoie.tptuples;

import java.util.LinkedList;
import java.util.Random;

public class Agent_System extends Thread{
	
	public void run(){
		System.out.println("Début Programme Tuple");
		
		Random rand = new Random();
		int plant_id = rand.nextInt(500000);
		int transport_id = rand.nextInt(500000);
		int supp_id = rand.nextInt(500000);
		
		Logistics_get_needs lgn = new Logistics_get_needs();
		Logistic_get_agreement lga = new Logistic_get_agreement();
		Customer_get_counter_offer cco = new Customer_get_counter_offer();
		Customer_get_counter_offer_transporter ccot = new Customer_get_counter_offer_transporter();
		Customer_get_counter_offer_suppliers ccos = new Customer_get_counter_offer_suppliers();
		Plant_get_offer pgo = new Plant_get_offer(plant_id);
		Plant_start_production psp = new Plant_start_production(plant_id);
		Supplier_get_offer sgo = new Supplier_get_offer(supp_id);
		Transporter_get_offer tgo = new Transporter_get_offer(transport_id);
		
		Plant_product pp = new Plant_product(plant_id);
		Transporter_get_product_from_plant tgpp = new Transporter_get_product_from_plant(transport_id, plant_id);
		Transporter_get_product_from_warehouse tgpw = new Transporter_get_product_from_warehouse(transport_id, plant_id);
		
		System.out.println("Agents crées");
		
		LinkedList<TupleData> infosTuple;
		Tuple tupleOut;
		TupleSystem ts = TupleSystem.getInstance();
		
		infosTuple = new LinkedList<TupleData>();
		infosTuple.add(new TupleData("customer_need", TupleType.STRING));
		infosTuple.add(new TupleData(rand.nextInt(1000)+1, TupleType.INTEGER));
		tupleOut = new Tuple(infosTuple);
		
		ts.out(tupleOut);
		
		System.out.println("Besoin Client");
		
		try {
			Thread.sleep(TupleSystem.SLEEP);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		lgn.start();
		lga.start();
		cco.start();
		ccot.start();
		ccos.start();
		pgo.start();
		psp.start();
		sgo.start();
		tgo.start();
		pp.start();
		tgpp.start();
		tgpw.start();
		
		System.out.println("Agents start");
	}
	
}
