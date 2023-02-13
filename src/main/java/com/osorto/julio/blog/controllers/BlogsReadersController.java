package com.osorto.julio.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.osorto.julio.blog.entities.BlogsReaders;
import com.osorto.julio.blog.services.BlogsReadersService;

@Controller
public class BlogsReadersController {

	@Autowired
	private BlogsReadersService service;

	@GetMapping({ "/blog_readers" })
	public String getBlogReaders(Model model) {
		model.addAttribute("blogReaders", service.findAll());
		return "frontend/blogs_reader";
	}

	@GetMapping({ "/new_blog_reader" })
	public String newBlogReaders(Model model) {

		return "frontend/new_blog_reader";
	}

	@PostMapping({ "/save_blog_reader" })
	public String saveBlogReaders(@ModelAttribute("blogReaderForm") BlogsReaders blogReaderForm,
			BindingResult bindingResult) {

		service.save(blogReaderForm);
		return "redirect:/blogs_reader";
	}

	@PostMapping({ "/update_blogs_reader" })
	public String updateBlogReaders(@ModelAttribute("blogReaderForm") BlogsReaders blogReaderForm,
			BindingResult bindingResult) {

		service.save(blogReaderForm);
		return "redirect:/blogs_reader";
	}

}
