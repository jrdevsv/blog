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
import org.springframework.web.bind.annotation.PutMapping;

import com.osorto.julio.blog.entities.Readers;
import com.osorto.julio.blog.services.ReadersService;

@Controller
public class ReadersController {

	@Autowired
	private ReadersService service;

	@GetMapping({ "/readers" })
	public String getReaders(Model model) {
		model.addAttribute("readers", service.findAll());
		return "frontend/readers";
	}

	@GetMapping({ "/new_reader" })
	public String newReader(Model model) {

		return "frontend/new_reader";
	}

	@PostMapping({ "/save_reader" })
	public String saveReader(@ModelAttribute("readerForm") Readers readerForm, BindingResult bindingResult) {

		service.save(readerForm);
		return "redirect:/readers";
	}

	@GetMapping({ "/edit_reader/{id}" })
	public String findReaderById(@PathVariable("id") int id, Model model) {

		model.addAttribute("reader", service.findById(id));

		return "frontend/edit_reader";
	}

	@PostMapping({ "/update_reader" })
	public String updateReader(@ModelAttribute("readerForm") Readers readerForm, BindingResult bindingResult) {
		
		System.out.println(readerForm.getIdReader());
		System.out.println(readerForm.getName());

		service.save(readerForm);
		return "redirect:/readers";
	}

	@GetMapping({ "/delete/{id}" })
	public String delete(@PathVariable("id") int id, Model model) {

		service.delete(id);

		return "redirect:/readers";
	}


}
