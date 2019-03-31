package com.yychat.controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.yychat.model.Message;
import com.yychat.model.User;

public class ClientConnetion {
    public static Socket s;//��̬��Ա����
	public ClientConnetion(){
		try {//�쳣����ṹ
			s=new Socket("127.0.0.1",3456);//������ַ���ز��ַ
            System.out.println("�ͻ���Socket"+s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
    public Message loginValidate(User user){
    	ObjectOutputStream oos;
    	Message mess=null;
	 //��������������
    	try {
			oos=new ObjectOutputStream(s.getOutputStream());//���ֽ�����������װ�������������
			oos.writeObject(user);
			System.out.println("����User���û���Ϊ"+user.getUserName()+"����Ϊ"+user.getPassWord());
			
			ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
			mess=(Message)ois.readObject();
			
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return mess;
}

	}