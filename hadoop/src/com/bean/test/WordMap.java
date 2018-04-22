package com.bean.test;

import java.io.IOException;
import java.util.StringTokenizer;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordMap extends Mapper<LongWritable, Text, Text, IntWritable> {
	// private Text mapkey = new Text();
	// private IntWritable mapvalue = new IntWritable();
	// LongWritable l = new LongWritable(1);
	IntWritable mapValue = new IntWritable(1);
	Text mapkey = new Text();
	@Override
	protected void cleanup(Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		System.out.println("cleanup方法！！！");
	}

	@Override
	protected void setup(Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		System.out.println("setup方法！！！");
	}

	@Override
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		System.out.println("key:" + key);
		StringTokenizer tokenizer = new StringTokenizer(value.toString());
		while (tokenizer.hasMoreTokens()) {
			mapkey.set(tokenizer.nextToken());
			context.write(mapkey, mapValue);
		}
		// StringTokenizer tokenizer = new StringTokenizer(value.toString());
		// while(tokenizer.hasMoreTokens()){
		// mapkey.set(tokenizer.nextToken());
		// context.write(mapkey, mapvalue);
		// }
	}

}
