package edu.soft2.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {//数据表news_user对应的实体类
    private String uid, username,upwd;
}
