package com.robo.project.model;

import lombok.Value;

import java.util.List;

@Value
public class ResultPage<T> {

    List<T> data;
    int pageNumber;
    long totalPages;

}