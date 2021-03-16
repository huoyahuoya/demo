package com.example.demo.readinglist;

import com.example.demo.aspect.LogCollection;
import com.example.demo.aspect.WzcgLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/reading")
public class ReadingListController {

    //private ReadingListRepository readingListRepository;
    /*@Autowired
    public ReadingListController(
            ReadingListRepository readingListRepository) {
        this.readingListRepository = readingListRepository;
    }*/

    /*@RequestMapping(value="/{reader}", method= RequestMethod.GET)
    public String readersBooks(
            @PathVariable("reader") String reader,
            Model model) {
        List<Book> readingList =
                readingListRepository.findByReader(reader);
        if (readingList != null) {
            model.addAttribute("books", readingList);
        }
        return "readingList";
    }
    @RequestMapping(value="/{reader}", method=RequestMethod.POST)
    public String addToReadingList(
            @PathVariable("reader") String reader, Book book) {
        book.setReader(reader);
        readingListRepository.save(book);
        return "redirect:/{reader}";
    }*/

    @RequestMapping("/aaa")
    @ResponseBody
    public String aaa(){
        return "reader";
    }

    @RequestMapping("/bbb")
    public String bbb(){
        return "reader.html";
    }

    @RequestMapping("/test-aspect1")
    @ResponseBody
    @WzcgLog(opsValue = "test1", remarkField = "test2")
    public String ccc(
            @RequestParam("id1") String id1,
            @RequestParam("id2") String id2,
            @RequestParam("id3") String id3
    ){
        return "reader";
    }

    @RequestMapping("/test-aspect2")
    @ResponseBody
    @LogCollection
    public String ddd(
            @RequestParam("id1") String id1,
            @RequestParam("id2") String id2,
            @RequestParam("id3") String id3
    ){
        return "test_ddd";
    }
}
