package ps2.restapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class DisciplinaController {

	private List<Disciplina> disciplinas;

	public DisciplinasController() {
		this.disciplinas = new ArrayList<>();
		disciplinas.add(new Professor(1, "Desenvolvimento", "Ds", "Sis. de info", 2));
	}

	@GetMapping("/api/disciplinas")
	Iterable<Disciplina> getDisciplinas() {
		return this.disciplinas;
	}
	
	@GetMapping("/api/disciplinas/{id}")
	Optional<Disciplina> getDisciplinas(@PathVariable long id) {
		for (Disciplina d: disciplinas) {
			if (d.getId() == id) {
				return Optional.of(d);
			}
		}
		return Optional.empty();
	}
	
	@PostMapping("/api/disciplinas")
	Disciplina createDisciplina(@RequestBody Disciplina d) {
		long maxId = 1;
		for (Disciplina disci: disciplinas) {
			if (disci.getId() > maxId) {
				maxId = disci.getId();
			}
		}
		d.setId(maxId+1);
		disciplinas.add(d);
		return d;
	}
	
	@PutMapping("/api/disciplinas/{disciplinaId}")
	Optional<Disciplina> updadeDisciplina(@RequestBody Disciplina disciplinaRequest, @PathVariable long disciplinaId) {
		Optional<Disciplina> opt = this.getDisciplina(disciplinaId);
		if (opt.isPresent()) {
			Disciplina disciplina = opt.get();
			disciplina.setNome(disciplinaRequest.getNome());
			disciplina.setMatricula(disciplinaRequest.getMatricula());
			disciplina.setArea(disciplinaRequest.getArea());
		}

		return opt;				
	}	
	
	@DeleteMapping(value = "/api/disciplinas/{id}")
	void deleteDisciplina(@PathVariable long id) {
		disciplinas.removeIf(p -> p.getId() == id);
	}		
}


