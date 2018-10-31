package com.lexus.demo.controllers;

import com.lexus.demo.entities.Request;
import com.lexus.demo.entities.User;
import com.lexus.demo.services.RequestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RequestController {

    @Autowired
    RequestDao requestDao;

    @PostMapping("/client/{id_client}/request")
    @CrossOrigin("*")
    public long saveRequest(@RequestBody Request request, @PathVariable long id_client){
        request.setClient(new User(id_client));
        request.setStatus("WAITING");
        Request r = requestDao.saveRequest(request);
        if(r != null){
            return r.getId_request();
        }

        return 0;
    }

    @GetMapping("/client/{id_client}/request")
    @CrossOrigin("*")
    public List<Request> findRequestsByClientId(@PathVariable int id_client){
        return requestDao.getRequestsByClient(id_client);
    }

    @GetMapping("/adviser/{id_adviser}/request")
    @CrossOrigin("*")
    public List<Request>findReportsByAdviserId(@PathVariable int id_adviser){
        return requestDao.getRequestsByAdviser(id_adviser);
    }

    @GetMapping("/request")
    @CrossOrigin("*")
    public List<Request>findAllRequests(){
        return requestDao.getAllRequests();
    }

    @GetMapping("/request/{id_request}")
    @CrossOrigin("*")
    public Request findById(@PathVariable long id_request){
        return requestDao.findById(id_request);
    }

    @PutMapping("/adviser/{id_adviser}/client/{id_client}/request/{id_request}")
    @CrossOrigin("*")
    public Request acceptRequest(@RequestBody Request request, @PathVariable long id_adviser,@PathVariable int id_client, @PathVariable long id_request){
        request.setId_request(id_request);
        request.setAdviser(new User(id_adviser));
        request.setClient(new User(id_client));
        request.setStatus("TAKEN");
        return requestDao.acceptRequest(request);

    }

    @PutMapping("/request/{id_request}")
    @CrossOrigin("*")
    public Request requestSolved(@RequestBody Request request, @PathVariable long id_request){
        request.setId_request(id_request);
        request.setStatus("DONE");
        return requestDao.solveRequest(request);

    }
}

/*
{
	"date":"20/11/18",
    "hour": "15:40:12",
    "subject": "something",
    "description": "jnfvkvnkvnrv",
    "system": "un systema"
}
*/