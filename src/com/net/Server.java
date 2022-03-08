package com.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author :珠代
 * @description :服务器,接受数据，给出反馈
 * @create :2022-03-07 10:15:00
 */
public class Server {
    public static void main(String[] args) throws IOException {
        //创建服务器的Socket对象
        ServerSocket ss =new ServerSocket(10000);

        while (true) {
            //监听客户端连接，返回一个Socket对象
            Socket s = ss.accept();
            //为每个客户端开启一个线程
            new Thread(new sThread(s)).start();
        }
//
//        //获取输入流读数据，并把数据显示在控制台
////        InputStream is =s.getInputStream();
////        byte[] bys =new byte[1024];
////        String data = new String(bys,0,is.read(bys));
////        System.out.println("客户端："+data);
//        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
//        //把数据写入文本文件
//        BufferedWriter bw = new BufferedWriter(new FileWriter("recieve.txt"));
//        String line;
//        while ((line=br.readLine())!=null){
////            if("886".equals(line)){
////                break;
////            }
//            System.out.println(line);
//            bw.write(line);
//            bw.newLine();
//            bw.flush();
//        }
//
//        //给出反馈
//        BufferedWriter bws =new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
//        bws.write("文件上传成功");
//        bws.newLine();
//        bws.flush();
//
////        //给出反馈
////        OutputStream os = s.getOutputStream();
////        os.write("数据已经收到".getBytes());
//
//        //释放资源
//        bw.close();
//        ss.close();
    }
}

