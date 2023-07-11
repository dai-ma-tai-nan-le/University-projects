package com.liu.covid.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liu.covid.entity.EmpIden;
import com.liu.covid.entity.EmpIs;
import com.liu.covid.entity.MaterialManage;
import com.liu.covid.mapper.EmpIdenMapper;
import com.liu.covid.mapper.EmpIsMapper;
import com.liu.covid.mapper.MaterialMapper;
import com.liu.covid.service.ChartService;
import com.liu.covid.vo.LineVO;
import com.liu.covid.vo.PieVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

//可视化图的实现方法
@Service
public class ChartServiceImpl extends ServiceImpl<EmpIdenMapper, EmpIden> implements ChartService {

    @Autowired
    private EmpIdenMapper empIdenMapper;
    @Autowired
    private EmpIsMapper empIsMapper;
    @Autowired
    private MaterialMapper materialMapper;

        @Override
        public LineVO lineVOList() {
            LineVO lineVO = new LineVO();
            List<String> month = new ArrayList<>();
            List<Integer> list=new ArrayList<>();
            Map<String, List> all = new HashMap<>();
            String type[] = {"确诊", "疑似", "治愈", "死亡"};

            try{
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
                String nowdate=format.format(new Date());//当前月份
                Date d1 = new SimpleDateFormat("yyyy-MM").parse("2018-01");//定义起始日期
                Date d2 = new SimpleDateFormat("yyyy-MM").parse(nowdate);//定义结束日期 可以去当前月也可以手动写日期。
                Calendar dd = Calendar.getInstance();//定义日期实例
                dd.setTime(d1);//设置日期起始时间
                while (dd.getTime().before(d2)) {//判断是否到结束日期
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
                    String str = sdf.format(dd.getTime());
                    month.add(str);
                    dd.add(Calendar.MONTH, 1);//进行当前日期月份加1
                }
            }catch (Exception e){
                System.out.println("异常"+e.getMessage());
            }
            //设置折线图月份
            Collections.reverse(month);
            lineVO.setMonth(month);

            //  设置 类型-数量 键值对
            //{"确诊", "疑似", "治愈", "死亡"}
            for (String t : type) {
                List<Integer> cot=new ArrayList<>();
                int j = 0;
                while (j < month.size()) {
                    QueryWrapper<EmpIden> userQueryWrapper = Wrappers.query();
                    userQueryWrapper.eq("status", t).like("idate", month.get(j++));
                    Integer count = empIdenMapper.selectCount(userQueryWrapper);
                    cot.add(count);
                    userQueryWrapper.clear();
                }
                all.put(t, cot);
            }

            int j = 0;
            while (j < month.size() ) {
                QueryWrapper<EmpIs> userQueryWrapper = Wrappers.query();
                userQueryWrapper.likeRight("begin", month.get(j++));
                Integer count = empIsMapper.selectCount(userQueryWrapper);
                list.add(count);
            }
            all.put("隔离", list);

            lineVO.setStatus(all);
            return lineVO;
        }

    @Override
    public List<PieVo> pieVOMap() {
        List<PieVo> pielist=new ArrayList<>();
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("isImp","1");
        List<MaterialManage> list=materialMapper.selectList(queryWrapper);
        for (MaterialManage mat:list){
            PieVo pieVo=new PieVo();
            pieVo.setName(mat.getName());
            pieVo.setValue(mat.getCount());
            pielist.add(pieVo);
        }
        return pielist;
    }


}
