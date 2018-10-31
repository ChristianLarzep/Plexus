package com.lexus.demo.services;

import com.lexus.demo.entities.Request;
import com.lexus.demo.repositories.IRepositoryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestDao {

    @Autowired
    IRepositoryRequest iRepositoryRequest;

    public Request saveRequest(Request request){
        Request r = iRepositoryRequest.save(request);
        if(r != null){
            return r;
        }

        return null;
    }

    public List<Request> getRequestsByClient(long id_client){
        return iRepositoryRequest.findByClient_UserId(id_client);
    }

    public List<Request> getRequestsByAdviser(long id_adviser){
        return iRepositoryRequest.findByAdviser_UserId((id_adviser));
    }

    public List<Request> getAllRequests(){
        return iRepositoryRequest.findAll();
    }

    public Request acceptRequest(Request r){
        if(iRepositoryRequest.findById(r.getId_request()).isPresent()){
            return iRepositoryRequest.save(r);
        }

        return null;
    }

    public Request solveRequest(Request r){
        if(iRepositoryRequest.findById(r.getId_request()).isPresent()){
            return iRepositoryRequest.save(r);
        }

        return null;
    }

    public Request findById(long id){
        Request request = iRepositoryRequest.findById(id).get();
        if(request != null){
            return request;
        }

        return null;
    }


}
