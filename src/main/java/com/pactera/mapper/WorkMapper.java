package com.pactera.mapper;

import com.pactera.domain.PactWork;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by pl on 2019/8/2
 */
@Mapper
public interface WorkMapper {

    void importWork(PactWork pactWork);

    void deleteWork();

    void importWorkDate(String attendance_date);

    void deleteWorkDate();

}
