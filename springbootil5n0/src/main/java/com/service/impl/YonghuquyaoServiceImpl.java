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


import com.dao.YonghuquyaoDao;
import com.entity.YonghuquyaoEntity;
import com.service.YonghuquyaoService;
import com.entity.vo.YonghuquyaoVO;
import com.entity.view.YonghuquyaoView;

@Service("yonghuquyaoService")
public class YonghuquyaoServiceImpl extends ServiceImpl<YonghuquyaoDao, YonghuquyaoEntity> implements YonghuquyaoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YonghuquyaoEntity> page = this.selectPage(
                new Query<YonghuquyaoEntity>(params).getPage(),
                new EntityWrapper<YonghuquyaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YonghuquyaoEntity> wrapper) {
		  Page<YonghuquyaoView> page =new Query<YonghuquyaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YonghuquyaoVO> selectListVO(Wrapper<YonghuquyaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YonghuquyaoVO selectVO(Wrapper<YonghuquyaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YonghuquyaoView> selectListView(Wrapper<YonghuquyaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YonghuquyaoView selectView(Wrapper<YonghuquyaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
