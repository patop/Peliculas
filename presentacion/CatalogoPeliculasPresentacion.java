package mx.com.gm.peliculas.presentacion;

import java.util.Scanner;

import mx.com.gm.peliculas.negocio.CatalogoPeliculasImpl;
import mx.com.gm.peliculas.negocio.ICatalogoPeliculas;

public class CatalogoPeliculasPresentacion {
    public static void main(String[] args) {
        int opcion = -1;
        Scanner sc = new Scanner(System.in);
        ICatalogoPeliculas catalogoPeliculas = new CatalogoPeliculasImpl();
        while (opcion != 0) {
            System.out.println("Elige una opcion:\n" +
                    "1. Iniciar Catalogo\n" +
                    "2. Agregar Pelicula\n" +
                    "3. Listar Pelicula\n" +
                    "4. Buscar Pelicula\n" +
                    "0 Salir");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    catalogoPeliculas.iniciarCatalogoPeliculas();
                    break;
                case 2:
                    System.out.println("Ingrese nombre de la Pelicula:");
                    String nombrePelicula = sc.nextLine();
                    catalogoPeliculas.agregarPelicula(nombrePelicula);
                    break;
                case 3:
                    catalogoPeliculas.listarPelicua();
                    break;
                case 4:
                    System.out.println("Ingresa el nombre de la pelicula a buscar:");
                    String nombrePeliculaBuscada = sc.nextLine();
                    catalogoPeliculas.buscarPelicula(nombrePeliculaBuscada);
                case 0:
                    System.out.println("Adios");
                default:
                    System.out.println("opcion no reconocida");
                    break;
            }

        }
    }
}
