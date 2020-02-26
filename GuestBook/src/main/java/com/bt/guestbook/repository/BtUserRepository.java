/**
 * 
 */
package com.bt.guestbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bt.guestbook.model.BtUser;

/**
 * @author Venkat
 *
 */
@Repository
public interface BtUserRepository extends JpaRepository<BtUser, Long>{

}
