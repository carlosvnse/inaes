package com.companyname.springbootcrudrest.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "labels")
@XmlRootElement
public class Label implements Serializable {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 100)
  @Column(name = "labelId")
  private String labelId;  
}