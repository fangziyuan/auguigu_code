package com.zhaokun.fresh.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhaokun.fresh.domain.Category;
import com.zhaokun.fresh.mapper.CategoryMapper;
import com.zhaokun.fresh.service.CategoryService;
import org.springframework.stereotype.Service;

/**
* @author zhaok
* @description 针对表【category】的数据库操作Service实现
* @createDate 2022-02-23 09:50:02
*/
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>
    implements CategoryService {

}




