package com.zhou.springboot.dao;

import com.zhou.springboot.bean.VersionTest;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class VersionBiz {

    @Resource
    private VersionTestMapper versionTestMapper;

    @Transactional
    public void test(String seq) {
        VersionTest test = new VersionTest();
        test.setId(1);
        test.setSeq(seq);
        versionTestMapper.updateByKey(1, seq);
    }

    //    @Transactional
    public void testVersion(String seq) {
        VersionTest test = new VersionTest();
        test.setId(1);
        test.setSeq(seq);
        versionTestMapper.updateByKeyVersion(1, seq, Integer.valueOf(seq));
    }

}
