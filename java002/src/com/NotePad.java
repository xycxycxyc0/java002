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
	//定义菜栏条组件
	JMenuBar jmb;
	//定义菜单组件
	JMenu []jm=new JMenu[5];
	//定义菜单项
	JMenuItem []jmi=new JMenuItem[23];
	//定义文本域组件
	JTextArea jta;
	//定义滚动窗格组件
	JScrollPane jsp;
	//声明变量，作用是判断文本变化是否有保存
	int flag = 0;

	//定义成员变量文件对象，用于保存打开的文件对象
	File selectedFile;
	//如果"打开"操作，会将打开的文件路径覆盖此路径；如果此路径为空，可以保存为新文件；
	//创建文件选择器对象，用于展示打开和保存界面，从而选择文件
	JFileChooser chooser = new JFileChooser();
	
	//退出提示框
	JFrame alertJFrame = new JFrame();
	JButton saveButton = new JButton("保存");
	JButton notsaveButton = new JButton("不保存");
	JButton cancelButton = new JButton("取消");
	
	public NotePad() {
		// TODO Auto-generated constructor stub
		init();
	}
	
	public void init() { 
		//实现组件
		//实现菜单条组件
		jmb=new JMenuBar();
		//实现菜单组件
		jm[0] = new JMenu("文件(F)");
		jm[1] = new JMenu("编辑(E)");
		jm[2] = new JMenu("格式(O)");
		jm[3] = new JMenu("查看(V)");
		jm[4] = new JMenu("帮助(H)");
		//实现文件(F)菜单的菜单项组件
		jmi[0] = new JMenuItem("新建(N)");
		jmi[0].addActionListener(this);
		jmi[1] = new JMenuItem("打开(O)");
		jmi[1].addActionListener(this);
		jmi[2] = new JMenuItem("保存(S)");
		jmi[2].addActionListener(this);
		jmi[3] = new JMenuItem("另存为(A)");
		jmi[3].addActionListener(this);
		jmi[4] = new JMenuItem("页面设置(U)");
		jmi[5] = new JMenuItem("打印(P)");
		jmi[6] = new JMenuItem("退出(X)");
		jmi[6].addActionListener(this);
		//实现编辑(E)菜单的菜单项组件
		jmi[7] = new JMenuItem("撤销(Z)");
		jmi[8] = new JMenuItem("剪切(X)");
		jmi[9] = new JMenuItem("复制(C)");
		jmi[10] = new JMenuItem("粘贴(P)");
		jmi[11] = new JMenuItem("删除(D)");
		jmi[12] = new JMenuItem("查找(F)");
		jmi[13] = new JMenuItem("查找下一个(N)");
		jmi[14] = new JMenuItem("替换(R)");
		jmi[15] = new JMenuItem("转到(G)");
		jmi[16] = new JMenuItem("全选(A)");
		jmi[16].addActionListener(this);
		jmi[17] = new JMenuItem("日期/时间(D)");
		//实现格式(O)菜单的菜单项组件
		jmi[18] = new JMenuItem("自动换行(W)");
		jmi[19] = new JMenuItem("字体(F)");
		//实现格式(O)菜单的菜单项组件
		jmi[20] = new JMenuItem("状态栏(S)");
		//实现帮助(H)菜单的菜单项组件
		jmi[21] = new JMenuItem("查看帮助(H)");
		jmi[22] = new JMenuItem("关于记事本(A)");
		//实现文本域组件
		jta = new JTextArea();
		jta.getDocument().addDocumentListener(new DocumentListener() {
			   //监听文本内容的去除事件；
			   public void removeUpdate(DocumentEvent e) {
			    //keyword = textField.getText();
				   flag = 1;
			   }
			   //监听文本内容的插入事件； 
			   public void insertUpdate(DocumentEvent e) {
			    //keyword = textField.getText();
				   flag = 1;
			   }
			   //监听文本属性的变化； 
			   public void changedUpdate(DocumentEvent e) {
				   flag = 1;
			   }
		});
		//向滚动窗格添加文本域组件
	    jsp = new JScrollPane(jta);
		//添加组件
		//向文件菜单中添加菜单项
		for(int i=0;i< 7;i++)
		 jm[0].add(jmi[i]);
		//向编辑菜单中添加菜单项
		for(int i=7;i<=17;i++)
		 jm[1].add(jmi[i]);
		//向格式菜单中添加菜单项
		for(int i=18;i<=19;i++)
		 jm[2].add(jmi[i]);
		//向查看菜单中添加菜单项
		jm[3].add(jmi[20]);
		//向帮助菜单中添加菜单项
		for(int i=21;i<=22;i++)
			jm[4].add(jmi[i]);
		//向菜单栏中添加菜单
		for(int i=0;i< 5;i++)
			jmb.add(jm[i]);
			
		
		//添加滚动窗格组件
		this.add(jsp);
		//设置菜单栏
		this.setJMenuBar(jmb);
		//设置窗体图标
		//this.setIconImage((new ImageIcon("images/NotePadLogo.jpg")).getImage());
		//设置窗体标题
		this.setTitle("NotePad");
    	//设置窗体大小
		this.setSize(700,500);
		//设置窗体起始位置
		this.setLocation(400,150);
		//设置窗体关闭方式
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置窗体可见
		this.setVisible(true);
   }

	public void init2() {
		JLabel ifSaveLabel = new JLabel("是否更改保存");
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
		
		
		alertJFrame.setTitle("提示");
		alertJFrame.setSize(300,100);
		alertJFrame.setLocation(500, 200);
		alertJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		alertJFrame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == jmi[0]) { //新建功能
			NotePad notePad = new NotePad();
		}
		if (e.getSource() == jmi[1]) { //打开功能
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
		if (e.getSource() == jmi[2]) { //保存功能
			try {
				saveMenuItemClick();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} 
		if (e.getSource() == jmi[3]) { //另存为功能
			try {
				asSaveMenuItemClick();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource() == jmi[6]) { //退出功能
			try {
				exitMenuItemClick();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource() == jmi[16]) {//保存功能
			selectAll();
		}
		if (e.getSource() == saveButton) { //退出保存
			try {
				saveMenuItemClick();
				System.exit(0);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource() == notsaveButton) { //退出不保存
			System.exit(0);
		}
		if(e.getSource() == cancelButton) { //取消退出
			alertJFrame.setVisible(false);
		}
	}	
	
	
	//"打开"事件处理函数
	private void openMenuItemClick() throws IOException {
		//打开文件选择器，选择文件
		//JFileChooser chooser = new JFileChooser();
		//过滤扩展名
		//创建文件名过滤器对象
		FileNameExtensionFilter filter = new FileNameExtensionFilter("txt","txt");
		chooser.setFileFilter(filter);
		//展示打开文件选择器
		//返回用户的选择结果
		int userChoose = chooser.showOpenDialog(this);
			
		//如果用户选择打开，则读取内容，否则返回
		if(userChoose == JFileChooser.CANCEL_OPTION) {
			return;
		}
		//读取文件内容
		selectedFile = chooser.getSelectedFile();		
		if(selectedFile!=null&&selectedFile.isFile()) {
			//创建IO流对象
			FileReader fr = new FileReader(selectedFile);	
			//定义数组，记录本次读取到的字符内容
			char[] chars = new char[1024];
			//定义变量，记录本次读取到的字符个数
			int len;
			//读取内容
			while((len=fr.read(chars))!=-1) {
				//将本次读取到的内容转为字符串
				String thisS = new String(chars,0,len);
				//将内容添加到GUI的文本域组件中
				jta.append(thisS);
			}
			//关闭流
			fr.close();
		}
	}
		
	//"保存"事件处理函数
	private void saveMenuItemClick() throws IOException{	
		//判断成员位置是否已经存在File对象
		if(selectedFile!=null) {
			//获取文件内容
			String data = jta.getText();
			//写出文件内容
			//创建IO流对象
			FileWriter fw = new FileWriter(selectedFile);	
			//写出内容
			fw.write(data);
			//关闭流
			fw.close();
		}else {//如果是新建的文件
			//打开文件选择器，选择文件
			//过滤扩展名
			//创建文件名过滤器对象
			FileNameExtensionFilter filter = new FileNameExtensionFilter("txt","txt");
			chooser.setFileFilter(filter);
			
			File newFile = new File("新建文本文件");
			//为文件选择器设置默认文件名
			chooser.setSelectedFile(newFile);
			//展示   保存文件选择器
			int userChoose = chooser.showSaveDialog(this);
			//如果用户选择保存，则写出内容，否则返回
			if(userChoose==JFileChooser.APPROVE_OPTION) {
				//获取用户选择的文件
				File selectedFile2 = chooser.getSelectedFile();
				//去掉空白，转为小写判断用户选择的文件是否有.txt扩展名，如果没有加上.txt
				if(!selectedFile2.getName().trim().toLowerCase().endsWith(".txt")) {
					selectedFile2 = new File(selectedFile2.getParent(),selectedFile2.getName()+".txt");
				}
				//获取用户选择文件所在目录
				File parentDIR = selectedFile2.getParentFile();
				//遍历当前文件夹，判断是否有重名的文件
				File[] listFiles = parentDIR.listFiles(); 
				//依次获取文件夹中每一文件对象与保存的文件对象名称做对比 
				for (File file : listFiles) {
					if(file.getName().equals(selectedFile2.getName())) {
						//提示有重复文件，是否覆盖
						int isCover = JOptionPane.showConfirmDialog(this, "当前目录已经存在相同名称的文件，是否覆盖？");
						if(isCover==JOptionPane.OK_OPTION) {
							//获取文件内容   
							String data = jta.getText();
							//写出文件内容
							//创建IO流对象
							FileWriter fw = new FileWriter(selectedFile2);
							//写出内容
							fw.write(data);
							//关闭流
							fw.close();
						}else {
							return;
						}
					}
				}
				//如果没有重复文件，直接写出即可
				//获取文件内容
				String data = jta.getText();
				//写出文件内容
				//创建IO流对象
				FileWriter fw = new FileWriter(selectedFile2);
				//写出内容
				fw.write(data);
				//关闭流
				fw.close();
			}
		}
	}
	//"另存为"事件处理函数
	public void asSaveMenuItemClick() throws IOException {
		FileNameExtensionFilter filter = new FileNameExtensionFilter("txt","txt");
		chooser.setFileFilter(filter);
		
		File newFile = new File("新建文本文件");
		//为文件选择器设置默认文件名
		chooser.setSelectedFile(newFile);
		//展示   保存文件选择器
		int userChoose = chooser.showSaveDialog(this);
		//如果用户选择保存，则写出内容，否则返回
		if(userChoose==JFileChooser.APPROVE_OPTION) {
			//获取用户选择的文件
			File selectedFile2 = chooser.getSelectedFile();
			//去掉空白，转为小写判断用户选择的文件是否有.txt扩展名，如果没有加上.txt
			if(!selectedFile2.getName().trim().toLowerCase().endsWith(".txt")) {
				selectedFile2 = new File(selectedFile2.getParent(),selectedFile2.getName()+".txt");
			}
			//获取用户选择文件所在目录
			File parentDIR = selectedFile2.getParentFile();
			//遍历当前文件夹，判断是否有重名的文件
			File[] listFiles = parentDIR.listFiles(); 
			//依次获取文件夹中每一文件对象与保存的文件对象名称做对比 
			for (File file : listFiles) {
				if(file.getName().equals(selectedFile2.getName())) {
					//提示有重复文件，是否覆盖
					int isCover = JOptionPane.showConfirmDialog(this, "当前目录已经存在相同名称的文件，是否覆盖？");
					if(isCover==JOptionPane.OK_OPTION) {
						//获取文件内容   
						String data = jta.getText();
						//写出文件内容
						//创建IO流对象
						FileWriter fw = new FileWriter(selectedFile2);
						//写出内容
						fw.write(data);
						//关闭流
						fw.close();
					}else {
						return;						}
				}
			}
				
			//如果没有重复文件，直接写出即可
			//获取文件内容
			String data = jta.getText();
			//写出文件内容
			//创建IO流对象
			FileWriter fw = new FileWriter(selectedFile2);
			//写出内容
			fw.write(data);
			//关闭流
			fw.close();
		}
	}
	
	//"全选"事件处理函数
	public void selectAll() {
		jta.selectAll();
	}
	
		
	//"退出"事件处理函数
	public void exitMenuItemClick() throws IOException { 
		if (flag == 0) { //文本内容未改变
			System.exit(0);
		}else if (flag == 1) {//文本内容改变，则提示是否保存
			init2();
		} 
	}
	
	public static void main(String[] args) {
		//创建NotePad实例对象
		new NotePad();
	}
}
