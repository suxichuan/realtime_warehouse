package com.cque.cdc;

import com.alibaba.ververica.cdc.connectors.mysql.MySQLSource;
import com.alibaba.ververica.cdc.debezium.DebeziumSourceFunction;
import com.alibaba.ververica.cdc.debezium.StringDebeziumDeserializationSchema;
import com.cque.cdc.bean.CDCDeserializationSchema;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * @school:cque
 * @author:suxichuan
 * @create： 2022/11/26:13:27:59
 */
public class FlinkCDC {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment executionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment();
        executionEnvironment.setParallelism(1);
        DebeziumSourceFunction<String> mysqlSource = MySQLSource.<String>builder()
              .hostname("117.78.7.187")
              .port(3306)
              .databaseList("process_config")
              .tableList("process_config.table_process")
              .username("root")
              .password("123456")
              .deserializer(new CDCDeserializationSchema())
              .build();
        DataStreamSource<String> stringDataStreamSource = executionEnvironment.addSource(mysqlSource);
        stringDataStreamSource.print();
        executionEnvironment.execute();
    }

}
