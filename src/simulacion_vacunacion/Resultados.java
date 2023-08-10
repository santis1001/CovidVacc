package simulacion_vacunacion;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class Resultados extends JFrame implements ListSelectionListener{


	public void main() {
		// TODO Auto-generated method stub
		
		Resultados IL = new Resultados();
		IL.frame();
		IL.setBounds(0,0,845,450);
		IL.setTitle("Simulacion de Vacunacion");
		IL.setDefaultCloseOperation(EXIT_ON_CLOSE);
		IL.setLocationRelativeTo ( null );
		
	}
	JTable JT, TT, PT;
	private void frame() {
		
		Container frame = this.getContentPane();
		frame .setLayout(null);
		setVisible(true);
		frame.setBackground(new Color(51,51,51));	
		
		//Object[][] data ={{1,25,50,2,15}, {2,22,54,91,34}};
		String[] encabezado = {"Modulo", "Personas Vac.", "Tiempo Total"};
		

		DefaultTableModel modelo = new DefaultTableModel(matrix, encabezado);
		JT = new JTable(modelo);
		JT.setDefaultEditor(Object.class, null);
		JT.setPreferredScrollableViewportSize(new Dimension(550,250));
		JT.setGridColor(new Color(239, 156, 0));
		JT.setForeground(new Color(239, 156, 0));
		JT.setBackground(new Color(79,79,79));
		JT.setSelectionBackground(new Color(160,160,160));
		JT.setSelectionForeground(new Color(153,79,0));
		JT.getSelectionModel().addListSelectionListener(this);

		
		JTableHeader JTH = JT.getTableHeader();
		JTH.setForeground(new Color(239, 156, 0));
		JTH.setBackground(new Color(32,32,32));
		
		
		JScrollPane JTP = new JScrollPane(JT); 
		JTP.setBounds(40,100,590,280);	

		JTP.getViewport().setBackground(new Color(79,79,79));

		String[] titulos = {"Tiempo total", "Personas totales", "Numero de Vacunas", "Modulos" };		

		DefaultTableModel totals = new DefaultTableModel(TotalM, titulos);
		TT = new JTable(totals);
		TT.setDefaultEditor(Object.class, null);
		TT.setPreferredScrollableViewportSize(new Dimension(550,100));
		TT.setGridColor(new Color(239, 156, 0));
		TT.setForeground(new Color(239, 156, 0));
		TT.setBackground(new Color(79,79,79));
		TT.setSelectionBackground(new Color(160,160,160));
		TT.setSelectionForeground(new Color(153,79,0));
		
		
		JTableHeader JTH1 = TT.getTableHeader();
		JTH1.setForeground(new Color(239, 156, 0));
		JTH1.setBackground(new Color(32,32,32));
		
		
		JScrollPane JTP1 = new JScrollPane(TT); 
		JTP1.setBounds(40,20,590,40);	

		JTP1.getViewport().setBackground(new Color(79,79,79));

		
		String[] Labels = {"No.", "Tiempo(s)"};		
		
		DefaultTableModel individual = new DefaultTableModel(TotalP, Labels);
		PT = new JTable(individual);
		PT.setDefaultEditor(Object.class, null);
		PT.setPreferredScrollableViewportSize(new Dimension(550,100));
		PT.setGridColor(new Color(239, 156, 0));
		PT.setForeground(new Color(239, 156, 0));
		PT.setBackground(new Color(79,79,79));
		PT.setSelectionBackground(new Color(160,160,160));
		PT.setSelectionForeground(new Color(153,79,0));
		
		JTableHeader JTH2 = PT.getTableHeader();
		JTH2.setForeground(new Color(239, 156, 0));
		JTH2.setBackground(new Color(32,32,32));
		
		
		JScrollPane JTP2 = new JScrollPane(PT); 
		JTP2.setBounds(650,100,150,280);	
		JTP2.getViewport().setBackground(new Color(79,79,79));
		
		frame.add(JTP);
		frame.add(JTP1);
		frame.add(JTP2);


	}
		
	
	public static ArrayList<ArrayList<Integer>> List = new ArrayList<ArrayList<Integer>>();
	public static ArrayList<module_time_model> MList = new ArrayList<module_time_model>();

	public static Object[][] matrix;
	public static Object[][] TotalM;
	public static Object[][] TotalP;

	
	
	public void addArray(ArrayList<Integer> sList , module_time_model mtm) {
		List.add(sList);
		
		MList.add(mtm);
		//System.out.println("se agrego");

	}
	
	public void finish() {
				
		
		
		Object[][] matriz = new Object[List.size()][4];
		int i=0;
		
		ArrayList<Integer> total = new ArrayList<Integer>();

		
		int TPV = 0;
		int TT = 0;
		for(ArrayList<Integer> in : List) {			
			matriz[i][0] = in.get(0).toString().trim();
			matriz[i][1] = in.get(1).toString().trim();
				TPV = TPV + in.get(1);
			matriz[i][2] = in.get(2).toString().trim();
				if(in.get(2)>TT) {
					TT = in.get(2);
				}
		
			i++;
		}	
		
		total.add(TT);total.add(TPV);total.add(TPV);
		total.add(Launcher.Module_total);
		Object[][] Totals = new Object[1][4];

		
		Totals[0][0] = total.get(0).toString().trim();
		Totals[0][1] = total.get(1).toString().trim();
		Totals[0][2] = total.get(2).toString().trim();
		Totals[0][3] = total.get(3).toString().trim();

		TotalM = new Object[1][4];
		TotalM = Totals;
		
		matrix = new Object[List.size()][3];
		matrix = matriz;			
		
		
		module_time_model m = MList.get(0); 
			System.out.println("Modulo: "+m.getModulo());
			int mod = m.getModulo();

			TotalP  = new Object[m.getTiempos().size()][2];

			int x =0;
			for(String s :m.getTiempos()) {
				//System.out.println("	"+x+": "+s);
				TotalP[x][0] = (x+1);
				TotalP[x][1] = s;
				x++;
			}
		
		
		main();
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
		System.out.println(""+JT.getSelectedRow());

		module_time_model m = MList.get((int) JT.getSelectedRow()); 
		
		//System.out.println("Modulo: "+m.getModulo());
		int mod = m.getModulo();

		TotalP  = new Object[m.getTiempos().size()][2];

		int x =0;
		for(String s :m.getTiempos()) {
			//System.out.println("	"+x+": "+s);
			TotalP[x][0] = (x+1);
			TotalP[x][1] = s;
			x++;
		}
		
		String[] Labels = {"No.", "Tiempo(s)"};		
		
		DefaultTableModel individual = new DefaultTableModel(TotalP, Labels);		
		PT.setModel(individual);
	}
	
}
