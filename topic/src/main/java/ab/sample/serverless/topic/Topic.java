package ab.sample.serverless.topic;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "topic")
public class Topic {

    private String topicId;
    private String topicTitle;
    private String topicContent;

    public Topic(String topicTitle, String topicContent) {
        this.topicTitle = topicTitle;
        this.topicContent = topicContent;
    }

    @DynamoDBHashKey(attributeName="topicId")
    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    @DynamoDBHashKey(attributeName="topicTitle")
    public String getTopicTitle() {
        return topicTitle;
    }

    public void setTopicTitle(String topicTitle) {
        this.topicTitle = topicTitle;
    }

    public String getTopicContent() {
        return topicContent;
    }

    public void setTopicContent(String topicContent) {
        this.topicContent = topicContent;
    }
}
