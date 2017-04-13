package example

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession


case class Person(name: String, age:Integer)
/**
  * Created by malczyk on 13.04.17.
  */
object PersonDemo {




  def main(args:Array[String]): Unit = {

    val spark = SparkSession
      .builder()
      .getOrCreate()

    import spark.implicits._


    val	peopleRDD:	RDD[Person]	=	spark.sparkContext.parallelize(Seq(Person("John",	10), Person("Jack",	50)))
    val	people	=	peopleRDD.toDS()
    people.show();

    people.where($"age"<40).show();


    people.createOrReplaceTempView("peopleView");
    val teenagersDF = spark.sql("SELECT name, age FROM peopleView WHERE age BETWEEN 9 AND 19")
    teenagersDF.show();


    spark.close();
  }



}
