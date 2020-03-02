/**
 * 
 */
package com.bt.guestbook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bt.guestbook.model.GuestBook;

/**
 * This class is used to perform CRUD operations on GuestBook Entity and we have added custom method to retrieve books based on the created by user.
 * @author Venkat
 *
 */
@Repository
public interface GuestBookRepository extends JpaRepository<GuestBook, Long>{

	/**
	 * This is used to get the guest books based on the user created it.
	 * 
	 * @param createdBy
	 * @return
	 */
	List<GuestBook> findByCreatedBy(String createdBy);
}
