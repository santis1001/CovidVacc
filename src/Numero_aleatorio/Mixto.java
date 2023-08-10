package Numero_aleatorio;

import java.util.ArrayList;

public class Mixto {
	
	public static ArrayList<Float> X= new ArrayList<>();
	
	public static void main(String args[]) throws Exception
    {
	
		
		M_Congruencial (7,8,5,7,4);
		

    }
	
	public static void M_Congruencial (int n, int m, int a, int c, int x)
	{
		float R = 0;
		X.add((float) x);
		
		for(int i=0;i<n;i++) {
			
			R = ((a*X.get(i)+c) % m);
			
			X.add(R);
			
			R = R / (m);
			
			System.out.println("X: "+X.get(i)+" i:"+i+" R:"+R);
		

		
		}		
		
	}
	
}
