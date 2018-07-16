package com.mo.swagger;

import com.mo.swagger.vo.BaseResponse;
import com.mo.swagger.vo.Order;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: MoXingwang 2018-07-16 16:47
 **/
@RestController
@RequestMapping("index")
public class IndexController {

    @ApiOperation(value = "常规接口")
    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public ResponseEntity<String> test1() {

        return ResponseEntity.ok("11111");
    }

    @ApiOperation(value = "ApiResponses测试泛型对象接口")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = BaseResponse.class),
            @ApiResponse(code = 200, message = "Success", response = Order.class)
    })
    @RequestMapping(value = "/test3", method = RequestMethod.GET)
    public BaseResponse<Order> test3() {

        return new BaseResponse("200", "success", new Order("11", "22"));
    }

    @ApiOperation(value = "不使用ApiResponses返回泛型对象")
    @RequestMapping(value = "/test4", method = RequestMethod.GET)
    public BaseResponse<Order> test4() {

        return new BaseResponse("200", "success", new Order("11", "22"));
    }

}
