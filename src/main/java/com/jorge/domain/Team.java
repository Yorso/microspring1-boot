package com.jorge.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement //Mostrará el resultado (domain object del método hiTeam() del controlador BaseBallController.java) 
                //en formato XML. Si ésto muestra resultado como JSON
				//Si ponemos http://localhost:8080/microspring1-boot/hiTeam.json nos mostrará resultado en json aunque tengamos la anotación @XmlRootElement
				//No ocurre al revés, ok? Sin tener @XmlRootElement, nos mostraría el resultado en JSON y no vale poner http://localhost:8080/microspring1-boot/hiTeam.xml, no funcionaría
@Entity //JPA annotation
public class Team {

	@Id //JPA annotation
	@GeneratedValue //JPA annotation
	Long id;
	
	String name;
	String location;
	String mascotte;
	
	@OneToMany(cascade=CascadeType.ALL) //JPA annotation
	@JoinColumn(name="teamId") //JPA annotation
	Set<Player> players;
	
	public Team() {
		super();
	}
	
	public Team(String location, String name, Set<Player> players) {
		this();
		this.name = name;
		this.location = location;
		this.players = players;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getMascotte() {
		return mascotte;
	}
	public void setMascotte(String mascotte) {
		this.mascotte = mascotte;
	}
	public Set<Player> getPlayers() {
		return players;
	}
	public void setPlayers(Set<Player> players) {
		this.players = players;
	}
	
	
}
