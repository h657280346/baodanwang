package xml;

import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class XmlTest1 {

	public static ArrayList<Product> list = new ArrayList<Product>();
	public static  void getdata() throws Exception {
		Properties pro = new Properties();
		pro.load(new FileReader("./user.properties"));
		String username = pro.getProperty("username");
		String password = pro.getProperty("password");
		String driver = pro.getProperty("driver");
		String url = pro.getProperty("url");
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = "select * from product";
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet rs = statement.executeQuery();
		while(rs.next()){
			String name = rs.getString("p_name");
	    	String fenlei = rs.getString("p_fenlei");
	    	int inventory = rs.getInt("p_inventory");
	    	int id = rs.getInt("p_id");
	    	int price = rs.getInt("p_price");
	    	int inprice = rs.getInt("p_inprice");
	    	Product product = new Product(id, name ,inventory, price,inprice, fenlei);
	    	list.add(product);
		}
	}
	
	public static void main(String[] args) throws Exception {
		getdata();
		Document document = new Document();
		Element products = new Element("products");
		document.addContent(products);
		while(list.size()>0){
			Element product = new Element("product");
			Element name = new Element("name");
			name.setText(list.get(0).getP_name());
			Element id = new Element("id");
			id.setText(String.valueOf(list.get(0).getP_id()));
			Element price = new Element("price");
			price.setText(String.valueOf(list.get(0).getP_price()));
			Element inprice = new Element("inprice");
			inprice.setText(String.valueOf(list.get(0).getP_inprice()));
			Element fenlei = new Element("fenlei");
			fenlei.setText(list.get(0).getP_name());
			list.remove(0);
			product.addContent(name);
			product.addContent(id);
			product.addContent(price);
			product.addContent(inprice);
			product.addContent(fenlei);
			products.addContent(product);
		}
		XMLOutputter out = new XMLOutputter();
		out.setFormat(Format.getPrettyFormat().setIndent("    "));
		out.output(document, new FileWriter("./test1.xml"));
	}
}
class Product {

	private int p_id;
	private String p_name;
	private int p_invenpory;
	private int p_price;
	private int p_inprice;
	private String p_fenlei;
	
	public Product(int p_id, String p_name, int p_invenpory, int p_price, int p_inprice, String p_fenlei) {
		this.p_id = p_id;
		this.p_name = p_name;
		this.p_invenpory = p_invenpory;
		this.p_price = p_price;
		this.p_inprice = p_inprice;
		this.p_fenlei = p_fenlei;
	}
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public int getP_invenpory() {
		return p_invenpory;
	}
	public void setP_invenpory(int p_invenpory) {
		this.p_invenpory = p_invenpory;
	}
	public int getP_price() {
		return p_price;
	}
	public void setP_price(int p_price) {
		this.p_price = p_price;
	}
	public int getP_inprice() {
		return p_inprice;
	}
	public void setP_inprice(int p_inprice) {
		this.p_inprice = p_inprice;
	}
	public String getP_fenlei() {
		return p_fenlei;
	}
	public void setP_fenlei(String p_fenlei) {
		this.p_fenlei = p_fenlei;
	}
}
