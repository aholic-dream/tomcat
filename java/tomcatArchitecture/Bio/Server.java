package tomcatArchitecture.Bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        // 创建ServerSocket监听端口8001
        ServerSocket server = new ServerSocket(8001);
        int num = 0;
        while (num < 30){
            // 等待客户端请求
            Socket socket = server.accept();
            // 通过Socket得到输出流，构造PrintWriter对象
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            // 通过Socket得到输入流，构造BufferedReader对象
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Thread thread = new Thread(() -> {
                try {
                    System.out.println("客户端说(并等待3秒)：" + reader.readLine());
                    Thread.sleep(1000*3);
                    writer.println("我是服务器，有什么事吗·我喜欢你·真的吗·真的·我也是啦：我的名字叫111" + Thread.currentThread().getName());
                    writer.flush();
                    System.out.println("客户端说(并等待3秒)：" + reader.readLine());
                    Thread.sleep(1000*3);
                    writer.println("我是服务器，有什么事吗·我喜欢你·真的吗·真的·我也是啦：我的名字叫222" + Thread.currentThread().getName());
                    writer.flush();
                    writer.close();
                    reader.close();
                } catch (Exception e) {
                    System.out.println("有异常，不关我事");
                }
            });

            thread.start();

            num++;
        }



    }
}
