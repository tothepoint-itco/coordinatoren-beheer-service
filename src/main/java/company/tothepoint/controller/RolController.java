package company.tothepoint.controller;

/**
 * Created by butrint on 25/04/16.
 */

import company.tothepoint.model.rol.Rol;
import company.tothepoint.repository.RollenRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rollen")
public class RolController {
    private static final Logger LOG = LoggerFactory.getLogger(RolController.class);
    @Autowired
    private RollenRepository rollenRepo;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Rol>> getAllRollen() {
        LOG.debug("GET /rollen getAllRollen() called!");
        return new ResponseEntity<>(rollenRepo.findAll(), HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Rol> getRol(@PathVariable("id") String id) {
        LOG.debug("GET /rollen/"+id+" getRol("+id+") called!");
        Optional<Rol> rolOption = Optional.ofNullable(rollenRepo.findOne(id));
        return rolOption.map(rol->
                new ResponseEntity<>(rol, HttpStatus.OK)
        ).orElse(
                new ResponseEntity<>(HttpStatus.NOT_FOUND)
        );
    }
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Rol> createRol(@RequestBody Rol rol) {
        LOG.debug("POST /rollen createRol(..) called!");
        Rol createRol = rollenRepo.save(rol);
        return new ResponseEntity<>(createRol, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity<Rol> updateRol(@PathVariable("id") String id, @RequestBody Rol rol) {
        LOG.debug("PUT /rollen/"+id+" updateRol("+id+", ..) called!");
        Optional<Rol> existingRol = Optional.ofNullable(rollenRepo.findOne(id));

        return existingRol.map(bu ->
                {
                    rol.setId(id);
                    return new ResponseEntity<>(rollenRepo.save(rol), HttpStatus.OK);
                }
        ).orElse(
                new ResponseEntity<>(HttpStatus.NOT_FOUND)
        );
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Rol> deleteRol(@PathVariable("id") String id) {
        LOG.debug("DELETE /rollen/"+id+" deleteRol("+id+") called!");
        if (rollenRepo.exists(id)) {
            rollenRepo.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}
