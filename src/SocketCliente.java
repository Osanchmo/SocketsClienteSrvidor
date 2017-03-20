import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class SocketCliente {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try{
            System.out.println("Creando un cliente");
            //Socket tcp
            Socket cliente = new Socket();
            //socket udp
            //DatagramSocket udp = new DatagramSocket();
            InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
            cliente.connect(addr);
            System.out.println("Estableciendo conexión");


            boolean bol = true;

            while (bol){



                System.out.print("Escriu una operació: ");
                String mensaje = in.nextLine();

                switch (mensaje){
                    case "exit":
                        cliente.close();
                        bol = false;
                        break;

                    default:
                        InputStream is = cliente.getInputStream();
                        OutputStream os = cliente.getOutputStream();
                        os.write(mensaje.getBytes());
                        System.out.println("Mensaje enviado");
                        byte [] res = new byte[250];
                        is.read(res);
                        System.out.println("resultat = " + new String(res));
                        break;
                }

            }
        }catch (Exception e){
           e.printStackTrace();
        }
    }


}
