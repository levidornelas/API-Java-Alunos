package spring_web.API_alunos.DTOS;

public class AlunoDTO {
    private Long id;
    private String nome;
    private String email;
    private String cpf;


    public AlunoDTO(){}

    public AlunoDTO(String cpf, String email, Long id, String nome) {
        this.cpf = cpf;
        this.email = email;
        this.id = id;
        this.nome = nome;
    }

    public AlunoDTO(Long id, String nome, String email, String cpf) {
    }

    @Override
    public String toString() {
        return "AlunoDto{" +
                "cpf='" + cpf + '\'' +
                ", id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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
