package ab.sample.serverless.topic.query;


import ab.sample.serverless.topic.object.Topic;

import java.util.List;

public class Response {
    String message;
    List<Topic> topic;

    public Response() {
    }

    public Response(String message, List<Topic> topic) {
        this.message = message;
        this.topic = topic;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Topic> getTopic() {
        return topic;
    }

    public void setTopic(List<Topic> topic) {
        this.topic = topic;
    }
}