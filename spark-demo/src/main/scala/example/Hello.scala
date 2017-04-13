package example

import org.apache.spark.SparkContext
import org.apache.spark.SparkConf


object Hello {


  def main(args:Array[String]): Unit = {

    val conf = new SparkConf().setAppName("SparkDemos").setMaster("spark://127.0.0.1:7077")

    val context = new SparkContext(conf)

    val logData = context.textFile("file:///etc/hosts"  , 2)
    logData.foreach(println)
    val numAs = logData.filter(line => line.contains("a")).count()
    val numBs = logData.filter(line => line.contains("b")).count()
    println("--------------------------")
    println(s"Lines with a: $numAs, Lines with b: $numBs")
    println("--------------------------")
    //SparkDemos.context.stop()
  }

}