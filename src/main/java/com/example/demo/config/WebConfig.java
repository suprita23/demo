package com.example.demo.config;

import java.net.URL;

import org.springframework.context.annotation.Configuration;

import com.amazonaws.xray.AWSXRay;
import com.amazonaws.xray.AWSXRayRecorderBuilder;
import com.amazonaws.xray.plugins.ECSPlugin;
import com.amazonaws.xray.strategy.sampling.LocalizedSamplingStrategy;

@Configuration
public class WebConfig {
	static {
		AWSXRayRecorderBuilder builder = AWSXRayRecorderBuilder.standard().withPlugin(new ECSPlugin());
		URL ruleFile = WebConfig.class.getResource("/sampling-rules.json");
		builder.withSamplingStrategy(new LocalizedSamplingStrategy(ruleFile));

		AWSXRay.setGlobalRecorder(builder.build());
	}

}
