package example

import org.apache.spark.SparkContext
import org.apache.spark.SparkConf

object Hello extends App {
  val conf = new SparkConf().setAppName("test").setMaster("spark://127.0.0.1:7077")
  val context = new SparkContext(conf)
  print(context)
}