package com.jvl.jvlbank.controller.client;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jvl.jvlbank.dto.client.ClientCreateDTO;
import com.jvl.jvlbank.dto.client.ClientResponseDTO;
import com.jvl.jvlbank.dto.client.ClientUpdateAddressDTO;
import com.jvl.jvlbank.service.client.ClientService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;




// Indica que esta classe é um controller REST e vai tratar requisições HTTP
@RestController

// Define o caminho base para todos os endpoints deste controller (ex: /clients)
@RequestMapping("/clients")

// Lombok: cria um construtor com os atributos marcados como 'final' (injeção de dependência)
@RequiredArgsConstructor
public class ClientController {

    //injeção do serviço que contém a lógica de negócio para mamnipular clientes
    private final ClientService clientService;

    /**
    * Endpoint para criar um novo cliente.
    * Método POST usado para criação.
    * Recebe um objeto ClientCreateDTO no corpo da requisição.
    * @param dto - dados de entrada validados com @Valid
    * @return ResponseEntity com status 201 e o DTO de resposta
    */
    @PostMapping
    public ResponseEntity<ClientResponseDTO> create(@valid @RequestBody ClientCreateDTO dto) {
        //cria o cliente e retorna com status 201(created)
        ClientResponseDTO createdClient = clientService.create(dto);       
        return ResponseEntity.created(
            //Define o header 'Location' apontando para o novo recurso criado
            //ex: /clients/1
            //futuramente criar uma utilidade para gerar essa URI
            //esse é um exemplo simples
            java.net.URI.create("/clients/"+createdClient.getId())
        ).body(createdClient);
    }

    /**
    * Endpoint para buscar um cliente por ID.
    * Método GET com o ID no caminho da URL.
    * @param id - identificador do cliente
    * @return DTO do cliente encontrado
    */
    @GetMapping("/{id}")    
    public ResponseEntity<ClientResponseDTO> getById(@PathVariable Long id) {
        return clientService.findById(id)
            .map(ResponseEntity::ok)//se existir, retorna 200 com o DTO
            .orElse(ResponseEntity.notFound().build());//se não, 404
    }
    
    /**
     * Endpoint para listar todos os clientes cadastrados.
     * Método GET sem parâmetros.
     * @return Lista de DTOs de todos os clientes 
     */
    @GetMapping("path")
    public ResponseEntity<List<ClientResponseDTO>> getAll() {
        return ResponseEntity.ok(clientService.getAll());
    }

    /**
     * Endpoint para atualizar apenas o endereço de um cliente. 
     * Método PATCH usado para atualizações parciais.  
     * @param id - identificador do cliente
     * @param dto - novo endereço (validado)
     */
    @PatchMapping("/{id}/address")
    public ResponseEntity<Void> updateAddress(
        @PathVariable Long id,
        @Valid @RequestBody ClientUpdateAddressDTO dto
    ){
        clientService.updateAddress(id, dto);
        return ResponseEntity.noContent().build(); //retorna 204(sem conteudo)
    }
    
    /**
     * Endpoint para excluir um cliente pelo ID.  
     * Método DELETE remove o cliente do sistema.  
     * @param id - identificador do cliente
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        clientService.delete(id);
        return ResponseEntity.noContent().build(); //Retorno 204 (sem conteudo)
    }







    // public ClientController(ClientService clientService){
    //     this.clientService = clientService;
    // }

    // @PostMapping
    // public ClientCreateDTO create(@RequestBody String entity) {
    //     //TODO: process POST request
        
    //     return entity;
    // }
    



    // @PatchMapping("/{id}/address")
    // public void updateAddress(@PathVariable Long id, @RequestBody String newAddress) {
    //     clientService.updateAddress(id, newAddress);
    // }


}
