package com.deepwise.ask.admin.entity.image;

import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: lefeng.yi
 * @Date: 2019/1/2 19:25
 * @Description:
 */
@Data
public class JsonImageInfo implements Serializable {
    private static final long serialVersionUID = -1942636775988230050L;

    private String path;
    private String title;
}
