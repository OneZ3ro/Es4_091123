package angelomoreno.Es4_091123.service;

import angelomoreno.Es3_081123.entities.Autore;
import angelomoreno.Es3_081123.exceptions.BadRequestException;
import angelomoreno.Es3_081123.exceptions.NotFoundException;
import angelomoreno.Es3_081123.repositories.AutoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AutoreService {
    @Autowired
    private AutoreRepository autoreRepo;

    public Autore save(Autore body) {
        autoreRepo.findByEmail(body.getEmail()).ifPresent(autore -> {
            throw new BadRequestException("L'email " + autore.getEmail() + " è gia utilizzata da qualcun altro. Provane un'altra");
        });
        return autoreRepo.save(body);
    }

    public List<Autore> getAutores() {
        return autoreRepo.findAll();
    }

    public Autore findById(long id) {
        return autoreRepo.findById(id).orElseThrow(() -> new NotFoundException("Non è stato trovato nessun autore con id " + id));
    }

    public Autore modifyAutore(long id, Autore body) {
        for (Autore autore : autoreRepo.findAll()) {
            if (autore.getId() == id) {
                autore.setNome(body.getNome());
                autore.setCognome(body.getCognome());
                autore.setEmail(body.getEmail());
                autore.setDataDiNascita(body.getDataDiNascita());
                return autoreRepo.save(autore);
            }
        }
        throw new NotFoundException(("Non è stato trovato nessun autore con id " + id));
    }

    public void deleteAutore(long id) {
        autoreRepo.delete(this.findById(id));
    }
}
