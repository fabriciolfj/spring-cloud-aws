package com.github.fabriciolfj.productservice.api.model.response;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDtoResponse {

    private Long id;
    private String name;
}
