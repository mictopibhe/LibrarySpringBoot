package pl.davidduke.LibraryBoot.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.davidduke.LibraryBoot.models.Book;
import pl.davidduke.LibraryBoot.models.Person;
import pl.davidduke.LibraryBoot.services.BooksService;
import pl.davidduke.LibraryBoot.services.PeopleService;

import javax.validation.Valid;


@Controller
@RequestMapping("/books")
public class BooksController {

    //private final PeopleService peopleService;
    private final BooksService booksService;

    @Autowired
    public BooksController(BooksService bookService, PeopleService peopleService) {
        this.booksService = bookService;
    //    this.peopleService = peopleService;
    }


    @GetMapping()
    public String bookIndex(Model model) {
        model.addAttribute("books", booksService.findAll());
        return "books/index";
    }

    @GetMapping("/{id}")
    public String showBook(@PathVariable("id") int id, Model model, @ModelAttribute("person") Person person) {
        model.addAttribute("book", booksService.findBook(id));

//        Optional<Person> bookOwner = bookDAO.getBookOwner(id);
//
//
//        if(bookOwner.isPresent()) {
//            model.addAttribute("owner", bookOwner.get());
//        } else {
//            model.addAttribute("people", personDAO.index());
//        }
        return "books/show";
    }

    @GetMapping("/new")
    public String newBook(@ModelAttribute("book")Book book) {
        return "books/new";
    }

    @PostMapping()
    public String createBook(@ModelAttribute("book") @Valid Book book,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "books/new";

        booksService.save(book);
        return "redirect:/books";
    }

    @GetMapping("/{id}/edit")
    public String editBook(Model model, @PathVariable("id") int id) {
        model.addAttribute("book", booksService.findBook(id));
        return "/books/edit";
    }

    @PatchMapping("/{id}")
    public String updateBook (@ModelAttribute("book") @Valid Book book,
                              BindingResult bindingResult, @PathVariable("id") int id){

        if (bindingResult.hasErrors())
            return "/books/edit";

        booksService.update(id, book);
        return "redirect:/books";
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable("id") int id) {
        booksService.delete(id);
        return "redirect:/books";
    }

//    @PatchMapping("/{id}/assign")
//    public String assignBook (@ModelAttribute("person") Person selecteedPerson, @PathVariable("id") int id){
//
//        bookDAO.assign(id, selecteedPerson);
//        return "redirect:/books/" + id;
//    }
//
//    @PatchMapping("/{id}/release")
//    public String releaseBook(@PathVariable("id") int id) {
//        bookDAO.release(id);
//        return "redirect:/books/" + id;
//    }

}
