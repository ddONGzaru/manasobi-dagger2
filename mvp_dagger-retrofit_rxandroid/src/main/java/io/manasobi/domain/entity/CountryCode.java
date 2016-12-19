package io.manasobi.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * Created by tw.jang on 2016-12-19.
 */

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryCode {

    @JsonProperty("JPY")
    private float JPY;

    @JsonProperty("KRW")
    private float KRW;

}