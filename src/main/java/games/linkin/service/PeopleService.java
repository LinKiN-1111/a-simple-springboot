package games.linkin.service;

import games.linkin.pojo.People;
import games.linkin.pojo.PeopleBean;

public interface PeopleService {

    public boolean add(People people);

    public boolean deleteById(int id);

    public boolean deleteByIds(int[] ids);

    public boolean update(People people);

    public PeopleBean<People> selectByPageAndSize(int page, int size);

    public PeopleBean<People> selectByCardId(String cardId);

}
