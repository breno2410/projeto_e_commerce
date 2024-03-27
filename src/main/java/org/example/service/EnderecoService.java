package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.example.interfaces.IService;
import org.example.model.Endereco;
import org.example.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service //indica camada de serviço/negócio
public class EnderecoService implements IService<Endereco, Integer> {

    @Autowired //injeção de dependência
    private EnderecoRepository EnderecoRepository;

    @Override
    @Transactional
    public Endereco create(Endereco entity) {
        log.info("Acessando método EnderecoService.create");
        log.debug("Valores recebidos: {}", entity);

        return EnderecoRepository.save(entity);
    }

    @Override
    public List<Endereco> read() {
        log.info("Acessando método EnderecoResource.read()");

        List<Endereco> lista = EnderecoRepository.findAll();

        log.debug("Resultado da consulta: {} registros", lista.size());

        return lista;
    }

    @Override
    public Endereco read(Integer id) {
        log.info("Acessando método EnderecoResource.read(id)");
        log.debug("Valores recebidos: id = {}", id);
        //Endereco EnderecoEncontrado = EnderecoRepository.findById(id);
        log.debug("Resultado da consulta: {} registros", 0);
        return null;
    }

    @Override
    @Transactional
    public Endereco update(Integer id, Endereco entity) {
        log.info("Acessando método EnderecoService.update");
        log.debug("Valores recebidos - id: {}, entity: {}", id, entity);


        Optional<Endereco> EnderecoEncontrado = EnderecoRepository.findById(id);
        if(EnderecoEncontrado.isPresent()){
            EnderecoRepository.save(entity);
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
