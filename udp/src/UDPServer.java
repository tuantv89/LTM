
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

// author: Thiều Văn Tuấn
public class UDPServer {

    DatagramSocket myServer = null;
    String input;
    int port = 5000;

    public void openServer() {
        try {
            myServer = new DatagramSocket(port);
        } catch (SocketException ex) {
            System.out.println(ex);
        }
    }

    public void listening() {
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        while (true) {
            try {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                myServer.receive(receivePacket);
                input = new String(receivePacket.getData());
                System.out.println("Data:" + input);
                InetAddress IPAddress = receivePacket.getAddress();
                int portC = receivePacket.getPort();
                System.out.println("Port:" + portC);
                String hostName = IPAddress.getHostAddress();
                System.out.println("Hostname:" + hostName);
                String response = "Server da nhan duoc du lieu, ket thuc";
                sendData = response.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, portC);
                myServer.send(sendPacket);
            } catch (IOException ex) {
                System.out.println(ex);;
            }
        }
    }

    public static void main(String[] args) {
        UDPServer server = new UDPServer();
        server.openServer();
        server.listening();
    }
}
