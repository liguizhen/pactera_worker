package com.pactera.service.impl;

import com.pactera.domain.PactWork;
import com.pactera.mapper.WorkMapper;
import com.pactera.service.WorkService;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

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
            workbook=Workbook.getWorkbook(new File("E:\\work.xls"));
            sheet=workbook.getSheet(0);
            int rows = sheet.getRows();
            int cols = sheet.getColumns();
            for(int i=1;i<rows;i++){
                PactWork pactWork = new PactWork();
                //for(int j=0;j<cols;j++){
                    //cells[i][j]=sheet.getCell(j,i);
                pactWork.setEmployee(sheet.getCell(i,1).getContents());
                pactWork.setAttendance_date(sheet.getCell(i,3).getContents());
                //}
                workMapper.importWork(pactWork);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("ok");
    }
}

