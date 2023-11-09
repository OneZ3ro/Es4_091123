package angelomoreno.Es4_091123.controllers;

import angelomoreno.Es4_091123.entities.Blog;
import angelomoreno.Es4_091123.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("")
    public List<Blog> getBlogs() {
        return blogService.getBlogs();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Blog saveBlog(@RequestBody Blog body){
        return blogService.save(body);
    }

    @GetMapping("/{id}")
    public Blog findById(@PathVariable long id){
        return blogService.findById(id);
    }

    @PutMapping("/{id}")
    public Blog modifyBlog(@PathVariable long id, @RequestBody Blog body){
        return blogService.modifyBlog(id, body);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBlog(@PathVariable long id) {
        blogService.deleteBlog(id);
    }
}
