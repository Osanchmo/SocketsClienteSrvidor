import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

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
            String operation = new String(mensaje);
            System.out.println("Mensaje recibido " + operation);
            int res = 0;
            char operator = ' ';
            String[] numbers = new String[2];
            numbers = operation.split("[+,-,*,/]");
            int x = Integer.valueOf(numbers[0]);
            int y = Integer.valueOf(numbers[1]);
            switch (operator){
                case '+':
                    break;
            }


            System.out.println(res);
            System.out.println("Cerrando el socket");
            socket.close();
            System.out.println("Cerrando el socket del servidor");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
