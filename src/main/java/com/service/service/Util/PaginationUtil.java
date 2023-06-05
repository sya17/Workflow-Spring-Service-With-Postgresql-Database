package com.service.service.Util;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.service.service.Util.response.Pagination;

public class PaginationUtil {

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
