package com.service.service.controller.masterdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service.service.Util.CommonUtil;
import com.service.service.Util.PaginationUtil;
import com.service.service.Util.response.ResponseUtils;
import com.service.service.constant.ResponRequestConstant;
import com.service.service.dto.masterdata.UserDTO;
import com.service.service.entity.masterdata.UserEntity;
import com.service.service.exception.NotFoundException;
import com.service.service.service.masterdata.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController extends CommonUtil {

    @Autowired
    UserService service;

    String path = "users";

    @PostMapping
    ResponseEntity<ResponseUtils> create(@RequestBody @Valid UserDTO user) {
        UserEntity usermodel = service.save(ConvertModel(user, UserEntity.class));
        UserDTO userRes = ConvertModel(usermodel, UserDTO.class);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(
                        setGeneralResponse(
                                userRes,
                                path,
                                ResponRequestConstant.MethodConstant.POST));
    }

    @PutMapping()
    ResponseEntity<ResponseUtils> update(@RequestBody @Valid UserDTO user) {
        UserEntity usermodel = service.update(user.getId(), ConvertModel(user, UserEntity.class));
        Object res = (usermodel == null ? (user.getId() + " Not Found") : ConvertModel(usermodel, UserDTO.class));
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(
                        setGeneralResponse(
                                res,
                                path,
                                ResponRequestConstant.MethodConstant.PUT));
    }

    @GetMapping()
    ResponseEntity<ResponseUtils> getAll(
                    @RequestParam(name = "page", required = false) Integer page,
                    @RequestParam(name = "page_size", required = false) Integer pageSize,
                    @RequestParam(name = "order_by", required = false) String orderBy,
                    @RequestParam(name = "sort_by", required = false) String sortBy,
                    HttpServletRequest request) {

            Object res = null;
            Page<UserEntity> dataPage = null;
            if (page != null) {
                    dataPage = service
                                    .getAll(PaginationUtil.getInstance().initPage(page, pageSize, orderBy, sortBy));

            } else {
                    res = service.getAll();
            }

            return ResponseEntity
                            .status(HttpStatus.OK)
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(setGeneralResponse(
                                            res,
                                            path,
                                            ResponRequestConstant.MethodConstant.GET,
                                            request,
                                            pageSize,
                                            dataPage));
    }

    @GetMapping("/{id}")
    ResponseEntity<ResponseUtils> getById(@PathVariable("id") String id) {
        ResponseUtils res = setGeneralResponse(
                (isNullOrEmpty(id) ? service.getAll()
                        : service
                                .getByIdOpt(id)
                                .orElseThrow(() -> new NotFoundException(id + " Not Found"))),
                path,
                ResponRequestConstant.MethodConstant.GET);
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(res);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<ResponseUtils> deleteById(@PathVariable("id") String id) {
        Object res = service.deleteById(id) ? "Delete Success" : id + " Not Found";
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(setGeneralResponse(
                        res,
                        path,
                        ResponRequestConstant.MethodConstant.DELETE));
    }
}
      