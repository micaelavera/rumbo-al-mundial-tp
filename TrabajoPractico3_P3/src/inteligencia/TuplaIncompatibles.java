package inteligencia;


public class TuplaIncompatibles<T1, T2>  //Lizz estuvo aqui
{

	T1 e1;
	T2 e2;

	public TuplaIncompatibles(T1 e1, T2 e2) 
	{
		this.e1 = e1;
		this.e2 = e2;
	}


	@Override
	public String toString() 
	{
		String ret = e1.toString() + "," + e2.toString() + ";";
		return ret;
	}

}
