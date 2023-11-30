package learning.app.Backend.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import learning.app.Backend.entites.Commentary;
import learning.app.Backend.enums.TypeCommentary;
import learning.app.Backend.service.CommentaryService;

@RestController
@RequestMapping(path = "commentary", produces = APPLICATION_JSON_VALUE)
public class CommentaryController {

    private CommentaryService commentaryService;

    public CommentaryController(CommentaryService commentaryService) {
        this.commentaryService = commentaryService;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void create(@RequestBody Commentary commentary){
        this.commentaryService.create(commentary);
    }

    @GetMapping(path="{id}",produces = APPLICATION_JSON_VALUE)
    public Commentary read(@PathVariable int id){
        return this.commentaryService.read(id);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Commentary> read(@RequestParam(required = false) TypeCommentary type){
        return this.commentaryService.find(type);
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @PutMapping(path = "{id}", consumes = APPLICATION_JSON_VALUE)
    public void modify(@PathVariable int id, @RequestBody Commentary commentary){
        this.commentaryService.modify(id, commentary);
    }

    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @DeleteMapping(path="{id}",produces = APPLICATION_JSON_VALUE)
    public void delete(@PathVariable int id){
        this.commentaryService.delete(id);
    }
}
