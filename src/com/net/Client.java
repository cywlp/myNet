package com.net;

import java.io.*;
import java.net.Socket;

/**
 * @author :珠代
 * @description :客户端，发送数据，接受反馈
 * @create :2022-03-07 10:15:00
 */
public class Client {
    public static void main(String[] args) throws IOException {

        //创建客户端的Socket对象
        Socket s = new Socket("192.168.0.115", 10000);

//        //获取输出流，写数据
//        OutputStream os = s.getOutputStream();
//        os.write("hello,server".getBytes());
//        //数据来自键盘录入，直到886，结束发送
//        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        //封装文本文件数据
        BufferedReader br =new BufferedReader(new FileReader("send.txt"));
        //封装输出流对象
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        String line;
        while ((line=br.readLine())!=null){
//            if(line.equals("886")){
//                break;
//            }
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
//        //自定义结束标记
//        bw.write("886");
//        bw.newLine();
//        bw.flush();
        //调用方法
        s.shutdownOutput();
////        //接受服务端反馈
//        InputStream is = s.getInputStream();
//        byte[] bys = new byte[1024];
//        String data = new String(bys, 0, is.read(bys));
//        System.out.println("服务器：" + data);
         //接受反馈
        BufferedReader brc=new BufferedReader(new InputStreamReader(s.getInputStream()));
        System.out.println("服务器："+brc.readLine());
        //释放资源
        br.close();
        s.close();
    }
}
