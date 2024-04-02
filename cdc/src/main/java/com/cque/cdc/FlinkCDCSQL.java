package com.cque.cdc;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.table.api.bridge.java.StreamTableEnvironment;

/**
 * @school:cque
 * @author:suxichuan
 * @create： 2022/11/26:12:25:28
 */
public class FlinkCDCSQL {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment executionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment();
        executionEnvironment.setParallelism(1);
        StreamTableEnvironment streamTableEnvironment = StreamTableEnvironment.create(executionEnvironment);
        streamTableEnvironment.executeSql("CREATE TABLE user_info (" +
              "    id INT," +
              "    name STRING," +
              "    age INT" +
              ") WITH (" +
              "    'connector' = 'mysql-cdc'," +
              "    'hostname' = '117.78.7.187'," +
              "    'port' = '3306'," +
              "    'username' = 'root'," +
              "    'password' = '123456'," +
              "    'database-name' = 'process_config'," +
              "    'table-name' = 'user_info'" +
              ")");
        streamTableEnvironment.executeSql("select * from user_info").print();
        executionEnvironment.execute();


    }
}
