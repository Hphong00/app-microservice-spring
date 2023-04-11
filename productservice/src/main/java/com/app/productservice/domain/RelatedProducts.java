package com.app.productservice.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity
@Table(name = "related_products")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RelatedProducts extends BaseDomain {
    @Column(name = "products_id")
    private String productsID;
    @Column(name = "related_products_id")
    private String relatedProductsId;

    //    relationship_type: Loại mối quan hệ giữa hai sản phẩm, ví dụ như "cùng danh mục", "cùng kiểu dáng", "cùng tính năng",...
    @Column(name = "relationship_type")
    private String relationshipType;
    @Column(name = "relevance_score")
    private String relevanceScore;
}
