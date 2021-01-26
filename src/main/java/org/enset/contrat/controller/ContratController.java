package org.enset.contrat.controller;


import org.enset.contrat.model.Contrat;
import org.enset.contrat.repository.ContratRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.List;

@RestController
public class ContratController {

    @Autowired
    private ContratRepository contratRepository;

    @PostMapping("contrats/add")
    public String addContrat(@RequestBody Contrat contrat){
        contrat.setDate(new Date());
        contratRepository.save(contrat);
        return "Add success";
    }

    @GetMapping("contrats/{id}")
    public Contrat consultation(@PathVariable Long id) {
        Contrat contrat = contratRepository.findById(id).get();
        return contrat;
    }

    @GetMapping("contrats")
    public List<Contrat> contrats(){
        return  contratRepository.findAll();
    }

    @GetMapping("contratsCIN")
    public Contrat consult(@RequestBody String cin){
        return  contratRepository.findByCinClient(cin);
    }


}
