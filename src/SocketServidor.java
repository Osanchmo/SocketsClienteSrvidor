import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServidor {

    public static void main(String[] args) {

        try {
            System.out.println("Creando servidor");
            ServerSocket serverSocket = new ServerSocket();
            System.out.println("Realizando el bind (vinculo)");
                InetSocketAddress addr = new InetSocketAddress("0.0.0.0", 5555);
                serverSocket.bind(addr);

            System.out.println("Aceptando conexiones");
            Boolean temp = true;

            while(temp) {
                Socket socket = serverSocket.accept();
                HiloPeticion hp = new HiloPeticion(socket);
                hp.start();
                System.out.println("Conexion recibida");
            }

           serverSocket.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
