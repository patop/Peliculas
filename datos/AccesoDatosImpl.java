package mx.com.gm.peliculas.datos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import mx.com.gm.peliculas.domain.Peliculas;
import mx.com.gm.peliculas.excepciones.AccesoDatosEX;
import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEX;

public class AccesoDatosImpl implements IAccesoDatos {

    @Override
    public boolean existe(String nombreArchivo) throws AccesoDatosEX {
        File archivo = new File(nombreArchivo);
        return archivo.exists();
    }

    @Override
    public List<Peliculas> listar(String Nombre) throws LecturaDatosEX {
        File archivo = new File(Nombre);
        List<Peliculas> peliculasList = new ArrayList<>();
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            while (linea != null) {
                Peliculas pelicula = new Peliculas(linea);
                peliculasList.add(pelicula);
            }
            entrada.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new LecturaDatosEX("Excepcion al listar peliculas " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            throw new LecturaDatosEX("Excepcion al listar peliculas " + e.getMessage());
        }
        return peliculasList;
    }

    @Override
    public void escribir(Peliculas pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx{
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(pelicula.toString());
            salida.close();
            System.out.println("Se ha escrito informacion en el archivo " + pelicula);
        } catch (IOException e) {
            e.printStackTrace();
            throw new EscrituraDatosEx("Error al escribir el archivo " +  e.getMessage());
        }
    }

    @Override
    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEX {
        File archivo = new File(nombreArchivo);
        String resultado = null;
        String linea = null;
        
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            linea = entrada.readLine();
            int indice = 1;
            while (linea != null) {
                if (buscar != null && buscar.equalsIgnoreCase(linea)) {
                    resultado = "La pelicula " + linea +" encontrada en el indice " + indice;
                    break;
                }
                linea = entrada.readLine();
                indice++;
            }
            entrada.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new LecturaDatosEX("Error al buscar Pelicula "+ e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            throw new LecturaDatosEX("Error al buscar Pelicula " + e.getMessage());
        }
        
        return resultado;
    }

    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEX {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo));
        } catch (IOException e) {
            e.printStackTrace();
            throw new AccesoDatosEX("Exception al crear el archivo " + e.getMessage());
        }
    }

    @Override
    public void borrar(String nombreArchivo) throws AccesoDatosEX {
        File archivo = new File(nombreArchivo);
        if (archivo.exists()) {
            archivo.delete();
            System.out.println("Se ha borrado el archivo");
        }


    }

}
