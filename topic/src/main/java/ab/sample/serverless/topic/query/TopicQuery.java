package ab.sample.serverless.topic.query;

import ab.sample.serverless.topic.object.Topic;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopicQuery implements RequestHandler<Request, Response> {

    public Response handleRequest(Request request, Context context) {
        List<Topic> topics  = queryTopics();
        return new Response("Topics retrieved succesfully", topics);
    }

    private List<Topic> queryTopics() {
        Topic queryTopic = new Topic();
        queryTopic.setTopicTitle("TopicTitle1");
        queryTopic.setTopicId("14460b84-b286-43e8-8d03-63b04969eb8d");
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
        DynamoDBMapper mapper = new DynamoDBMapper(client);
//        Map<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
//        eav.put(":topicTitle", new AttributeValue().withS("TopicTitle1"));
//        eav.put(":topicId", new AttributeValue().withS("1"));
        DynamoDBQueryExpression<Topic> queryExpression = new DynamoDBQueryExpression<Topic>()
                .withHashKeyValues(queryTopic)
//                .withKeyConditionExpression("begins_with (topicId, :topicId) and begins_with (topicTitle, :topicTitle)")
//                .withExpressionAttributeValues(eav)
         ;
        return mapper.query(Topic.class, queryExpression);
    }

}