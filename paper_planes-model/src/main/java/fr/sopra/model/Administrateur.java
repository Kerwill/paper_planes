package fr.sopra.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "administrateur")
public class Administrateur {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="ADM_ID")
		private int id;

		@Column(name="ADM_TECHNICIEN", nullable=false)
		@NotEmpty
		private boolean isTechnicien = true;
	
		@Column(name="ADM_USERNAME", length =100, nullable=false)
		@NotEmpty
		@Size(max = 100)
		private String username;

		@Column(name="ADM_PASSWORD", length =100, nullable=false)
		@NotEmpty
		@Size(max = 100)
		private String password;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public boolean isTechnicien() {
			return isTechnicien;
		}

		public void setTechnicien(boolean isTechnicien) {
			this.isTechnicien = isTechnicien;
		}
	}



