package com.huashijun.drools.service;

import com.alibaba.fastjson2.JSON;
import com.huashijun.drools.model.OrderInfoVO;
import com.huashijun.drools.model.PayInfoModel;
import com.huashijun.drools.model.UserType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderInfoService {

    @Autowired
    private KieContainer kieContainer;

    public PayInfoModel getPayInfo(OrderInfoVO orderInfoVO) {
        //通过订单号查询出支付信息
        PayInfoModel model = new PayInfoModel();
        model.setOrderNumber("order123456");
        model.setAmount(200);
        model.setUserType(UserType.FIRSTLEVEL);
        System.out.println("打折前== " + JSON.toJSONString(model));
        // 开启会话
        KieSession kieSession = kieContainer.newKieSession();
        // 设置折扣对象
        kieSession.setGlobal("payInfoModel", model);
        // 设置订单信息对象
        kieSession.insert(model);
        // 触发规则
        kieSession.fireAllRules();
        // 中止会话
        kieSession.dispose();
        System.out.println("打折后== " + JSON.toJSONString(model));
        return model;
    }
}
