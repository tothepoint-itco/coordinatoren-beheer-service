package company.tothepoint.controller;


import company.tothepoint.model.beheerder.Beheerder;
import company.tothepoint.repository.BeheerderRepository;
import company.tothepoint.repository.BusinessUnitRepository;
import company.tothepoint.repository.RollenRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import java.security.Principal;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/beheerders")
public class BeheerderController {
    private static final Logger LOG = LoggerFactory.getLogger(BeheerderController.class);

    @Autowired
    private BeheerderRepository beheerRepo;
    @Autowired
    private BusinessUnitRepository businessUnitRepo;
    @Autowired
    private RollenRepository rollenRepo;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Beheerder>> getAllBeheerders( @RequestHeader(value="Authorization") String authorizationHeader, Principal crurrentUser) {
        return new ResponseEntity<>(beheerRepo.findAll(), HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Beheerder> getBeheerder(@PathVariable("id") String id){
        Optional<Beheerder> beheerderOption = Optional.ofNullable(beheerRepo.findOne(id));
        return beheerderOption.map(beheerder ->
            new ResponseEntity<>(beheerder, HttpStatus.OK)
        ).orElse(
                new ResponseEntity<>(HttpStatus.NOT_FOUND)
        );
    }
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Beheerder> createBeheerder(@RequestBody Beheerder beheerder) {
        LOG.debug("POST /beheerders createBeheerder(..) called!");
        Beheerder createdBeheerder = beheerRepo.save(beheerder);
        return new ResponseEntity<>(createdBeheerder, HttpStatus.CREATED);
        //Optional<Rol> rolOption = Optional.ofNullable(rollenRepo.findOne(beheerder.getRolId()));
        //Optional<BusinessUnit> businessOption = Optional.ofNullable(businessUnitRepo.findOne(beheerder.getBusinessUnitId()));
//        return rolOption.flatMap( rol -> {
//            return businessOption.map( businessUnit -> {
//              return   new ResponseEntity<>(beheerRepo.save(beheerder), HttpStatus.CREATED);
//            });
//        }).orElse( new ResponseEntity<>(HttpStatus.BAD_REQUEST));
//        rabbitTemplate.convertAndSend(exchangeName, routingKey, new BediendeCreatedNotification("bediendeCreated", createdBediende));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity<Beheerder> updateBeheerder(@PathVariable("id") String id, @RequestBody Beheerder beheerder) {
        LOG.debug("PUT /beheerders/"+id+" updateBeheerder("+id+", ..) called!");
        Optional<Beheerder> existingBeheerder = Optional.ofNullable(beheerRepo.findOne(id));

        return existingBeheerder.map(bu ->
                {
                    beheerder.setId(id);
//                    rabbitTemplate.convertAndSend(exchangeName, routingKey, new BediendeUpdatedNotification("bediendeUpdated", bediende));
                    return new ResponseEntity<>(beheerRepo.save(beheerder), HttpStatus.OK);
                }
        ).orElse(
                new ResponseEntity<>(HttpStatus.NOT_FOUND)
        );
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Beheerder> deleteBeheerder(@PathVariable("id") String id) {
        LOG.debug("DELETE /beheerders/"+id+" deleteBeheerder("+id+") called!");
        if (beheerRepo.exists(id)) {
            beheerRepo.delete(id);
//            rabbitTemplate.convertAndSend(exchangeName, routingKey, new BediendeDeletedNotification("bediendeDeleted", id));
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }





}
