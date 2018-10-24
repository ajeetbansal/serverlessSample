package ab.sample.serverless.topic.cud;

public class Request {
    String topicTitle;
    String topicContent;

    public Request() {
    }

    public Request(String topicTitle, String topicContent) {
        this.topicTitle = topicTitle;
        this.topicContent = topicContent;
    }

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