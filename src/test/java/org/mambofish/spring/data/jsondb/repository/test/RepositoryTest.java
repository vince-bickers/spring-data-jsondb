package org.mambofish.spring.data.jsondb.repository.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author vince
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes =JsonDBRepositoryConfig.class)
public class RepositoryTest {

    @Autowired private ContactRepository contactRepository;

    @Test
    public void shouldSaveContact() {

        Contact contact = contactRepository.save(new Contact("jane"));
        assertEquals("jane", contact.getId());

    }

    @Test
    public void shouldFindContact() {

        contactRepository.save(new Contact("jane"));
        Contact contact = contactRepository.findOne("jane");
        assertEquals("jane", contact.getId());

    }

    @Test
    public void shouldUpdateContact() {

        contactRepository.save(new Contact("jane"));

        Contact contact = contactRepository.findOne("jane");
        contact.setName("jennifer");
        contactRepository.save(contact);


        contact = contactRepository.findOne("jane");
        assertEquals("jennifer", contact.getName());

    }

    @Test
    public void shouldDeleteContact() {

        Contact contact = contactRepository.save(new Contact("jane"));
        contactRepository.delete(contact);
        assertFalse(contactRepository.exists("jane"));
    }

    @Test
    public void shouldDeleteContactById() {

        Contact contact = contactRepository.save(new Contact("jane"));
        contactRepository.delete(contact.getId());
        assertFalse(contactRepository.exists("jane"));
    }

    @Test
    public void shouldDeleteAll() {

        contactRepository.save(new Contact("jane"));
        contactRepository.save(new Contact( "pete"));

        assertTrue(contactRepository.exists("jane"));
        assertTrue(contactRepository.exists("pete"));

        contactRepository.deleteAll();

        assertFalse(contactRepository.exists("jane"));
        assertFalse(contactRepository.exists("pete"));

    }

}
