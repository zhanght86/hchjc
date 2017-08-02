package cn.river.web;

import cn.river.dto.AjaxResult2;
import cn.river.service.SensorDataService;
import cn.river.utils.UtilDate;
import cn.river.utils.UtilLog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Guide on 2017/3/20.
 */
@Controller
public class OuterInterfaceAction {
    private final SensorDataService sensorDataService;
    @Autowired
    public OuterInterfaceAction(SensorDataService sensorDataService) {
        this.sensorDataService = sensorDataService;
    }
    
  //上传数据
    @RequestMapping(value = "/Sensordata",method = RequestMethod.POST)
    @ResponseBody
    public String insert(@RequestBody String Sensordata,HttpServletResponse response){
//    	System.out.println(Sensordata+"---"+UtilDate.DateTime());
    	UtilLog.log("C:\\cshlog.txt",Sensordata.toString()+"---"+UtilDate.DateTime());
//    	SensorDataEntity sensorDataEntity = JSON.parseObject(Sensordata, SensorDataEntity.class);
//    	return JSON.toJSONString(sensorDataService.insert(sensorDataEntity));
//    	if(Sensordata!=null){
////    		sensorDataService.insertPostHistory(Sensordata);
//    		return JSON.toJSONString(new AjaxResult2(0, "ok"));
//    	}else{
//    		return JSON.toJSONString(new AjaxResult2(404, "failed"));
//    	}
    	return JSON.toJSONString(new AjaxResult2(0, "ok"));
    }
}
