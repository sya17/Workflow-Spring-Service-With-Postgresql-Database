package com.service.service.Util;

import java.util.List;

import org.springframework.validation.FieldError;

import com.service.service.Util.response.ErrorResponse;
import com.service.service.Util.response.Pagination;
import com.service.service.Util.response.ResponseUtils;
import com.service.service.constant.ResponRequestConstant;

public class CommonUtil {
    public static CommonUtil INSTANCE = new CommonUtil();

    public static CommonUtil getInstance() {
        if (INSTANCE != null) {
            return INSTANCE;
        } else {
            return new CommonUtil();
        }
    }

    public void println(String msg) {
        PrintUtil.getInstance().println(msg);
    }

    public void print(String msg) {
        PrintUtil.getInstance().print(msg);
    }

    public boolean isNullOrEmpty(String val) {
        return StringUtil.getInstance().isNullOrEmpty(val);
    }

    public <S, D> D ConvertModel(S source, Class<D> destinationClass) {
        return ModdelMapperUtil.getInstance().convert(source, destinationClass);
    }

    public void ConvertModelObj(Object source, Object destinationSource) {
        ModdelMapperUtil.getInstance().convertObj(source, destinationSource);
    }

    public void setDefaultValue() {

    }

    public ResponseUtils setGeneralResponse(
            Object data,
            String path,
            String method) {
        return setGeneralResponse(data, path, method, null, null);
    }

    public ResponseUtils setGeneralResponse(
            Object data,
            String path,
            String method,
            String msg,
            List<ErrorResponse> errMsg) {
                ResponseUtils resUtils = new ResponseUtils();
                resUtils.setService("/" + path);
        if (!isNullOrEmpty(method)) {
            switch (method) {
                case ResponRequestConstant.MethodConstant.POST:
                    resUtils.setMessage("Create Successfully");
                    break;
                case ResponRequestConstant.MethodConstant.PUT:
                    resUtils.setMessage("Updated Successfully");
                    break;
                case ResponRequestConstant.MethodConstant.GET:
                    resUtils.setMessage("Get Successfully");
                    break;
                case ResponRequestConstant.MethodConstant.DELETE:
                    resUtils.setMessage("Delete Successfully");
                    break;
                default:
                    break;
            }
        }
        if (!isNullOrEmpty(msg)) {
            resUtils.setMessage(msg);
        }
        if (errMsg != null && errMsg.size() > 0) {
            resUtils.setErr_message(errMsg);
        }

        resUtils.setData(data);
        return resUtils;
    }

    public Pagination setPage(ResponseUtils responseUtils) {
        Pagination.getInstance().setNext_page_url("NEXT");
        Pagination.getInstance().setPrev_page_url("PREV");
        responseUtils.setPage(Pagination.getInstance());
        return Pagination.getInstance();
    }

}
