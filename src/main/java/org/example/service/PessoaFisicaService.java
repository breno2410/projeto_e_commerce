package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.example.interfaces.IService;
import org.example.model.PessoaFisica;
import org.example.repository.PessoaFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service //indica camada de serviço/negócio
public class PessoaFisicaService implements IService<PessoaFisica, Integer> {

    @Autowired //injeção de dependência
    private PessoaFisicaRepository PessoaFisicaRepository;

    @Override
    @Transactional
    public PessoaFisica create(PessoaFisica entity) {
        log.info("Acessando método PessoaFisicaService.create");
        log.debug("Valores recebidos: {}", entity);

        return PessoaFisicaRepository.save(entity);
    }

    @Override
    public List<PessoaFisica> read() {
        log.info("Acessando método PessoaFisicaResource.read()");

        List<PessoaFisica> lista = PessoaFisicaRepository.findAll();

        log.debug("Resultado da consulta: {} registros", lista.size());

        return lista;
    }

    @Override
    public PessoaFisica read(Integer id) {
        log.info("Acessando método PessoaFisicaResource.read(id)");
        log.debug("Valores recebidos: id = {}", id);
        //PessoaFisica PessoaFisicaEncontrado = PessoaFisicaRepository.findById(id);
        log.debug("Resultado da consulta: {} registros", 0);
        return null;
    }

    @Override
    @Transactional
    public PessoaFisica update(Integer id, PessoaFisica entity) {
        log.info("Acessando método PessoaFisicaService.update");
        log.debug("Valores recebidos - id: {}, entity: {}", id, entity);


        Optional<PessoaFisica> PessoaFisicaEncontrado = PessoaFisicaRepository.findById(id);
        if(PessoaFisicaEncontrado.isPresent()){
            PessoaFisicaRepository.save(entity);
        }

        return null;
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        log.info("Acessando método delete");
        log.info("Valor recebido: {id}", id);

    }
}
