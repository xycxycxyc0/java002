package com;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;

public class NotePad extends JFrame implements ActionListener {  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//������������
	JMenuBar jmb;
	//����˵����
	JMenu []jm=new JMenu[5];
	//����˵���
	JMenuItem []jmi=new JMenuItem[23];
	//�����ı������
	JTextArea jta;
	//��������������
	JScrollPane jsp;
	//�����������������ж��ı��仯�Ƿ��б���
	int flag = 0;

	//�����Ա�����ļ��������ڱ���򿪵��ļ�����
	File selectedFile;
	//���"��"�������Ὣ�򿪵��ļ�·�����Ǵ�·���������·��Ϊ�գ����Ա���Ϊ���ļ���
	//�����ļ�ѡ������������չʾ�򿪺ͱ�����棬�Ӷ�ѡ���ļ�
	JFileChooser chooser = new JFileChooser();
	
	//�˳���ʾ��
	JFrame alertJFrame = new JFrame();
	JButton saveButton = new JButton("����");
	JButton notsaveButton = new JButton("������");
	JButton cancelButton = new JButton("ȡ��");
	
	public NotePad() {
		// TODO Auto-generated constructor stub
		init();
	}
	
	public void init() { 
		//ʵ�����
		//ʵ�ֲ˵������
		jmb=new JMenuBar();
		//ʵ�ֲ˵����
		jm[0] = new JMenu("�ļ�(F)");
		jm[1] = new JMenu("�༭(E)");
		jm[2] = new JMenu("��ʽ(O)");
		jm[3] = new JMenu("�鿴(V)");
		jm[4] = new JMenu("����(H)");
		//ʵ���ļ�(F)�˵��Ĳ˵������
		jmi[0] = new JMenuItem("�½�(N)");
		jmi[0].addActionListener(this);
		jmi[1] = new JMenuItem("��(O)");
		jmi[1].addActionListener(this);
		jmi[2] = new JMenuItem("����(S)");
		jmi[2].addActionListener(this);
		jmi[3] = new JMenuItem("���Ϊ(A)");
		jmi[3].addActionListener(this);
		jmi[4] = new JMenuItem("ҳ������(U)");
		jmi[5] = new JMenuItem("��ӡ(P)");
		jmi[6] = new JMenuItem("�˳�(X)");
		jmi[6].addActionListener(this);
		//ʵ�ֱ༭(E)�˵��Ĳ˵������
		jmi[7] = new JMenuItem("����(Z)");
		jmi[8] = new JMenuItem("����(X)");
		jmi[9] = new JMenuItem("����(C)");
		jmi[10] = new JMenuItem("ճ��(P)");
		jmi[11] = new JMenuItem("ɾ��(D)");
		jmi[12] = new JMenuItem("����(F)");
		jmi[13] = new JMenuItem("������һ��(N)");
		jmi[14] = new JMenuItem("�滻(R)");
		jmi[15] = new JMenuItem("ת��(G)");
		jmi[16] = new JMenuItem("ȫѡ(A)");
		jmi[16].addActionListener(this);
		jmi[17] = new JMenuItem("����/ʱ��(D)");
		//ʵ�ָ�ʽ(O)�˵��Ĳ˵������
		jmi[18] = new JMenuItem("�Զ�����(W)");
		jmi[19] = new JMenuItem("����(F)");
		//ʵ�ָ�ʽ(O)�˵��Ĳ˵������
		jmi[20] = new JMenuItem("״̬��(S)");
		//ʵ�ְ���(H)�˵��Ĳ˵������
		jmi[21] = new JMenuItem("�鿴����(H)");
		jmi[22] = new JMenuItem("���ڼ��±�(A)");
		//ʵ���ı������
		jta = new JTextArea();
		jta.getDocument().addDocumentListener(new DocumentListener() {
			   //�����ı����ݵ�ȥ���¼���
			   public void removeUpdate(DocumentEvent e) {
			    //keyword = textField.getText();
				   flag = 1;
			   }
			   //�����ı����ݵĲ����¼��� 
			   public void insertUpdate(DocumentEvent e) {
			    //keyword = textField.getText();
				   flag = 1;
			   }
			   //�����ı����Եı仯�� 
			   public void changedUpdate(DocumentEvent e) {
				   flag = 1;
			   }
		});
		//�������������ı������
	    jsp = new JScrollPane(jta);
		//������
		//���ļ��˵�����Ӳ˵���
		for(int i=0;i< 7;i++)
		 jm[0].add(jmi[i]);
		//��༭�˵�����Ӳ˵���
		for(int i=7;i<=17;i++)
		 jm[1].add(jmi[i]);
		//���ʽ�˵�����Ӳ˵���
		for(int i=18;i<=19;i++)
		 jm[2].add(jmi[i]);
		//��鿴�˵�����Ӳ˵���
		jm[3].add(jmi[20]);
		//������˵�����Ӳ˵���
		for(int i=21;i<=22;i++)
			jm[4].add(jmi[i]);
		//��˵�������Ӳ˵�
		for(int i=0;i< 5;i++)
			jmb.add(jm[i]);
			
		
		//��ӹ����������
		this.add(jsp);
		//���ò˵���
		this.setJMenuBar(jmb);
		//���ô���ͼ��
		//this.setIconImage((new ImageIcon("images/NotePadLogo.jpg")).getImage());
		//���ô������
		this.setTitle("NotePad");
    	//���ô����С
		this.setSize(700,500);
		//���ô�����ʼλ��
		this.setLocation(400,150);
		//���ô���رշ�ʽ
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//���ô���ɼ�
		this.setVisible(true);
   }

