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
	public boolean equals(Object t2) 
	{
		boolean ret = true;
		if (!(t2 instanceof TuplaIncompatibles))
			ret = false;
		else 
		{
			// es importante no asumir <T1,T2> para t2,pues podria ser <T3,T4>
			TuplaIncompatibles<T1, T2> t3 = (TuplaIncompatibles) t2;
			ret = ret && t3.e1.equals(e1) && t3.e2.equals(e2);
		}
		return ret;
	}

	@Override
	public String toString() 
	{
		String ret = e1.toString() + "," + e2.toString() + ";";
		return ret;
	}

}
