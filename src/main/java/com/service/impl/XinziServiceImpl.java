package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.XinziDao;
import com.entity.XinziEntity;
import com.service.XinziService;
import com.entity.view.XinziView;

/**
 * 薪资 服务实现类
 * @author 
 * @since 2021-03-03
 */
@Service("xinziService")
@Transactional
public class XinziServiceImpl extends ServiceImpl<XinziDao, XinziEntity> implements XinziService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<XinziView> page =new Query<XinziView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}
