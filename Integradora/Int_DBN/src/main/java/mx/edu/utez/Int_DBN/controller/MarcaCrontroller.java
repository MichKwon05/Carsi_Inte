package mx.edu.utez.Int_DBN.controller;

import mx.edu.utez.Int_DBN.dto.MarcaDto;
import mx.edu.utez.Int_DBN.message.ResourceNotFoundException;
import mx.edu.utez.Int_DBN.model.marcas.Marca;
import mx.edu.utez.Int_DBN.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marcas")
@CrossOrigin
public class MarcaCrontroller {

    @Autowired
    MarcaService marcaService;

    @GetMapping("/")
    public ResponseEntity<List<Marca>> getAllMarcas() {
        return ResponseEntity.ok(marcaService.getAllMarcas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Marca> getMarcaById(@PathVariable("id") int id) throws ResourceNotFoundException {
        return ResponseEntity.ok(marcaService.getMarcaById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<Marca> save(@RequestBody MarcaDto marcaDto){
        return ResponseEntity.ok(marcaService.save(marcaDto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Marca> update(@PathVariable("id") int id, @RequestBody MarcaDto marcaDto) throws ResourceNotFoundException {
        return ResponseEntity.ok(marcaService.update(id, marcaDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Marca> delete(@PathVariable("id") int id) throws ResourceNotFoundException {
        return ResponseEntity.ok(marcaService.delete(id));
    }
}
