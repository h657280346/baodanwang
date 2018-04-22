package com.yczc.ssm.service;

import java.util.List;

import com.yczc.ssm.pojo.Contact;

public interface ContactService {

	public List<Contact> findAllContact() throws Exception;
	public boolean updateContact(Contact contact) throws Exception;


}
