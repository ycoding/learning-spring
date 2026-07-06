package com.moltentech.jobportal.contact.service;

import com.moltentech.jobportal.dto.ContactRequestDto;

public interface IContactService {
    boolean saveContact(ContactRequestDto contactRequestDto);
}
