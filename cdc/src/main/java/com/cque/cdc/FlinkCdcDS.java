package com.cque.cdc;

import com.alibaba.ververica.cdc.connectors.mysql.MySQLSource;
import com.alibaba.ververica.cdc.debezium.DebeziumSourceFunction;
import com.alibaba.ververica.cdc.debezium.StringDebeziumDeserializationSchema;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * @school:cque
 * @author:suxichuan
 * @create： 2022/11/25:22:26:03
 */
public class FlinkCdcDS {
    public static void main(String[] args) throws Exception {

        DebeziumSourceFunction<String> mySqlSource = MySQLSource.<String>builder()
              .hostname("117.78.7.187")
              .port(3306)
              .databaseList("process_config") // set captured database
              .tableList("process_config.table_process") // set captured table
              .username("root")
              .password("123456")
              .deserializer(new StringDebeziumDeserializationSchema()) // converts SourceRecord to JSON String
              .build();
        StreamExecutionEnvironment environment = StreamExecutionEnvironment.getExecutionEnvironment();
        environment.setParallelism(1);
        DataStreamSource<String> stringDataStreamSource = environment.addSource(mySqlSource);
        stringDataStreamSource.print();

        environment.execute();
    }
}
