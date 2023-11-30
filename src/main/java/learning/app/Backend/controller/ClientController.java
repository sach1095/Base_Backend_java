package learning.app.Backend.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import learning.app.Backend.entites.Client;
import learning.app.Backend.service.ClientService;

@RestController
@RequestMapping(path = "client")
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void create(@RequestBody Client client){ this.clientService.create(client); }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Client> find(){
        return this.clientService.find();
    }

    @GetMapping(path="{id}",produces = APPLICATION_JSON_VALUE)
    public Client read(@PathVariable int id){
        return this.clientService.read(id);
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @PutMapping(path = "{id}", consumes = APPLICATION_JSON_VALUE)
    public void modify(@PathVariable int id, @RequestBody Client client){
        this.clientService.modify(id, client);
    }
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @DeleteMapping(path="{id}",produces = APPLICATION_JSON_VALUE)
    public void delete(@PathVariable int id){
        this.clientService.delete(id);
    }
}

