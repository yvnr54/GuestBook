package com.bt.guestbook.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.ui.Model;

import com.bt.guestbook.model.BtUser;
import com.bt.guestbook.repository.BtUserRepository;

@RunWith(PowerMockRunner.class)
class BtUserControllerTest {

	@Mock
	BtUser btUser;
	
	@Mock
	BtUserRepository btUserRepository;
	
	@InjectMocks
	BtUserController btUserController;
	
	@Mock 
	Model model;
	
	@Mock
	List<BtUser> usersList = new ArrayList<BtUser>();
	
	@Test
	void testGetUsers() {
		when(btUserRepository.findAll()).thenReturn(usersList);
		assertEquals("users",btUserController.getUsers(model));
	}

	@Test
	void testGetUser() {
		fail("Not yet implemented");
	}

	@Test
	void testSaveUser() {
		fail("Not yet implemented");
	}

	@Test
	void testEditUser() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteUser() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateUser() {
		fail("Not yet implemented");
	}

}
