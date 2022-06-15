package com;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.GregorianCalendar;
import javax.swing.*;

/*��������*/

public class Calender extends JFrame implements ActionListener,Runnable {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// �·ݺ���ݵ������б��

	JComboBox MonthBox = new JComboBox();
	JComboBox YearBox = new JComboBox();

	// �·ݺ���ݵı�ǩ
	JLabel shuru = new JLabel("����������");
	JLabel YearLabel = new JLabel("���: ");
	JLabel MonthLabel = new JLabel("�·�: ");

	// ��ȷ�����������족��"��һ��"��"��һ��"�ĸ���ť

    JButton button_ok = new JButton("ȷ��");
	JButton button_today = new JButton("����");
	JButton button_upmonth = new JButton("����");
	JButton button_downmonth = new JButton("����");
	
	
	// ��ȡ��������ڡ���ݡ��·�

	Date now_date = new Date();
	int now_year = now_date.getYear() + 1900;
	int now_month = now_date.getMonth();

	// �÷���ʾ���������

	boolean todayFlag = false;

	// ��һ�鰴ť��ʾ���ڣ�һ��7��7�У���һ��Ϊ���ڵ�����

	JButton[] button_day = new JButton[42];
	String[] week = { "��", "һ", "��", "��", "��", "��", "��" };
	JButton[] button_week = new JButton[7];

	// �����û�ѡ������

	String year_int = null;

	// �����û�ѡ����·�

	int month_int;
	//ʱ��
	JLabel Now_Time = new JLabel();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd�� hhʱmm��ss��");
	 

/**

* ���캯��

*/

	public Calender() {
		super();
		this.setTitle("�� ��");
		this.init();
		this.setLocation(400, 300);
		pack();
	}
	
/**

* ��ʼ������

*/

