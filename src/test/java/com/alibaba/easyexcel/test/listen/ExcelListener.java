package com.alibaba.easyexcel.test.listen;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;

/* 解析监听器，
* 每解析一行会回调invoke()方法。
* 整个excel解析结束会执行doAfterAllAnalysed()方法
*
* 下面只是我写的一个样例而已，可以根据自己的逻辑修改该类。
* @author anjunshuang
*/
public class ExcelListener extends AnalysisEventListener {


    private List<Object>  data = new ArrayList<Object>();

    @Override
    public void invoke(Object object, AnalysisContext context) {
        System.out.println(context.getCurrentSheet());
        data.add(object);
        if(data.size()>=100){
            doSomething();
            data = new ArrayList<Object>();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        doSomething();
    }
    public void doSomething(){
        for (Object o:data) {
            System.out.println(o);
        }
    }
}
