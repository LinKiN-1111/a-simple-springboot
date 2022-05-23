package games.linkin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class People {
    private int id;
    private String name;
    private String sex;
    private String cardId;
    private String covidTest;
    private String vaccination;


    public People(String name, String sex, String cardId, String covidTest, String vaccination) {
        this.name = name;
        this.sex = sex;
        this.cardId = cardId;
        this.covidTest = covidTest;
        this.vaccination = vaccination;
    }
}
