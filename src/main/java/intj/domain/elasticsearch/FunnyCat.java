package intj.domain.elasticsearch;

import intj.ElasticSearchSettings;
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

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    //todo: ANY other way to make it non-public?
    public List<Feature> getFeatures() {
        return features;
    }

    @Field(type = FieldType.Nested)
    private final List<Feature> features = new ArrayList<>();

    public void addFeature(Feature feature){
        this.features.add(feature);
    }


    public CatDetails getCatDetails() {
        return catDetails;
    }

    public void setCatDetails(CatDetails catDetails) {
        this.catDetails = catDetails;
    }

    public FunnyCat(String name, Integer age) {

        this.lastModified = Date.from(Instant.now());
        this.name = name;
        this.age = age;
        this.id = Integer.valueOf(ID_GENERATOR.getAndIncrement()).toString();
    }

    public FunnyCat() {

    }

    public void addCatDetails(CatDetails catDetails){
        this.catDetails = catDetails;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
