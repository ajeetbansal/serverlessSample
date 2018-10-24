package ab.sample.serverless.topic.cud;


import ab.sample.serverless.topic.object.Topic;

public class Response {
    String message;
    Topic topic;

    public Response() {
    }

    public Response(String message, Topic topic) {
        this.message = message;
        this.topic = topic;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}