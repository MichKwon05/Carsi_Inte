package mx.edu.utez.Int_DBN.model.members;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MembersRepository extends MongoRepository<Members, Integer> {
    //public List<Members> findById(String id);
    /*public List<Members> findByNombre(String nombre);
    public List<Members> findByNacionalidad(String nacionalidad);
    public List<Members> findByPosicion(String posicion);*/
}
