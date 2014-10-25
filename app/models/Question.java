package models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Senthil Sundaram on 10/25/14.
 */
public class Question {
    @Id
    @GeneratedValue
    public Long id;

    public Long skillId;

    public String optionOne;
    public String optionTwo;
    public String optionThree;
    public String optionFour;

    public int numOptions;
}
