package com.zhou.springboot.bigdata;

import java.io.FileOutputStream;
import java.io.IOException;
//import org.apache.hadoop.fs.Path;
//import org.apache.hadoop.io.IntWritable;
//import org.apache.hadoop.io.LongWritable;
//import org.apache.hadoop.io.Text;
//import org.apache.hadoop.mapred.FileInputFormat;
//import org.apache.hadoop.mapred.FileOutputFormat;
//import org.apache.hadoop.mapred.JobConf;
//import org.apache.hadoop.mapreduce.Job;
//import org.apache.hadoop.mapreduce.Mapper;
//import org.apache.hadoop.mapreduce.Reducer;

public class MapReduceTest {

 /*   public static class MaxTempMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

        //Text相当于String
        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            String line = value.toString();
            String[] ss = line.split("-");
            context.write(new Text(ss[0]), new IntWritable(Integer.valueOf(ss[1]))); //k,v
        }
    }

    public static class MaxTempReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

        @Override
        protected void reduce(Text key, Iterable<IntWritable> values, Context context)
                throws IOException, InterruptedException {
            int max = Integer.MIN_VALUE;
            for (IntWritable iw : values) {
                max = Math.max(iw.get(), max);
            }
            context.write(new Text(key), new IntWritable(max));
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Job job = new Job();
        job.setJarByClass(MapReduceTest.class);
        job.setJobName("myjob");

        JobConf conf = new JobConf(MapReduceTest.class);

        FileInputFormat.addInputPath(conf,new Path("/Users/hfzhou/Desktop/tmp.txt"));
        FileOutputFormat.setOutputPath(conf,new Path("/Users/hfzhou/Desktop/res.txt"));

        job.setMapperClass(MaxTempMapper.class);
        job.setReducerClass(MaxTempReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        job.waitForCompletion(true);

    }*/


}
