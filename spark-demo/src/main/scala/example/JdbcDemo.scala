package example

import org.apache.spark.sql.SparkSession

/**
  * Created by malczyk on 13.04.17.
  */
object JdbcDemo {

  def main(args:Array[String]): Unit = {
    val spark = SparkSession
      .builder()
      .getOrCreate()

   // import spark.implicits._

    val jdbcDF = spark.read
      .format("jdbc")
      .option("driver", "com.mysql.jdbc.Driver")
      .option("url", "jdbc:mysql://172.17.0.1:3307/dhengine")
      .option("dbtable", "dhengine.IncomingMessage")
      .option("user", "dh")
      .option("password", "dh123")
      .load()

    jdbcDF.createOrReplaceTempView("message")
    val rows = spark.sql("SELECT msisdn FROM message").collect();
    val x = spark.sparkContext.parallelize(rows)
    val count = x.count();
    println(s"Count >> $count");
    val counts = x.map(msisdn => (msisdn, 1)).reduceByKey(_ + _).filter(_._2 > 50)
    counts.collect().foreach(println);
  }
}
