package test;

import java.sql.*;
import java.util.*;
import javax.swing.table.*;

@SuppressWarnings("serial")
public class TableModel extends AbstractTableModel {
	// 表的元素
	private Vector<Vector<String>> rowData;
	private Vector<String> colName;
	// 数据库
	private PreparedStatement stmt;
	private ResultSet result;
	private Connection con;
	public TableModel(String sql,int beginId) throws SQLException {
		this.initData(sql,beginId);
	}

	public TableModel() throws SQLException {
		this.initData("SELECT * FROM t_pm25 where f_id>? order by f_id",232);
	}

	public void initData(String sql,int beginId) throws SQLException {
		setRowData(new Vector<Vector<String>>());
		setColName(new Vector<String>());
		getColName().add("编号");
		getColName().add("区域代号");
		getColName().add("城市");
		getColName().add("时间");
		getColName().add("地点");
		getColName().add("空气质量指数");
		getColName().add("空气质量等级");
		getColName().add("pm2.5含量");
		getColName().add("pm10含量");
		getColName().add("CO含量");
		getColName().add("NO2含量");
		getColName().add("O3含量/1h");
		getColName().add("O3含量/8h");
		getColName().add("SO2含量");
		getColName().add("主要污染物");
		/*
		 * 数据库的导入
		 */
		DBConnection db = new DBConnection();
		try {
			con = db.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		if(beginId ==1){
		String sql1 = "select f_id from t_pm25 order by f_id";
		stmt = con.prepareStatement(sql1);
		result = stmt.executeQuery();
		if(result.next()){
			beginId = result.getInt("f_id")-1;
		}
		}
		stmt = con.prepareStatement(sql);
		if(beginId!=0){
		stmt.setInt(1,beginId);
		}
		result = stmt.executeQuery();
		importSQL();
	}

	void importSQL() throws SQLException {
		@SuppressWarnings("unused")
		boolean signNull = true;
		int count = 0;
		while (result.next()){
			count++;
			if(count>16){
				break;
			}
			Vector<String> item = new Vector<String>();
			for (int i = 1; i < 16; i++) {
				item.add(result.getString(i));
			}
			getRowData().add(item);
			signNull = false;
		}
		result.close();
	}

	@Override
	public int getColumnCount() {// 得到列数
		return this.colName.size();
	}

	@Override
	public int getRowCount() {// 得到行数
		return this.rowData.size();
	}

	@Override
	public Object getValueAt(int row, int col) {// 得到某行某列的数据
		return (this.rowData.get(row)).get(col);
	}

	@Override
	public String getColumnName(int column) {
		return this.colName.get(column);
	}

	public Vector<Vector<String>> getRowData() {
		return rowData;
	}

	public void setRowData(Vector<Vector<String>> rowData) {
		this.rowData = rowData;
	}

	public Vector<String> getColName() {
		return colName;
	}

	public void setColName(Vector<String> colName) {
		this.colName = colName;
	}

	public void addMsg(String sql) {
		try {
			stmt = con.prepareStatement(sql);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteMsg(String sql) {
		try {
			stmt = con.prepareStatement(sql);
			stmt.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
