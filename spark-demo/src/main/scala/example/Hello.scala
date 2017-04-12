package example

import org.apache.spark.SparkContext
import org.apache.spark.SparkConf

import scala.io.Source

object Hello extends App {
  val conf = new SparkConf().setAppName("test").setMaster("spark://127.0.0.1:7077")
  val dict = getDictionary("German")

  val context = new SparkContext(conf)

  val translated = context.textFile("/tmp/")
    .map(line => line.split("\\s+")
    .map(word => dict.getOrElse(word, word))
    .mkString(" "))

  print(translated.collect())


  def getDictionary(lang:String): Map[String, String] = {
    val url = "http://www.june29.com/IDP/files/%s.txt".format(lang)
    println("Grabbing dictionary from: %s".format(url))
    Source.fromURL(url, "ISO-8859-1").mkString
      .split("\\r?\\n")
      .filter(line => !line.startsWith("#"))
      .map(line => line.split("\\t"))
      .map(tkns => (tkns(0).trim, tkns(1).trim)).toMap
  }
}