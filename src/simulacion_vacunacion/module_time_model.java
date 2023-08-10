package simulacion_vacunacion;

import java.util.ArrayList;

public class module_time_model {

	
	int Modulo;
	public int getModulo() {
		return Modulo;
	}
	public void setModulo(int modulo) {
		Modulo = modulo;
	}
	public ArrayList<String> getTiempos() {
		return Tiempos;
	}
	public void setTiempos(ArrayList<String> tiempos) {
		Tiempos = tiempos;
	}
	ArrayList<String> Tiempos;
	public module_time_model(int M, ArrayList<String> times){
		this.Modulo = M;
		this.Tiempos = times;
		
	}
}
