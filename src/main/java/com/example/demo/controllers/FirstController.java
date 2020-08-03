package com.example.demo.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.xray.AWSXRay;
import com.amazonaws.xray.entities.Subsegment;

@RestController
@RequestMapping( "/" )
public class FirstController {
	
	static final String S3_BUCKET_NAME = "oriental-bucket";
 
    @GetMapping("/api" )
    public List<String> index() {
    	AWSXRay.beginSegment("demo-Segment");
    	testAWSClientInstrumentation();
    	Subsegment sub = AWSXRay.beginSubsegment("handleDynamoRequest");
        List<String> s = new ArrayList<>();
        s.add("Docker + AWS CodePipline Tutorial");
        s.add("This is a sample app");
        AWSXRay.endSubsegment();
        AWSXRay.endSegment();
        return s;
    }
    
    private void testAWSClientInstrumentation() {
    	System.out.println("Starting S3 client test...");
    	AmazonS3 s3_client = AmazonS3ClientBuilder.defaultClient();

        // S3 Test
        try {
            File file = File.createTempFile("test", ".txt");
            file.deleteOnExit();
            Writer writer = new OutputStreamWriter(new FileOutputStream(file));
            writer.write("test file");
            writer.close();

            PutObjectRequest putRequest = new PutObjectRequest(S3_BUCKET_NAME, "agent/test.txt", file);
            PutObjectResult s3Result = s3_client.putObject(putRequest);
            System.out.println(s3Result);

        } catch(IOException e) {
            System.out.println("Unable to test S3" + e.toString());
        }
    }
}
