package com.example.Spring.utility;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.example.Spring.dao.impl.UserDaoImpl;
import com.example.Spring.protos.Element;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class SqsTransaction {

    @Value("${cloud.aws.end-point.uri}")
    private  String endpoint ;
  private final AmazonSQS amazonSQS;

    private static final Logger LOGGER = LoggerFactory.getLogger(SqsTransaction.class);


    public SqsTransaction(AmazonSQS amazonSQS) {
        this.amazonSQS = amazonSQS;
    }




    public  void sendMsg(Element element) throws InvalidProtocolBufferException {

        String messageBody = JsonFormat.printer().print(element);
        SendMessageRequest sendMessageRequest = new SendMessageRequest()
                .withQueueUrl(endpoint)
                .withMessageBody(messageBody).withDelaySeconds(20);
          amazonSQS.sendMessage(sendMessageRequest);
    }

    public  List<Element> receiveMsg() {
        List<Message> messages = amazonSQS.receiveMessage(endpoint).getMessages();
        List<Element> transactionMsgList = new ArrayList<>();
        for(Message msg : messages) {
            Element.Builder element = Element.newBuilder();
            try {
                JsonFormat.parser().ignoringUnknownFields().merge(msg.getBody(),element);
                transactionMsgList.add(element.build());
            }
            catch(Exception e) {
                LOGGER.info("{}", e.getMessage());
            }

            amazonSQS.deleteMessage(endpoint, msg.getReceiptHandle());
        }

        return  transactionMsgList;
    }




}
