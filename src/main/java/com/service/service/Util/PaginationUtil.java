package com.service.service.Util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.service.service.Util.response.Pagination;
import com.service.service.constant.PaginationConstant;

public class PaginationUtil {

    public static PaginationUtil INSTANCE;

    public static PaginationUtil getInstance() {
        if (INSTANCE != null) {
            return INSTANCE;
        } else {
            return new PaginationUtil();
        }
    }

    Integer perPageG = PaginationConstant.page.rowsPerPage;

    public Pageable initPage(Integer page, Integer pageSize, String orderBy, String sortBy) {
        Map<String, String> mapSort = new HashMap<String, String>();
        mapSort.put("ORDER_BY", orderBy);
        mapSort.put("SORT_BY", sortBy);
        return getPageable(page, pageSize, mapSort);
    }

    public Pageable getPageable(Integer page, Integer pageSize, Map<String, String> mapSort) {
        String orderBy = mapSort.get("ORDER_BY");
        String sortBy = mapSort.get("SORT_BY");
        page = page != null ? page : 1;
        pageSize = pageSize != null ? pageSize : PaginationConstant.page.rowsPerPage;
        this.perPageG = pageSize;
        if ((!StringUtil.getInstance().isNullOrEmpty(orderBy)
                && !StringUtil.getInstance().isNullOrEmpty(sortBy))
                && (page != null && pageSize != null)) {
            System.out.println(">. Entries Paginations & Sort");
            if (orderBy.equalsIgnoreCase("ASC")) {
                PageRequest pageRequest = PageRequest.of((page - 1), pageSize, Sort.Direction.ASC, sortBy);
                return pageRequest;
            } else {
                PageRequest pageRequest = PageRequest.of((page - 1), pageSize, Sort.Direction.DESC, sortBy);
                return pageRequest;
            }
        } else {
            System.out.println(">. Entries Only Paginations");
            PageRequest pageRequest = PageRequest.of((page - 1), pageSize);
            return pageRequest;
        }
    }


    public Page<Object> pageRequest(Pageable pageable, JpaRepository repo) {
        return repo.findAll(pageable);
    }

    public Pagination getPaginations(Pageable pageable, JpaRepository repo) {
        Page<Object> paginations = repo.findAll(pageable);
        Pagination paginationsresponse = null;
        // Pagination paginationsresponse = new Pagination(
        // (paginations.getNumber() + 1),
        // paginations.getNumberOfElements(),
        // paginations.getTotalPages(),
        // (int) paginations.getTotalElements(),
        // null, null);
        return paginationsresponse;
    }
}
