package com.javabull.ssm.blog.service;

import com.javabull.ssm.blog.bean.Options;

public interface IOptionsService {
    Options getOption();

    int update(Options options);
}
