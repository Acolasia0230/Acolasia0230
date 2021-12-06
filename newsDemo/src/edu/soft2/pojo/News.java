package edu.soft2.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class News {//数据表news对应的实体类
    private String nId,nTid,nTitle,nAuthor,nCreateDate,
    nPicPath,nContent,nModifyDate,nSummary;
}
