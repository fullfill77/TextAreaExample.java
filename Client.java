import java.io.*;
import java.net.*;

public class Client{
private Socket s=null;
private DataInputStream in=null;
private DataOutputStream out=null;

public Client(String addr, int port)
{
try{
s=new Socket(addr,port);
System.out.println("Connected");
in=new DataInputStream(System.in);
out=new DataOutputStream(s.getOutputStream());
}
catch (IOException i){
System.out.println(i);
return;
}
String m="";
while(!m.equals("Over")){
try{
m=in.readLine();
out.writeUTF(m);
}
catch(IOException i){
System.out.println(i);
}
}
try{
in.close();
out.close();
s.close();
}
catch(IOException i){
System.out.println(i);
}
}
public static void main(String[] args){
Client c = new Client("127.0.0.1",5000);
}
}

DataOutputStream out = new DataOutputStream(socket.getOutputStream());
out.writeUTF("Hello Server");

DataInputStream in = new DataInputStream(socket.getInputStream());
String reply = in.readUTF();
System.out.println("Server says: " + reply);

out.writeUTF("Hello Server");
out.flush();

String reply = in.readUTF();
System.out.println(reply);

