package com.cque.cdc.bean;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.ververica.cdc.debezium.DebeziumDeserializationSchema;
import io.debezium.data.Envelope;
import io.debezium.data.Json;
import org.apache.flink.api.common.typeinfo.BasicTypeInfo;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.util.Collector;


import org.apache.kafka.connect.connector.ConnectRecord;
import org.apache.kafka.connect.data.Field;
import org.apache.kafka.connect.data.Struct;
import org.apache.kafka.connect.source.SourceRecord;

import java.util.List;

/**
 * @school:cque
 * @author:suxichuan
 * @create： 2022/11/26:13:32:15
 */
public class CDCDeserializationSchema implements DebeziumDeserializationSchema<String> {

    @Override
    public void deserialize(SourceRecord sourceRecord, Collector<String> collector) throws Exception {
        ConnectRecord record = (ConnectRecord) sourceRecord;
        String topic = record.topic();
        String[] split = topic.split("\\.");
        String database = split[1];
        String table = split[2];
        Struct value = (Struct) record.value();
        Struct after = value.getStruct("after");
        Envelope.Operation operation = Envelope.operationFor(sourceRecord);
        JSONObject dataJson = new JSONObject();
        if (after != null) {
            List<Field> fields = after.schema().fields();
            for (Field field : fields) {
                String name = field.name();
                String val = after.getString(name);
                dataJson.put(name, val);
            }
        }
        JSONObject result = new JSONObject();
        result.put("database", database);
        result.put("table", table);
        result.put("data", dataJson);
        result.put("operation", operation);
        collector.collect(result.toJSONString());
    }

    @Override
    public TypeInformation<String> getProducedType() {
        return BasicTypeInfo.STRING_TYPE_INFO;
    }
}
