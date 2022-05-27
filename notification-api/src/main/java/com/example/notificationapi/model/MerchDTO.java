package com.example.notificationapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MerchDTO {
    private String merchId;
    private String header;
    private String description;
    private String brandName;
    private String imageUrl;
    private String category;
    private int votes;
    private String ownerId;
}
