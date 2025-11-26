package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class AppController {
	
	
	@Autowired
	BookManager manager;
	
	@GetMapping("/")
	public String showHomePage(Model model) {
		model.addAttribute("booklist",manager.getAllBook());
		return "index";
	}
	
	@GetMapping("/new")
	public String showCreatePage() {
		return "create_book_form";
	}
	
	@PostMapping("/save")
	public String saveBook(@ModelAttribute Book book) {
		manager.saveBook(book);
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String editBook(@PathVariable Long id, Model model) {
		model.addAttribute("staff", manager.getBookById(id));
		return "edit_form";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable Long id, Model model) {
		manager.deleteBook(id);
		return "redirect:/";
	}	
}
