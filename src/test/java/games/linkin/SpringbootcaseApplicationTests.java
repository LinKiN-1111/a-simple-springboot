package games.linkin;

import games.linkin.dao.PeopleDao;
import games.linkin.pojo.People;
import games.linkin.pojo.PeopleBean;
import games.linkin.pojo.User;
import games.linkin.service.impl.PeopleServiceImpl;
import games.linkin.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootcaseApplicationTests {

    @Autowired
    private PeopleDao peopleDao;
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private PeopleServiceImpl peopleService;

    @Test
    void contextLoads() {
        People people = new People("1234","男123","123123123","阴123性","已4接种");
        PeopleBean<People> peoplePeopleBean = peopleService.selectByPageAndSize(1, 2);
//        peopleService.update(people);
//        peopleService.add(people);
//        peopleService.deleteById(37);
//        int[] a = {36,38};
//        peopleService.deleteByIds(a);
        String cardId = "123123432123123";
        PeopleBean<People> peoplePeopleBean1 = peopleService.selectByCardId(cardId);
        System.out.println(peoplePeopleBean1);
    }

}
