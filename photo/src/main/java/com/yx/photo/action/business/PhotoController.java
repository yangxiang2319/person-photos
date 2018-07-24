package com.yx.photo.action.business;

import com.alibaba.fastjson.JSONObject;
import com.yx.photo.service.user.UserService;
import com.yx.photo.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

    @Autowired
    private UserService userService;

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
     * @param user
     * @return
     */
    @RequestMapping("/loginValidate")
    @ResponseBody
    public String loginValidate(HttpServletRequest request, User user){
        log.info("开始校验登录信息");
        JSONObject rst = new JSONObject();
        //验证通过 code=0  验证不通过 code=1
        JSONObject backRst = userService.getUser(user);
        String code = backRst.getString("code");
        if("1".equals(code) || "2".equals(code)){
            rst.put("code","1");
            rst.put("msg",backRst.getString("msg"));
        }else{

            User backUser = (User)backRst.get("user");
            //验证密码
            if(user.getPassword().equals(backUser.getPassword())){
                rst.put("code","0");
                //将用户信息保存在session中
                HttpSession session = request.getSession();
                session.setAttribute("user",backUser);
            }else{
                rst.put("code","1");
                rst.put("msg","密码错误");
            }
        }
        String rstStr = rst.toJSONString();
        log.info("校验结果：{}",rstStr);
        return rstStr;
    }
}
