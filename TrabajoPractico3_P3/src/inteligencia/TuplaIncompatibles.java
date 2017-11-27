package inteligencia;


public class TuplaIncompatibles<T1, T2>{

	T1 jugador1;
	T2 jugador2;

	public TuplaIncompatibles(T1 e1, T2 e2){
		this.jugador1 = e1;
		this.jugador2 = e2;
	}


	@Override
	public String toString(){
		String ret = jugador1.toString() + "," + jugador2.toString() + ";";
		return ret;
	}

	public T1 getJugador1() {
		return jugador1;
	}


	public T2 getJugador2() {
		return jugador2;
	}

}
