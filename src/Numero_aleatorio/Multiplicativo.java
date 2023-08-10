package Numero_aleatorio;

import java.util.ArrayList;

public class Multiplicativo {

	public static ArrayList<Float> X= new ArrayList<>();
	
	public static void main(String args[]) throws Exception
    {
		
		
		M_Congruencial (10,9,7,4);
		

    }
	
	public static void M_Congruencial (int n, int m, int a, int x)
	{
		float R = 0;
		X.add((float) x);
		
		for(int i=0;i<n;i++) {
			
			R = ((a*X.get(i)) % m);
			
			X.add(R);
			
			R = R / (m-1);
			
			System.out.println("X: "+X.get(i)+" i:"+i+" R:"+R);
		}
		
		
	}
}
