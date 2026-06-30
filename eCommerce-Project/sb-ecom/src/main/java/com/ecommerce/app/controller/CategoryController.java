package com.ecommerce.app.controller;

import com.ecommerce.app.model.Category;
import com.ecommerce.app.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/public/categories")
    //@RequestMapping(value = "/public/categories",  method = RequestMethod.GET)
    private ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping("/public/categories")
    //@RequestMapping(value = "/public/categories",  method = RequestMethod.POST)
    public ResponseEntity<String> createCategory(@Valid @RequestBody Category category) {
        categoryService.createCategory(category);
        return new ResponseEntity<>("Category added successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/admin/categories/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId) {
        String status = categoryService.deleteCategory(categoryId);
        return new  ResponseEntity<>(status, HttpStatus.OK);
//       try {
//           String status = categoryService.deleteCategory(categoryId);
//           return new  ResponseEntity<>(status, HttpStatus.OK);
           //return ResponseEntity.ok(status);
           //return ResponseEntity.status(HttpStatus.OK).body(status);
//       } catch (ResponseStatusException e) {
//           return new ResponseEntity<>(e.getReason(), HttpStatus.NOT_FOUND);
//       }
    }

    @PutMapping(("/categories/{categoryId}"))
    public ResponseEntity<String> updateCategory(@RequestBody Category category, @PathVariable Long categoryId) {
        categoryService.updateCategory(category, categoryId);
        return new ResponseEntity<>("Category with categoryId : " + categoryId + " updated successfully", HttpStatus.OK);
//        try {
//            categoryService.updateCategory(category, categoryId);
//            return new ResponseEntity<>("Category with categoryId : " + categoryId + " updated successfully", HttpStatus.OK);
//        } catch (ResponseStatusException e) {
//            return new ResponseEntity<>(e.getReason(), HttpStatus.NOT_FOUND);
//        }
    }
}
