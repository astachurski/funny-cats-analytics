package intj.domain.elasticsearch;

import intj.ElasticSearchSettings;
import lombok.*;
import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Document(
        indexName = ElasticSearchSettings.indexName,
        type = ElasticSearchSettings.type, shards = 1, replicas = 0, refreshInterval = "-1")
@Getter
@Setter
@Builder
@AllArgsConstructor
public class FunnyCat {
    private static AtomicInteger ID_GENERATOR = new AtomicInteger(1);
    @Field(type = FieldType.Integer, index = true)
    private Integer age;
    @Field(type = FieldType.text, index = true)
    private String name;
    @Field(type = FieldType.Object)
    private CatDetails catDetails;
    @Id
    private String id;
    @Field(type = FieldType.Date)
    private Date lastModified;

    @Field(type = FieldType.Nested)
    private final List<Feature> features = new ArrayList<>();

    public void addFeature(Feature feature){
        this.features.add(feature);
    }

    public FunnyCat(String name, Integer age) {

        this.name = name;
        this.age = age;
    }

    public void resetId(){
        this.id = Integer.valueOf(ID_GENERATOR.getAndIncrement()).toString();
        this.lastModified = Date.from(Instant.now());
    }

    public FunnyCat() {
    }
}
