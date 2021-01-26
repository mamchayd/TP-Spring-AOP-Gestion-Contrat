package org.enset.contrat.controller;


import org.enset.contrat.aspects.crypt.Decrypt;
import org.enset.contrat.aspects.crypt.Encrypt;
import org.enset.contrat.aspects.log.MyLog;
import org.enset.contrat.aspects.security.SecuredByAspect;
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
    @Encrypt(values = {"titre","nomClient","cinClient"})
    @SecuredByAspect(roles = {"ADMIN"})
    @MyLog
    public String addContrat(@RequestBody Contrat contrat){
        contrat.setDate(new Date());
        contratRepository.save(contrat);
        return "Add success";
    }

    @GetMapping("contrats/{id}")
    @Decrypt(values = {"titre","nomClient","cinClient"})
    @SecuredByAspect(roles = {"ADMIN","USER"})
    @MyLog
    public Contrat consultation(@PathVariable Long id) {
        Contrat contrat = contratRepository.findById(id).get();
        return contrat;
    }
    @GetMapping("contrats")
    @Decrypt(values = {"titre","nomClient","cinClient"})
    @SecuredByAspect(roles = {"ADMIN","USER"})
    @MyLog
    public List<Contrat> contrats(){
        return  contratRepository.findAll();
    }

    @GetMapping("contratsCIN")
    @Decrypt(values = {"titre","nomClient","cinClient"})
    @SecuredByAspect(roles = {"ADMIN","USER"})
    @MyLog
    public Contrat consult(@RequestBody String cin){
        return  contratRepository.findByCinClient(cin);
    }


}
