package com.example.jpah2demo;

import com.example.jpah2demo.entities.Cliente;
import com.example.jpah2demo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping("/addClient")
    public ResponseEntity<Cliente> addClient(@RequestBody Cliente cliente) {
        cliente.getTelefones().forEach(telefone -> telefone.setCliente(cliente));
        cliente.getEnderecos().forEach(endereco -> endereco.setCliente(cliente));
        Cliente clienteRegistrado = clienteRepository.save(cliente);

        return ResponseEntity.status(HttpStatus.CREATED).body(clienteRegistrado);
    }

    @GetMapping("/findAllClients")
    public ResponseEntity<List<Cliente>> findAllClients() {
        List<Cliente> clientes = clienteRepository.findAll();
        return ResponseEntity.ok().body(clientes);
    }

    @GetMapping("/findClientById/{id}")
    public ResponseEntity<Cliente> findClientById(@PathVariable("id") Long idClient) {
        if (clienteRepository.findById(idClient).isPresent())
            return ResponseEntity.ok().body(clienteRepository.findById(idClient).get());
        return ResponseEntity.ok().body(null);
    }

    @DeleteMapping("/removeClientById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerCliente(@PathVariable("id") Long idClient) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(idClient);

        clienteOptional.ifPresent(cliente -> clienteRepository.delete(cliente));
    }

    @PutMapping("/updateClientById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCliente(@PathVariable("id") Long id, @RequestBody Cliente cliente) {
        if (clienteRepository.findById(id).isPresent()) {
            cliente.getTelefones().forEach(telefone -> telefone.setCliente(cliente));
            cliente.getEnderecos().forEach(endereco -> endereco.setCliente(cliente));
            clienteRepository.save(cliente);
        }
    }
}
