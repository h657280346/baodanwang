package com.bean.test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FsUrlStreamHandlerFactory;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

public class Hdfs {
	static{
		URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory());
	}
	public static void main(String[] args) throws MalformedURLException, IOException {
//		InputStream in = new URL("hdfs://192.168.5.2:9000/input/test.txt").openStream();
//		IOUtils.copyBytes(in, System.out, 1024);
		listFile();
	}
	public static void upLoadFile() throws IOException{
		String localSrc = "./test.txt";
		String dest = "hdfs://192.168.5.2:9000/input/test.txt";
		InputStream in = new BufferedInputStream(new FileInputStream(localSrc));
		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(URI.create(dest),conf);
		FSDataOutputStream out = fs.create(new Path(dest));
		IOUtils.copyBytes(in, out, conf);
	}
	public static void listFile() throws IOException{
		String dest = "hdfs://192.168.5.2:9000/output";
		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(URI.create(dest),conf);
		FileStatus fileList[] = fs.listStatus(new Path(dest));
		int size = fileList.length;
		for (int i = 0; i < size; i++) {
			System.out.println("name:" + fileList[i].getPath().getName()
					+ "/t/tsize:" + fileList[i].getLen());
		}
		fs.close();
	}
}
