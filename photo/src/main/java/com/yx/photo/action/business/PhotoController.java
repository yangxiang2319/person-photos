package com.yx.photo.action.business;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;

/**
 * 相册正页controller
 * @author yangxiang
 * @date 2018/7/18 14:26
 * @param 
 * @return
 */
@Controller
@RequestMapping("/bus")
public class PhotoController {

    private static final Logger log = LoggerFactory.getLogger(PhotoController.class);

    /**
     * 显示主页面
     * @author yangxiang
     * @date 2018/7/18 14:43
     * @param 
     * @return
     */
    @RequestMapping("/show")
    public String showPhoto(HttpServletRequest request){
        log.info("跳到系统主页面");
         return "business/main";
    }

    /**
     * 登录验证
     * @author yangxiang
     * @date 2018/7/18 14:44
     * @param 
     * @return
     */
    @RequestMapping("/loginValidate")
    @ResponseBody
    public String loginValidate(HttpServletRequest request){
        log.info("开始校验登录信息");
        JSONObject rst = new JSONObject();
        //验证通过 code=0  验证不通过 code=1
        rst.put("code","0");
        String rstStr = rst.toJSONString();
        log.info("校验结果：{}",rstStr);
        return rstStr;
    }
}
