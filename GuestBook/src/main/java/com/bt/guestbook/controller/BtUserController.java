/**
 * 
 */
package com.bt.guestbook.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bt.guestbook.repository.BtUserRepository;

/**
 * @author Venkat
 *
 */
@Controller
@RequestMapping(path = "/user")
public class BtUserController {

    private static final Logger logger = LoggerFactory.getLogger(BtUserController.class);

	@Autowired
	private BtUserRepository btUserRepository;
	
	// Need to add CRUD operations for USER
}
