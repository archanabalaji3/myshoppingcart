package com.niit.shoppingcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.domain.Category;

@Controller

public class CategoryController {
	//we need to call CategoryDAO methods
			//get,save,update,delete,list
			//inject the category Dao
			@Autowired
			private CategoryDAO categoryDAO;
			
			@Autowired
			private Category category;
			
			@GetMapping("/category/get/{id}")
			public ModelAndView getCategory(@RequestParam("id") String id)
			{
				category = categoryDAO.get(id);
				
				ModelAndView mv= new ModelAndView("home");
				mv.addObject("category",category);
				return mv;
			}
			@PostMapping("/category/save/")
		
			public ModelAndView saveCategory(@RequestParam("id") String id,@RequestParam("name") String name, @RequestParam("description") String description)
			{ 
				category.setId(id);
				category.setName(name);
				category.setDescription(description);
				ModelAndView mv= new ModelAndView("home");
				if (categoryDAO.save(category)==true)
				{
					mv.addObject("successMessage","THe Category created Successfully");
				}
				else
				{
					mv.addObject("errorMessage","Category not Saved Successfully");
				}
				return mv;
			}
			@PutMapping("/category/update/")
			public ModelAndView updateCategory(@RequestBody Category category)
			{
				ModelAndView mv= new ModelAndView("home");
				if (categoryDAO.update(category)==true)
				{
					mv.addObject("Success Msg","THe Category update Successfully");
				}
				else
				{
					mv.addObject("Error Msg","Category not update Successfully");
				}
				return mv;
			}
			@DeleteMapping("/category/delete/{id}")
			public ModelAndView deleteCategory(@RequestParam("id") String id)
			{

				ModelAndView mv= new ModelAndView("home");
				if(categoryDAO.delete(id)==true)
				{
					mv.addObject("Success Msg","THe Category deleted Successfully");
				}
				else
				{
					mv.addObject("Error Msg","could not delete");
				}
				return mv;
			}
			@GetMapping("/categories")
			public ModelAndView setAllCategories()
			{
				ModelAndView mv= new ModelAndView("home");
				List<Category> categories= categoryDAO.list();
				mv.addObject("categories",categories);
				return mv;
			}
}
