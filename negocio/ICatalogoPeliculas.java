package mx.com.gm.peliculas.negocio;

public interface ICatalogoPeliculas {
    public static final String NOMBRE_ARCHIVO = "peliculas.txt";

    public void agregarPelicula(String nombrePelicula);

    public void listarPelicua();

    public void buscarPelicula(String buscar);

    public void iniciarCatalogoPeliculas();
}
