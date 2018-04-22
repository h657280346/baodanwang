package test;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

@SuppressWarnings("serial")
public class AddMsgDialog extends JDialog implements ActionListener {
	private JLabel j2;
	private JLabel j3;
	private JLabel j4;
	private JLabel j5;
	private JLabel j6;
	private JLabel j7;
	private JLabel j8;
	private JLabel j9;
	private JLabel j10;
	private JLabel j11;
	private JLabel j12;
	private JLabel j13;
	private JLabel j14;
	private JLabel j15;
	private JTextField jt2;
	private JTextField jt3;
	private JTextField jt4;
	private JTextField jt5;
	private JTextField jt6;
	private JTextField jt7;
	private JTextField jt8;
	private JTextField jt9;
	private JTextField jt10;
	private JTextField jt11;
	private JTextField jt12;
	private JTextField jt13;
	private JTextField jt14;
	private JTextField jt15;
	private JButton submitBut;
	private JButton cancelBut;

	public AddMsgDialog(Frame owner, String title, boolean model) {
		// 父窗口,窗口名,是否是模式窗口
		super(owner, title, model);
		Font font = new Font("宋体",Font.BOLD,18);
		this.setBounds(350, 150, 850, 500); // (x轴起点,y轴起点,长度,高度)
		this.setResizable(false); // (窗体大小不可由用户修改)
		this.setLayout(null);
		j2 = new JLabel("区域代码");
		j2.setFont(font);
		j2.setBounds(20, 60, 150, 30);
		j3 = new JLabel("城市");
		j3.setFont(font);
		j3.setBounds(20, 100, 150, 30);
		j4 = new JLabel("时间");
		j4.setFont(font);
		j4.setBounds(20, 140, 150, 30);
		j5 = new JLabel("地点");
		j5.setFont(font);
		j5.setBounds(20, 180, 150, 30);
		j6 = new JLabel("空气质量指数");
		j6.setFont(font);
		j6.setBounds(20, 220, 150, 30);
		j7 = new JLabel("空气质量等级");
		j7.setFont(font);
		j7.setBounds(20, 260, 150, 30);
		j8 = new JLabel("pm2.5含量");
		j8.setFont(font);
		j8.setBounds(20, 300, 150, 30);
		j9 = new JLabel("pm10指数");
		j9.setFont(font);
		j9.setBounds(420, 60, 150, 30);
		j10 = new JLabel("CO含量");
		j10.setFont(font);
		j10.setBounds(420, 100, 150, 30);
		j11 = new JLabel("NO2含量");
		j11.setFont(font);
		j11.setBounds(420, 140, 150, 30);
		j12 = new JLabel("O3含量/1h");
		j12.setFont(font);
		j12.setBounds(420, 180, 150, 30);
		j13 = new JLabel("O3含量/8h");
		j13.setFont(font);
		j13.setBounds(420, 220, 150, 30);
		j14 = new JLabel("SO2含量");
		j14.setFont(font);
		j14.setBounds(420, 260, 150, 30);
		j15 = new JLabel("主要污染物");
		j15.setFont(font);
		j15.setBounds(420, 300, 150, 30);
		jt2 = new JTextField(10);
		jt2.setFont(font);
		jt2.setBounds(140, 60, 250, 30);
		jt3 = new JTextField(10);
		jt3.setFont(font);
		jt3.setBounds(140, 100, 250, 30);
		jt4 = new JTextField(10);
		jt4.setFont(font);
		jt4.setBounds(140, 140, 250, 30);
		jt5 = new JTextField(10);
		jt5.setFont(font);
		jt5.setBounds(140, 180, 250, 30);
		jt6 = new JTextField(10);
		jt6.setFont(font);
		jt6.setBounds(140, 220, 250, 30);
		jt7 = new JTextField(10);
		jt7.setFont(font);
		jt7.setBounds(140, 260, 250, 30);
		jt8 = new JTextField(10);
		jt8.setFont(font);
		jt8.setBounds(140, 300, 250, 30);
		jt9 = new JTextField(10);
		jt9.setFont(font);
		jt9.setBounds(540, 60, 250, 30);
		jt10 = new JTextField(10);
		jt10.setFont(font);
		jt10.setBounds(540, 100, 250, 30);
		jt11 = new JTextField(10);
		jt11.setFont(font);
		jt11.setBounds(540, 140, 250, 30);
		jt12 = new JTextField(10);
		jt12.setFont(font);
		jt12.setBounds(540, 180, 250, 30);
		jt13 = new JTextField(10);
		jt13.setFont(font);
		jt13.setBounds(540, 220, 250, 30);
		jt14 = new JTextField(10);
		jt14.setFont(font);
		jt14.setBounds(540, 260, 250, 30);
		jt15 = new JTextField(10);
		jt15.setFont(font);
		jt15.setBounds(540, 300, 250, 30);
		submitBut = new JButton("确认");
		submitBut.setFont(font);
		submitBut.setBounds(325, 380, 100, 30);
		cancelBut = new JButton("取消");
		cancelBut.setFont(font);
		cancelBut.setBounds(465, 380, 100, 30);
		submitBut.addActionListener(this);
		cancelBut.addActionListener(this);
		this.add(j2);
		this.add(j3);
		this.add(j4);
		this.add(j5);
		this.add(j6);
		this.add(j7);
		this.add(j8);
		this.add(j9);
		this.add(j10);
		this.add(j11);
		this.add(j12);
		this.add(j13);
		this.add(j14);
		this.add(j15);
		this.add(jt2);
		this.add(jt3);
		this.add(jt4);
		this.add(jt5);
		this.add(jt6);
		this.add(jt7);
		this.add(jt8);
		this.add(jt9);
		this.add(jt10);
		this.add(jt11);
		this.add(jt12);
		this.add(jt13);
		this.add(jt14);
		this.add(jt15);
		this.add(submitBut);
		this.add(cancelBut);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == submitBut) {
			if (jt2.getText().equals("")||jt3.getText().equals("")
				||jt4.getText().equals("")||jt5.getText().equals("")
				||jt6.getText().equals("")||jt7.getText().equals("")
				||jt8.getText().equals("")||jt9.getText().equals("")
				||jt10.getText().equals("")||jt11.getText().equals("")
				||jt12.getText().equals("")||jt13.getText().equals("")
				||jt14.getText().equals("")||jt15.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "输入不能有空", "提示", JOptionPane.PLAIN_MESSAGE);
			} else {
				int id =  selectLastId()+1;
				String sql = "insert into "
						+ "t_pm25(f_id,f_areacode,f_area,f_time,f_place,f_AQI,f_AQItype,f_PM25per1h,f_PM10per1h,"
						+ "f_COper1h,f_NO2per1h,f_O3per1h,f_O3per8h,f_SO2per1h,f_majorpollutant)"+ "values('" 
						+ id + "','"+ jt2.getText() + "','"+ jt3.getText() + "','" + jt4.getText() + "','" 
						+ jt5.getText()+ "','" + jt6.getText()+ "','" + jt7.getText()+ "','" +jt8.getText()
						+ "','" + jt9.getText()+ "','" + jt10.getText()+ "','" + jt11.getText()+ "','" + jt12.getText()
						+ "','" + jt13.getText()+ "','" + jt14.getText()+ "','" + jt15.getText()+ "')";
				try {
					TableModel tablemodel = new TableModel();
					tablemodel.addMsg(sql);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(this, "添加成功", "提示", JOptionPane.PLAIN_MESSAGE);
				this.setVisible(false);
			}
		}
		if (e.getSource() == cancelBut) {
			this.setVisible(false);
		}
	}
	public int selectLastId(){
		int id = 0;
		int id1 = 0;
		DBConnection db = new DBConnection();
		try {
			Connection con = db.getConnection();
			String sql = "select f_id from t_pm25 order by f_id";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet result = stmt.executeQuery();
			while(result.next()){
				id = result.getInt("f_id");
				if(id1<id){
					id1 = id;
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return id1;
	}
}