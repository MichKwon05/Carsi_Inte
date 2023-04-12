package mx.edu.utez.Int_DBN.service;

import mx.edu.utez.Int_DBN.dto.MarcaDto;
import mx.edu.utez.Int_DBN.message.ResourceNotFoundException;
import mx.edu.utez.Int_DBN.model.marcas.Marca;
import mx.edu.utez.Int_DBN.model.marcas.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class MarcaService {

    @Autowired
    MarcaRepository marcaRepository;

    public List<Marca> getAllMarcas(){
        return marcaRepository.findAll();
    }

    public Marca getMarcaById(int id) throws ResourceNotFoundException {
        return marcaRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Not Found"));
    }

    public Marca save(MarcaDto marcaDto) {
        int id = autoIncrements();
        Marca marca = new Marca(id, marcaDto.getNameMarca(), marcaDto.getMember(), marcaDto.getNumComercials(), marcaDto.getAmbassador());
        return marcaRepository.save(marca);
    }

    public Marca update(int id, MarcaDto marcaDto) throws ResourceNotFoundException {
        Marca marca = marcaRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Not Found"));
        marca.setNameMarca(marca.getNameMarca());
        marca.setMember(marca.getMember());
        marca.setNumComercials(marca.getNumComercials());
        marca.setAmbassador(marca.getAmbassador());
        return marcaRepository.save(marca);
    }

    public Marca delete(int id) throws ResourceNotFoundException {
        Marca marca = marcaRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Not Found"));
        marcaRepository.delete(marca);
        return marca;
    }

    //Private Methods
    private int autoIncrements(){
        List<Marca> marcas = marcaRepository.findAll();
        return marcaRepository.findAll().isEmpty()? 1 :
                marcas.stream().max(Comparator.comparing(Marca::getId)).get().getId() + 1;
    }
}
