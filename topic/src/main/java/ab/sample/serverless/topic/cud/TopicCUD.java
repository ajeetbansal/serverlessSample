package ab.sample.serverless.topic.cud;

import ab.sample.serverless.topic.object.Topic;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.Context;

import java.util.UUID;

public class TopicCUD implements RequestHandler<Request, Response> {

    public Response handleRequest(Request request, Context context) {
        context.getLogger().log("Input: " + request.topicTitle + " " + request.topicContent);
        Topic newTopic = createTopicObject(request);
        persistTopic(newTopic);
        context.getLogger().log("Output: " + newTopic.getTopicId());
        return new Response(newTopic.getTopicId(), newTopic);
    }

    private Topic createTopicObject(Request request) {
        String topicId = UUID.randomUUID().toString();
        Topic topic = new Topic(request.getTopicTitle(), request.getTopicContent());
        topic.setTopicId(topicId);
        return topic;
    }

    private void persistTopic(Topic topic) {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
        DynamoDBMapper mapper = new DynamoDBMapper(client);
        mapper.save(topic);
    }
}