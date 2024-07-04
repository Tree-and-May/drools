package com.qianye.drools.service.impl.action;

import com.github.rholder.retry.Retryer;
import com.github.rholder.retry.RetryerBuilder;
import com.github.rholder.retry.WaitStrategies;
import com.github.rholder.retry.WaitStrategy;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class HttpService {
    private static final Logger logger = LoggerFactory.getLogger(HttpService.class);

    private static final int MAX_RETRIES = 3;
    private static final int TIMEOUT_SECONDS = 10;

    public static String executeHttpRequest(HttpRequestBase request) {
        HttpClientBuilder builder = HttpClientBuilder.create();
        builder.useSystemProperties();
        CloseableHttpClient httpClient = builder.build();

        Callable<CloseableHttpResponse> callable = () -> httpClient.execute(request);
        WaitStrategy waitStrategy = WaitStrategies.fixedWait(1, TimeUnit.SECONDS);
        Retryer<CloseableHttpResponse> retryer = RetryerBuilder.<CloseableHttpResponse>newBuilder()
                .retryIfException()
                .withWaitStrategy(waitStrategy)
                .withStopStrategy((attempt, result) -> attempt >= MAX_RETRIES)
                .build();

        try {
            CloseableHttpResponse response = retryer.call(callable);
            int statusCode = response.getStatusLine().getStatusCode();
            String responseBody = EntityUtils.toString(response.getEntity());
            logger.info("HTTP request status code: {}", statusCode);
            logger.info("HTTP response body: {}", responseBody);
            response.close();
            httpClient.close();
            return responseBody;
        } catch (Exception e) {
            logger.error("HTTP request failed after {} retries", MAX_RETRIES, e);
            throw new RuntimeException(e);
        }
    }
}