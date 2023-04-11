package com.app.productservice.service.impl;

import com.app.productservice.dto.ProductDTO;
import com.app.productservice.domain.Product;
import com.app.productservice.repository.ProductRepository;
import com.app.productservice.service.ProductService;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

@Service
public class ProductServiceImpl implements ProductService {
    private final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
    @Autowired
    ProductRepository productRepository;

    private ObjectMapper mapper = new ObjectMapper().configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

    @Override
    @Transactional
    public ProductDTO insertProduct(HttpServletRequest request, ProductDTO dto) {
        log.info("Request to insertProduct : {}", request, dto);
        Product product =  mapper.convertValue(dto, Product.class);
        productRepository.save(product);
        return dto;
    }

    @Override
    @Transactional
    public ProductDTO getProductById(HttpServletRequest request, String id) {
        log.info("Request to getProductById : {}", request, id);
        Product product = productRepository.findProductById(id);
        ProductDTO productDTO =  mapper.convertValue(product, ProductDTO.class);
        return productDTO;
    }
}
