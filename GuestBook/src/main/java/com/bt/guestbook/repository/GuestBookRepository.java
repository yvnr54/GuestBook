/**
 * 
 */
package com.bt.guestbook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bt.guestbook.model.GuestBook;

/**
 * @author Venkat
 *
 */
@Repository
public interface GuestBookRepository extends JpaRepository<GuestBook, Long>{

	List<GuestBook> findByCreatedBy(String createdBy);
}
