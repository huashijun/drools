package com.huashijun.drools.controller;

import com.huashijun.drools.model.OrderInfoVO;
import com.huashijun.drools.model.PayInfoModel;
import com.huashijun.drools.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderInfoController {

    @Autowired
    private OrderInfoService orderInfoService;

    /**
     * 获取支付信息
     */
    @PostMapping("/getPayInfo")
    public ResponseEntity<PayInfoModel> getPayInfo(@RequestBody OrderInfoVO orderInfoVO) {
        PayInfoModel model = orderInfoService.getPayInfo(orderInfoVO);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }
}
