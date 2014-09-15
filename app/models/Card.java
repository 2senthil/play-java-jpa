package models;

import play.db.jpa.JPA;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Senthil Sundaram on 9/14/14.
 */
@Entity
public class Card {
    @Id
    @GeneratedValue
    public Long id;

    public String creator;
    public String source;

    public String title;
    
    @Column(length=1000)
    public String snippet;

    public String imageUrl;
    public String url;

    @Column(length=5000)
    public String content;
    public String rating;

    @Temporal(TemporalType.DATE)
    public Date date;

    public String skills;
    public String type;
}
