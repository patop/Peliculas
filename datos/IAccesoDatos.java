package mx.com.gm.peliculas.datos;

import java.util.List;

import mx.com.gm.peliculas.domain.Peliculas;
import mx.com.gm.peliculas.excepciones.*;

public interface IAccesoDatos {
    public boolean existe(String nombreArchivo) throws AccesoDatosEX;

    public List<Peliculas> listar(String Nombre) throws LecturaDatosEX;

    public void escribir(Peliculas pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx;

    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEX;

    public void crear(String nombreArchivo) throws AccesoDatosEX;

    public void borrar(String nombreArchivo)throws AccesoDatosEX;
}
