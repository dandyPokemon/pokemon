package org.koreait.main.entitise;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MainProduct {
    private String header;
    private List<Product> onlineStoreProducts;
    private List<Product> licenseProducts;
}