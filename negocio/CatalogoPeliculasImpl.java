package mx.com.gm.peliculas.negocio;

import mx.com.gm.peliculas.datos.AccesoDatosImpl;
import mx.com.gm.peliculas.datos.IAccesoDatos;
import mx.com.gm.peliculas.domain.Peliculas;
import mx.com.gm.peliculas.excepciones.AccesoDatosEX;
import mx.com.gm.peliculas.excepciones.LecturaDatosEX;

public class CatalogoPeliculasImpl implements ICatalogoPeliculas {

    private final IAccesoDatos datos;

    public CatalogoPeliculasImpl() {
        this.datos = new AccesoDatosImpl();
    }

    @Override
    public void agregarPelicula(String nombrePelicula) {
        Peliculas pelicula = new Peliculas(nombrePelicula);
        boolean anexar = false;
        try {
            anexar = datos.existe(NOMBRE_ARCHIVO);
            datos.escribir(pelicula, NOMBRE_ARCHIVO, anexar);
        } catch (AccesoDatosEX e) {
            System.out.println("Error de acceso a datos");
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void listarPelicua() {
        try {
            var pelicula =  this.datos.listar(NOMBRE_ARCHIVO);
            for(var peliculas: pelicula){
                System.out.println("pelicula = " + pelicula);
            }
        } catch (LecturaDatosEX e) {
            System.out.println("Error de acceso datos");
            e.printStackTrace(System.out);
        }

    }

    @Override
    public void buscarPelicula(String buscar) {
        String resultado = null;
       
            try {
                resultado = this.datos.buscar(NOMBRE_ARCHIVO, buscar);
            } catch (LecturaDatosEX e) {
                System.out.println("Error de Acceso a datos");
                e.printStackTrace(System.out);
            }
        
        System.out.println("resultado = " + resultado);
    }

    @Override
    public void iniciarCatalogoPeliculas() {
        try {
            if (this.datos.existe(NOMBRE_ARCHIVO)) {
                datos.borrar(NOMBRE_ARCHIVO);
                datos.crear(NOMBRE_ARCHIVO);
            }else{
                datos.crear(NOMBRE_ARCHIVO);
            }
        } catch (AccesoDatosEX e) {
            System.out.println("Error al iniciar catalogo de peliculas");
            e.printStackTrace(System.out);
        }
    }

}
