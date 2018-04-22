package com.yczc.ssm.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.yczc.ssm.util.GetID;
import com.yczc.ssm.util.WX_Util;

@Controller
public class Step2 {
	
	private String appid = "wx9471acc7a0c59a6e";
	private String secret = "9b47850ad9473eb17363b16595c8d5e8";
	String key = "GPZULsQWa5kToVt37zXu4ysgErGojQbO";
	String mch_id = "1364486702";
	String notify_url = "http://1.1.1.1";

	@RequestMapping(value = "/step2", produces = "text/html;charset=UTF-8")
	public @ResponseBody
	String step2(HttpServletRequest req, HttpServletResponse rep)
			throws Exception {
		String openid = req.getParameter("openid");
		String total_fee = req.getParameter("total_fee");
		String body = req.getParameter("body");
		
		String costId = req.getParameter("costId");
		
		String userId = req.getParameter("userId");
		
		//start 测试
		if(costId==null||"".equals(costId)){
			costId="2313245f7c6c45bd8b9647cbaba4612f";
		}
		//账号 15602004803 密码123456
		if(userId==null||"".equals(userId)){
			
			userId="616A45727A4F2F5436534254326F335836416E3952413D3D";
		}
		//end 测试
		Token token = JSON.parseObject(accessToken(), Token.class);  
		 
		Pay pay= JSON.parseObject(disburse(costId, userId, token.getData().getAccessToken()), Pay.class);

		System.out.println(body);
		if (openid != null & total_fee != null) {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("appid", appid);
			map.put("mch_id", mch_id);
			map.put("nonce_str", WX_Util.getRandomStr());
			map.put("body", pay.getData().getBody());
			//正式
			map.put("out_trade_no", pay.getData().getOut_trade_no());
			//测试
		//	map.put("out_trade_no",GetID.getUUID());
			map.put("total_fee", pay.getData().getTotal_fee());
			//	map.put("total_fee", total_fee);
			map.put("spbill_create_ip", getIP(req));
			// 
			map.put("notify_url", pay.getData().getNotify_url());
			map.put("trade_type", "JSAPI");
			map.put("openid", openid);
			BeanStep2 beanStep2 = WX_Util.step2(map, key);
			System.out.println("Step2   " + JSON.toJSONString(beanStep2));
			return JSON.toJSONString(beanStep2);
		} else {
			return JSON.toJSONString("-1");
		}

	}
	
	@RequestMapping(value = "/step4", produces = "text/html;charset=UTF-8")
	public @ResponseBody String  step4(HttpServletRequest req, HttpServletResponse rep){
		
		Token token = JSON.parseObject(accessToken(), Token.class);  
	 
		Pay pay= JSON.parseObject(disburse("2313245f7c6c45bd8b9647cbaba4612f", "46434E322F4649375753746C5A5157316245302B68773D3D", token.getData().getAccessToken()), Pay.class);
		
		return  JSON.toJSONString(pay);
	}
	
	public String clientId="Rg50JOtW9LLr9TNzAhvX";
	public String clientSecret="ORuJITY2SUjRYnFLMe2ElgOq5jnlFHCSmDWZ8IGg";
	
	public String accessToken() {
        String value="clientId="+clientId+"&clientSecret="+clientSecret;
		return sendGet("http://wx.5izuqiu.cn/api/V2/user/access_token", value);
	}
	
	public String disburse(String costId,String userId,String accessToken) {
        String value="payType=currency,"+userId+"&"
        		+ "payment=weixin&"
        		+ "orderChoose="+costId+"&"
        		+ "accessToken="+accessToken;
		return sendPost("http://wx.5izuqiu.cn/api/V2/disburse/disburse", value);
	}
	
	
	
