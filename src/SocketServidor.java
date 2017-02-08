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

            Socket socket = serverSocket.accept();

            System.out.println("Conexion recibida");

            InputStream io = socket.getInputStream();
            OutputStream os = socket.getOutputStream();

            byte[] mensaje = new byte[250];
            io.read(mensaje);

            System.out.println("Mensaje recibido " + new String(mensaje));

            System.out.println("Cerrando el socket");

            System.out.println("Cerrando el socket del servidor");


        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
