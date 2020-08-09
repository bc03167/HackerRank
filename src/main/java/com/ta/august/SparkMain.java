package com.ta.august;


import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.ArrayList;
import java.util.List;

public class SparkMain {

    public static void main(String args[]) {
        List<Double> inputData = new ArrayList<>();
        inputData.add(3.1415);
        inputData.add(12.44);
        inputData.add(3.0);
        inputData.add(22.22);
        Logger.getLogger("org.apache").setLevel(Level.WARN);

        SparkConf conf = new SparkConf()
                .setAppName("startingSpark")
                .setMaster("local[*]");
        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaRDD<Double> myRDD = sc.parallelize(inputData);

        sc.close();
    }
}
