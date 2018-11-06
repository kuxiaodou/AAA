package com.aaa.infomation.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

public class SmsVerification {

	 //url前半部分
	public static final String BASE_URL = "https://api.miaodiyun.com/20150822/industrySMS/sendSMS";
	 //注册后系统自动生成的账号ACCOUNT SID
	public static final String ACCOUNT_SID = "657aec63f14844dbb2a5d3f41a786f6c";
	 // 注册后系统自动生成的TOKEN
	public static final String AUTH_TOKEN = "e18f6012c9bf456aafedf3ed250b0a5f";
	//响应数据类型, JSON或XML
	public static final String RESP_DATA_TYPE = "json";
	private static int verificationCode=(int)((Math.random() * 9 + 1) * 100000); //随机验证码
	private static String smsContent = "【在线教育】您的验证码为"+verificationCode+"，请于30分钟内正确输入，如非本人操作，请忽略此短信。";//短信签名+内容（用模板不能自定义必须和模板一致）
	
	public static int getVerificationCode(String phone)
	{
		String tmpSmsContent = null;
	    try{
	      tmpSmsContent = URLEncoder.encode(smsContent, "UTF-8");
	    }catch(Exception e){
	      
	    }
	    String url = BASE_URL;
	    String body = "accountSid=" + ACCOUNT_SID + "&to=" + phone + "&smsContent=" + tmpSmsContent
	        + createCommonParam();

	    // 提交请求
	    String result = post(url, body);
	    //输出信息状态信息
	    System.out.println("result:" + System.lineSeparator() + result);
	    return verificationCode;
	}
	
	/**
	 * 构造通用参数timestamp、sig和respDataType
	 * 
	 * @return
	 */
	public static String createCommonParam()
	{
		// 时间戳
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String timestamp = sdf.format(new Date());

		// 签名
		String sig = DigestUtils.md5Hex(ACCOUNT_SID + AUTH_TOKEN + timestamp);

		return "&timestamp=" + timestamp + "&sig=" + sig + "&respDataType=" + RESP_DATA_TYPE;
	}

	/**
	 * post请求
	 * 
	 * @param url
	 *            功能和操作
	 * @param body
	 *            要post的数据
	 * @return
	 * @throws IOException
	 */
	public static String post(String url, String body)
	{
		String result = "";
		try
		{
			OutputStreamWriter out = null;
			BufferedReader in = null;
			URL realUrl = new URL(url);
			URLConnection conn = realUrl.openConnection();

			// 设置连接参数
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setConnectTimeout(5000);
			conn.setReadTimeout(20000);
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			// 提交数据
			out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
			out.write(body);
			out.flush();

			// 读取返回数据
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			String line = "";
			boolean firstLine = true; // 读第一行不加换行符
			while ((line = in.readLine()) != null)
			{
				if (firstLine)
				{
					firstLine = false;
				} else
				{
					result += System.lineSeparator();
				}
				result += line;
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 回调测试工具方法
	 * 
	 * @param url
	 * @param1reqStr
	 * @return
	 */
	public static String postHuiDiao(String url, String body)
	{
		String result = "https://api.miaodiyun.com";
		try
		{
			OutputStreamWriter out = null;
			BufferedReader in = null;
			URL realUrl = new URL(url);
			URLConnection conn = realUrl.openConnection();

			// 设置连接参数
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setConnectTimeout(5000);
			conn.setReadTimeout(20000);

			// 提交数据
			out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
			out.write(body);
			out.flush();

			// 读取返回数据
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			String line = "";
			boolean firstLine = true; // 读第一行不加换行符
			while ((line = in.readLine()) != null)
			{
				if (firstLine)
				{
					firstLine = false;
				} else
				{
					result += System.lineSeparator();
				}
				result += line;
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}



}
