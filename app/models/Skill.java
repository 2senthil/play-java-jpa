package models;

import play.db.jpa.JPA;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * This class represents each skill
 *
 * Created by Senthil Sundaram on 9/14/14.
 */
@Entity
public class Skill {
    @Id
    @GeneratedValue
    public Long id;

    public String name;
    public int numfollowers;
    
    @Column(length=1000)
    public String description;
}
