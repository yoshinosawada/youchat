package com.chatserver.controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import com.yychat.model.Message;
import com.yychat.model.User;

public class StartServer {
	ServerSocket ss;
	Socket s;
	
	public static HashMap hmSocket=new HashMap<String,Socket>();//泛型，通用类
	String userName;
	public StartServer(){
		try {
			ss=new ServerSocket(3456);//服务器端口监听3456
			System.out.println("服务器已经启动，监听3456端口...");
			while(true){//?多线程问题
				s=ss.accept();//等待客户端建立连接
				System.out.println(s);//输出连接Socket对象
				
				//字节输入流 包装成 对象输入流
				ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
				User user=(User)ois.readObject();
				this.userName=user.getUserName();
				System.out.println(user.getUserName());
				System.out.println(user.getPassWord());
				
				//Server端验证密码是否“123456”
				Message mess=new Message();
				mess.setSender("Server");
				mess.setReceiver(user.getUserName());
				if(user.getPassWord().equals("123456")){//不能用"==",对象比较
					//消息传递，创建一个Message对象				
					mess.setMessageType(Message.message_LoginSuccess);//验证通过					
				}
				else{				
					mess.setMessageType(Message.message_LoginFailure);//验证不通过	
				}
				
				ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
				oos.writeObject(mess);
				
				if(user.getPassWord().equals("123456")){
					//保存每一个用户对应的Socket
					hmSocket.put(userName,s);
					
					//如何接收客户端的聊天信息？另建一个线程来接收聊天信息
					new ServerReceiverThread(s).start();
				}
				
			}			
			
		} catch (IOException | ClassNotFoundException e) {			
			e.printStackTrace();
		}
	}
}
