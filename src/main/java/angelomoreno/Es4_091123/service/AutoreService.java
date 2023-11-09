package angelomoreno.Es4_091123.service;

import angelomoreno.Es4_091123.entities.Autore;
import angelomoreno.Es4_091123.exceptions.BadRequestException;
import angelomoreno.Es4_091123.exceptions.NotFoundException;
import angelomoreno.Es4_091123.payloads.aurori.NewAutoreDTO;
import angelomoreno.Es4_091123.repositories.AutoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
@Service
public class AutoreService {
    @Autowired
    private AutoreRepository autoreRepo;

    public Autore save(NewAutoreDTO body) throws IOException {
        autoreRepo.findByEmail(body.email()).ifPresent(autore -> {
            throw new BadRequestException("L'email " + autore.getEmail() + " è gia utilizzata da qualcun altro. Provane un'altra");
        });

        Autore autore = new Autore();
        autore.setNome(body.nome());
        autore.setCognome(body.cognome());
        autore.setEmail(body.email());
        autore.setDataDiNascita(body.dataDiNascita());
        return autoreRepo.save(autore);
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
