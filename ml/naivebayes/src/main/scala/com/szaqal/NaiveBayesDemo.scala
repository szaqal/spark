package com.szaqal

import org.apache.spark.ml.classification.NaiveBayes
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.feature.VectorAssembler

import org.apache.spark.sql.{ DataFrame, SparkSession }

/**
 * Created by malczyk on 20.04.17.
 */
object NaiveBayesDemo {

  def dataFrame(spark: SparkSession, file: String): DataFrame = {
    import org.apache.spark.sql.functions._
    val mappingDouble: String ⇒ Double = _.trim.toDouble
    val mappingInt: String ⇒ Int = _.trim.toInt
    val toDouble = udf(mappingDouble)
    val toInt = udf(mappingInt)

    val df = spark.read.csv(file)
      .withColumn("_c0", toDouble(col("_c0")))
      .withColumn("_c1", toDouble(col("_c1")))
      .withColumn("_c2", toDouble(col("_c2")))
      .withColumn("_c3", toDouble(col("_c3")))
      .withColumn("label", toInt(col("_c4")))
    println(df.printSchema())

    val assembler = new VectorAssembler()
      .setInputCols(Array("_c0", "_c1", "_c2", "_c3"))
      .setOutputCol("features")

    val transform = assembler.transform(df).select("features", "label")
    println(transform.printSchema())
    println(transform)
    return transform
  }

  def main(args: Array[String]): Unit = {

    val spark = SparkSession
      .builder()
      .getOrCreate()
    println("Training Data")
    val trainDf = dataFrame(spark, "file:///ml/iris.data")

    println("Testing Data")
    val testDf = dataFrame(spark, "file:///ml/iris.test")

    //TRAIN
    val model = new NaiveBayes().fit(trainDf)

    val predictions = model.transform(testDf)
    predictions.show()

    val evaluator = new MulticlassClassificationEvaluator()
      .setLabelCol("label")
      .setPredictionCol("prediction")
      .setMetricName("accuracy")
    val accuracy = evaluator.evaluate(predictions)
    println("Test set accuracy = " + accuracy)

    spark.stop()
  }
}
