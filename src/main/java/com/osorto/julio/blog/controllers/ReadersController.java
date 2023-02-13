package com.osorto.julio.blog.controllers;

import java.security.Key;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.osorto.julio.blog.entities.Readers;
import com.osorto.julio.blog.entities.User;
import com.osorto.julio.blog.services.ReadersService;
import com.osorto.julio.blog.services.UserService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Controller
public class ReadersController {

	private static final int expireInMs = 300 * 1000;
	private final static Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

	@Autowired
	private ReadersService service;

	@Autowired
	private UserService userService;

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
		service.save(readerForm);
		return "redirect:/readers";
	}

	@GetMapping({ "/delete/{id}" })
	public String delete(@PathVariable("id") int id, Model model) {
		service.delete(id);
		return "redirect:/readers";
	}

	@RequestMapping(value = "/listReaders", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseEntity<List<Readers>> listar(@RequestHeader String token) throws Exception {

		if (!validate(token)) {
			new ResponseEntity<String>("Token no valido", HttpStatusCode.valueOf(401));
		}

		List<Readers> lista = service.findAll();
		return new ResponseEntity<List<Readers>>(lista, HttpStatusCode.valueOf(200));
	}

	@RequestMapping(value = "/token", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> generate(@RequestParam String username) {
		String token = Jwts.builder().setSubject(username).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + expireInMs)).signWith(key).compact();

		return new ResponseEntity<String>(token, HttpStatusCode.valueOf(200));
	}

	public boolean isExpired(String token) {
		Claims claims = getClaims(token);
		return claims.getExpiration().after(new Date(System.currentTimeMillis()));
	}

	public String getUsername(String token) {
		Claims claims = getClaims(token);
		return claims.getSubject();
	}

	public boolean validate(String token) {

		User u = userService.findByUsername(getUsername(token));

		if (u == null || u.getUsername() == null || u.getUsername().isBlank()) {
			return false;
		}

		if (getUsername(token) != null && u.getUsername() == getUsername(token) && isExpired(token)) {
			return true;
		}
		return false;
	}

	private Claims getClaims(String token) {
		return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
	}

}
