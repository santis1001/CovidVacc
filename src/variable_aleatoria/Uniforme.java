package variable_aleatoria;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Uniforme {

	public static void main(String args[]) throws Exception
    {
		Uniforme u = new Uniforme();
		
		SimpleDateFormat sdf = new SimpleDateFormat("SSS");
		SimpleDateFormat sdg = new SimpleDateFormat("ss");
		SimpleDateFormat sdh = new SimpleDateFormat("ss");
		
		
        String sf = sdf.format(new Date());
        String sg = sdg.format(new Date());
        String sh = sdh.format(new Date());
        
        double rsf = Float.parseFloat(sf);
        double rsg = Integer.parseInt(sg)/10;
        double rsh = Integer.parseInt(sh);

		double a=rsh,b=rsg,R=rsf;
		System.out.println(""+a+" "+b+" "+R);
				
		u.uniforme(a,b,R);
		
    }

	private void uniforme(double a, double b, double r) {
		
		Double Vu = a+r*(b-a);
		if(Vu<0)
			Vu = (-1)*Vu;
		
		System.out.println(Vu+"");

	}
}
