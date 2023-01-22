package co.com.Test.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CrearUsuario {
    @JsonProperty("name")
    public Integer getName() {
        return name;
    }
    @JsonProperty("name")
    public void setName(Integer name) {
        this.name = name;
    }
    @JsonProperty("job")
    public String getJob() {
        return job;
    }
    @JsonProperty("job")
    public void setJob(String job) {
        this.job = job;
    }

    @JsonProperty("name")
    private Integer name;
    @JsonProperty("job")
    private String job;

}

