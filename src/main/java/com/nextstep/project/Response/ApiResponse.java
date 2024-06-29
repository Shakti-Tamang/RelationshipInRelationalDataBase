package com.nextstep.project.Response;

import com.fasterxml.jackson.annotation.JacksonAnnotation;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ApiResponse<T> {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("Message ")
    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("Code")
    private int code;


//    It stores bunch of object:
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("List")
    private List<T>list;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("One object")

//    It is in case when we need one object to edit:
    private T data;

}
