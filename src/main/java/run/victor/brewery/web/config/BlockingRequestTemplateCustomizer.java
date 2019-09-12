package run.victor.brewery.web.config;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Victor Wardi - @victorwardi on 9/12/2019
 */
@Component
public class BlockingRequestTemplateCustomizer implements RestTemplateCustomizer {

    private final Integer maxConnections;
    private final Integer defaultMaxConnectionsRoute;
    private final Integer requestTimeout;
    private final Integer socketTimeout;

    public BlockingRequestTemplateCustomizer(@Value("${vr.brewery.maxConnections}") Integer maxConnections,
                                             @Value("${vr.brewery.defaultMaxConnectionsRoute}") Integer defaultMaxConnectionsRoute,
                                             @Value("${vr.brewery.requestTimeout}") Integer requestTimeout,
                                             @Value("${vr.brewery.socketTimeout}") Integer socketTimeout) {
        this.maxConnections = maxConnections;
        this.defaultMaxConnectionsRoute = defaultMaxConnectionsRoute;
        this.requestTimeout = requestTimeout;
        this.socketTimeout = socketTimeout;
    }

    public ClientHttpRequestFactory clientRequestFactory() {
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(maxConnections);
        connectionManager.setDefaultMaxPerRoute(defaultMaxConnectionsRoute);

        RequestConfig requestConfig = RequestConfig.custom()
            .setConnectionRequestTimeout(requestTimeout)
            .setSocketTimeout(socketTimeout)
            .build();
        CloseableHttpClient httpClient = HttpClients.custom()
            .setConnectionManager(connectionManager)
            .setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy())
            .setDefaultRequestConfig(requestConfig)
            .build();

        return new HttpComponentsClientHttpRequestFactory(httpClient);

    }

    @Override
    public void customize(RestTemplate restTemplate) {
        restTemplate.setRequestFactory(this.clientRequestFactory());
    }
}
