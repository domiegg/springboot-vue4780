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


import com.dao.YaokuxinxiDao;
import com.entity.YaokuxinxiEntity;
import com.service.YaokuxinxiService;
import com.entity.vo.YaokuxinxiVO;
import com.entity.view.YaokuxinxiView;

@Service("yaokuxinxiService")
public class YaokuxinxiServiceImpl extends ServiceImpl<YaokuxinxiDao, YaokuxinxiEntity> implements YaokuxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YaokuxinxiEntity> page = this.selectPage(
                new Query<YaokuxinxiEntity>(params).getPage(),
                new EntityWrapper<YaokuxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YaokuxinxiEntity> wrapper) {
		  Page<YaokuxinxiView> page =new Query<YaokuxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YaokuxinxiVO> selectListVO(Wrapper<YaokuxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YaokuxinxiVO selectVO(Wrapper<YaokuxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YaokuxinxiView> selectListView(Wrapper<YaokuxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YaokuxinxiView selectView(Wrapper<YaokuxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
