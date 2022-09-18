package com.offcn.service;

import com.offcn.entity.Trolley;

import java.util.List;

public interface TrolleyService {
    int addTrolley(Trolley trolley);

    int selectTrolleyCount(int uid);

    List<Trolley> selectByUid(int uid);

    int deleteByTid(int tid, int uid);
}
