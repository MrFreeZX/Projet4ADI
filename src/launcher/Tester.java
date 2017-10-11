package launcher;

import java.io.File;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Instance;
import model.InstanceList;
import model.Matrix;
import model.IOCsv;
import model.IOGraph;

public class Tester {
	public static void main(String[] args) {
		
		
		
		Double[] array = {1.1, 2.2 , 3.3};
		Double[] array2 = {4.7, 8.3 , 10.1};
		Double[] array3 = {6.0, 2.8 , 9.7};
		
		Instance i1 = new Instance(array);
		InstanceList iList= new InstanceList(3);
		
		iList.addInstance(i1);
		iList.addInstance(new Instance(array2));
		iList.addInstance(new Instance(array3));
		
		InstanceList i2 = null;
		try 
		{
			i2= new InstanceList (IOCsv.importCsv(new File("src/wine.data.txt"))); //interface pour afficher le graphe , temps de progression, temps de calcul
		} catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<List<Double>> arcsList = i2.calculateArcs();
		
		try {
			IOGraph.exportGraphCsv("src/arcsList.csv", "src/nodesList.csv", arcsList);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//output csv (un avec classe + noeud l'autre cf IOGraph)
		//paralleliser
		//Mini-rapport avec diagramme de classe
		
	}
}