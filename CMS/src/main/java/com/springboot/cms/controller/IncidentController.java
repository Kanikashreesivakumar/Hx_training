package com.springboot.cms.controller;

import com.springboot.cms.exception.ResourceNotFoundException;
import com.springboot.cms.model.Incident;
import com.springboot.cms.service.IncidentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class IncidentController {

    private final IncidentService incidentService;



    @GetMapping("/api/indicent/all")
    public List<Incident> getAll(){
     return incidentService.getAll();
    }
    @PostMapping("/api/incident/add")
    public void addIncident(@RequestBody Incident incident){
        incidentService.addIncident(incident);

    }

    @GetMapping("/api/incident/get-one/{id}")
    public ResponseEntity<Object> getById(@PathVariable int id){
        try {
            Incident incident = incidentService.getById(id);

            return ResponseEntity
                    .ok(incident);
        }catch(ResourceNotFoundException e){
            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }
    }

    @DeleteMapping("/api/incident/delete/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable int id){
        try {
            incidentService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        catch(ResourceNotFoundException e){
            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }
    }
    @PutMapping("/api/incident/update/{id}")
    public ResponseEntity<Object> update(@PathVariable int id,
                                         @RequestBody Incident updatedIncident) {
        try {
            incidentService.update(id, updatedIncident);
            return ResponseEntity
                    .ok()
                    .build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }
    }

}
