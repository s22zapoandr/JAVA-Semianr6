package lv.venta.model;

import org.springframework.validation.annotation.Validated;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter	
@NoArgsConstructor
@ToString
@Table(name = "StudentTable")
@Entity
public class Student {
	//variables
		@Setter(value = AccessLevel.NONE)
		@Column(name = "Ids")
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long ids;
		
		@NotNull
		@Pattern(regexp = "[A-Z{1}[1-z]+")
		@Size(min = 2, max = 10)
		@Column(name = "Name")
		private String name;
		
		@NotNull
		@Pattern(regexp = "[A-Z{1}[1-z]+")         
		@Size(min = 2, max = 20)
		@Column(name = "Surname")
		private String surname;
		
		
		public Student(String name, String surname) {
			setName(name);
			setSurname(surname);
		}

}
