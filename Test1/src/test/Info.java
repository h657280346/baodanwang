package test;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

import java.awt.event.*;
import java.sql.*;

@SuppressWarnings("serial")
public class Info extends JFrame implements ActionListener {
	// 主角面上的控件
	private JLabel inputLabel;
	private JTextField it1;
	private JTextField it2;
	private JTextField it3;
	private JTextField it4;
	private JTextField it5;
	private JTextField it6;
	private JTextField it7;
	private JTextField it8;
	private JTextField it9;
	private JTextField it10;
	private JTextField it11;
	private JTextField it12;
	private JTextField it13;
	private JTextField it14;
	private JTextField it15;
	private JButton searchBut;
	private JTable Table;
	private JButton addBut;
	private JButton modifyBut;
	private JButton deleteBut;
	private JButton refreshBut;
	private JButton prevBut;
	private JButton nextBut;
	private JLabel pageLabel1;
	private JLabel pageLabel2;
	private JTextField pageText;
	private JButton goBut;
	private TableModel TableModel;

	public static void main(String[] args) throws SQLException {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame.setDefaultLookAndFeelDecorated(true);
				JDialog.setDefaultLookAndFeelDecorated(true);
				try {

					/*
					 * 想要修改皮肤的话，只需要更改，下面这个函数的参数，具体改成什么样，可以打开，Referenced
					 * Libraries -> 点击substance.jar ->
					 * 找到org.jvnet.substance.skin这个包 ->
					 * 将下面的SubstanceDustCoffeeLookAndFeel 替换成
					 * 刚刚打开的包下的任意一个“Substance....LookAndFeel”即可
					 */
					UIManager.setLookAndFeel(new org.jvnet.substance.skin.SubstanceOfficeBlue2007LookAndFeel());
					Info info = new Info();
					info.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Info() {
		// 创建主界面上的控件
		this.setBounds(20, 50,1830, 780);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		Font font = new Font("宋体",Font.BOLD,18);
		try {
			TableModel = new TableModel();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JLabel p1 = new JLabel("编号");
		p1.setFont(font);
		p1.setBounds(37, 120, 100, 30);
		JLabel p2 = new JLabel("区域代号");
		p2.setFont(font);
		p2.setBounds(95, 120, 100, 30);
		JLabel p3 = new JLabel("城市");
		p3.setFont(font);
		p3.setBounds(195, 120, 100, 30);
		JLabel p4 = new JLabel("时间");
		p4.setFont(font);
		p4.setBounds(350, 120, 100, 30);
		JLabel p5 = new JLabel("地点");
		p5.setFont(font);
		p5.setBounds(565, 120, 100, 30);
		JLabel p6 = new JLabel("空气质量指数");
		p6.setFont(font);
		p6.setBounds(655, 120, 120, 30);
		JLabel p7 = new JLabel("空气质量等级");
		p7.setFont(font);
		p7.setBounds(787, 120, 120, 30);
		JLabel p8 = new JLabel("pm2.5含量");
		p8.setFont(font);
		p8.setBounds(925, 120, 100, 30);
		JLabel p9 = new JLabel("pm10指数");
		p9.setFont(font);
		p9.setBounds(1015, 120, 100, 30);
		JLabel p10 = new JLabel("CO含量");
		p10.setFont(font);
		p10.setBounds(1100, 120, 100, 30);
		JLabel p11 = new JLabel("NO2含量");
		p11.setFont(font);
		p11.setBounds(1175, 120, 100, 30);
		JLabel p12 = new JLabel("O3含量/1h");
		p12.setFont(font);
		p12.setBounds(1270, 120, 100, 30);
		JLabel p13 = new JLabel("O3含量/8h");
		p13.setFont(font);
		p13.setBounds(1395, 120, 100, 30);
		JLabel p14 = new JLabel("SO2含量");
		p14.setFont(font);
		p14.setBounds(1510, 120, 100, 30);
		JLabel p15 = new JLabel("主要污染物");
		p15.setFont(font);
		p15.setBounds(1625, 120, 100, 30);
		JLabel t1 = new JLabel("编号");
		t1.setFont(font);
		t1.setBounds(120, 30, 100, 30);
		JLabel t2 = new JLabel("区域代号");
		t2.setFont(font);
		t2.setBounds(195, 30, 100, 30);
		JLabel t3 = new JLabel("城市");
		t3.setFont(font);
		t3.setBounds(300, 30, 100, 30); 
		JLabel t4 = new JLabel("时间");
		t4.setFont(font);
		t4.setBounds(470, 30, 100, 30);
		JLabel t5 = new JLabel("地点");
		t5.setFont(font);
		t5.setBounds(690, 30, 100, 30);
		JLabel t6 = new JLabel("空气指数");
		t6.setFont(font);
		t6.setBounds(800, 30, 120, 30);
		JLabel t7 = new JLabel("空气等级");
		t7.setFont(font);
		t7.setBounds(905, 30, 120, 30);
		JLabel t8 = new JLabel("pm2.5");
		t8.setFont(font);
		t8.setBounds(1015, 30, 100, 30);
		JLabel t9 = new JLabel("pm10");
		t9.setFont(font);
		t9.setBounds(1090, 30, 100, 30);
		JLabel t10 = new JLabel("CO");
		t10.setFont(font);
		t10.setBounds(1170, 30, 100, 30);
		JLabel t11 = new JLabel("NO2");
		t11.setFont(font);
		t11.setBounds(1235, 30, 100, 30);
		JLabel t12 = new JLabel("O3/1h");
		t12.setFont(font);
		t12.setBounds(1295, 30, 100, 30);
		JLabel t13 = new JLabel("O3/8h");
		t13.setFont(font);
		t13.setBounds(1365, 30, 100, 30);
		JLabel t14 = new JLabel("SO2");
		t14.setFont(font);
		t14.setBounds(1445, 30, 100, 30);
		JLabel t15 = new JLabel("主要污染物");
		t15.setFont(font);
		t15.setBounds(1535, 30, 100, 30);
		inputLabel = new JLabel("查询");
		inputLabel.setFont(font);
		inputLabel.setBounds(37, 70, 150, 30);
		it1 = new JTextField(10);
		it1.setFont(font);
		it1.setBounds(100, 70, 80, 30);
		it2 = new JTextField(50);
		it2.setFont(font);
		it2.setBounds(190, 70, 80, 30);
		it3 = new JTextField(50);
		it3.setFont(font);
		it3.setBounds(280, 70, 80, 30);
		it4 = new JTextField(50);
		it4.setFont(font);
		it4.setBounds(370, 70, 240, 30);
		it5 = new JTextField(50);
		it5.setFont(font);
		it5.setBounds(620, 70, 180, 30);
		it6 = new JTextField(50);
		it6.setFont(font);
		it6.setBounds(810, 70, 60, 30);
		it7 = new JTextField(50);
		it7.setFont(font);
		it7.setBounds(880, 70, 120, 30);
		it8 = new JTextField(50);
		it8.setFont(font);
		it8.setBounds(1010, 70, 60, 30);
		it9 = new JTextField(50);
		it9.setFont(font);
		it9.setBounds(1080, 70, 60, 30);
		it10 = new JTextField(50);
		it10.setFont(font);
		it10.setBounds(1150, 70, 60, 30);
		it11 = new JTextField(50);
		it11.setFont(font);
		it11.setBounds(1220, 70, 60, 30);
		it12 = new JTextField(50);
		it12.setFont(font);
		it12.setBounds(1290, 70, 60, 30);
		it13 = new JTextField(50);
		it13.setFont(font);
		it13.setBounds(1360, 70, 60, 30);
		it14 = new JTextField(50);
		it14.setFont(font);
		it14.setBounds(1430, 70, 60, 30);
		it15 = new JTextField(50);
		it15.setFont(font);
		it15.setBounds(1500, 70, 160, 30);
		searchBut = new JButton("搜索");
		searchBut.setFont(font);
		searchBut.setBounds(1680, 70, 80, 30);
		Table = new JTable(TableModel);
		Table.setFont(font);
		Table.setBounds(15,155,1750,510);
		Table.setRowHeight(32);
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		Table.setDefaultRenderer(Object.class, r);
		setTable();
		addBut = new JButton("添加");
		addBut.setFont(font);
		addBut.setBounds(640, 700, 80, 30);
		modifyBut = new JButton("修改");
		modifyBut.setFont(font);
		modifyBut.setBounds(740, 700, 80, 30);
		deleteBut = new JButton("删除");
		deleteBut.setFont(font);
		deleteBut.setBounds(840, 700, 80, 30);
		refreshBut = new JButton("刷新");
		refreshBut.setFont(font);
		refreshBut.setBounds(940, 700, 80, 30);
		prevBut = new JButton("上一页");
		prevBut.setFont(font);
		prevBut.setBounds(1120, 700, 100, 30);
		nextBut = new JButton("下一页");
		nextBut.setFont(font);
		nextBut.setBounds(1240, 700, 100, 30);
		pageLabel1 = new JLabel("跳转到第");
		pageLabel1.setFont(font);
		pageLabel1.setBounds(1370, 700, 80, 30);
		pageText = new JTextField(10);
		pageText.setFont(font);
		pageText.setBounds(1455, 700, 60, 30);
		pageLabel2 = new JLabel("页  共"+selectTotalPage()+"页");
		pageLabel2.setFont(font);
		pageLabel2.setBounds(1520, 700, 120, 30);
		goBut = new JButton("跳转");
		goBut.setFont(font);
		goBut.setBounds(1665, 700, 100, 30);
		searchBut.addActionListener(this);
		addBut.addActionListener(this);
		refreshBut.addActionListener(this);
		modifyBut.addActionListener(this);
		deleteBut.addActionListener(this);
		prevBut.addActionListener(this);
		nextBut.addActionListener(this);
		goBut.addActionListener(this);
		this.add(inputLabel);
		this.add(it1);
		this.add(it2);
		this.add(it3);
		this.add(it4);
		this.add(it5);
		this.add(it6);
		this.add(it7);
		this.add(it8);
		this.add(it9);
		this.add(it10);
		this.add(it11);
		this.add(it12);
		this.add(it13);
		this.add(it14);
		this.add(it15);
		this.add(searchBut);
		this.add(addBut);
		this.add(Table);
		this.add(modifyBut);
		this.add(deleteBut);
		this.add(refreshBut);
		this.add(prevBut);
		this.add(nextBut);
		this.add(pageLabel1);
		this.add(pageLabel2);
		this.add(pageText);
		this.add(goBut);
		this.add(p1);
		this.add(p2);
		this.add(p3);
		this.add(p4);
		this.add(p5);
		this.add(p6);
		this.add(p7);
		this.add(p8);
		this.add(p9);
		this.add(p10);
		this.add(p11);
		this.add(p12);
		this.add(p13);
		this.add(p14);
		this.add(p15);
		this.add(t1);
		this.add(t2);
		this.add(t3);
		this.add(t4);
		this.add(t5);
		this.add(t6);
		this.add(t7);
		this.add(t8);
		this.add(t9);
		this.add(t10);
		this.add(t11);
		this.add(t12);
		this.add(t13);
		this.add(t14);
		this.add(t15);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == searchBut) {
			if (!this.it1.getText().equals("") || !this.it2.getText().equals("") || !this.it3.getText().equals("")
					|| !this.it4.getText().equals("") || !this.it5.getText().equals("") || !this.it6.getText().equals("")
					|| !this.it7.getText().equals("") || !this.it8.getText().equals("") || !this.it9.getText().equals("")
					|| !this.it10.getText().equals("") || !this.it11.getText().equals("")
					|| !this.it12.getText().equals("") || !this.it13.getText().equals("")
					|| !this.it14.getText().equals("") || !this.it15.getText().equals("")){
				String sql = "SELECT * FROM t_pm25 WHERE";
				//f_id,f_areacode,f_area,f_time,f_place,f_AQI,f_AQItype,f_PM25per1h,f_PM10per1h,f_COper1h,f_NO2per1h,f_O3per1h,f_O3per8h,f_SO2per1h,f_majorpollutant
				if (!this.it1.getText().equals("")) {
					sql = sql + " f_id = " + it1.getText() + " and";
				}
				if (!this.it2.getText().equals("")) { 
					sql = sql + " f_areacode = " + it2.getText() + " and";
				}
				if (!this.it3.getText().equals("")) {
					sql = sql + " f_area = '" + it3.getText() + "' and";
				}
				if (!this.it4.getText().equals("")) {
					sql = sql + " f_time = " + it4.getText() + " and";
				}
				if (!this.it5.getText().equals("")) {
					sql = sql + " f_place = ’" + it5.getText() + "‘ and";
				}
				if (!this.it6.getText().equals("")) {
					sql = sql + " f_AQI = " + it6.getText() + " and";
				}
				if (!this.it7.getText().equals("")) {
					sql = sql + " f_AQItype = " + it7.getText() + " and";
				}
				if (!this.it8.getText().equals("")) {
					sql = sql + " f_PM25per1h = " + it8.getText() + " and";
				}
				if (!this.it9.getText().equals("")) {
					sql = sql + " f_PM10per1h = " + it9.getText() + " and";
				}
				if (!this.it10.getText().equals("")) {
					sql = sql + " f_COper1h = " + it10.getText() + " and";
				}
				if (!this.it11.getText().equals("")) {
					sql = sql + " f_NO2per1h = " + it11.getText() + " and";
				}
				if (!this.it12.getText().equals("")) {
					sql = sql + " f_O3per1h = " + it12.getText() + " and";
				}
				if (!this.it13.getText().equals("")) {
					sql = sql + " f_O3per8h = " + it13.getText() + " and";
				}
				if (!this.it14.getText().equals("")) {
					sql = sql + " f_SO2per1h = " + it14.getText() + " and";
				}
				if (!this.it15.getText().equals("")) {
					sql = sql + " f_majorpollutant = " + it15.getText() + " and";
				}
				int index = sql.lastIndexOf("and");
				sql = sql.substring(0,index);
				sql = sql + ";";
				try {
					TableModel TableModel = new TableModel(sql, 0);
					Table.setModel(TableModel);
					setTable();
					pageChange(sql);
					this.TableModel = TableModel;
					int page = pageNum(sql);
					pageLabel2.setText("页  共"+page+"页");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(this, "输入不能全部为空", "提示", JOptionPane.PLAIN_MESSAGE);
			}
		} else if (e.getSource() == addBut) {
			@SuppressWarnings("unused")
			AddMsgDialog addWin = new AddMsgDialog(this, "添加信息", true);
			this.refreshTable(1);
		} else if (e.getSource() == refreshBut) {
			this.refreshTable(1);
		} else if (e.getSource() == deleteBut) {
			int rowNum = Table.getSelectedRow();
			if (rowNum < 0 || rowNum > Table.getRowCount()) {
				JOptionPane.showMessageDialog(this, "未选中", "提示", JOptionPane.PLAIN_MESSAGE);
			} else {
				int n = JOptionPane.showConfirmDialog(null, "确认删除吗?", "确认删除框", JOptionPane.YES_NO_OPTION);
				if (n == JOptionPane.YES_OPTION) {
					String Num = (String) Table.getValueAt(rowNum, 0);
					String sql = "DELETE FROM t_pm25 WHERE f_id= '" + Num + "'";
					TableModel.deleteMsg(sql);
					this.refreshTable(1);
					JOptionPane.showMessageDialog(this, "删除成功", "提示", JOptionPane.PLAIN_MESSAGE);
				} else if (n == JOptionPane.NO_OPTION) {
					return;
				}
			}
		} else if (e.getSource() == modifyBut) {
			Table.setModel(TableModel);
			int rowNum = Table.getSelectedRow();
			if (rowNum < 0 || rowNum > Table.getRowCount()) {
				JOptionPane.showMessageDialog(this, "未选中", "提示", JOptionPane.PLAIN_MESSAGE);
			} else {
				@SuppressWarnings("unused")
				Modify modifyWin = new Modify(this, "修改信息", true, TableModel, rowNum);
				this.refreshTable(1);
			}
		} else if (e.getSource() == prevBut) {
			int num = Integer.parseInt((String) TableModel.getValueAt(0, 0));
			int id = selectFirstId();
			if (id < num) {
				refreshTable(num - 18);
			}
		} else if (e.getSource() == nextBut) {
			int cumNum = TableModel.getRowCount();
			int num = Integer.parseInt((String) TableModel.getValueAt(cumNum - 1, 0));
			int id = 0;
			int id1 = 0;
			DBConnection db = new DBConnection();
			try {
				Connection con = db.getConnection();
				String sql = "select f_id from t_pm25 order by f_id";
				PreparedStatement stmt = con.prepareStatement(sql);
				ResultSet result = stmt.executeQuery();
				while (result.next()) {
					id = result.getInt("f_id");
					if (id1 < id) {
						id1 = id;
					}
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			if (id1 > num) {
				refreshTable(num);
			}
		} else if (e.getSource() == goBut) {
			String page = this.pageText.getText();
			int page1 = Integer.parseInt(page);
			int count = 0;
			if (!page.equals("")) {
				int totalPage = selectTotalPage();
				if (page1 <= totalPage) {
					int id = 0;
					int count1 = 0;
					DBConnection db = new DBConnection();
					try {
						Connection con = db.getConnection();
						String sql = "select f_id from t_pm25 order by f_id";
						PreparedStatement stmt = con.prepareStatement(sql);
						ResultSet result = stmt.executeQuery();
						while (result.next()) {
							count1++;
							if (count1 == page1 * 16 - 15) {
								id = result.getInt("f_id") - 1;
								break;
							}
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					refreshTable(id);
				} else {
					JOptionPane.showMessageDialog(this, "输入的页码超出范围", "提示", JOptionPane.PLAIN_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(this, "页数不能为空", "提示", JOptionPane.PLAIN_MESSAGE);
			}

		}
	}

	public int pageNum(String sql){
		int count = 0;
		int totalPage = 0;
		DBConnection db = new DBConnection();
		try {
			Connection con = db.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet result = stmt.executeQuery();
			while (result.next()) {
				count++;
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		if (count % 16 != 0) {
			totalPage = count / 16 + 1;
		} else {
			totalPage = count / 16;
		}
		return totalPage;
	}
	public int selectTotalPage() {
		int count = 0;
		int totalPage = 0;
		DBConnection db = new DBConnection();
		try {
			Connection con = db.getConnection();
			String sql = "select * from t_pm25 order by f_id";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet result = stmt.executeQuery();
			while (result.next()) {
				count++;
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		if (count % 16 != 0) {
			totalPage = count / 16 + 1;
		} else {
			totalPage = count / 16;
		}
		return totalPage;
	}

	public int selectFirstId() {
		int id = 0;
		DBConnection db = new DBConnection();
		try {
			Connection con = db.getConnection();
			String sql = "select f_id from t_pm25 order by f_id";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet result = stmt.executeQuery();
			if (result.next()) {
				id = result.getInt("f_id");
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return id;
	}
	
	public void pageChange(String sql){
		
	}
	public void setTable(){
		TableColumn Column1 = Table.getColumnModel().getColumn(3);
		Column1.setPreferredWidth(240);
		Column1.setMaxWidth(240);
		Column1.setMinWidth(240);
		TableColumn Column2 = Table.getColumnModel().getColumn(4);
		Column2.setPreferredWidth(180);
		Column2.setMaxWidth(180);
		Column2.setMinWidth(180);
		TableColumn Column3 = Table.getColumnModel().getColumn(0);
		Column3.setPreferredWidth(50);
		Column3.setMaxWidth(50);
		Column3.setMinWidth(50);
		TableColumn Column4 = Table.getColumnModel().getColumn(6);
		Column4.setPreferredWidth(180);
		Column4.setMaxWidth(180);
		Column4.setMinWidth(180);
		TableColumn Column5 = Table.getColumnModel().getColumn(14);
		Column5.setPreferredWidth(180);
		Column5.setMaxWidth(180);
		Column5.setMinWidth(180);
		TableColumn Column6 = Table.getColumnModel().getColumn(11);
		Column6.setPreferredWidth(130);
		Column6.setMaxWidth(130);
		Column6.setMinWidth(130);
		TableColumn Column7 = Table.getColumnModel().getColumn(12);
		Column7.setPreferredWidth(130);
		Column7.setMaxWidth(130);
		Column7.setMinWidth(130);
		TableColumn Column8 = Table.getColumnModel().getColumn(0);
		Column8.setPreferredWidth(80);
		Column8.setMaxWidth(80);
		Column8.setMinWidth(80);
	}
	public void refreshTable(int beginId) {
		TableModel searchMsg;
		pageLabel2.setText("页  共"+selectTotalPage()+"页");
		try {
			searchMsg = new TableModel("SELECT * FROM t_pm25 where f_id >? order by f_id", beginId);
			Table.setModel(searchMsg);
			setTable();
			TableModel = searchMsg;
		} catch (SQLException e1) {
			e1.printStackTrace();
		}		
	}
}