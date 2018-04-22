package com.baodanwang.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.alibaba.fastjson.JSONObject;

public class WXUtil {

	public static OpenidBean getOpenid(String appid, String secret, String code) {
		URL url = null;
		HttpURLConnection connection = null;
		BufferedReader breader = null;
		StringBuffer strb = new StringBuffer();

		try {
			url = new URL("https://api.weixin.qq.com/sns/jscode2session?appid=" + appid + "&secret=" + secret
					+ "&js_code=" + code + "&grant_type=authorization_code");
			System.out.println(url);
			connection = (HttpURLConnection) url.openConnection();
			connection.connect();

			breader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
			String str;
			while ((str = breader.readLine()) != null) {
				strb.append(str);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			breader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		connection.disconnect();

		return JSONObject.parseObject(strb.toString(), OpenidBean.class);
	}
}