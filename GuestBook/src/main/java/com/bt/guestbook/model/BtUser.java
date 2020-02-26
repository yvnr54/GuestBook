/**
 * 
 */
package com.bt.guestbook.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Venkat
 *
 */

@Entity
@Table(name = "BT_USER")
public class BtUser implements Serializable{

	private static final long serialVersionUID = -2852243277711662277L;

	@Id
	@GeneratedValue(generator = "BT_USER_SEQ",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "BT_USER_SEQ",sequenceName = "BT_USER_SEQ",allocationSize = 1)
	private Long id;
	private String name;
	private String userName;
	private String password;
	private String status;
	
	public BtUser() {
		super();
	}
	
	public BtUser(String name, String userName, String password, String status) {
		super();
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.status = status;
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
