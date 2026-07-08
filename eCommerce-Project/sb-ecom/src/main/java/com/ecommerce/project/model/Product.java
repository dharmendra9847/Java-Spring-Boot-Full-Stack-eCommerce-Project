package com.ecommerce.project.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @NotBlank(message = "Product name is required")
    @Size(min = 3, max = 150, message = "Product name must be between 3 and 150 characters")
    @Column(nullable = false, length = 150)
    private String productName;

    @NotBlank(message = "Product image is required")
    @Size(max = 500, message = "Image path cannot exceed 500 characters")
    @Column(nullable = false, length = 500)
    private String image;

    @NotBlank(message = "Product description is required")
    @Size(min = 10, max = 2000, message = "Description must be between 10 and 2000 characters")
    @Column(nullable = false, length = 2000)
    private String description;

    @NotNull(message = "Quantity is required")
    @PositiveOrZero(message = "Quantity cannot be negative")
    @Column(nullable = false)
    private Integer quantity;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.01", message = "Price must be greater than 0")
//    @Digits(integer = 10, fraction = 2,
//            message = "Price can have up to 10 integer digits and 2 decimal places")
    @Column(nullable = false)
    private Double price;

    @NotNull(message = "Discount is required")
    @DecimalMin(value = "0.00", message = "Discount cannot be negative")
    @DecimalMax(value = "100.00", message = "Discount cannot exceed 100%")
//    @Digits(integer = 3, fraction = 2,
//            message = "Discount format is invalid")
    @Column(nullable = false)
    private Double discount;

    @NotNull(message = "Special price is required")
    @Positive(message = "Special price must be greater than 0")
//    @Digits(integer = 10, fraction = 2,
//            message = "Special price can have up to 10 integer digits and 2 decimal places")
    @Column(nullable = false)
    private Double specialPrice;

    @NotNull(message = "Category is required")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
}