	/**
	 * 向指定 URL 发送POST方法的请求
	 * @param url  发送请求的 URL
	 * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return 所代表远程资源的响应结果
	 */
	public static String sendPost(String url, String param) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			conn.setRequestProperty("Accept-Charset", "utf-8");
			conn.setRequestProperty("contentType", "utf-8");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			out.print(param);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}
	
	/**
 	* 向指定URL发送GET方法的请求
 	* @param url   发送请求的URL
 	* @param param  请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
 	* @return URL 所代表远程资源的响应结果
	*/
	public static String sendGet(String url, String param) {
		String result = "";
		BufferedReader in = null;
		try {
			String urlNameString = url + "?" + param;
			URL realUrl = new URL(urlNameString);
			// 打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();
			// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			connection.setRequestProperty("Accept-Charset", "utf-8");
			connection.setRequestProperty("contentType", "utf-8");
			// 建立实际的连接
			connection.connect();
			// 获取所有响应头字段
			Map<String, List<String>> map = connection.getHeaderFields();
			// 遍历所有的响应头字段
			for (String key : map.keySet()) {
				System.out.println(key + "--->" + map.get(key));
			}
			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送GET请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
	
	public static class Token{
		
		
		@Override
		public String toString() {
			return "Token [status=" + status + ", status_code=" + status_code + ", status_reason=" + status_reason
					+ ", data=" + data + "]";
		}

		public boolean status;
		
		public int status_code;
		
		public String status_reason;
		
		public DataToken data;
		
		public Token(){}
		
		public static class DataToken{
			
			public String accessToken;

			public String tokenType;
			
			public int expiresIn;
			
			public DataToken(){}
			
			public String getAccessToken() {
				return accessToken;
			}

			public void setAccessToken(String accessToken) {
				this.accessToken = accessToken;
			}

			public String getTokenType() {
				return tokenType;
			}

			public void setTokenType(String tokenType) {
				this.tokenType = tokenType;
			}

			public int getExpiresIn() {
				return expiresIn;
			}

			public void setExpiresIn(int expiresIn) {
				this.expiresIn = expiresIn;
			}

			@Override
			public String toString() {
				return "DataToken [accessToken=" + accessToken + ", tokenType=" + tokenType + ", expiresIn=" + expiresIn
						+ "]";
			}
			
		}

		public boolean isStatus() {
			return status;
		}

		public void setStatus(boolean status) {
			this.status = status;
		}

		public int getStatus_code() {
			return status_code;
		}

		public void setStatus_code(int status_code) {
			this.status_code = status_code;
		}

		public String getStatus_reason() {
			return status_reason;
		}

		public void setStatus_reason(String status_reason) {
			this.status_reason = status_reason;
		}

		public DataToken getData() {
			return data;
		}

		public void setData(DataToken data) {
			this.data = data;
		}
	}
	
	public static class Pay{
		
		
		@Override
		public String toString() {
			return "Pay [status=" + status + ", status_code=" + status_code + ", status_reason=" + status_reason
					+ ", data=" + data + "]";
		}

		public boolean status;
		
		public int status_code;
		
		public String status_reason;
		
		public DataPay data;
		
		public Pay(){}
		
		public static class DataPay{
			
			@Override
			public String toString() {
				return "DataPay [body=" + body + ", payment=" + payment + ", total_fee=" + total_fee + ", notify_url="
						+ notify_url + ", trade_name=" + trade_name + ", out_trade_no=" + out_trade_no + "]";
			}
			public String body;//����
			
			public String payment;//֧����ʽ
			
			public int total_fee;//֧��Ǯ���ѷ�Ϊ��λ
			
			public String notify_url;//�ص���ַ
			
			public String trade_name;//��Ʒ����
			
			public String out_trade_no;//������
			
			public DataPay(){}
			
			public String getBody() {
				return body;
			}
			public void setBody(String body) {
				this.body = body;
			}
			public String getPayment() {
				return payment;
			}
			public void setPayment(String payment) {
				this.payment = payment;
			}
			public int getTotal_fee() {
				return total_fee;
			}
			public void setTotal_fee(int total_fee) {
				this.total_fee = total_fee;
			}
			public String getNotify_url() {
				return notify_url;
			}
			public void setNotify_url(String notify_url) {
				this.notify_url = notify_url;
			}
			public String getTrade_name() {
				return trade_name;
			}
			public void setTrade_name(String trade_name) {
				this.trade_name = trade_name;
			}
			public String getOut_trade_no() {
				return out_trade_no;
			}
			public void setOut_trade_no(String out_trade_no) {
				this.out_trade_no = out_trade_no;
			}
		}

		public boolean isStatus() {
			return status;
		}

		public void setStatus(boolean status) {
			this.status = status;
		}

		public int getStatus_code() {
			return status_code;
		}

		public void setStatus_code(int status_code) {
			this.status_code = status_code;
		}

		public String getStatus_reason() {
			return status_reason;
		}

		public void setStatus_reason(String status_reason) {
			this.status_reason = status_reason;
		}

		public DataPay getData() {
			return data;
		}

		public void setData(DataPay data) {
			this.data = data;
		}
		
	} 

	public String getIP(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (null == ip || 0 == ip.length() || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (null == ip || 0 == ip.length() || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (null == ip || 0 == ip.length() || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("X-Real-IP");
		}
		if (null == ip || 0 == ip.length() || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
}
