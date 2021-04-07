package com.javabull.ssm.blog.entity;

import com.javabull.ssm.blog.bean.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TagWarp implements Serializable {
    private Tag tag;
    private Integer articleCount;
}
