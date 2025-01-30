package com.praveen.firstApp.company.impl;

import com.praveen.firstApp.company.Company;
import com.praveen.firstApp.company.CompanyRepository;
import com.praveen.firstApp.company.CompanyService;
import com.praveen.firstApp.job.Job;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public void addCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteCompanyById(Long id) {
        try {
            companyRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateCompanyById(Long id, Company newCompany) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if (companyOptional.isPresent()) {
            Company company = companyOptional.get();
            company.setName(newCompany.getName());
            company.setDescription(newCompany.getDescription());
            company.setLocation(newCompany.getLocation());
            companyRepository.save(company);
            return true;
        }
        return false;

    }
}
