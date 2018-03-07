package com.ll.service;

import com.ll.VO.Pagequery;
import com.ll.pojo.ReadyTest;
import com.ll.VO.readyTestVO;

public interface testpeopleService {
    Pagequery gettestpeople(Integer page, Integer rows);

    String edittestpeople(ReadyTest readyTest);

    String deltestpeople(String ids);

    readyTestVO getreadytestPasswordandPhone(Integer id);
}
