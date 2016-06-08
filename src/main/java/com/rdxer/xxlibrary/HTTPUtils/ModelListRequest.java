package com.rdxer.xxlibrary.HTTPUtils;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.rdxer.xxlibrary.HTTPUtils.listener.ErrorListener;
import com.rdxer.xxlibrary.HTTPUtils.listener.FailedListener;
import com.rdxer.xxlibrary.HTTPUtils.listener.OKListener;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by LXF on 16/6/3.
 */

public class ModelListRequest<T> extends XXRequest<List<T>> {


    public ModelListRequest(URLInfo url, JSONObject requestBody, OKListener<List<T>> okListener, FailedListener failedListener, ErrorListener errorListener) {
        super(url, requestBody, okListener, failedListener, errorListener);
    }

    @Override
    protected List<T> parseResponseToTarget(JSONObject response) throws Exception {
        JSONArray res = (JSONArray) getTargetData(response);
        return (List<T>)res.toJavaObject(getTClass());
    }

    public Class<T> getTClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
}
