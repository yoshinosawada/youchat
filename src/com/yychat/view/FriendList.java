package com.yychat.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class FriendList  extends JFrame implements ActionListener,MouseListener{//����
	//��Ա����
	CardLayout cardLayout;
	
	
	//��һ����Ƭ
	//����
	JPanel myFriendPanel;
	
	
	JButton myFriendButton;
	
	//�в�
	JScrollPane myFriendListJScrollPane;//������
	JPanel myFriendListJPanel;
	public static final int MYFRIENDCOUNT=51;


	private static final String LEFT = null;


	JLabel[] myFriendJLabel=new JLabel[MYFRIENDCOUNT];
	
	//�ϲ�
	JPanel myStrangerBlackListPanel;
	JButton myStrangerButton;
	JButton blackListButton;
	
	
	//�ڶ�����Ƭ
			JPanel myStrangerPanel;
			//����
			JPanel myFriendStrangerPanel;
			JButton myStrangerButton1;
			JButton myFriendButton1;
			
			//�в�
			JScrollPane myStrangerListJScrollPane;
			JPanel myStrangerListJPanel;
			public static final int MYCOUNT=51;


			public static final String LEFT1 = null;
			JLabel[] myStrangerJLabel=new JLabel[MYCOUNT];
			
			JPanel myStrangerBlackListPanel1;
			
			//�ϲ�
			JButton blackListButton1;
			
	String userName;//��Ա����
	public FriendList(String userName){//�β�
		this.userName=userName;
		//������һ�ſ�Ƭ
		myFriendPanel =new JPanel(new BorderLayout());
  		System.out.println(myFriendPanel.getLayout());
  		 
  		
  		//����
  		myFriendButton=new JButton("�ҵĺ���");
  		myFriendPanel.add(myFriendButton,"North");
  		
  		
  	    //�в�
  		myFriendListJPanel=new JPanel(new GridLayout(MYFRIENDCOUNT-1,1));
		for(int i=1;i<MYFRIENDCOUNT;i++){
			myFriendJLabel[i]=new JLabel(i+"",new ImageIcon("images/yy2.gif"),JLabel.LEFT);
			myFriendListJPanel.add(myFriendJLabel[i]);
		}
		
		
		myFriendListJScrollPane=new JScrollPane(myFriendListJPanel);
		myFriendPanel.add(myFriendListJScrollPane);
		
		
		
		//�ϲ�
		myStrangerBlackListPanel=new JPanel(new GridLayout(2,1));
		myStrangerButton=new JButton("�ҵ�İ����");
		myStrangerButton.addActionListener(this);//�¼�����
		blackListButton=new JButton("������");
		myStrangerBlackListPanel.add(myStrangerButton);
		myStrangerBlackListPanel.add(blackListButton);
		myFriendPanel.add(myStrangerBlackListPanel,"South");
		
		
		
		//�����ڶ�����Ƭ
		myStrangerPanel=new JPanel(new BorderLayout());//���֣��߽粼��
		//����
		myFriendStrangerPanel=new JPanel(new GridLayout(2,1));
	    myFriendButton1=new JButton("�ҵĺ���");
	    myFriendButton1.addActionListener(this);//�¼�����
	    myStrangerButton1=new JButton("�ҵ�İ����");
	    myFriendStrangerPanel.add(myFriendButton1);
	    myFriendStrangerPanel.add(myStrangerButton1);
	    myStrangerPanel.add(myFriendStrangerPanel, "North");
	    
	    
	    
		//�в�
		myStrangerListJPanel=new JPanel(new GridLayout(MYCOUNT-1,1));
		for(int i=1;i<MYCOUNT;i++){
			myStrangerJLabel[i]=new JLabel(i+"",new ImageIcon("images/YY1.gif"),JLabel.LEFT);
			myStrangerJLabel[i].addMouseListener(this);
			myStrangerListJPanel.add(myStrangerJLabel[i]);
		}
		
		
		myStrangerListJScrollPane=new JScrollPane(myStrangerListJPanel);
		myStrangerPanel.add(myStrangerListJScrollPane);
		
		
		//�ϲ�
		blackListButton1=new JButton("������");
		myStrangerPanel.add(blackListButton1,"South");
		
		
		//���������Ƭ
		cardLayout=new CardLayout();
		this.setLayout(cardLayout);
		this.add(myFriendPanel,"1");
		this.add(myStrangerPanel,"2");
		
		
		this.setSize(150,500);
		this.setTitle(userName+"�ĺ����б�");
		this.setIconImage(new ImageIcon("images/yy0.gif").getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null); 
		this.setVisible(true);
	}

	public static void main(String[] args) {
		//FriendList friendList=new FriendList("fjj");
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==myStrangerButton) cardLayout.show(this.getContentPane(), "2");
		if(e.getSource()==myFriendButton1) cardLayout.show(this.getContentPane(), "1");
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(arg0.getClickCount()==2){
			new FriendChat();
			
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		JLabel jlbl1=(JLabel)arg0.getSource();
		jlbl1.setForeground(Color.red);
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		JLabel jlbl1=(JLabel)arg0.getSource();
		jlbl1.setForeground(Color.BLACK);
		 
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
