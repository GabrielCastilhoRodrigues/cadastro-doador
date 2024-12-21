package com.doadores.doadores.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.doadores.doadores.entity.Doador;
import com.doadores.doadores.service.DoacaoService;
import com.doadores.doadores.service.DoardoresService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Controller para o Doador.
 */
@RestController
@RequestMapping("/doadores")
public class DoadoresController {

    @Autowired
    private DoardoresService doadoresService;

    @Autowired
    private DoacaoService doacaoService;

    /**
     * Método POST para inserir um Doador.
     *
     * @param doador
     *   O Body do Doador.
     * @return
     *   Os dados inseridos do Doador.
     */
    @PostMapping({ "", "/" })
    public Doador salvar(@RequestBody Doador doador) {
        try {
            return doadoresService.salvar(doador);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Método GET para retornar todos os Doadores.
     *
     * @return
     *   Lista com todos os Doadores.
     */
    @GetMapping({ "", "/" })
    public List<Doador> getTodosDoadores() {
        try {
            return doadoresService.getTodosDoadores();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    /**
     * Método GET/id para retornar o Doador que possua o ID informado.
     *
     * @param id
     *   ID do Doador.
     * @return
     *   Os dados do Doador.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Doador> getDoadorById(@PathVariable Long id) {
        try {
            Doador doador = doadoresService.getDoador(id).orElse(null);

            if (doador == null) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok(doador);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Método DELETE, que deleta o Doador com base do ID.
     *
     * @param id
     *   ID do Doador.
     * @return
     *   Mensagem de conclusão/erro do processamento.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        try {
            doadoresService.excluir(id);
            return new ResponseEntity<String>("Removido com sucesso",
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("Não foi possível remover a entidade",
                    HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Método POST, que recebe um arquivo JSON para realizar a importação dos dados do arquivo para
     * a base de dados.
     *
     * @param file
     *   Arquivo JSON com as informações esperadas.
     * @return
     *   Se a operação foi concluída com sucesso.
     */
    @PostMapping("/importar")
    public ResponseEntity<Void> importarJson(@RequestParam("file") MultipartFile file) {
        try {
            doadoresService.importaJson(file);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/doacao")
    public ResponseEntity<String> realizaDoacao(@RequestParam("doador") Long idDoador,
        @RequestParam("receptor") Long idReceptor) {
        try {
            boolean isDoacaoValida = doacaoService.validarDoacao(idDoador, idReceptor);

            if (isDoacaoValida) {
                return new ResponseEntity<String>("Doação realizada com sucesso",
                        HttpStatus.OK);
            }

            return new ResponseEntity<String>("Doação não é válida", HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
