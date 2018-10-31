package com.lexus.demo.controllers;

import com.lexus.demo.entities.Report;
import com.lexus.demo.entities.User;
import com.lexus.demo.services.ReportDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReportController {

    @Autowired
    ReportDao reportDao;

    @PostMapping("/adviser/{id_adviser}/client/{id_client}/report")
    @CrossOrigin("*")
    public boolean saveReport(@RequestBody Report report, @PathVariable long id_adviser, @PathVariable long id_client){
        report.setAdvisor(new User(id_adviser));
        report.setClient(new User(id_client));
        if(reportDao.saveReport(report)){
            return true;
        }

        return false;
    }

    @GetMapping("/client/{id_client}/report")
    @CrossOrigin("*")
    public List<Report> findReportsByClientId(@PathVariable int id_client){
       return reportDao.getReportsByClient(id_client);
    }

    @GetMapping("/adviser/{id_adviser}/report")
    @CrossOrigin("*")
    public List<Report>findReportsByAdviserId(@PathVariable int id_adviser){
        return reportDao.getReportsByAdviser(id_adviser);
    }

    @GetMapping("/report")
    @CrossOrigin("*")
    public List<Report>findAllReports(){
        return reportDao.getAllReports();
    }
}

/*
{
	"system": "Un sistema",
    "initDate": "20/11/18 16:40:12",
    "endDate": "20/11/18 17:00:32",
    "status":"Terminado",
    "time":"20 min",
    "amount": 30.00,
    "description":"El equipo no estaba conetado"
}
 */