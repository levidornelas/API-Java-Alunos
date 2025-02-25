import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring_web.API_alunos.service.AlunoService;

@SpringBootTest
public class AlunoTeste {
    @Autowired
    AlunoService alunoService;

}
