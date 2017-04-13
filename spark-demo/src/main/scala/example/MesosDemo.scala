package example

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by malczyk on 13.04.17.
  */
object MesosDemo {

  def main(args:Array[String]): Unit = {
    val conf = new SparkConf()
      .setMaster("mesos://192.168.2.11:5050")
      .setAppName("MesosTestApp")
      .set("spark.executor.uri", "http://localhost/spark-2.1.0-bin-hadoop2.7.tgz")
    val sc = new SparkContext(conf)
    print(sc)
  }
}
