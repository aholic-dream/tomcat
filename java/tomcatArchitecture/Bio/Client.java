package tomcatArchitecture.Bio;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {
        System.out.println(String.valueOf(System.currentTimeMillis()));
        // 向本机的8888端口发送请求
        Socket socket = new Socket("127.0.0.1", 8001);

        // 通过Socket得到输出流，构造PrintWriter对象
        PrintWriter writer = new PrintWriter(socket.getOutputStream());
        // 通过Socket得到输入流，构造BufferedReader对象
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        //命令行输入
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = input.readLine();
        while (!inputStr.equals("exit")){
            writer.println(inputStr); // 写入消息
            writer.flush(); // 刷新输出流，使得客户端可以收到消息
            System.out.println("等待服务器响应......");
            System.out.println("服务器说：" + reader.readLine());
            inputStr = input.readLine();
        }

        writer.close();
        reader.close();
        socket.close();
    }
}
