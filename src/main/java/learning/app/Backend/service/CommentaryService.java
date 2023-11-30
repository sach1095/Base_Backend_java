package learning.app.Backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import learning.app.Backend.entites.Client;
import learning.app.Backend.entites.Commentary;
import learning.app.Backend.enums.TypeCommentary;
import learning.app.Backend.repository.CommentaryRepository;

@Service
public class CommentaryService {

    private ClientService clientService;
    private CommentaryRepository commentaryRepository;

    public CommentaryService(ClientService clientService, CommentaryRepository commentaryRepository) {
        this.clientService = clientService;
        this.commentaryRepository = commentaryRepository;
    }

    public void create(Commentary commentary){
        Client client = this.clientService.readOrCreate(commentary.getClient());
        commentary.setClient(client);
        if (commentary.getText().contains("pas"))
            commentary.setType(TypeCommentary.UNLIKE);
        else
            commentary.setType(TypeCommentary.LIKE);
        this.commentaryRepository.save(commentary);
    }

    public List<Commentary> find(TypeCommentary type){
        if (type == null)
            return this.commentaryRepository.findAll();
        else{
            return this.commentaryRepository.findByType(type);
        }
    }
    public Commentary read(int id) {
        Optional<Commentary> optionalSentiment = this.commentaryRepository.findById(id);
        return optionalSentiment.orElse(null);
    }

    public void delete(int id) {
        this.commentaryRepository.deleteById(id);
    }

    public void modify(int id, Commentary commentary) {
        Commentary commentaryDBB = this.read(id);
        if(commentaryDBB.getId() == commentary.getId()){
            commentaryDBB.setText(commentary.getText());
            commentaryDBB.setType(commentary.getType());
            commentaryDBB.setClient(commentary.getClient());
            this.commentaryRepository.save(commentaryDBB);
        }
    }
}
