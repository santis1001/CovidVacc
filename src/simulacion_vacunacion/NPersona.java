package simulacion_vacunacion;

import java.util.ArrayList;

public class NPersona  extends Thread{

	math math = new math();
	
	int NP; //Numero de personas

	int NV; //Numero de Vacunas por modulo
	int TM; //Tiempo de aplicacion de la vacuna
	int MDT;//Marget error de tiempo de aplicacion de la vacuna
	
	int Module;
	int PV;
	int time;
	
	public NPersona(int nP, int M) {
		// TODO Auto-generated constructor stub
		this.NP = nP;
		this.Module = M;
	}
	
	public void run() {
		
//		System.out.println(TL+" "+NV+" "+TM+" "+MDT+" "+Module);

		int auxtime = 0;
		
		int n = 0;
		int ntimes = 0;
		int i=0;
		int aux =0;
		
		ArrayList<String> tlist = new ArrayList<String>() ;

	
		while(Launcher.counter()<NP) {
		
			//System.out.println("Entra ciclo"+Module);

			if(Launcher.turn(auxtime, Module)==1 || i==0) {
				double timex = Math.round(math.poisson());
				aux =(int) (auxtime +(timex));
				tlist.add(timex+"");			
				//System.out.println(aux);
				auxtime = aux;
			
				i++;
			
				Launcher.docount();
			}
		}
		
		PV = i;
		time = auxtime;
		
		System.out.println("Modulo: "+Module+" --Personas Vacunadas: "+i+
				"--Tiempo Total: "+time+" --veces revastecer: "+ntimes
				);
		
		ArrayList<Integer> list = new ArrayList<>();
		list.add(Module);
		list.add(i);
		list.add((time/60));
		list.add(ntimes);
		
		
		Resultados R = new Resultados();
		R.addArray(list, new module_time_model(Module, tlist));
			
		Launcher.Module_count++;

		if(Launcher.Module_count==Launcher.Module_total) {
			R.finish();
			System.out.println("Done");

		}
	}
}
