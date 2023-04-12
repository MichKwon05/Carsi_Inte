package mx.edu.utez.Int_DBN.model.marcas;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaRepository extends MongoRepository<Marca, Integer>{
}
