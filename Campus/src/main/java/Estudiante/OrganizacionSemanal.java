package Estudiante;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JSlider;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.awt.event.ItemEvent;
import javax.swing.JButton;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject; 
import org.json.*;
import org.json.simple.parser.*; 
import com.google.gson.*;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;

public class OrganizacionSemanal extends JPanel {
	
	public static String [] Tareassemana1 = {};
	public static int semana = 1;
	
	
	/**
	 * Create the panel.
	 */
	public OrganizacionSemanal(){
		/*
		JSONObject ObjetoSemana = new JSONObject();
		
		ObjetoSemana.put("Semana", 1);
		
		JSONArray Retos = new JSONArray();
		Map mapaRetos = new LinkedHashMap(3);
		mapaRetos.put("nombre","Autoestima");
		mapaRetos.put("FechaVencimiento", "10-10-20");
		
		JSONArray Objetivos = new JSONArray();
		Map mapaObjetivos = new LinkedHashMap(2);
		mapaObjetivos.put("1", "Elevar Autoestima");
		mapaObjetivos.put("2", "Mejorar notas");
		Objetivos.add(mapaObjetivos);
		
		mapaRetos.put("Objetivos",Objetivos);
		mapaRetos.put("TEC-Colones", "34");
		
		
		
		
		Retos.add(mapaRetos);
		ObjetoSemana.put("Retos", Retos);
		System.out.println(ObjetoSemana);
		*/
		setLayout(null);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (arg0.getStateChange() == ItemEvent.SELECTED) {
					int semana = comboBox.getSelectedIndex();
					setSemana(semana);
				}
			}
		});
		comboBox.setBounds(219, 21, 124, 32);
		
		JTree tree = new JTree();
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent e) {
				Object obj = e.getNewLeadSelectionPath().getLastPathComponent();
			     System.out.println("" + obj.toString());
			}
		});
		tree.setBounds(21, 0, 98, 342);
		add(tree);
		
		try {
			Object obj = new JSONParser().parse(new FileReader("../semana.json"));
			JSONObject Semanas = (JSONObject) obj; 
			JSONArray Semana = (JSONArray) Semanas.get("semanas"); 
			Iterator iteradorSemana = Semana.iterator();
			
			int contador = 1;
			comboBox.addItem(null);
			while(iteradorSemana.hasNext()) {
				
				comboBox.addItem("Semana "+ contador);
				iteradorSemana.next();
				contador += 1;
			}
			contador = 0;
			add(comboBox);
			
			/*Aqui empieza el algoritmo para leer el json*/
			
			
			Gson gson = new Gson();
			String json = gson.toJson(obj);
			
			
			ListaSemanas listaSemanas = gson.fromJson(json, ListaSemanas.class);
			System.out.println(listaSemanas.getSemana());
			System.out.println(listaSemanas.getSemana().get(0).getRetos().get(0).getNombreReto());		
			
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	public void setSemana(int semana){
		this.semana = semana;
		System.out.println(semana);
	}
}
