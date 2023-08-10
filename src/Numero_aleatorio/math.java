package Numero_aleatorio;


import java.util.Random;
public class math {

    public static final Random defaultR = new Random();

	public double main(){
		math DP = new math();
        double lambda = 134.59;

        //System.out.println("Testing stat: Poisson" + " with lambda: " + lambda);
           
		return DP.getRandom(defaultR,lambda);
	
    }
	public double getRandom(Random r, double lambda) {
        double L = Math.exp(-lambda);
        int k = 0;
        double p = 1.0;
        do {
            k++;
            p = p * r.nextDouble();
        } while (p > L);

        return k - 1;
    }

}
