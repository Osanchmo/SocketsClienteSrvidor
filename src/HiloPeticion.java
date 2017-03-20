import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
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
            OutputStream os = socket.getOutputStream();
            byte[] mensaje = new byte[250];
            io.read(mensaje);
            String ques = new String(mensaje);

            //Class expression by https://github.com/uklimaschewski/EvalEx
            Expression exp = new Expression(ques);

            System.out.println(exp.eval());

            os.write(String.valueOf(exp.eval()).getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
