
package es.iesfranciscodelosrios.entidad;


import javax.persistence.*;

@Entity
@Table(name = "notas")
public class Nota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", nullable = false, length = 30)
    private String titulo;

    @Column(name = "texto", nullable = false, length = 200)
    private String texto;

    //Obligatorio constructor por defecto
    public Nota() {
    }

    public Nota(Long id, String titulo, String texto)
    {
        this.id = id;
        this.titulo = titulo;
        this.texto = texto;
    }

    public Nota(String titulo, String texto)
    {
        this.titulo = titulo;
        this.texto = texto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
            return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
