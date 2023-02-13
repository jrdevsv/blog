package com.osorto.julio.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.osorto.julio.blog.entities.Blogs;
import com.osorto.julio.blog.services.BlogsService;

@Controller
public class BlogsController {

	@Autowired
	private BlogsService service;

	@GetMapping({ "/blogs" })
	public String getBlog(Model model) {
		model.addAttribute("blogs", service.findAll());
		return "frontend/blogs";
	}

	@GetMapping({ "/new_blog" })
	public String newBlog(Model model) {

		return "frontend/new_blog";
	}

	@PostMapping({ "/save_blog" })
	public String saveBlog(@ModelAttribute("blogForm") Blogs blogForm, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "frontend/new_blog";
		}

		service.save(blogForm);
		return "redirect:/blogs";
	}

	@GetMapping({ "/edit_blog/{id}" })
	public String findBlogById(@PathVariable("id") int id, Model model) {

		model.addAttribute("blog", service.findById(id));

		return "frontend/edit_blog";
	}

	@PostMapping({ "/update_blog" })
	public String updateBlog(@ModelAttribute("blogForm") Blogs blogForm, BindingResult bindingResult) {

		service.save(blogForm);
		return "redirect:/blogs";
	}

	@GetMapping({ "/delete_blog/{id}" })
	public String deleteBlog(@PathVariable("id") int id, Model model) {

		service.delete(id);

		return "redirect:/blogs";
	}

}
