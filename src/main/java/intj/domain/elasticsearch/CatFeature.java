package intj.domain.elasticsearch;


import intj.ElasticSearchSettings;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.concurrent.atomic.AtomicInteger;

@Document(
        indexName = ElasticSearchSettings.indexName,
        type = ElasticSearchSettings.type_child,
        shards = 1, replicas = 0, refreshInterval = "-1")
public class CatFeature {
    private static AtomicInteger ID_GENERATOR = new AtomicInteger(1);

    @Id
    private String id;

    public CatFeature(FunnyCat parent, String featureName){
        this.id = Integer.valueOf(ID_GENERATOR.getAndIncrement()).toString();
        this.catId = parent.getId();
        this.featureName = featureName;
    }

    @Field(type = FieldType.text, store = true)
    private String catId;

    public CatFeature(){

    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(FunnyCat parent) {

        this.featureName = featureName;
    }

    @Field(type = FieldType.text)
    private String featureName;
}
