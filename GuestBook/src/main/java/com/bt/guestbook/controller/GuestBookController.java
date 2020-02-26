/**
 * 
 */
package com.bt.guestbook.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bt.guestbook.model.GuestBook;
import com.bt.guestbook.repository.GuestBookRepository;

/**
 * @author Venkat
 *
 */
@Controller
@RequestMapping("/guestBook")
public class GuestBookController {

    private static final Logger logger = LoggerFactory.getLogger(GuestBookController.class);
    
	@Autowired
	private GuestBookRepository guestBookRepository;
	
	@GetMapping("/admin/all")
	public String getAllBooks(Model model) {
		model.addAttribute("bookList", guestBookRepository.findAll());
		return "allBooks";
	}
	
	@GetMapping("/admin/{id}")
	public String getBookById(@PathVariable("id") Long id, Model model) {
		Optional<GuestBook> optionalBook = guestBookRepository.findById(id);
		if(optionalBook.isPresent())
			model.addAttribute("guestBook", optionalBook.get());
		else
			model.addAttribute("errorMsg", "Book Not Found with this id");
		return "editBook";
	}
	
	@GetMapping("/admin/delete/{id}")
	public String deleteBook(@PathVariable("id") Long id,Model model) {
		guestBookRepository.deleteById(id);
		model.addAttribute("successMsg", "Book deleted Successfully");
		return "redirect:/admin/all";
	}
	
	@PutMapping("/admin/update")
	public String updateBook(@ModelAttribute("guestBook") GuestBook book, Model model) {
		guestBookRepository.save(book);
		model.addAttribute("successMsg", "Book Updated Successfully");
		return "redirect:/admin/all";
	}
	
	@GetMapping("/add")
	public String getBook(Model model) {
		model.addAttribute("guestBook", new GuestBook());
		return "createBook";
	}
	
	@PostMapping("/save")
	public String addBook(@ModelAttribute("guestBook") GuestBook book, Model model) {
		guestBookRepository.save(book);
		model.addAttribute("successMsg", "Book Saved Successfully");
		List<GuestBook> myBooks = guestBookRepository.findByCreatedBy("venkat"); // Need to replace
		model.addAttribute("myBooks", myBooks);
		return "myBooks";
	}
	
	@GetMapping("/image")
	public void getImage(Long id, HttpServletResponse response) throws IOException, SQLException {
        //store image in browser cache
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        response.setHeader("Cache-Control", "max-age=2628000");

        //obtaining bytes from DB
        Optional<GuestBook> optionalBook = guestBookRepository.findById(id);
        Blob imageData = optionalBook.get().getFile();

        //write result to http response
        try (OutputStream out = response.getOutputStream()) {
            out.write(imageData.getBinaryStream().read());
        }
} 
}
