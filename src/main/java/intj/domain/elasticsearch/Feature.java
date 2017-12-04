package intj.domain.elasticsearch;

import intj.ElasticSearchSettings;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.concurrent.atomic.AtomicInteger;

@Document(
        indexName = ElasticSearchSettings.indexName,
        type = ElasticSearchSettings.type_feature,
        shards = 1, replicas = 0, refreshInterval = "-1")

public class Feature {
    private static AtomicInteger ID_GENERATOR = new AtomicInteger(1);

    @Id
    private String id;

    @Field(type = FieldType.text)
    private String feature;

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public Feature(String feature) {
        this.feature = feature;
        this.id = Integer.valueOf(ID_GENERATOR.getAndIncrement()).toString();
    }
}
