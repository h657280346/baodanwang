package com.yczc.ssm.mapper;

import java.util.List;

import com.yczc.ssm.pojo.Contact;

public interface ContactMapper {

	public List<Contact> findAllContact() throws Exception;
	public boolean updateContact(Contact contact) throws Exception;

}
