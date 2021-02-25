package AtmServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import Protocol.Protocol;

public class MultiServerThread extends Thread {
private Socket socket = null;

public MultiServerThread(Socket socket) {
super("MultiServerThread");
this.socket = socket;
}

public void run() {

try {
PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
BufferedReader Ch = new BufferedReader(
new InputStreamReader(
socket.getInputStream()));

String inputLine, outputLine="",Choice;
out.println(outputLine);
while ((inputLine = Ch.readLine()) != null) {
Protocol kkp = new Protocol();
out.println("Vui lòng chọn lựa chọn: 1 Kiểm Tra Số Dư,2 Rút tiền,3 Tiền Gửi,4 Chuyển Khoản,5 Exit");


while ((Choice = Ch.readLine()) != null)
{
if (Choice.equals("1"))
{

out.println("Nhập số thẻ của bạn");
BufferedReader in = new BufferedReader(
new InputStreamReader(
socket.getInputStream()));
inputLine=in.readLine();
outputLine = kkp.processInput(Choice+inputLine,"");
if(outputLine.substring(0,1).equals("1"))
{
out.println("Số dư hiện tại của bạn là:"+ outputLine.substring(0,1));

}
else if(outputLine.substring(0,1).equals("3"))
{
out.println("Chứng minh nhân dân không hợp lệ");
}
else if(outputLine.substring(0,1).equals("4"))
{
out.println("Lỗi không xác định");
}
out.println("Vui lòng chọn lựa chọn: 1 Kiểm Tra Số Dư,2 Rút tiền,3 Tiền Gửi,4 Chuyển Khoản,5 Exit");
//in.close();
}
else if (Choice.equals("2"))
{
out.println("Nhập số thẻ của bạn");
BufferedReader in = new BufferedReader(
new InputStreamReader(
socket.getInputStream()));
inputLine=in.readLine();
out.println("Nhập số tiền muốn rút:");
BufferedReader Amt = new BufferedReader(
new InputStreamReader(
socket.getInputStream()));
String Amount=Amt.readLine();
outputLine = kkp.processInput(Choice+inputLine+Amount,"");
if(outputLine.substring(0,1).equals("1"))
{
out.println("Số dư hiện tạ của bạn là:"+ outputLine.substring(1));
}
else if(outputLine.substring(0,1).equals("3"))
{
out.println("ID của bạn không đúng");
}
else if(outputLine.substring(0,1).equals("4"))
{
out.println("Lỗi không xác định");
}
else if(outputLine.substring(0,1).equals("2"))
{
out.println("Số tiền vượt quá giới hạn");
}
out.println("Vui lòng chọn lựa chọn: 1 Kiểm Tra Số Dư,2 Rút tiền,3 Tiền Gửi,4 Chuyển Khoản,5 Exit");
//in.close();
}
else if (Choice.equals("3"))
{
out.println("Nhập số thẻ của bạn");
BufferedReader in = new BufferedReader(
new InputStreamReader(
socket.getInputStream()));
inputLine=in.readLine();
out.println("Nhập số tiền muốn gửi");
BufferedReader Amt = new BufferedReader(
new InputStreamReader(
socket.getInputStream()));
String Amount=Amt.readLine();
outputLine = kkp.processInput(Choice+inputLine+Amount,"");

if(outputLine.substring(0,1).equals("1"))
{
out.println("Số dư hiện tại của bạn là:"+ outputLine.substring(1));
}
else if(outputLine.substring(0,1).equals("3"))
{
out.println("ID của bạn không đúng");
}
else if(outputLine.substring(0,1).equals("4"))
{
out.println("Lỗi không xác định");
}
else if(outputLine.substring(0,1).equals("2"))
{
out.println("Số tiền vượt quá giới hạn");
}
out.println("Vui lòng chọn lựa chọn: 1 Kiểm Tra Số Dư,2 Rút tiền,3 Tiền Gửi,4 Chuyển Khoản,5 Exit");
//in.close();
}
else if (Choice.equals("4"))
{
out.println("Nhập số thẻ của bạn");
BufferedReader in = new BufferedReader(
new InputStreamReader(
socket.getInputStream()));
inputLine=in.readLine();
out.println("Nhập số tiền cần chuyển ");
BufferedReader Amt = new BufferedReader(
new InputStreamReader(
socket.getInputStream()));
String Amount=Amt.readLine();
out.println("Nhập số tài khoản được chuyển");
BufferedReader Acc2 = new BufferedReader(
new InputStreamReader(
socket.getInputStream()));
String SecondAccount=Acc2.readLine();
outputLine = kkp.processInput(Choice+inputLine+Amount,SecondAccount);
if(outputLine.substring(0,1).equals("1"))
{
out.println("Số dư hiện tại của bạn là:"+ outputLine.substring(1));
}
else if(outputLine.substring(0,1).equals("3"))
{
out.println("ID của bạn không đúng");
}
else if(outputLine.substring(0,1).equals("4"))
{
out.println("Lỗi không xác định");
}
else if(outputLine.substring(0,1).equals("2"))
{
out.println("Số tiền vượt quá giới hạn");
}
out.println("Vui lòng chọn lựa chọn: 1 Kiểm Tra Số Dư,2 Rút tiền,3 Tiền Gửi,4 Chuyển Khoản,5 Exit");
//in.close();

}

else if (Choice.equals("0"))
break;

}
}
out.close();

socket.close();

} catch (IOException e) {
e.printStackTrace();
} catch (Exception e) {
e.printStackTrace();
}
}
}

