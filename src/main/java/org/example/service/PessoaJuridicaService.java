package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.example.interfaces.IService;
import org.example.model.PessoaJuridica;
import org.example.repository.PessoaJuridicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service //indica camada de serviço/negócio
public class PessoaJuridicaService implements IService<PessoaJuridica, Integer> {

    @Autowired //injeção de dependência
    private PessoaJuridicaRepository PessoaJuridicaRepository;

    @Override
    @Transactional
    public PessoaJuridica create(PessoaJuridica entity) {
        log.info("Acessando método PessoaJuridicaService.create");
        log.debug("Valores recebidos: {}", entity);

        return PessoaJuridicaRepository.save(entity);
    }

    @Override
    public List<PessoaJuridica> read() {
        log.info("Acessando método PessoaJuridicaResource.read()");

        List<PessoaJuridica> lista = PessoaJuridicaRepository.findAll();

        log.debug("Resultado da consulta: {} registros", lista.size());

        return lista;
    }

    @Override
    public PessoaJuridica read(Integer id) {
        log.info("Acessando método PessoaJuridicaResource.read(id)");
        log.debug("Valores recebidos: id = {}", id);
        //PessoaJuridica PessoaJuridicaEncontrado = PessoaJuridicaRepository.findById(id);
        log.debug("Resultado da consulta: {} registros", 0);
        return null;
    }

    @Override
    @Transactional
    public PessoaJuridica update(Integer id, PessoaJuridica entity) {
        log.info("Acessando método PessoaJuridicaService.update");
        log.debug("Valores recebidos - id: {}, entity: {}", id, entity);


        Optional<PessoaJuridica> PessoaJuridicaEncontrado = PessoaJuridicaRepository.findById(id);
        if(PessoaJuridicaEncontrado.isPresent()){
            PessoaJuridicaRepository.save(entity);
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