	private void init() {

		Font font = new Font("Dialog", Font.BOLD, 14);
		shuru.setFont(font);
		YearLabel.setFont(font);
		MonthLabel.setFont(font);
		button_ok.setFont(font);
		button_today.setFont(font);

		// �趨������䣬Ϊ��ǰ��ݵĹ�ȥ2022�굽��ǰ��ݵ�δ��5000�꣬

		for (int i = now_year - 2022; i <= now_year + 5000; i++) {
			YearBox.addItem(i + "");
		}

		// �趨��������б�Ϊ��ǰ��ݣ���ǰ�·ݴ��ڵ�ʮ��
		YearBox.setSelectedIndex(2022);

		// �趨�·����䣬12����
		for (int i = 1; i < 13; i++) {
			MonthBox.addItem(i + "");
		}

		// �趨�·������б�Ϊ��ǰ�·�

		MonthBox.setSelectedIndex(now_month);

		// ���������б��Ϳ��ư�ť�����

		JPanel panel_ym = new JPanel();
		panel_ym.add(shuru);
		panel_ym.add(YearLabel);
		panel_ym.add(YearBox);
		panel_ym.add(MonthLabel);
		panel_ym.add(MonthBox);
		panel_ym.add(button_ok);
		panel_ym.add(button_today);
		panel_ym.add(button_upmonth);
		panel_ym.add(button_downmonth);
		
		Now_Time = new JLabel(sdf.format(new Date()));
		//����JLabelһЩ����ֵ��
		Now_Time.setForeground(Color.DARK_GRAY);
		Now_Time.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		Now_Time.setBounds(233, 36, 250, 15);
		panel_ym.add(Now_Time);

		// Ϊ4����ť����¼�������

		button_ok.addActionListener(this);
		button_today.addActionListener(this);
		button_upmonth.addActionListener(this);
		button_downmonth.addActionListener(this);

		// �����������

		JPanel panel_day = new JPanel();

		// ���񲼾ֹ�������7��7�У�����֮��ˮƽ�ʹ�ֱ�����ϼ����Ϊ5

		panel_day.setLayout(new GridLayout(7, 7, 3, 3));

		// ������ڵ����֣����ŵ�������

		for (int i = 0; i < 7; i++) {

			button_week[i] = new JButton(" ");
			button_week[i].setText(week[i]);
			button_week[0].setForeground(Color.black);
			panel_day.add(button_week[i]);
		}

		button_week[0].setForeground(Color.red);
		button_week[6].setForeground(Color.red);

		// ������ڣ��ŵ�������

		for (int i = 0; i < 42; i++) {
			button_day[i] = new JButton(" ");
			panel_day.add(button_day[i]);
		}

		// ��ʾ��ǰ���µ�����
		this.paintDay();
		

		// ���������������
		JPanel panel_main = new JPanel();
		// �߽粼�ֹ�����

		panel_main.setLayout(new BorderLayout());
		panel_main.add(panel_ym, BorderLayout.NORTH);		
		panel_main.add(panel_day, BorderLayout.SOUTH);
		getContentPane().add(panel_main);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

/**

* ��ʾ��ǰ���µ�����

*/

	public void paintDay() {
		if (todayFlag) {
			// Ҫ����ʾ���������
			year_int = now_year + "";
			month_int = now_month;
		} else {
			// ���򣬴��������л�ȡ�û�ѡ�������
			year_int = YearBox.getSelectedItem().toString();
			month_int = MonthBox.getSelectedIndex();// ��ѡ�����
		}
		// ������ֵ
		int year_sel = Integer.parseInt(year_int) - 1900;
		// ������µĵ�һ��
		Date firstDay = new Date(year_sel, month_int, 1);
		// ����һ��Calendarʵ��
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(firstDay);
		

		int days = 0; // ���ĳ���·ݵ�����
		int day_week = 0; // ���ĳ���µĵ�һ�������ڼ�����ֵ
		int day_week2 = 0;

		// �ж��Ǽ��·�,���������趨day��ֵ ���ж��·�Ҫ�ж��Ƿ�������
		if (month_int == 0 || month_int == 2 || month_int == 4 || month_int == 6 || month_int == 7 || month_int == 9 || month_int == 11) {
			days = 31;
		} else if (month_int == 3 || month_int == 5 || month_int == 8 || month_int == 10) {
			days = 30;
		} else {
			// ���£���������꣬����29�죬������28��
			if (cal.isLeapYear(year_sel)) {
				days = 29;
			} else {
				days = 28;
			}
		}
		// getDay������ȡ���������ڼ�
		day_week = firstDay.getDay();
		int count = 1;

/*
*���ư�ť������������Ҫ����ѡ�����·ݵĵ�һ�������ڼ���ȷ�����ư�ť����ʼλ��
*����day_week��������Ҫ���Ƶ���ʼλ�ã�������Щ�Ǳ��°�ťҪ����ɫ��ʾ��
*/

		for (int i = day_week; i < day_week + days; count++, i++) {
			if (i % 7 == 0 || i == 6 || i == 13 || i == 20 || i == 27 || i == 34 || i == 41) {
				// ����Ǳ߽��ϵİ�ť�������ú�ɫ���Ա�ʾ��ĩ
				if (i == day_week + now_date.getDate() - 1) {
					// ��������һ������������ɫ��ʾ
					button_day[i].setForeground(Color.blue);
					button_day[i].setText(count + "");
				} else {
					// �����߽��ϵİ�ť�е������ú�ɫ
					button_day[i].setForeground(Color.red);
					button_day[i].setText(count + "");
				}
			} else {
				if (i == day_week + now_date.getDate() - 1) {
					button_day[i].setForeground(Color.blue);
					button_day[i].setText(count + "");
				} else {
					// һ��λ�õİ�ť�ϵ������ú�ɫ��ʾ
					button_day[i].setForeground(Color.black);
					button_day[i].setText(count + "");
				}
			}
		}
		// ����û��������ֵ��ʾ�İ�ť���д���
		int After_Day = 1;
        cal.set(cal.MONTH, cal.get(cal.MONTH)-1);
        int lastDateOfPrevMonth = cal.getActualMaximum(cal.DAY_OF_MONTH);
        int nowMonthfirstButton = lastDateOfPrevMonth - day_week + 1;
		
		if (day_week == 0) {
			// �����һ�������գ��򽫺���İ�ť�ϵ����ֶ���Ϊ���µ�����
			for (int i = days; i < 42; i++, After_Day++) {
				button_day[i].setForeground(Color.gray);
				button_day[i].setText(After_Day + "");
			}
		} else {
			// �����һ�첻�����գ��򽫵�һ��ǰ��İ�ť�ÿ�
			for (int i = 0; i < day_week; i++, nowMonthfirstButton++) {
				button_day[i].setForeground(Color.gray);
				button_day[i].setText(nowMonthfirstButton + "");
			} // ���һ�����İ�ť��Ϊ���µ�����
			for (int i = day_week + days; i < 42; i++, After_Day++) {
				button_day[i].setForeground(Color.gray);
				button_day[i].setText(After_Day + "");
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button_ok) {
			// ������ȷ����ť�͵���setDay()���·������ư�ť
			todayFlag = false;
			this.paintDay();
		} else if (e.getSource() == button_today) {
			// ���������찴ť���õ����������
			todayFlag = true;
			YearBox.setSelectedIndex(2022);
			MonthBox.setSelectedIndex(now_month);
			this.paintDay();
		} else if (e.getSource() == button_upmonth){//������¿ɵõ���������
			 todayFlag = false;
			 if (month_int == 0) {
				YearBox.setSelectedIndex(YearBox.getSelectedIndex() - 1);
				MonthBox.setSelectedIndex(11);
			}else {
				MonthBox.setSelectedIndex(MonthBox.getSelectedIndex() - 1);
			}
			 this.paintDay(); 
		} else if (e.getSource() == button_downmonth){//������¿ɵõ���������
			 todayFlag = false;
			 if (month_int == 11) {
				YearBox.setSelectedIndex(YearBox.getSelectedIndex() + 1);
				MonthBox.setSelectedIndex(0);
			}else {
				MonthBox.setSelectedIndex(MonthBox.getSelectedIndex() + 1);
			}
			 this.paintDay(); 
		}
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);//Thread.Sleep()�������ڽ���ǰ�߳�����һ��ʱ�䣬��λΪ���롣����Ϊÿ1000��������һ���̡߳�
				Now_Time.setText(sdf.format(new Date()));//�ѵ�ǰ��ϵͳʱ�丳�赽�����Զ����JLabel��
			} catch (InterruptedException e) {
				e.printStackTrace();//�׳��쳣
			}
		}
	}
	
	public static void main(String[] args) {
		Calender ct = new Calender();
		new Thread(ct).start();//�����߳�
	}

}

