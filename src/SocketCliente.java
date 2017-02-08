import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.Socket;

public class SocketCliente {

    public static void main(String[] args) {

        try{
            System.out.println("Creando un cliente");
            //Socket tcp
            Socket cliente = new Socket();
            //socket udp
            //DatagramSocket udp = new DatagramSocket();
            System.out.println("Estableciendo conexión");
            InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
            cliente.connect(addr);

            InputStream is = cliente.getInputStream();
            OutputStream os = cliente.getOutputStream();

            System.out.println("Enviando mensaje...");

            String mensaje = "1+1;";
            os.write(mensaje.getBytes());

            System.out.println("Mensaje enviado");


            System.out.println("Cerrando socket del cliente");

            cliente.close();

            System.out.println("Terminado");
        }catch (Exception e){
           e.printStackTrace();
        }
    }


}
