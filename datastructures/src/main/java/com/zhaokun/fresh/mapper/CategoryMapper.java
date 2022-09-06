package com.zhaokun.fresh.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhaokun.fresh.domain.Category;
import org.apache.ibatis.annotations.Mapper;

/**
* @author zhaok
* @description 针对表【category】的数据库操作Mapper
* @createDate 2022-02-23 09:50:02
* @Entity generator.domain.Category
*/
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

}




