package com.road.kafka;

import com.alibaba.fastjson.JSON;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.Properties;

/**
 * 启动线程消费kafka-topic消息
 */
public class KafkaConsumerDemo extends Thread {

    protected static Logger log = LoggerFactory.getLogger(KafkaConsumerDemo.class);

    private final KafkaConsumer<String, String> kafkaConsumer;

    public KafkaConsumerDemo(String topic) {
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "10.122.101.85:23310");

        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "1");

        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");

        // 间隔时间
        properties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
        // 反序列化 key
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
            "org.apache.kafka.common.serialization.StringDeserializer");
        // 反序列化 value
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
            "org.apache.kafka.common.serialization.StringDeserializer");
        // 构建 KafkaConsumer
        kafkaConsumer = new KafkaConsumer<>(properties);
        // 设置 topic
        kafkaConsumer.subscribe(Collections.singletonList(topic));
    }

    /**
     * 接收消息
     */
    @Override
    public void run() {
        while (true) {
            // 拉取消息
            ConsumerRecords<String, String> consumerRecord = kafkaConsumer.poll(100000000);
            log.info("consumerRecords : {}", JSON.toJSONString(consumerRecord));
            for (ConsumerRecord<String, String> record : consumerRecord) {
                // record.partition() 获取当前分区
                log.info(
                    "Received message: (" + record.key() + ", " + record.value() + ") at offset " + record.offset());
            }
        }
    }

    public static void main(String[] args) {
        new KafkaConsumerDemo("RealtimeMergeTrigger").start();
    }
}
