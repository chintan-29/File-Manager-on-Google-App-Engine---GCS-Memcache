import java.io.IOException;
import java.util.StringTokenizer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class wordcount {

public static class mapr extends Mapper<Object, Text, Text, IntWritable>
{

    private final static IntWritable In = new IntWritable(1);
    private Text word = new Text();

    public void map(Object key, Text value, Context context) throws IOException, InterruptedException 
      {
          StringTokenizer n = new StringTokenizer(value.toString());
          while (n.hasMoreTokens()) {
          word.set(n.nextToken());
          context.write(word,In);
      }
}
                        }

  public static class reducer
       extends Reducer<Text,IntWritable,Text,IntWritable> {
    private IntWritable out = new IntWritable();
    public void reduce(Text key, Iterable<IntWritable> values,Context context) throws IOException, InterruptedException 
{
      
       int sum = 0;
       for (IntWritable val : values)
       {
        sum += val.get();
       }
      
      out.set(sum);
      context.write(key,out);
}
  }

  public static void main(String[] args) throws Exception {
    long start = System.currentTimeMillis(); 
    Configuration conf = new Configuration();
    Job job = Job.getInstance(conf, "word count");
    job.setJarByClass(wordcount.class);
    job.setMapperClass(mapr.class);
    job.setCombinerClass(reducer.class);
    job.setReducerClass(reducer.class);
    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(IntWritable.class);
    FileInputFormat.addInputPath(job, new Path(args[0]));
    FileOutputFormat.setOutputPath(job, new Path(args[1]));
    long stop = System.currentTimeMillis();
    stop=stop-start;
    System.out.println(stop);
    System.exit(job.waitForCompletion(true) ? 0 : 1);
      }
}
