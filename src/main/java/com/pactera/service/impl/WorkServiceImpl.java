package com.pactera.service.impl;

import com.pactera.domain.PactWork;
import com.pactera.mapper.WorkMapper;
import com.pactera.service.WorkService;
import jxl.Sheet;
import jxl.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by pl on 2019/8/2
 */
@Service
public class WorkServiceImpl implements WorkService {

    @Autowired
    private WorkMapper workMapper;

    @Override
    public void importWork() {
        Sheet sheet;
        Workbook workbook;
        try{
            workbook = Workbook.getWorkbook(new File("E:\\work.xls"));
            sheet = workbook.getSheet(0);
            int rows = sheet.getRows();
            List<String> dateList = new ArrayList<>();
            workMapper.deleteWork();
            workMapper.deleteWorkDate();
            for(int i=1;i<rows;i++){
                PactWork pactWork = new PactWork();
                String str = sheet.getCell(0,i).getContents();
                String dateStr = str.replaceAll("/","-");
                Date date = parse(dateStr);
                pactWork.setAttendance_date(dateStr);
                pactWork.setEmployee(sheet.getCell(1,i).getContents());
                workMapper.importWork(pactWork);
                if(!dateList.contains(dateStr) && isWeekDay(date)){
                    workMapper.importWorkDate(dateStr);
                }
                dateList.add(dateStr);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Date parse(String str) {
        if(str == null || StringUtils.isEmpty(str)){
            return null;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormat.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


    private Boolean isWeekDay(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY) {
            return false; // 周末不计入
        }
        return true;
    }
}

