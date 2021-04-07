package com.javabull.ssm.blog.service;

import com.javabull.ssm.blog.bean.Screen;
import com.javabull.ssm.blog.entity.ScreenParam;

import java.util.List;

public interface IScreenService {
    /**
     * 获取所有大幕
     *
     * @return
     */
    List<Screen> getAll();

    /**
     * 根据screenId获取大幕
     *
     * @param screenId
     * @return
     */
    Screen getOneByScreenId(Integer screenId);

    /**
     * 根据screenId查出大幕，并且查出对应的articleId articleTitle
     *
     * @param screenId
     * @return
     */
    ScreenParam getOneByScreenIdWithArticleId(Integer screenId);

    /**
     * 获取所有screen,并且查出对应的articleId articleTitle
     *
     * @return
     */
    List<ScreenParam> getScreensWithArticleId();

    /**
     * 添加一个大幕
     *
     * @param screen
     * @return
     */
    int addOne(Screen screen);

    /**
     * 根据screenId删除一条数据
     *
     * @param screenId
     * @return
     */
    int deleteOneByScreenId(Integer screenId);

    /**
     * 更新一条记录
     *
     * @param screen
     * @return
     */
    int updateOneByScreenId(Screen screen);

    /**
     * 检查大幕名是否存在
     * @param screenTitle
     * @return
     */
    boolean existScreenTitle(String screenTitle);
}
