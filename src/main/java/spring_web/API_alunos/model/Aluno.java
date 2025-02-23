package spring_web.API_alunos.model;
import jakarta.persistence.*;

@Entity
@Table(name = "Alunos1")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alunos", nullable = false)
    private Long id;

    @Column(name = "aluno_nome")
    private String nome;

    @Column(name = "email", unique = true)
    private String email;

    @Override
    public String toString() {
        return "Alunos{" +
                "email='" + email + '\'' +
                ", id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
