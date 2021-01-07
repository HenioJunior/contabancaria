package com.crystaldata.contabancaria.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crystaldata.contabancaria.DTO.ClienteDTO;
import com.crystaldata.contabancaria.entities.Cliente;
import com.crystaldata.contabancaria.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	public ClienteRepository repository;
	
	@Transactional(readOnly = true)
	public List<ClienteDTO> findAll(){
		List<Cliente> list = repository.findAll();
		return list.stream().map(x -> new ClienteDTO(x)).collect(Collectors.toList());
	}
}
