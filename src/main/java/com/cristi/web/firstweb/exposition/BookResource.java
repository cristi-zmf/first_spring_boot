package com.cristi.web.firstweb.exposition;

import com.cristi.web.firstweb.domain.Book;
import com.cristi.web.firstweb.domain.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/")
public class BookResource {

    private Books books;

    @Autowired
    public BookResource(
            Books books) {
        this.books = books;
    }

    @RequestMapping(value="/{reader}", method= RequestMethod.GET)
    public String readersBooks(
            @PathVariable("reader") String reader,
            Model model) {

        Set<Book> readingList = books.findByReader(reader);
        if (readingList != null) {
            model.addAttribute("books", readingList);
        }
        return "readingList";
    }

    @RequestMapping(value="/{reader}", method=RequestMethod.POST)
    public String addToReadingList(
            @PathVariable("reader") String reader, Book book) {
        Book modified = new Book(reader, book);
        books.add(modified);
        return "redirect:/{reader}";
    }
}
