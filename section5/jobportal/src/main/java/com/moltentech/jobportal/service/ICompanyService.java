package com.moltentech.jobportal.service;

import com.moltentech.jobportal.dto.CompanyDto;

import java.util.List;

public interface ICompanyService {
    List<CompanyDto> getAllCompanies();
}
