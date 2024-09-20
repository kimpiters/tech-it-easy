package nl.novi.TechItEasy.controllers;

import jakarta.validation.Valid;
import nl.novi.TechItEasy.dtos.TelevisionDto;
import nl.novi.TechItEasy.dtos.TelevisionInputDto;
import nl.novi.TechItEasy.dtos.TelevisionSalesDto;
import nl.novi.TechItEasy.services.TelevisionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("televisions")
public class TelevisionsController {
    private final TelevisionService televisionService;

    public TelevisionsController(TelevisionService televisionService) {
        this.televisionService = televisionService;
    }

    @GetMapping
    public ResponseEntity<List<TelevisionDto>> getAllTelevisions() {
        return ResponseEntity.ok(televisionService.getAllTelevisions());
    }

    @GetMapping("/sales")
    public ResponseEntity<List<TelevisionSalesDto>> getTelevisionsForSales() {
        return ResponseEntity.ok(televisionService.getAllTelevisionsForSales());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TelevisionDto> getTelevisionById(@PathVariable long id) {
        return ResponseEntity.ok(televisionService.getTelevisionById(id));
    }

    @PostMapping
    public ResponseEntity<Object> addTelevision(@Valid @RequestBody TelevisionInputDto tdto, BindingResult br) {

        if (br.hasFieldErrors()) {
            StringBuilder sb = new StringBuilder();
            for (FieldError fe : br.getFieldErrors()) {
                sb.append(fe.getField() + ": ");
                sb.append(fe.getDefaultMessage() + "\n");
            }
            return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
        }
        Long id = televisionService.addTelevision(tdto);
        tdto.id = id;

        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + id).toUriString());

        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TelevisionDto> updateTelevision(@PathVariable long id, @RequestBody TelevisionInputDto tdto) {
        televisionService.updateTelevision(id, tdto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TelevisionDto> deleteTelevision(@PathVariable long id) {
        televisionService.deleteTelevision(id);
        return ResponseEntity.noContent().build();
    }

}
