package com.github.fabriciolfj.productservice.api.mapper.request;


import com.github.fabriciolfj.productservice.api.model.request.ProductDtoRequest;
import com.github.fabriciolfj.productservice.domain.model.Product;

public class ProductMapperRequest {

    private ProductMapperRequest() {

    }

    public static Product toDomain(final ProductDtoRequest productDtoRequest) {
        return Product.builder()
                .name(productDtoRequest.getName())
                .build();
    }
}
