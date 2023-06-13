package com.service.service.Util;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.validation.FieldError;

import com.service.service.Util.response.ErrorResponse;
import com.service.service.Util.response.Pagination;
import com.service.service.Util.response.ResponseUtils;
import com.service.service.constant.ResponRequestConstant;
import com.service.service.entity.masterdata.workflow.WorkflowGroupEntity;

import jakarta.servlet.http.HttpServletRequest;

public class CommonUtil {

    @Autowired
    public ModelMapper mp;

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

    public void mergeEntity(Object source, Object destinationSource) {
        if (source != null && destinationSource != null) {
            // ModdelMapperUtil.getInstance().mergeEntity(source, destinationSource);
            mp.map(source, destinationSource);
        }
    }

    public void setDefaultValue() {

    }

    public String getPathUri(HttpServletRequest request, String defaultStr) {
        if (request != null) {
            return request.getRequestURL().toString();
        } else {
            return defaultStr;
        }
    }

    public ResponseUtils setGeneralResponse(
            Object data,
            String path,
            String method) {
        return setGeneralResponse(data, path, method, null, null, null, null, null);
    }

    public ResponseUtils setGeneralResponse(
            Object data,
            String path,
            String method,
            HttpServletRequest request,
            Integer perPage,
            Page page) {
        return setGeneralResponse(data, path, method, null, null, request, perPage, page);
    }

    public ResponseUtils setGeneralResponse(
            Object data,
            String path,
            String method,
            String msg,
            Object errMsg,
            HttpServletRequest request,
            Integer perPage,
            Page page) {
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
                case ResponRequestConstant.MethodConstant.ERROR:
                    resUtils.setMessage("There is an Error");
                    break;
                default:
                    resUtils.setMessage("There is an Error");
                    break;
            }
        }
        if (!isNullOrEmpty(msg)) {
            resUtils.setMessage(msg);
        }
        if (errMsg != null) {
            resUtils.setErr_message(errMsg);
        }

        if (page != null) {
            resUtils.setPage(setPage(page, getPathUri(request, path), perPage));
            resUtils.setData(page.getContent());
        } else {
            resUtils.setData(data);
        }
        return resUtils;
    }

    public Pagination setPage(Page pagination, String endPoint) {
        return setPage(pagination, endPoint, null);
    }

    public Pagination setPage(Page pagination, String endPoint, Integer perPage) {
        Pagination paginationResponse = new Pagination<>();
        if (pagination != null) {
            String nextPage = (pagination.getNumber() + 1) < pagination.getTotalPages()
                    ? (endPoint + "?page=" + (pagination.getNumber() + 2) + "&page_size="
                            + (perPage != null ? perPage : PaginationUtil.getInstance().perPageG))
                    : null;
            String previous_page = (pagination.getNumber() + 1) > 1
                    ? (endPoint + "?page=" + (pagination.getNumber()) + "&page_size="
                            + (perPage != null ? perPage : PaginationUtil.getInstance().perPageG))
                    : null;
            paginationResponse.setNext_page_url(StringUtil.getInstance().makeStringStripIfNull(nextPage));
            paginationResponse.setPrev_page_url(StringUtil.getInstance().makeStringStripIfNull(previous_page));
            paginationResponse.setCurrent_page(pagination.getNumber() + 1);
            paginationResponse.setCurrent_element(pagination.getNumberOfElements());
            paginationResponse.setTotal_pages(pagination.getTotalPages());
            paginationResponse.setTotal_element((int) pagination.getTotalElements());
        } else {
            paginationResponse.setNext_page_url("-");
            paginationResponse.setPrev_page_url("-");
        }
        return paginationResponse;
    }

    public void workflow(JpaRepository repo, String tableName) {
        WorkflowUtil.getInstance().startWorkflow(repo, tableName);
    }
}
