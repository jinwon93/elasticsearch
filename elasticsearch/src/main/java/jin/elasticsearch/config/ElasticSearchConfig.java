package jin.elasticsearch.config;

import org.elasticsearch.client.RestClient;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.erhlc.AbstractElasticsearchConfiguration;

import org.springframework.data.elasticsearch.client.erhlc.RestClients;
import org.springframework.data.elasticsearch.config.EnableElasticsearchAuditing;


@Configuration
@EnableElasticsearchAuditing
public  class ElasticSearchConfig extends AbstractElasticsearchConfiguration  {


    @Override
    public RestHighLevelClient elasticsearchClient() {
        ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo("localhost:9200")
                .build();
        return RestClients.create(clientConfiguration).rest();
    }
}
