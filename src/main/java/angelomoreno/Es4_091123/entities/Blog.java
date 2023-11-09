package angelomoreno.Es4_091123.entities;

import angelomoreno.Es3_081123.enums.Categoria;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "blogs")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Categoria categoria;
    private String titolo;
    private String contenuto;
    private long minutiLettura;
    @ManyToOne
    @JoinColumn(name = "autore", nullable = false)
    private Autore autore;
}
