package Hilos;
public class ContadorThread extends Thread {

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                System.out.println("Contador: " + i);
                Thread.sleep(1000); // Pausa de 1 segundo
            }
            System.out.println("Tarea completada.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

