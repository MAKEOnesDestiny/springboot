package com.zhou.springboot.hbase;

import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HBaseUtil {

    private static Configuration configuration = HBaseConfiguration.create();

    private static Connection connection;

    private static Admin admin;

    public static final Logger log = LoggerFactory.getLogger(HBaseUtil.class);

    static {
        configuration.set("hbase.zookeeper.quorum", "127.0.0.1:2181");
        try {
            connection = ConnectionFactory.createConnection(configuration);
            admin = connection.getAdmin();
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }

    public void testCreateTable() throws IOException {
        TableName tableName = TableName.valueOf("my_test_hbase_table");
        HTableDescriptor descriptor = new HTableDescriptor(tableName);
        String[] cf = new String[]{"cfa","cfb"};
        for (String s:cf) {
            descriptor.addFamily(new HColumnDescriptor(s));
        }
        admin.createTable(descriptor);
    }

    public static void main(String[] args) throws IOException {
        new HBaseUtil().testCreateTable();
    }


}
