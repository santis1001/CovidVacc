package Numero_aleatorio;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class NumerosPseudoaleatorios extends JFrame {
	
	public static ArrayList<Float> lista= new ArrayList<>();

	ArrayList<String> np = new ArrayList<String>();
	private JPanel contentPane;
	private JTextField textField, textField_1, textField_2, textField_3, textField_4;
	
	int n, m, listInicial;
	int x;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NumerosPseudoaleatorios frame = new NumerosPseudoaleatorios();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NumerosPseudoaleatorios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 150, 450, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tarea 2.1");
		lblNewLabel.setBounds(179, 11, 71, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Aditivo");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				lista.add((float) 65);
				lista.add((float) 89);
				lista.add((float) 98);
				lista.add((float) 03);
				lista.add((float) 69);
				
				int n = Integer.parseInt(textField.getText());
				int m = Integer.parseInt(textField_1.getText());

				Aditivo (n,m,lista.size());
			
			}
		});
		btnNewButton.setBounds(10, 76, 107, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Multiplicativo");
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				int n = Integer.parseInt(textField.getText());
				int m = Integer.parseInt(textField_1.getText());
				int a = Integer.parseInt(textField_2.getText());
				int x = Integer.parseInt(textField_3.getText());
				
				Multiplicativo (n,m,a,x);

			}
		});
		btnNewButton_1.setBounds(10, 128, 107, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Lineal");
		btnNewButton_2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				int n = Integer.parseInt(textField.getText());
				int m = Integer.parseInt(textField_1.getText());
				int a = Integer.parseInt(textField_2.getText());
				int x = Integer.parseInt(textField_3.getText());
				int c = Integer.parseInt(textField_4.getText());
				
				Mixto(n,m,a,x,c);
			}
		});
		btnNewButton_2.setBounds(10, 178, 107, 23);
		contentPane.add(btnNewButton_2);
		
		
		textField = new JTextField();
		textField.setBounds(314, 77, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(314, 129, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(314, 179, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(314, 229, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(314, 269, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("n:");
		lblNewLabel_1.setBounds(270, 80, 34, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("m:");
		lblNewLabel_2.setBounds(270, 132, 34, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("a:");
		lblNewLabel_3.setBounds(270, 182, 71, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("x:");
		lblNewLabel_4.setBounds(270, 232, 71, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("c:");
		lblNewLabel_5.setBounds(270, 272, 71, 14);
		contentPane.add(lblNewLabel_5);
	}
	
	public static void Aditivo (int n, int m, int x)
	{
		float R = 0;
		

		
		System.out.println(1);
		
		for(int i=0;i<n;i++) {
			
			System.out.println(x+(i-1));
			
			R = (lista.get(x+(i-1)) + lista.get(i) ) % m;
			
			lista.add(R);
			
			R = R / (m-1);

			System.out.println("X: "+lista.get(i)+" i:"+i+" R:"+R);
			JOptionPane.showMessageDialog(null, "R:"+R);

			
		}
		
		
	}
	public static void Multiplicativo (int n, int m, int a, int x)
	{
		
		ArrayList<Float> X= new ArrayList<>();

		float R = 0;
		X.add((float) x);
		
		for(int i=0;i<n;i++) {
			
			R = ((a*X.get(i)) % m);
			
			X.add(R);
			
			R = R / (m-1);
			
			System.out.println("X: "+X.get(i)+" i:"+i+" R:"+R);
			JOptionPane.showMessageDialog(null, "R:"+R);
		}
		
		
	}
	public static void Mixto (int n, int m, int a, int x, int c)
	{
		ArrayList<Float> X= new ArrayList<>();

		float R = 0;
		X.add((float) x);
		
		for(int i=0;i<n;i++) {
			
			R = ((a*X.get(i)+c) % m);
			
			X.add(R);
			
			R = R / (m);
			
			System.out.println("R:"+R);
			JOptionPane.showMessageDialog(null, "X: "+X.get(i)+" i:"+i+" R:"+R);

		}
		
		
	}
}

