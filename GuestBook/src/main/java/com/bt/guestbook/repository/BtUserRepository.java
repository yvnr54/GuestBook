/**
 * 
 */
package com.bt.guestbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bt.guestbook.model.BtUser;

/**
 * This  is used to perform CRUD operations on BtUser entity and it extended super interface JPA Repository.
 * 
 * @author Venkat
 *
 */
@Repository
public interface BtUserRepository extends JpaRepository<BtUser, Long>{

}
