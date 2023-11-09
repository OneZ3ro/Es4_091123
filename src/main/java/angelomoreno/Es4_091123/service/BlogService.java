package angelomoreno.Es4_091123.service;

import angelomoreno.Es3_081123.entities.Blog;
import angelomoreno.Es3_081123.exceptions.NotFoundException;
import angelomoreno.Es3_081123.repositories.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepo;

    public Blog save(Blog body) {
        return blogRepo.save(body);
    }

    public List<Blog> getBlogs() {
        return blogRepo.findAll();
    }

    public Blog findById(long id) {
        return blogRepo.findById(id).orElseThrow(() ->  new NotFoundException("Non è stato trovato nessun autore con id " + id));
    }

    public Blog modifyBlog(long id, Blog body) {
        for (Blog blog : blogRepo.findAll()) {
            if (blog.getId() == id) {
                blog.setCategoria(body.getCategoria());
                blog.setTitolo(body.getTitolo());
                blog.setContenuto(body.getContenuto());
                blog.setMinutiLettura(body.getMinutiLettura());
                blog.setAutore(body.getAutore());
                return blogRepo.save(blog);
            }
        }
        throw new NotFoundException("Non è stato trovato nessun autore con id " + id);
    }

    public void deleteBlog(long id) {
        blogRepo.delete(this.findById(id));
    }
}
