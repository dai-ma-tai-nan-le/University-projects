package com.offcn.imovie.dao;

import com.offcn.imovie.pojo.Performer;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PerformerDao {

    @Select("select * from performerdetailtable limit 5")
    List<Performer> performerTop5();
}
