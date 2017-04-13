import sbt._

object Dependencies {
  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.0.1"
  lazy val spark = "org.apache.spark" %% "spark-core" % "2.1.0"
  lazy val sparkSql = "org.apache.spark" %% "spark-sql" % "2.1.0"
}
