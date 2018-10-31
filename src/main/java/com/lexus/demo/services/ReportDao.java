package com.lexus.demo.services;

import com.lexus.demo.entities.Report;
import com.lexus.demo.repositories.IRepositoryReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportDao {

    @Autowired
    IRepositoryReport iRepositoryReport;

    public boolean saveReport(Report report){
        if(iRepositoryReport.save(report) != null){
            return true;
        }

        return false;
    }

    public List<Report> getReportsByClient(long id_client){
        return iRepositoryReport.findByClient_UserId(id_client);
    }

    public List<Report> getReportsByAdviser(long id_adviser){
        return iRepositoryReport.findByAdviser_UserId((id_adviser));
    }

    public List<Report> getAllReports(){
        return iRepositoryReport.findAll();
    }
}
