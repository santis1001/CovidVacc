package simulacion_vacunacion;

import java.util.ArrayList;

public class HTiempo extends Thread{

	math math = new math();
	
	int TL; //Tiempo Limite

	int NV; //Numero de Vacunas por modulo


	
	int Module;
	int PV;
	int time;
	
	public HTiempo(int tL, int M) {
		// TODO Auto-generated constructor stub
		this.TL = tL;
		this.Module = M;
	
		
	}

	public void run() {
		
//		System.out.println(TL+" "+NV+" "+TM+" "+MDT+" "+Module);

		int auxtime = 0;
		
		int n = 0;
		int i;
		int aux =0;
		ArrayList<String> tlist = new ArrayList<String>() ;

		
		for(i=0;aux<(TL*60);i++) {
			
			double time = Math.round(math.poisson());
			aux =(int) (auxtime +(time));
			tlist.add(time+"");
			
			System.out.println(aux);

			if(aux<(TL*60)) {
				auxtime = aux;
				
			}else {
				break;		
			}			
		}
		
		PV = i;
		time = auxtime;
		
		System.out.println("Modulo: "+Module+" --Personas Vacunadas: "+i+
				"--Tiempo Total: "+time/60+" --veces revastecer: "

				);
		
		ArrayList<Integer> list = new ArrayList<>();
		list.add(Module);
		list.add(i);
		list.add((time/60));
		
		
		
		Resultados R = new Resultados();
		R.addArray(list, new module_time_model(Module, tlist));
			
		Launcher.add();

		if(Launcher.mdlc()==Launcher.Module_total) {
			R.finish();
			System.out.println("Done");

		}
		
	}
}
