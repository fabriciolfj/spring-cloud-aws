package com.github.fabriciolfj.productservice.api.mapper.response;


import com.github.fabriciolfj.productservice.api.model.response.ProductDtoResponse;
import com.github.fabriciolfj.productservice.domain.model.Product;

public class ProductMapperResponse {

    public ProductMapperResponse() {

    }

    public static ProductDtoResponse toDto(final Product product) {
        return ProductDtoResponse
                .builder()
                .id(product.getId())
                .name(product.getName())
                .build();
    }
}
