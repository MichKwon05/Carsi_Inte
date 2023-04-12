package mx.edu.utez.Int_DBN.model.album;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AlbumRepository extends MongoRepository<Album, Integer>{
}
