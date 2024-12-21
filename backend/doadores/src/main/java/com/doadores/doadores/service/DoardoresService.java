package com.doadores.doadores.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.doadores.doadores.entity.Doador;
import com.doadores.doadores.repository.DoadoresRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Service para a entidade Doador.
 */
@Service
public class DoardoresService {

    /**
     * Repository para utilização dos métodos dentro do Service.
     */
    @Autowired
    private DoadoresRepository doadoresRepository;

    /**
     * Salva o Doador na base de dados.
     * 
     * @param doador
     *   O Doador que deve ser inserido na base de dados.
     * @return
     *   Os dados do Doador inserido.
     */
    public Doador salvar(Doador doador) {
        return doadoresRepository.save(doador);
    }

    /**
     * Retorna uma lista com todos os Doadores cadastrados.
     *
     * @return
     *   Uma lista com todos os Doadores cadastrados.
     */
    public List<Doador> getTodosDoadores() {
        return doadoresRepository.findAll();
    }

    /**
     * Retorna um Doador com base do ID informado.
     *
     * @param id
     *   ID do Doador.
     * @return
     *   O Doador com base do ID informado.
     */
    public Optional<Doador> getDoador(Long id) {
        return doadoresRepository.findById(id);
    }

    /**
     * Exclui o Doador com base do ID informado.
     * 
     * @param id
     *   ID do Doador.
     */
    public void excluir(Long id) {
        doadoresRepository.deleteById(id);
    }

    /**
     * Realiza a importação de um arquivo JSON, contendo os Doadores.
     *
     * @param file
     *   O arquivo com as informações.
     *
     * @throws IOException Uma exceção ao tentar acessar o arquivo.
     */
    public void importaJson(MultipartFile file) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Doador[] doadores = mapper.readValue(file.getInputStream(), Doador[].class);
        for (Doador doador : doadores) {
            salvar(doador);
        }
    }
}
