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


import com.dao.JiaofeiqingdanDao;
import com.entity.JiaofeiqingdanEntity;
import com.service.JiaofeiqingdanService;
import com.entity.vo.JiaofeiqingdanVO;
import com.entity.view.JiaofeiqingdanView;

@Service("jiaofeiqingdanService")
public class JiaofeiqingdanServiceImpl extends ServiceImpl<JiaofeiqingdanDao, JiaofeiqingdanEntity> implements JiaofeiqingdanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiaofeiqingdanEntity> page = this.selectPage(
                new Query<JiaofeiqingdanEntity>(params).getPage(),
                new EntityWrapper<JiaofeiqingdanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiaofeiqingdanEntity> wrapper) {
		  Page<JiaofeiqingdanView> page =new Query<JiaofeiqingdanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<JiaofeiqingdanVO> selectListVO(Wrapper<JiaofeiqingdanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JiaofeiqingdanVO selectVO(Wrapper<JiaofeiqingdanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JiaofeiqingdanView> selectListView(Wrapper<JiaofeiqingdanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiaofeiqingdanView selectView(Wrapper<JiaofeiqingdanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
