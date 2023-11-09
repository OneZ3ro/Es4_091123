package angelomoreno.Es4_091123.controllers;

import angelomoreno.Es4_091123.entities.Autore;
import angelomoreno.Es4_091123.exceptions.BadRequestException;
import angelomoreno.Es4_091123.payloads.aurori.NewAutoreDTO;
import angelomoreno.Es4_091123.service.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
    public Autore saveAutore(@RequestBody @Validated NewAutoreDTO body, BindingResult validation){
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors());
        } else {
            return autoreService.save(body);
        }
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
