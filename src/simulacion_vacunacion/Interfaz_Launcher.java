package simulacion_vacunacion;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

public class Interfaz_Launcher extends JFrame implements ItemListener, ActionListener{

	
	public static int Tlim;
	public static int Npers;
	public static int CVac;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Interfaz_Launcher IL = new Interfaz_Launcher();
		IL.frame();
		IL.setBounds(0,0,400,310);
		IL.setTitle("Simulacion de Vacunacion");
		IL.setDefaultCloseOperation(EXIT_ON_CLOSE);
		IL.setLocationRelativeTo ( null );
		
	}
	//Entradas de Datos
	JFormattedTextField JTF_TL, JTF_CV, JTF_NP; 
	JFormattedTextField JTF_MDV;
	
	//MODULARES
	JRadioButton JRB_TL, JRB_CV, JRB_NP;
	//Botones
	JButton Sim;

	
	public void frame(){
		Container frame = this.getContentPane();
		frame .setLayout(null);
		setVisible(true);
		frame.setBackground(new Color(51,51,51));
		
		
		//nombres de las variables a ingresar por el usuario 
		JLabel TL = new JLabel("Tiempo Limite (min)");
		TL.setBounds(45,20,200,40);
		TL.setForeground(new Color(239, 156, 0));
		TL.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		
		JLabel CV = new JLabel("Cantidad de Vacunas");
		CV.setBounds(45,60,200,40);
		CV.setForeground(new Color(239, 156, 0));
		CV.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		
		JLabel NP = new JLabel("Numero de Personas");
		NP.setBounds(45,100,200,40);
		NP.setForeground(new Color(239, 156, 0));
		NP.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		
		JLabel NDM = new JLabel("Numero de Modulos");
		NDM.setBounds(45,140,200,40);
		NDM.setForeground(new Color(239, 156, 0));
		NDM.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		

		
		frame.add(TL);
		frame.add(CV);
		frame.add(NP);
		frame.add(NDM);
		

		//Seleccion del tipo de simulacion 
		JRB_TL = new JRadioButton("");
		JRB_TL.setBounds(15,30,20,20);
		JRB_TL.setBackground(new Color(51,51,51));
		JRB_TL.addItemListener(this);
		
		JRB_CV = new JRadioButton("");
		JRB_CV.setBounds(15,70,20,20);
		JRB_CV.setBackground(new Color(51,51,51));
		JRB_CV.addItemListener(this);
		
		JRB_NP = new JRadioButton("");
		JRB_NP.setBounds(15,110,20,20);
		JRB_NP.setBackground(new Color(51,51,51));
		JRB_NP.addItemListener(this);
		
		ButtonGroup bg=new ButtonGroup();   
		
		bg.add(JRB_TL);
		bg.add(JRB_CV);
		bg.add(JRB_NP);
		
		frame.add(JRB_TL);
		frame.add(JRB_CV);
		frame.add(JRB_NP);
		
		//Cuadro de texto con los valores
		
		//JTF_TL, JTF_CV, JTF_NP, JTF_NV;
		
		NumberFormat format = NumberFormat.getInstance();
	    NumberFormatter formatter = new NumberFormatter(format);
	    formatter.setValueClass(Integer.class);
	    formatter.setMinimum(1);
	    formatter.setMaximum(Integer.MAX_VALUE);
	    formatter.setAllowsInvalid(false);
	    formatter.setCommitsOnValidEdit(true);
	    

	    
		JTF_TL = new JFormattedTextField(formatter);
		JTF_TL.setEditable(false);
		JTF_TL.setBounds(250,25,100,30);
		JTF_TL.setBackground(new Color(159,159,159));
		JTF_TL.setForeground(new Color(239, 156, 0));
		JTF_TL.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		
		JTF_CV = new JFormattedTextField(formatter);
		JTF_CV.setEditable(false);
		JTF_CV.setBounds(250,65,100,30);
		JTF_CV.setBackground(new Color(159,159,159));
		JTF_CV.setForeground(new Color(239, 156, 0));
		JTF_CV.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		
		JTF_NP = new JFormattedTextField(formatter);
		JTF_NP.setEditable(false);
		JTF_NP.setBounds(250,105,100,30);
		JTF_NP.setBackground(new Color(159,159,159));
		JTF_NP.setForeground(new Color(239, 156, 0));
		JTF_NP.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		
		//Paramteros
		JTF_MDV = new JFormattedTextField(formatter);
		JTF_MDV.setEditable(true);
		JTF_MDV.setBounds(250,145,100,30);
		JTF_MDV.setBackground(new Color(79,79,79));
		JTF_MDV.setForeground(new Color(239, 156, 0));
		JTF_MDV.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		
		
		frame.add(JTF_TL);
		frame.add(JTF_CV);
		frame.add(JTF_NP);
		frame.add(JTF_MDV);
	

		
		//boton correr simulacion
		
		Sim = new JButton("Simular");
		Sim.setBounds(240,205,110,30);
		Sim.addActionListener(this);
		Sim.setOpaque(true);
		Sim.setForeground(new Color(239, 156, 0));
		Sim.setBackground(new Color(51,51,51));
		Sim.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		
		frame.add(Sim);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(JRB_TL)) {
			//System.out.println("TL");
			
			JTF_TL.setEditable(true);		
			JTF_TL.setBackground(new Color(79,79,79));

			JTF_CV.setEditable(false);
			JTF_CV.setBackground(new Color(159,159,159));
			JTF_CV.setText("");

			JTF_NP.setEditable(false);
			JTF_NP.setBackground(new Color(159,159,159));
			JTF_NP.setText("");

		}
		if(e.getSource().equals(JRB_CV)) {
			//System.out.println("CV");
			JTF_TL.setEditable(false);
			JTF_TL.setBackground(new Color(159,159,159));
			JTF_TL.setText("");
			
			JTF_CV.setEditable(true);
			JTF_CV.setBackground(new Color(79,79,79));
			
			JTF_NP.setEditable(false);
			JTF_NP.setBackground(new Color(159,159,159));
			JTF_NP.setText("");

		}
		if(e.getSource().equals(JRB_NP)) {
			//System.out.println("NP");
			
			JTF_TL.setEditable(false);
			JTF_TL.setBackground(new Color(159,159,159));
			JTF_TL.setText("");
			
			JTF_CV.setEditable(false);
			JTF_CV.setBackground(new Color(159,159,159));
			JTF_CV.setText("");
			
			JTF_NP.setEditable(true);	
			JTF_NP.setBackground(new Color(79,79,79));

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource().equals(Sim)) {
			Resultados.List = new ArrayList<ArrayList<Integer>>();
			
			int TL = 0; //Tiempo Limite
			int NP = 0; //Numero de personas			
			int CV = 0; //Cantidad de Vacunas
			int MDV = 0;//Modulos de Vacunacion
			int NV = 0; //Numero de Vacunas por modulo


			int i = 0;
			if(JRB_TL.isSelected() & !(JTF_TL.getText().equals(""))) {
				//System.out.println("hola");
				TL = Integer.parseInt(JTF_TL.getText().replace(",", ""));
				Tlim =TL;				
				i++;
			}
			if(JRB_CV.isSelected() & !(JTF_CV.getText().equals(""))) {
				//System.out.println("hola");
				CV = Integer.parseInt(JTF_CV.getText().replace(",", ""));
				CVac = CV;
				i++;
			}
			if(JRB_NP.isSelected() & !(JTF_NP.getText().equals(""))) {
				//System.out.println("hola");
				NP = Integer.parseInt(JTF_NP.getText().replace(",", ""));
				Npers = NP;
				i++;
			}
			if(!(JTF_MDV.getText().equals(""))) {
				MDV =  Integer.parseInt(JTF_MDV.getText().replace(",", ""));;
				i++;
			}
			
			
			if(i==2) {
				
				if(JRB_TL.isSelected()) {
					Launcher.runTL(TL, MDV );
					this.dispose();
				}
				if(JRB_CV.isSelected()) {
					Launcher.runCV(CV, MDV);
					this.dispose();
				}
				if(JRB_NP.isSelected()) {				
					Launcher.runNP(NP, MDV);
					this.dispose();
				}
				
			}
			
		}
		
	}

}
