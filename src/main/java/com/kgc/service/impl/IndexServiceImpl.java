package com.kgc.service.impl;

import com.kgc.mapper.StudentinfoMapper;
import com.kgc.pojo.Studentinfo;
import com.kgc.pojo.StudentinfoExample;
import com.kgc.service.IndexService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shkstart
 */
@Service("indexService")
public class IndexServiceImpl implements IndexService {
    @Resource
    StudentinfoMapper studentinfoMapper;

    @Override
    public List<Studentinfo> selall() {
        return studentinfoMapper.selectByExample(null);
    }

    @Override
    public Studentinfo selById(Integer id) {
        return studentinfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int upd(Studentinfo studentinfo, Integer id) {
        StudentinfoExample example = new StudentinfoExample();
        StudentinfoExample.Criteria criteria = example.createCriteria();
        criteria.andSidEqualTo(id);
        return studentinfoMapper.updateByExampleSelective(studentinfo, example);
    }
}
