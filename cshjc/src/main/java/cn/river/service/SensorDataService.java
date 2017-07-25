package cn.river.service;

import cn.river.dao.DevicesDataDao;
import cn.river.dto.AjaxResult2;
import cn.river.entity.DevicesDataEntity;
import cn.river.entity.SensorDataEntity;
import cn.river.utils.UtilDate;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Guide on 2017/2/6.
 */
@Service
public class SensorDataService {
    @Resource
    DevicesDataDao devicesDataDao;

    //insert
    public AjaxResult2 insert(SensorDataEntity sensorDataEntity){
        if (sensorDataEntity==null) {
            return new AjaxResult2(400, "data empty");
        }else if(sensorDataEntity.getDeviceID()==null || "".equals(sensorDataEntity.getDeviceID())){
        	return new AjaxResult2(400, "DeviceID empty");
        }else if(sensorDataEntity.getVersion()==null || "".equals(sensorDataEntity.getVersion())){
        	return new AjaxResult2(400, "Version empty");
        }else if(sensorDataEntity.getQuanity()==null || "".equals(sensorDataEntity.getQuanity())){
        	return new AjaxResult2(400, "Quanity empty");
        }else if(sensorDataEntity.getTimestamp()==null || "".equals(sensorDataEntity.getTimestamp())){
        	return new AjaxResult2(400, "Timesamp empty");
        }else if(sensorDataEntity.getBlaRriData().getCod()==null || "".equals(sensorDataEntity.getBlaRriData().getCod())){
        	return new AjaxResult2(400, "COD empty");
        }else if(sensorDataEntity.getBlaRriData().getDoPer()==null || "".equals(sensorDataEntity.getBlaRriData().getDoPer())){
        	return new AjaxResult2(400, "DO percent empty");
        }else if(sensorDataEntity.getBlaRriData().getDoVal()==null || "".equals(sensorDataEntity.getBlaRriData().getDoVal())){
        	return new AjaxResult2(400, "DO value empty");
        }else if(sensorDataEntity.getBlaRriData().getNH4()==null || "".equals(sensorDataEntity.getBlaRriData().getNH4())){
        	return new AjaxResult2(400, "NH4 empty");
        }else if(sensorDataEntity.getBlaRriData().getTemp()==null || "".equals(sensorDataEntity.getBlaRriData().getTemp())){
        	return new AjaxResult2(400, "TEMP empty");
        }else if(sensorDataEntity.getBlaRriData().getORP()==null || "".equals(sensorDataEntity.getBlaRriData().getORP())){
        	return new AjaxResult2(400, "orp empty");
        }else if(sensorDataEntity.getBlaRriData().getZS()==null || "".equals(sensorDataEntity.getBlaRriData().getZS())){
        	return new AjaxResult2(400, "ZS empty");
        }
        //开始添加
        DevicesDataEntity devicesDataEntity = new DevicesDataEntity();
        devicesDataEntity.setDeviceId(sensorDataEntity.getDeviceID());
        devicesDataEntity.setCod(sensorDataEntity.getBlaRriData().getCod());
        
        devicesDataEntity.setDoPer(sensorDataEntity.getBlaRriData().getDoPer());
        devicesDataEntity.setDoVal(sensorDataEntity.getBlaRriData().getDoVal());
        devicesDataEntity.setNh4(sensorDataEntity.getBlaRriData().getNH4());
        devicesDataEntity.setTemp(sensorDataEntity.getBlaRriData().getTemp());
        devicesDataEntity.setOrp(sensorDataEntity.getBlaRriData().getORP());
        devicesDataEntity.setZs(sensorDataEntity.getBlaRriData().getZS());
        devicesDataEntity.setVersion(sensorDataEntity.getVersion());
        devicesDataEntity.setQuanity(sensorDataEntity.getQuanity());
        devicesDataEntity.setDevicePostTime(sensorDataEntity.getTimestamp());
        devicesDataEntity.setAddTime(UtilDate.DateTime());
        
        int ret = devicesDataDao.insert(devicesDataEntity);
        if (ret<=0){
            return new AjaxResult2(404, "failed");
        }else{
            return new AjaxResult2(0, "ok");
        }
    }

}
