package com.javabull.ssm.blog.service.impl;

import com.javabull.ssm.blog.bean.Screen;
import com.javabull.ssm.blog.bean.ScreenExample;
import com.javabull.ssm.blog.dao.ScreenMapper;
import com.javabull.ssm.blog.entity.ScreenParam;
import com.javabull.ssm.blog.service.IScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScreenService implements IScreenService {

    @Autowired
    private ScreenMapper screenMapper;

    @Override
    public List<Screen> getAll() {
        ScreenExample screenExample = new ScreenExample();
        screenExample.setOrderByClause("tb_screen.screen_order desc");
        return screenMapper.selectByExample(screenExample);
    }

    @Override
    public Screen getOneByScreenId(Integer screenId) {
        return screenMapper.selectByPrimaryKey(screenId);
    }

    @Override
    public ScreenParam getOneByScreenIdWithArticleId(Integer screenId) {
        return screenMapper.selectByScreenIdWithArticleId(screenId);
    }

    @Override
    public List<ScreenParam> getScreensWithArticleId() {
        return screenMapper.selectScreensWithArticleId();
    }

    @Override
    public int addOne(Screen screen) {
        return screenMapper.insert(screen);
    }

    @Override
    public int deleteOneByScreenId(Integer screenId) {
        return screenMapper.deleteByPrimaryKey(screenId);
    }

    @Override
    public int updateOneByScreenId(Screen screen) {
        return screenMapper.updateByPrimaryKeySelective(screen);
    }

    @Override
    public boolean existScreenTitle(String screenTitle) {
        ScreenExample screenExample = new ScreenExample();
        ScreenExample.Criteria criteria = screenExample.createCriteria();
        criteria.andScreenImgNameEqualTo(screenTitle);
        long l = screenMapper.countByExample(screenExample);
        return l >= 1;
    }
}
