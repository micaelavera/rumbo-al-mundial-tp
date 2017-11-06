package inteligencia;

import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Set;

public class Solucion
{
	private Set<Jugador> _objetos;
	
	public Solucion()
	{
		_objetos = new HashSet<Jugador>();
	}

	public void agregar(Jugador objeto)
	{
		_objetos.add(objeto);
	}

	public void eliminar(Jugador objeto)
	{
		_objetos.remove(objeto);
	}

	public int nivelJuego()
	{
		int ret = 0;
		for(Jugador obj: _objetos)
			ret += obj.nivelJuego();
		
		return ret;
	}

	public Set<Jugador> getObjetos()
	{
		return _objetos;
	}
	
	public int cantidadDeJugadores(){
		return _objetos.size();
	}
	
	@Override
	public String toString()
	{
		String ret = "";
		for(Jugador obj: _objetos)
			ret += (ret.length() > 0 ? "\n " : "") + obj.nombre()+ " " +obj.posicion()+ " "+ obj.nivelJuego()+ " "+obj.incompatible();
		return ret;
	}

	public Solucion clonar()
	{
		// Deep copy
		Solucion ret = new Solucion();
		for(Jugador obj: _objetos)
			ret.agregar(obj);
		
		return ret;
	}
}









