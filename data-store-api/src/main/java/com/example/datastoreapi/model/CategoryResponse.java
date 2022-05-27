package com.example.datastoreapi.model;

import com.sun.org.glassfish.gmbal.AMXMetadata;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponse {

    private Long id;

    private String name;

    private Integer numberInSorting;
}
