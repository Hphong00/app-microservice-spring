package com.app.productservice.rest;

import com.app.productservice.dto.ProductDTO;
import com.app.productservice.dto.respon.AppResponse;
import com.app.productservice.service.ProductService;
import com.app.productservice.utils.AppUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/api/product")
public class ProductResource {
    private final Logger log = LoggerFactory.getLogger(ProductResource.class);

    @Autowired
    private ProductService productService;

    @Autowired
    private AppUtils appUtils;

    @PostMapping
    public ResponseEntity<AppResponse<ProductDTO>> insertProduct(HttpServletRequest request, @RequestBody ProductDTO productDTO) {
        log.debug("Request to insertProduct : {}", request, productDTO);
        return ResponseEntity.ok(appUtils.buildSuccessResponse(productService.insertProduct(request, productDTO)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppResponse<ProductDTO>> getProductById(HttpServletRequest request, @PathVariable String id) {
        log.debug("Request to getProductById : {}", request, id);
        return ResponseEntity.ok(appUtils.buildSuccessResponse(productService.getProductById(request, id)));
    }
}
