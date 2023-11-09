package angelomoreno.Es4_091123.controllers;

import angelomoreno.Es3_081123.entities.Autore;
import angelomoreno.Es3_081123.service.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autori")
public class AutoreController {
    @Autowired
    private AutoreService autoreService;

    @GetMapping("")
    public List<Autore> getAutores() {
        return autoreService.getAutores();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Autore saveAutore(@RequestBody Autore body){
        return autoreService.save(body);
    }

    @GetMapping("/{id}")
    public Autore findById(@PathVariable long id){
        return autoreService.findById(id);
    }

    @PutMapping("/{id}")
    public Autore modifyAutore(@PathVariable long id, @RequestBody Autore body){
        return autoreService.modifyAutore(id, body);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAutore(@PathVariable long id) {
        autoreService.deleteAutore(id);
    }
}
