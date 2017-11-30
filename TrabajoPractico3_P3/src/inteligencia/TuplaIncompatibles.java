package inteligencia;


public class TuplaIncompatibles<T1, T2>{

	 private T1 jugador1;
	 private T2 jugador2;

	public TuplaIncompatibles(T1 e1, T2 e2){
		this.jugador1 = e1;
		this.jugador2 = e2;
	}

	@Override
	public String toString(){
		String ret = jugador1.toString() + "," + jugador2.toString() + ";";
		return ret;
	}

	public T1 jugador1() {
		return jugador1;
	}
	
	public T2 jugador2() {
		return jugador2;
	}
}
