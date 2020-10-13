package com.zhou.springboot.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JacksonApiTest {

    public static final ObjectMapper objectMapper = new ObjectMapper();

    public static void listWithParameterized() throws IOException {
        String json = new String("{\n"
                                         + "    \"tableId\":\"105569595219248128\",\n"
                                         + "    \"columns\": [\n"
                                         + "        {\n"
                                         + "            \"tableName\": \"area\",\n"
                                         + "            \"tableNameInChinese\": null,\n"
                                         + "            \"columnName\": \"test\",\n"
                                         + "            \"columnNameInChinese\": null,\n"
                                         + "            \"dataSource\": null,\n"
                                         + "            \"businessIndicatorDef\": null,\n"
                                         + "            \"modifyType\": \"del\",\n"
                                         + "            \"dbName\": \"oms\"\n"
                                         + "        },\n"
                                         + "        {\n"
                                         + "            \"tableName\": \"area\",\n"
                                         + "            \"tableNameInChinese\": null,\n"
                                         + "            \"columnName\": \"test-zhf\",\n"
                                         + "            \"columnNameInChinese\": \"\",\n"
                                         + "            \"dataSource\": null,\n"
                                         + "            \"businessIndicatorDef\": null,\n"
                                         + "            \"modifyType\": \"add\",\n"
                                         + "            \"dbName\": \"oms\"\n"
                                         + "        }\n"
                                         + "    ]\n"
                                         + "}");
        Map map = objectMapper.readValue(json, Map.class);
        List<StrategicDataDictionaryVo> list = objectMapper.convertValue(map.get("columns"),
                                                                  new TypeReference<List<StrategicDataDictionaryVo>>(){});
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, StrategicDataDictionaryVo.class);
        List<StrategicDataDictionaryVo> list2 = objectMapper.convertValue(map.get("columns"),javaType);
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        listWithParameterized();
    }


}
