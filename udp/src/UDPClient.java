
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

// author: Thiều Văn Tuấn
public class UDPClient {

    DatagramSocket mySocket = null;
    int port = 5000;

    public void connection() {
        try {
            mySocket = new DatagramSocket();
        } catch (SocketException ex) {
            System.out.println(ex);
        }
    }

    public void send(String str) {
        if (mySocket != null) {
            byte[] sendData = new byte[1024];
            try {
                InetAddress IPAddress = InetAddress.getByName("localhost");
                sendData = str.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
                mySocket.send(sendPacket);
            } catch (SocketException e) {
                System.err.println(e);
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }

    public String receive() {
        if (mySocket != null) {
            byte[] receiveData = new byte[1024];
            try {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                mySocket.receive(receivePacket);
                return new String(receivePacket.getData());
            } catch (SocketException e) {
                System.err.println(e);
            } catch (IOException e) {
                System.err.println(e);
            }
        }
        return null;
    }

    public void close() {
        if (mySocket != null) {
            try {
                mySocket.close();
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap du lieu gui di:");
        String sendStr = sc.nextLine();
        UDPClient client = new UDPClient();
        client.connection();
        client.send(sendStr);
        System.out.println(client.receive());
    }
}
