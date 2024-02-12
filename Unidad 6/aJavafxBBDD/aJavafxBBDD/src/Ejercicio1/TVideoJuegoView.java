package Ejercicio1;

import java.util.List;

public class TVideoJuegoView {
	public void mostrarJuegos(List<TVideoJuego> juegos) {
		for (TVideoJuego videojuego : juegos) {
			System.out.println("IDJUEGO: " + videojuego.getIdjuego());
			System.out.println("Nombre: " + videojuego.getNombre());
			System.out.println("Año: " + videojuego.getAnio());
			System.out.println("Compañía: " + videojuego.getCompania());
			System.out.println("Precio: " + videojuego.getPrecio());
			System.out.println("Sinopsis: " + videojuego.getSinopsis());
			System.out.println("Plataforma: " + videojuego.getPlataforma());
			System.out.println();
		}
	}
}
