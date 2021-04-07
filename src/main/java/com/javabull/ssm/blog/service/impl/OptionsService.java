package com.javabull.ssm.blog.service.impl;

import com.javabull.ssm.blog.bean.Options;
import com.javabull.ssm.blog.dao.OptionsMapper;
import com.javabull.ssm.blog.service.IOptionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OptionsService implements IOptionsService {

    @Autowired
    private OptionsMapper optionsMapper;

    /**
     * @return
     */
    public Options getOption() {
        List<Options> options = optionsMapper.selectByExample(null);
        return options == null ? null : options.get(0);
    }

    public int update(Options options) {
        options.setOptionUpdateTime(new Date());
        return optionsMapper.updateByPrimaryKey(options);
    }
}
