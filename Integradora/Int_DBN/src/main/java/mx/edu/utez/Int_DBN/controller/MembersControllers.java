package mx.edu.utez.Int_DBN.controller;

import mx.edu.utez.Int_DBN.dto.MembersDto;
import mx.edu.utez.Int_DBN.message.ResourceNotFoundException;
import mx.edu.utez.Int_DBN.model.members.Members;
import mx.edu.utez.Int_DBN.service.MembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
@CrossOrigin
public class MembersControllers {
    @Autowired
    MembersService membersService;
    @GetMapping("/")
    public ResponseEntity<List<Members>> getAllMembers(){
        return ResponseEntity.ok(membersService.getAllMembers());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Members> getMembersById(@PathVariable("id") int id) throws ResourceNotFoundException {
        return ResponseEntity.ok(membersService.getMembersById(id));
    }
    @PostMapping("/add")
    public ResponseEntity<Members> save(@RequestBody MembersDto membersDto){
        return ResponseEntity.ok(membersService.save(membersDto));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Members> update(@PathVariable("id") int id, @RequestBody MembersDto membersDto) throws ResourceNotFoundException {
        return ResponseEntity.ok(membersService.update(id, membersDto));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Members> delete(@PathVariable("id") int id) throws ResourceNotFoundException {
        return ResponseEntity.ok(membersService.delete(id));
    }
}
