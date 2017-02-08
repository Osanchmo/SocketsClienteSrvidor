import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class HiloPeticion extends Thread {

    private Socket socket = new Socket();

    public HiloPeticion(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {

            InputStream io = socket.getInputStream();
            byte[] mensaje = new byte[250];
            io.read(mensaje);

            System.out.println("Mensaje recibido " + new String(mensaje));
            System.out.println("Cerrando el socket");

            socket.close();
            System.out.println("Cerrando el socket del servidor");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
