package intj.domain.elasticsearch;

import intj.ElasticSearchSettings;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Document(
        indexName = ElasticSearchSettings.indexName,
        type = ElasticSearchSettings.type, shards = 1, replicas = 0, refreshInterval = "-1")
public class FunnyCat {

    private static AtomicInteger ID_GENERATOR = new AtomicInteger(1);

    @Field(type = FieldType.text, index = true)
    private String name;

    public CatFeature getCatFeature() {
        return catFeature;
    }

    public void setCatFeature(CatFeature catFeature) {
        this.catFeature = catFeature;
    }

    private Integer age;

    @Field(type = FieldType.Nested)
    private CatFeature catFeature;

    @Id
    private String id;

    public FunnyCat(String name, Integer age) {
        this.name = name;
        this.age = age;
        this.id = Integer.valueOf(ID_GENERATOR.getAndIncrement()).toString();
    }

    public FunnyCat() {

    }

    public void addCatFeature(CatFeature catFeature){
        this.catFeature = catFeature;
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
