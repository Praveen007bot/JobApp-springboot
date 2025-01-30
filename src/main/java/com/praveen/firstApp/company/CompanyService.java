package com.praveen.firstApp.company;

import com.praveen.firstApp.job.Job;

import java.util.List;

public interface CompanyService {

    List<Company> getAllCompanies();

    void addCompany(Company company);

    Company getCompanyById(Long id);

    boolean deleteCompanyById(Long id);

    boolean updateCompanyById(Long id, Company newCompany);
}
