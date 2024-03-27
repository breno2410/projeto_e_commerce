package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.example.interfaces.IService;
import org.example.model.Telefone;
import org.example.repository.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service //indica camada de serviço/negócio
public class TelefoneService implements IService<Telefone, Integer> {

    @Autowired //injeção de dependência
    private TelefoneRepository TelefoneRepository;

    @Override
    @Transactional
    public Telefone create(Telefone entity) {
        log.info("Acessando método TelefoneService.create");
        log.debug("Valores recebidos: {}", entity);

        return TelefoneRepository.save(entity);
    }

    @Override
    public List<Telefone> read() {
        log.info("Acessando método TelefoneResource.read()");

        List<Telefone> lista = TelefoneRepository.findAll();

        log.debug("Resultado da consulta: {} registros", lista.size());

        return lista;
    }

    @Override
    public Telefone read(Integer id) {
        log.info("Acessando método TelefoneResource.read(id)");
        log.debug("Valores recebidos: id = {}", id);
        //Telefone TelefoneEncontrado = TelefoneRepository.findById(id);
        log.debug("Resultado da consulta: {} registros", 0);
        return null;
    }

    @Override
    @Transactional
    public Telefone update(Integer id, Telefone entity) {
        log.info("Acessando método TelefoneService.update");
        log.debug("Valores recebidos - id: {}, entity: {}", id, entity);


        Optional<Telefone> TelefoneEncontrado = TelefoneRepository.findById(id);
        if(TelefoneEncontrado.isPresent()){
            TelefoneRepository.save(entity);
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
