package br.com.itau.challenge.controllers;

import br.com.itau.challenge.controllers.request.AutomovelRequest;
import br.com.itau.challenge.controllers.response.AutomovelResponse;
import br.com.itau.challenge.domain.Automovel;
import br.com.itau.challenge.services.AutomovelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AutomovelController {

    private final AutomovelService automovelService;

    public AutomovelController(AutomovelService automovelService) {
        this.automovelService = automovelService;
    }

    @PostMapping("/cadastroAutomoveis")
    public ResponseEntity<AutomovelResponse> criaAutomovel(@RequestBody AutomovelRequest automovelRequest) {
        Automovel automovel = automovelService.criaAutomovel(automovelRequest.toDomain());

        AutomovelResponse automovelResponse = AutomovelResponse.fromDomain(automovel);

        return new ResponseEntity<>(automovelResponse, HttpStatus.CREATED);
    }

    @GetMapping("/automoveis")
    public ResponseEntity<List<AutomovelResponse>> buscaAutomoveis() {
        List<Automovel> automoveis = automovelService.listaAutomoveis();

        List<AutomovelResponse> automoveisResponse = automoveis
                .stream()
                .map(AutomovelResponse::fromDomain)
                .toList();

        return new ResponseEntity<>(automoveisResponse, HttpStatus.OK);
    }
}
