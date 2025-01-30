package com.praveen.firstApp.company;

import java.util.List;

public interface CompanyService {

    List<Company> getAllCompanies();

    void addCompany(Company company);
}
