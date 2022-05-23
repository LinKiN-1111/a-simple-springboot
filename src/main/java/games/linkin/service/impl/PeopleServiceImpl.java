package games.linkin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import games.linkin.dao.PeopleDao;
import games.linkin.pojo.People;
import games.linkin.pojo.PeopleBean;
import games.linkin.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class PeopleServiceImpl implements PeopleService {

    @Autowired
    private PeopleDao peopleDao;

    public boolean add(People people){
        try{
            peopleDao.insert(people);
            return true;
        }catch ( Exception e){
            return false;
        }
    }

    @Override
    public boolean deleteById(int id) {
        try{
            peopleDao.deleteById(id);
            return true;
        }catch( Exception e){
            return false;
        }
    }

    @Override
    public boolean deleteByIds(int[] ids) {
        List<Integer> idsList = new ArrayList<Integer>();
        for (int i = 0; i < ids.length; i++) {
            idsList.add(ids[i]);
        }
        try{
            peopleDao.deleteBatchIds(idsList);
            return true;
        }catch( Exception e){
            return false;
        }    }


    @Override
    public boolean update(People people) {
        int id;
        id = people.getId();
        try {
            LambdaUpdateWrapper<People> luw = new LambdaUpdateWrapper<>();
            LambdaUpdateWrapper<People> eq = luw.eq(People::getId, id);
            peopleDao.update(people,eq);
            return true;
        }catch ( Exception e){
            return false;
        }
    }

    @Override
    public PeopleBean<People> selectByPageAndSize(int page, int size) {
        try{
            IPage ipage = new Page(page,size);
            peopleDao.selectPage(ipage,null);

            PeopleBean<People> peopleBean = new PeopleBean<>();
            peopleBean.setRow(ipage.getRecords());
            peopleBean.setTotalCount((int) ipage.getTotal());

            return peopleBean;
        }catch ( Exception e){
            return null;
        }
    }

    @Override
    public PeopleBean<People> selectByCardId(String cardId) {
        try{
            LambdaQueryWrapper<People> lqw = new LambdaQueryWrapper<People>();
            lqw.eq(People::getCardId, cardId);

            List<People> peopleList = peopleDao.selectList(lqw);

            PeopleBean<People> peoplePeopleBean = new PeopleBean<>();
            peoplePeopleBean.setTotalCount(1);
            peoplePeopleBean.setRow(peopleList);

            return peoplePeopleBean;

        }catch( Exception e){
            return null;
        }
    }


}
