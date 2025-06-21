package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.YishikaiyaoDao;
import com.entity.YishikaiyaoEntity;
import com.service.YishikaiyaoService;
import com.entity.vo.YishikaiyaoVO;
import com.entity.view.YishikaiyaoView;

@Service("yishikaiyaoService")
public class YishikaiyaoServiceImpl extends ServiceImpl<YishikaiyaoDao, YishikaiyaoEntity> implements YishikaiyaoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YishikaiyaoEntity> page = this.selectPage(
                new Query<YishikaiyaoEntity>(params).getPage(),
                new EntityWrapper<YishikaiyaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YishikaiyaoEntity> wrapper) {
		  Page<YishikaiyaoView> page =new Query<YishikaiyaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YishikaiyaoVO> selectListVO(Wrapper<YishikaiyaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YishikaiyaoVO selectVO(Wrapper<YishikaiyaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YishikaiyaoView> selectListView(Wrapper<YishikaiyaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YishikaiyaoView selectView(Wrapper<YishikaiyaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
