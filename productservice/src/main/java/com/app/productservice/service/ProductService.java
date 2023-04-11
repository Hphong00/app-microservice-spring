package com.app.productservice.service;

import com.app.productservice.dto.ProductDTO;

import javax.servlet.http.HttpServletRequest;

public interface ProductService {

    ProductDTO insertProduct(HttpServletRequest request, ProductDTO productDTO);

    ProductDTO getProductById(HttpServletRequest request, String id);

}
