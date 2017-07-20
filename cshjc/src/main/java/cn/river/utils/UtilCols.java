package cn.river.utils;

import java.util.ArrayList;
import java.util.List;

import static javafx.scene.input.KeyCode.V;

/**
 * Created by Guide on 2016/12/16.
 */
public class UtilCols {
    public static String[] Modify(String[] str){
        if (str==null || str.length==0){
            return null;
        }
        List<String> tmp = new ArrayList<String>();
        for (String s :str){
            if (s!=null && !s.trim().equals("") && !s.equals("options") && !s.equals("checkBox") && !s.equals("headImg") && !s.equals("id") && !s.equals("headImage") && !s.equals("image") &&!s.equals("checkBoxforDel") &&!s.equals("unionid") && !s.contains("image")  && !s.contains("Image")  && !s.contains("img")  && !s.contains("Img") && !s.contains("openid")){
                tmp.add(s);
            }
        }
        if (tmp.size()>0){
            return tmp.toArray(new String[0]);
        }
        return null;
    }

    public static Integer[] StringToIntArr(String checkBoxforDel){
        List<Integer> ids = new ArrayList<Integer>();
        if (checkBoxforDel!=null && checkBoxforDel.length()>0){
            String[] str = checkBoxforDel.split(",");
            for (String s : str ){
                Integer i = Integer.valueOf(s);
                if (i!=null && i>=0){
                    ids.add(i);
                }
            }
        }else{
            ids=null;
        }
        if (ids==null){
            return null;
        }
        if (ids.size()==0){
            return null;
        }
        return ids.toArray(new Integer[0]);
    }


    public static String[] StringToStrArr(String checkBoxforDel){
        List<String> ids = new ArrayList<String>();
        if (checkBoxforDel!=null && checkBoxforDel.length()>0){
            String[] str = checkBoxforDel.split(",");
            for (String s : str ){
                if (s!=null && s.length()>20){
                    ids.add(s);
                }
            }
        }else{
            ids=null;
        }
        if (ids==null){
            return null;
        }
        if (ids.size()==0){
            return null;
        }
        return ids.toArray(new String[0]);
    }
}
