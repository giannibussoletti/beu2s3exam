package gianni_bussoletti.beu2s3exam.services;

import gianni_bussoletti.beu2s3exam.DTO.EventoDTO;
import gianni_bussoletti.beu2s3exam.entites.CreatoreEventi;
import gianni_bussoletti.beu2s3exam.entites.Evento;
import gianni_bussoletti.beu2s3exam.repositories.EventoRepository;
import gianni_bussoletti.beu2s3exam.security.TokenTools;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EventoService {

    private EventoRepository eventoRepository;
    private TokenTools tools;


    public Evento save(EventoDTO body, CreatoreEventi creatoreEventi) {
        Evento newEvento = new Evento(body.nome(), body.descrizione(), body.descrizione(), body.data(), body.postiDisponibili(), creatoreEventi);
        return this.eventoRepository.save(newEvento);
    }

    public Page<Evento> findAllEventi(int page, int size, String orderBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(orderBy));
        return this.eventoRepository.findAll(pageable);
    }
}