	public void init2() {
		JLabel ifSaveLabel = new JLabel("�Ƿ���ı���");
		Panel head = new Panel();
		Panel body = new Panel();
		Panel footer = new Panel();
		
		head.add(ifSaveLabel);
		footer.add(saveButton);
		footer.add(notsaveButton);
		footer.add(cancelButton);
			
		saveButton.addActionListener(this);
		notsaveButton.addActionListener(this);
		cancelButton.addActionListener(this);

		alertJFrame.setLayout(new BorderLayout());
		alertJFrame.add(head, BorderLayout.NORTH);
		alertJFrame.add(footer, BorderLayout.SOUTH);
		
		
		alertJFrame.setTitle("��ʾ");
		alertJFrame.setSize(300,100);
		alertJFrame.setLocation(500, 200);
		alertJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		alertJFrame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == jmi[0]) { //�½�����
			NotePad notePad = new NotePad();
		}
		if (e.getSource() == jmi[1]) { //�򿪹���
			if (jta.getText().equals("")) {
				try {
					openMenuItemClick();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else {
				jta.setText(null);
				try {
					openMenuItemClick();
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		if (e.getSource() == jmi[2]) { //���湦��
			try {
				saveMenuItemClick();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} 
		if (e.getSource() == jmi[3]) { //���Ϊ����
			try {
				asSaveMenuItemClick();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource() == jmi[6]) { //�˳�����
			try {
				exitMenuItemClick();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource() == jmi[16]) {//���湦��
			selectAll();
		}
		if (e.getSource() == saveButton) { //�˳�����
			try {
				saveMenuItemClick();
				System.exit(0);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource() == notsaveButton) { //�˳�������
			System.exit(0);
		}
		if(e.getSource() == cancelButton) { //ȡ���˳�
			alertJFrame.setVisible(false);
		}
	}	
	
	
	//"��"�¼�������
	private void openMenuItemClick() throws IOException {
		//���ļ�ѡ������ѡ���ļ�
		//JFileChooser chooser = new JFileChooser();
		//������չ��
		//�����ļ�������������
		FileNameExtensionFilter filter = new FileNameExtensionFilter("txt","txt");
		chooser.setFileFilter(filter);
		//չʾ���ļ�ѡ����
		//�����û���ѡ����
		int userChoose = chooser.showOpenDialog(this);
			
		//����û�ѡ��򿪣����ȡ���ݣ����򷵻�
		if(userChoose == JFileChooser.CANCEL_OPTION) {
			return;
		}
		//��ȡ�ļ�����
		selectedFile = chooser.getSelectedFile();		
		if(selectedFile!=null&&selectedFile.isFile()) {
			//����IO������
			FileReader fr = new FileReader(selectedFile);	
			//�������飬��¼���ζ�ȡ�����ַ�����
			char[] chars = new char[1024];
			//�����������¼���ζ�ȡ�����ַ�����
			int len;
			//��ȡ����
			while((len=fr.read(chars))!=-1) {
				//�����ζ�ȡ��������תΪ�ַ���
				String thisS = new String(chars,0,len);
				//��������ӵ�GUI���ı��������
				jta.append(thisS);
			}
			//�ر���
			fr.close();
		}
	}
		
	//"����"�¼�������
	private void saveMenuItemClick() throws IOException{	
		//�жϳ�Աλ���Ƿ��Ѿ�����File����
		if(selectedFile!=null) {
			//��ȡ�ļ�����
			String data = jta.getText();
			//д���ļ�����
			//����IO������
			FileWriter fw = new FileWriter(selectedFile);	
			//д������
			fw.write(data);
			//�ر���
			fw.close();
		}else {//������½����ļ�
			//���ļ�ѡ������ѡ���ļ�
			//������չ��
			//�����ļ�������������
			FileNameExtensionFilter filter = new FileNameExtensionFilter("txt","txt");
			chooser.setFileFilter(filter);
			
			File newFile = new File("�½��ı��ļ�");
			//Ϊ�ļ�ѡ��������Ĭ���ļ���
			chooser.setSelectedFile(newFile);
			//չʾ   �����ļ�ѡ����
			int userChoose = chooser.showSaveDialog(this);
			//����û�ѡ�񱣴棬��д�����ݣ����򷵻�
			if(userChoose==JFileChooser.APPROVE_OPTION) {
				//��ȡ�û�ѡ����ļ�
				File selectedFile2 = chooser.getSelectedFile();
				//ȥ���հף�תΪСд�ж��û�ѡ����ļ��Ƿ���.txt��չ�������û�м���.txt
				if(!selectedFile2.getName().trim().toLowerCase().endsWith(".txt")) {
					selectedFile2 = new File(selectedFile2.getParent(),selectedFile2.getName()+".txt");
				}
				//��ȡ�û�ѡ���ļ�����Ŀ¼
				File parentDIR = selectedFile2.getParentFile();
				//������ǰ�ļ��У��ж��Ƿ����������ļ�
				File[] listFiles = parentDIR.listFiles(); 
				//���λ�ȡ�ļ�����ÿһ�ļ������뱣����ļ������������Ա� 
				for (File file : listFiles) {
					if(file.getName().equals(selectedFile2.getName())) {
						//��ʾ���ظ��ļ����Ƿ񸲸�
						int isCover = JOptionPane.showConfirmDialog(this, "��ǰĿ¼�Ѿ�������ͬ���Ƶ��ļ����Ƿ񸲸ǣ�");
						if(isCover==JOptionPane.OK_OPTION) {
							//��ȡ�ļ�����   
							String data = jta.getText();
							//д���ļ�����
							//����IO������
							FileWriter fw = new FileWriter(selectedFile2);
							//д������
							fw.write(data);
							//�ر���
							fw.close();
						}else {
							return;
						}
					}
				}
				//���û���ظ��ļ���ֱ��д������
				//��ȡ�ļ�����
				String data = jta.getText();
				//д���ļ�����
				//����IO������
				FileWriter fw = new FileWriter(selectedFile2);
				//д������
				fw.write(data);
				//�ر���
				fw.close();
			}
		}
	}
	//"���Ϊ"�¼�������
	public void asSaveMenuItemClick() throws IOException {
		FileNameExtensionFilter filter = new FileNameExtensionFilter("txt","txt");
		chooser.setFileFilter(filter);
		
		File newFile = new File("�½��ı��ļ�");
		//Ϊ�ļ�ѡ��������Ĭ���ļ���
		chooser.setSelectedFile(newFile);
		//չʾ   �����ļ�ѡ����
		int userChoose = chooser.showSaveDialog(this);
		//����û�ѡ�񱣴棬��д�����ݣ����򷵻�
		if(userChoose==JFileChooser.APPROVE_OPTION) {
			//��ȡ�û�ѡ����ļ�
			File selectedFile2 = chooser.getSelectedFile();
			//ȥ���հף�תΪСд�ж��û�ѡ����ļ��Ƿ���.txt��չ�������û�м���.txt
			if(!selectedFile2.getName().trim().toLowerCase().endsWith(".txt")) {
				selectedFile2 = new File(selectedFile2.getParent(),selectedFile2.getName()+".txt");
			}
			//��ȡ�û�ѡ���ļ�����Ŀ¼
			File parentDIR = selectedFile2.getParentFile();
			//������ǰ�ļ��У��ж��Ƿ����������ļ�
			File[] listFiles = parentDIR.listFiles(); 
			//���λ�ȡ�ļ�����ÿһ�ļ������뱣����ļ������������Ա� 
			for (File file : listFiles) {
				if(file.getName().equals(selectedFile2.getName())) {
					//��ʾ���ظ��ļ����Ƿ񸲸�
					int isCover = JOptionPane.showConfirmDialog(this, "��ǰĿ¼�Ѿ�������ͬ���Ƶ��ļ����Ƿ񸲸ǣ�");
					if(isCover==JOptionPane.OK_OPTION) {
						//��ȡ�ļ�����   
						String data = jta.getText();
						//д���ļ�����
						//����IO������
						FileWriter fw = new FileWriter(selectedFile2);
						//д������
						fw.write(data);
						//�ر���
						fw.close();
					}else {
						return;						}
				}
			}
				
			//���û���ظ��ļ���ֱ��д������
			//��ȡ�ļ�����
			String data = jta.getText();
			//д���ļ�����
			//����IO������
			FileWriter fw = new FileWriter(selectedFile2);
			//д������
			fw.write(data);
			//�ر���
			fw.close();
		}
	}
	
	//"ȫѡ"�¼�������
	public void selectAll() {
		jta.selectAll();
	}
	
		
	//"�˳�"�¼�������
	public void exitMenuItemClick() throws IOException { 
		if (flag == 0) { //�ı�����δ�ı�
			System.exit(0);
		}else if (flag == 1) {//�ı����ݸı䣬����ʾ�Ƿ񱣴�
			init2();
		} 
	}
	
	public static void main(String[] args) {
		//����NotePadʵ������
		new NotePad();
	}
}
