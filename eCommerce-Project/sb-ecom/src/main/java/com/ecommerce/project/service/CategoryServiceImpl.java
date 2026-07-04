package com.ecommerce.project.service;

import com.ecommerce.project.exception.APIException;
import com.ecommerce.project.exception.ResourceNotFoundException;
import com.ecommerce.project.model.Category;
import com.ecommerce.project.payload.CategoryDTO;
import com.ecommerce.project.payload.CategoryResponse;
import com.ecommerce.project.repositories.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private  final ModelMapper modelMapper;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    //List<Category> categories = new ArrayList<>();
    //private Long nextId = 1L;

    @Override
    public CategoryResponse getAllCategories(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder) {

        // Sort
        Sort sortByAndOrder = sortOrder.equalsIgnoreCase("asc")
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();


        // Pagination Implementation
        Pageable pageDetails = PageRequest.of(pageNumber, pageSize, sortByAndOrder);
        Page<Category> categoryPage = categoryRepository.findAll(pageDetails);

        //return categories;
//        List<Category> categories = categoryRepository.findAll();
        List<Category> categories = categoryPage.getContent();
        if (categories.isEmpty()) {
            throw new APIException("No category not created till now.");
        }
        List<CategoryDTO> categoryDTOS = categories.stream()
                .map(category -> modelMapper.map(category, CategoryDTO.class))
                .toList();

        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setContent(categoryDTOS);
        categoryResponse.setPageNumber(categoryPage.getNumber());
        categoryResponse.setPageSize(categoryPage.getSize());
        categoryResponse.setTotalElements(categoryPage.getTotalElements());
        categoryResponse.setTotalPages(categoryPage.getTotalPages());
        categoryResponse.setLastPage(categoryPage.isLast());
        return categoryResponse;
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        //category.setCategoryId(nextId++);
        //categories.add(category);

        Category category = modelMapper.map(categoryDTO, Category.class);

        Category categoryFromDB = categoryRepository.findByCategoryName(categoryDTO.getCategoryName());
        if (categoryFromDB != null) {
            throw new APIException("Category with the name "+ categoryDTO.getCategoryName() + " already exists!!!");
        }

        Category savedCategory = categoryRepository.save(category);
        return modelMapper.map(savedCategory, CategoryDTO.class);
    }

    @Override
    public CategoryDTO deleteCategory(Long categoryId) {


        Category category = categoryRepository.findById(categoryId)
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource Not Found"));
//                .orElseThrow(ResourceNotFoundException::new);
                .orElseThrow(() ->
                        new ResourceNotFoundException("Category", "categoryId", categoryId));

//        List<Category> categories = categoryRepository.findAll();
//
//        Category category = categories.stream()
//                .filter(c -> c.getCategoryId().equals(categoryId))
//                .findFirst()
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource Not Found"));

        //categories.remove(category);
//        categoryRepository.delete(category);
//        return "Category with categoryId: " + categoryId + " Deleted Successfully!!";
        categoryRepository.delete(category);
        return modelMapper.map(category, CategoryDTO.class);
    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO, Long categoryId) {

        Optional<Category> savedCategoryOptional = categoryRepository.findById(categoryId);

        Category CategoryFromDB = savedCategoryOptional
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category Not Found"));
//                  .orElseThrow(ResourceNotFoundException::new);
                .orElseThrow(() ->
                        new ResourceNotFoundException("Category", "categoryId", categoryId));

        Category category = modelMapper.map(categoryDTO, Category.class);

        category.setCategoryId(categoryId);

        Category savedCategory = categoryRepository.save(category);
        return modelMapper.map(savedCategory, CategoryDTO.class);

//        List<Category> categories = categoryRepository.findAll();
//
//        Optional<Category> categoryOptional = categories.stream()
//                .filter(c -> c.getCategoryId().equals(categoryId))
//                .findFirst();
//
//        if (categoryOptional.isPresent()) {
//            Category existingCategory = categoryOptional.get();
//            //existingCategory.setCategoryName(category.getCategoryName());
//            //return existingCategory;
//            existingCategory.setCategoryName(category.getCategoryName());
//
//            Category savedCategory = categoryRepository.save(existingCategory);
//            return savedCategory;
//        } else {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category Not Found");
//        }
    }
}
