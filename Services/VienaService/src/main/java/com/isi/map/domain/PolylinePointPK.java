package com.isi.map.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class PolylinePointPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3794655158304810077L;

	@Column(name = "Id_Obiect")
	private Integer objectId;

	@Column(name = "Numar_Secventa")
	private Integer sequenceNumber;

	@Column(name = "Tip_Obiect")
	private String objectType;
}
