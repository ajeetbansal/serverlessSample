package ab.sample.serverless.topic.cud

import com.amazonaws.regions.Regions
import com.amazonaws.services.lambda.AWSLambda
import com.amazonaws.services.lambda.AWSLambdaClientBuilder
import com.amazonaws.services.lambda.model.InvokeRequest
import com.amazonaws.services.lambda.model.InvokeResult;
import spock.lang.Specification

class TopicCUDIntegTest extends Specification{
    def "Test Create Topic" () {
        setup:
        Regions region = Regions.fromName("us-east-2");
        System.setProperty("aws.accessKeyId","AKIAIFIDD3SKLA2ALV3A")
        System.setProperty("aws.secretKey","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")
        AWSLambdaClientBuilder builder = AWSLambdaClientBuilder.standard()
                .withRegion(region);
        AWSLambda client = builder.build();

        String payload = "{\n" +
                "  \"topicTitle\": \"TopicTitle1\",\n" +
                "  \"topicContent\": \"TopicContent1\"\n" +
                "}"
        when:

        InvokeRequest req = new InvokeRequest()
                .withFunctionName("ServerlessSampleTopicCUD")
                .withPayload(payload);
        InvokeResult result = client.invoke(req);
        then:
        result.getPayload() != null
        println new String(result.getPayload().array(), "UTF-8")
    }

}