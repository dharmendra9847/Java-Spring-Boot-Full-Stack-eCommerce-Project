package com.ecommerce.project.controller;

import com.ecommerce.project.config.AppConstants;
import com.ecommerce.project.payload.CategoryDTO;
import com.ecommerce.project.payload.CategoryResponse;
import com.ecommerce.project.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    private ResponseEntity<CategoryResponse> getAllCategories(
            @RequestParam(name = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
            @RequestParam(name = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
            @RequestParam(name = "sortBy", defaultValue = AppConstants.SORT_CATEGORY_BY, required = false) String sortBy,
            @RequestParam(name = "sortOrder", defaultValue = AppConstants.SORT_DIR, required = false) String sortOrder
    ) {
        CategoryResponse categoryResponse = categoryService.getAllCategories(pageNumber, pageSize, sortBy, sortOrder);
        return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
    }

    @PostMapping("/public/categories")
    //@RequestMapping(value = "/public/categories",  method = RequestMethod.POST)
    public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
        CategoryDTO savedCategoryDTO = categoryService.createCategory(categoryDTO);
        return new ResponseEntity<>(savedCategoryDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/admin/categories/{categoryId}")
    public ResponseEntity<CategoryDTO> deleteCategory(@PathVariable Long categoryId) {
        CategoryDTO deletedCategory = categoryService.deleteCategory(categoryId);
        return new  ResponseEntity<>(deletedCategory, HttpStatus.OK);
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
    public ResponseEntity<CategoryDTO> updateCategory(@RequestBody CategoryDTO categoryDTO, @PathVariable Long categoryId) {
        CategoryDTO savedCategoryDTO = categoryService.updateCategory(categoryDTO, categoryId);
        return new ResponseEntity<>(savedCategoryDTO, HttpStatus.OK);
//        try {
//            categoryService.updateCategory(category, categoryId);
//            return new ResponseEntity<>("Category with categoryId : " + categoryId + " updated successfully", HttpStatus.OK);
//        } catch (ResponseStatusException e) {
//            return new ResponseEntity<>(e.getReason(), HttpStatus.NOT_FOUND);
//        }
    }
}
