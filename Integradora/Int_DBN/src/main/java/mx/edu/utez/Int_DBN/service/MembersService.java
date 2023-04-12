package mx.edu.utez.Int_DBN.service;

import mx.edu.utez.Int_DBN.dto.MembersDto;
import mx.edu.utez.Int_DBN.message.ResourceNotFoundException;
import mx.edu.utez.Int_DBN.model.members.Members;
import mx.edu.utez.Int_DBN.model.members.MembersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class MembersService {

    @Autowired
    MembersRepository membersRepository;
    public List<Members> getAllMembers() {
        return membersRepository.findAll();
    }

    public Members getMembersById(int id) throws ResourceNotFoundException {
        return membersRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Not Found"));
    }
    public Members save(MembersDto membersDto) {
        int id = autoIncrements();
        Members members = new Members(id, membersDto.getNombre(), membersDto.getNacionalidad(), membersDto.getCumpleanos(), membersDto.getPosicion());
        return membersRepository.save(members);
    }
    public Members update(int id, MembersDto membersDto) throws ResourceNotFoundException {
        Members members = membersRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Not Found"));
        members.setNombre(membersDto.getNombre());
        members.setNacionalidad(membersDto.getNacionalidad());
        members.setCumpleanos(membersDto.getCumpleanos());
        members.setPosicion(membersDto.getPosicion());
        return membersRepository.save(members);
    }
    public Members delete(int id) throws ResourceNotFoundException {
        Members members = membersRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Not Found"));
        membersRepository.delete(members);
        return members;
    }
    //Private Methods
    private int autoIncrements(){
        List<Members> members = membersRepository.findAll();
        return membersRepository.findAll().isEmpty()? 1 :
                members.stream().max(Comparator.comparing(Members::getId)).get().getId() + 1;
    }
}
