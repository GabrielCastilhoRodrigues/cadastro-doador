package com.doadores.doadores.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doadores.doadores.entity.Doador;
import com.doadores.doadores.entity.TipoSanguineo;
import com.doadores.doadores.repository.DoadoresRepository;

@Service
public class DoacaoService {

    @Autowired
    private DoadoresRepository doadoresRepository;

    public boolean validarDoacao(Long doadorId, Long receptorId) {
        Doador doador = doadoresRepository.findById(doadorId)
                .orElseThrow(() -> new IllegalArgumentException("Doador não encontrado"));
        Doador receptor = doadoresRepository.findById(receptorId)
                .orElseThrow(() -> new IllegalArgumentException("Receptor não encontrado"));

        TipoSanguineo tipoDoador = doador.getTipo_Sanguineo();
        TipoSanguineo tipoReceptor = receptor.getTipo_Sanguineo();

        return tipoDoador.podeDoarPara(tipoReceptor);
    }
}
