package com.github.fabriciolfj.productservice.api.controller;


import com.github.fabriciolfj.productservice.api.ResourceUriHelper;
import com.github.fabriciolfj.productservice.api.mapper.request.ProductMapperRequest;
import com.github.fabriciolfj.productservice.api.mapper.response.ProductMapperResponse;
import com.github.fabriciolfj.productservice.api.model.request.ProductDtoRequest;
import com.github.fabriciolfj.productservice.api.model.response.ProductDtoResponse;
import com.github.fabriciolfj.productservice.domain.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
@RequestMapping("/products")
@RestController
@RequiredArgsConstructor
public class ProductController {
    
    private final ProductService service;
    
    @GetMapping
    public List<ProductDtoResponse> findAll() {
        return service.findAll().stream()
                .map(p -> ProductMapperResponse.toDto(p)).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ProductDtoResponse findBy(@PathVariable("id") final Long id) {
        return Optional.of(service.findlById(id)).map(p -> ProductMapperResponse.toDto(p)).get();
    }

    @PostMapping
    public void create(@RequestBody ProductDtoRequest dto) {
        var product = service.create(ProductMapperRequest.toDomain(dto));
        ResourceUriHelper.addUriResponseHeader(product);
    }

    @PutMapping("/{id}")
    public ProductDtoResponse update(@PathVariable("id")final Long id, @RequestBody ProductDtoRequest dto) {
        return Optional.of(service.update(id, ProductMapperRequest.toDomain(dto)))
                .map(p -> ProductMapperResponse.toDto(p)).get();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") final Long id) {
        service.delete(id);
    }
}
