package Numero_aleatorio;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Aditivo {
	
	
	public static ArrayList<Float> lista= new ArrayList<>();
	
	public static void main(String args[]) throws Exception
    {
        SimpleDateFormat sdf = new SimpleDateFormat("SSS");
        String sf = sdf.format(new Date());
		int x = Integer.parseInt(sf);
		x=x*x;
        //System.out.println(x);
        String s = x+"";
        
        String[] aux = s.split("");
        ArrayList<String> newlist = new ArrayList<String>();
        
        for(int i=0;i<aux.length;i++) {
//        	System.out.println(""+aux[i]);
        	if(!(i==(aux.length-1))) {
        	newlist.add(aux[i]+""+aux[i+1]);
        	}else {
        		newlist.add(aux[i]+""+aux[0]);	
        	}
        	
        	        	
        }
        for(String st:newlist) {
        	System.out.println(""+st);
        	float fl = Float.parseFloat(st);
        	lista.add((float) fl);
        }
        
		
		
		M_Congruencial (lista.get(2),lista.get(1),lista.size());

    }
	
	
	public static void M_Congruencial (float n, float m, int x)
	{
		float R = 0;
		for(int i=0;i<10;i++) {
			
			//System.out.println(x+(i-1));
			
			R = (lista.get(x+(i-1)) + lista.get(i) ) % m;
			
			lista.add(R);
			
			R = R / (m-1);

			System.out.println("X: "+lista.get(i)+" i:"+i+" R:"+R);

			
		}
		
		
	}

}
