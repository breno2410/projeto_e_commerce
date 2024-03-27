package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.example.interfaces.IService;
import org.example.model.Contato;
import org.example.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service //indica camada de serviço/negócio
public class ContatoService implements IService<Contato, Integer> {

    @Autowired //injeção de dependência
    private ContatoRepository ContatoRepository;

    @Override
    @Transactional
    public Contato create(Contato entity) {
        log.info("Acessando método ContatoService.create");
        log.debug("Valores recebidos: {}", entity);

        return ContatoRepository.save(entity);
    }

    @Override
    public List<Contato> read() {
        log.info("Acessando método ContatoResource.read()");

        List<Contato> lista = ContatoRepository.findAll();

        log.debug("Resultado da consulta: {} registros", lista.size());

        return lista;
    }

    @Override
    public Contato read(Integer id) {
        log.info("Acessando método ContatoResource.read(id)");
        log.debug("Valores recebidos: id = {}", id);
        //Contato ContatoEncontrado = ContatoRepository.findById(id);
        log.debug("Resultado da consulta: {} registros", 0);
        return null;
    }

    @Override
    @Transactional
    public Contato update(Integer id, Contato entity) {
        log.info("Acessando método ContatoService.update");
        log.debug("Valores recebidos - id: {}, entity: {}", id, entity);


        Optional<Contato> ContatoEncontrado = ContatoRepository.findById(id);
        if(ContatoEncontrado.isPresent()){
            ContatoRepository.save(entity);
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
