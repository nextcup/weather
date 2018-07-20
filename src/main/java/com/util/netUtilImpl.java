package com.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class netUtilImpl implements netUtil{
	
	@Override
	public String getJson(String url) throws IOException{
		HttpURLConnection connection = null;
		URL url2 = new URL(url);
		connection=(HttpURLConnection) url2.openConnection();
		/*�Ժͷ������ṩ�����ӽ�������*/
		connection.connect();
		/*��ȡ״̬��*/
		int recode = connection.getResponseCode();
		BufferedReader bufferedReader = null;
		String json = new String();
		/*������ӳɹ�*/			
		if(recode==200) {
			/*�����ݽ��ж������ҷ�װ��json����ַ��������ҷ���json*/
			InputStream inputStream = connection.getInputStream();
			bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
			String string = null;
			
			while ((string=bufferedReader.readLine())!=null) {
				json=json+string;
			}			
		}
		return json;
	}
}