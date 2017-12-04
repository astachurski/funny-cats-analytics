package intj.domain.elasticsearch;

import intj.ElasticSearchSettings;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

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
    @Field(type = FieldType.Nested)
    private CatDetails catDetails;
    @Id
    private String id;

    public CatDetails getCatDetails() {
        return catDetails;
    }

    public void setCatDetails(CatDetails catDetails) {
        this.catDetails = catDetails;
    }

    public FunnyCat(String name, Integer age) {
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
