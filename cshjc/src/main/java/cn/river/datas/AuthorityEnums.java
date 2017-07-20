package cn.river.datas;

/**
 * Created by Guide on 2017/3/20.
 */
public enum AuthorityEnums {
    SPOTS("采集点管理"),
    DEVICES("设备管理"),
    INTERFACES("接口管理"),
    DATA_CENTER("数据中心"),
    DATA_BACKUP("数据备份"),
    DATA_RECOVERY("数据恢复"),
    DATA_CLEAN("数据清洗"),
    AUTHORITIES("权限管理"),
    ADMINS("管理员管理"),
    SYSPARAMs("系统参数");

    private String name;

    AuthorityEnums(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
