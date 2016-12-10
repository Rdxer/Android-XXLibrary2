package com.rdxer.xxlibrary.javaExtension;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LXF on 2015/07/10.
 */

public class ListEX {

    public static  <T>  T fastObj(List<T> list){
        return safe(list,0);
    }
    public static <T> void fastObj(List<T> list,IEXValue<T> iex){
        T v = fastObj(list);
        if (v != null) {
            iex.complete(v);
        }
    }

    public  static <T> T lastObj(List<T> list){
        if (list == null){
            return null;
        }
        return safe(list,list.size()-1);
    }

    public  static  <T> void lastObj(List<T> list,IEXValue<T> iex){
        T v = lastObj(list);
        if (v != null) {
            iex.complete(v);
        }
    }

    public  static <T> T safe(List<T> list,int index){
        if (list == null) {
            return null;
        }
        int size = list.size();
        if (size < 1){
            return null;
        }
        if (size<=index){
            return null;
        }
        return list.get(index);
    }

    public  static <T> void safe(List<T> list,int index,IEXValue<T> iex){
        T v = safe(list,index);
        if (v != null) {
            iex.complete(v);
        }
    }

    public  static <T> List<T> filter(List<T> list,IEXValueFilter<T> filter){
        List<T> res = new ArrayList<>();
        for (T obj:list) {
            if (filter.filter(obj)){
                res.add(obj);
            }
        }
        return res;
    }

    public   static <T> List<T> filter(List<T> list,IEXValueCompose<T> compose){
        List<T> res = new ArrayList<>();
        for (T obj:list) {
            T resObj = compose.compose(obj);
            if (resObj != null){
                res.add(resObj);
            }
        }
        return res;
    }



}
