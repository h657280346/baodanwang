package com.yczc.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yczc.ssm.mapper.ContactMapper;
import com.yczc.ssm.pojo.Contact;
import com.yczc.ssm.service.ContactService;

@Service("contactService")
public class ContactServiceImpl implements ContactService{
	@Autowired
	private ContactMapper contactMapper = null;
	

	public List<Contact> findAllContact() throws Exception {
		List<Contact> contacts = contactMapper.findAllContact();
		return contacts;
	}

	

	public boolean updateContact(Contact contact) throws Exception {
		boolean flag = contactMapper.updateContact(contact);
		return flag;
	}


}
