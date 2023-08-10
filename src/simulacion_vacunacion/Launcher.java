package simulacion_vacunacion;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Launcher {


	public static int Module_count=0;
	public static int Module_total;

	
	public static math math = new math();

	
	public static void runTL(int TL,int MDV) {
//		System.out.println("Work TL");				
		Module_total = MDV;
		HTiempo HT[] = new HTiempo[MDV];
		
		
		for(int i=0;i<MDV;i++) {
			HT[i] = new HTiempo(TL, i+1);
			HT[i].start();
		}
		
		
		
	}

	static ArrayList<Integer> TVariable;
	public static void runCV(int CV,int MDV) {
//		System.out.println("Work CV");	
		Module_total = MDV;
		PTotal = CV;
		CVacunas HCV[] = new CVacunas[MDV];
		TVariable = new ArrayList<Integer>();

	    for(int i=0;i<MDV;i++) {
	    	HCV[i] = new CVacunas(CV,  i+1);
			HCV[i].start();
			TVariable.add(0);
		}
	}


	public static void runNP(int NP,int MDV) {

		Module_total = MDV;
		NPersona HCV[] = new NPersona[MDV];
	
		for(int i=0;i<MDV;i++) {
	    	HCV[i] = new NPersona(NP,  i+1);
			HCV[i].start();
		}
		
	}
	
	public static int PTotal=0;
	public static int Pcount=0;
	

	public static synchronized int counter() {

		
		return Pcount;
		
	}
	
	public static synchronized int docount() {

		Pcount++;
		
		return Pcount;
		
	}
	
	public static synchronized void add() {
	
		Module_count++;
	}
	public static synchronized int mdlc() {
		
		return Module_count;
		
	}
	static int counter = 0;
	public static synchronized int turn(int auxtime, int module) {
		
		if(counter()<PTotal){
			//System.out.println("pt: "+PTotal+" pc: "+Pcount);

			if(counter != Module_total && TVariable.get(module-1) == 0){
				TVariable.set(module-1, auxtime);
				//System.out.println(""+(module-1)+" :: "+auxtime);
				counter++;		
				return 0;

			}else if(counter == Module_total){
				TVariable.set(module-1, auxtime);

				//System.out.println(module+" :: "+TVariable.stream().min(Integer::compare).get());
				
				if(TVariable.stream().min(Integer::compare).get() == auxtime) {
					//System.out.println(""+auxtime);

					return 1;
					
				}else {
					return 0;				
				}	
			}else {
				return 0;				
			}
		
		}else {
			return 0;
		}
		
	}

	
}
