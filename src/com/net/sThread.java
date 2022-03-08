package com.net;

import java.io.*;
import java.net.Socket;

/**
 * @author :珠代
 * @description :
 * @create :2022-03-07 12:12:00
 */
public class sThread implements Runnable {
    private Socket s;

    public sThread(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        try {
            //接受数据收到的文本文件
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            //把数据写入文本文件
            int i=0;
            File f =new File("recieve("+i+").txt");
            while (f.exists()){
                i++;
                f=new File("recieve("+i+").txt");
            }

            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                bw.write(line);
                bw.newLine();
                bw.flush();
                }
            //给出反馈
            BufferedWriter bws =new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            bws.write("文件上传成功");
            bws.newLine();
            bws.flush();
            //释放资源
                s.close();
            } catch(IOException e){
                e.printStackTrace();
            }


        }
}