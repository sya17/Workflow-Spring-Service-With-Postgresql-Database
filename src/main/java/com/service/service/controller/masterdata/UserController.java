package com.service.service.controller.masterdata;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RestController;

import com.service.service.Util.CommonUtil;
import com.service.service.Util.response.ResponseUtils;
import com.service.service.constant.ResponRequestConstant;
import com.service.service.dto.masterdata.UserDTO;
import com.service.service.entity.masterdata.UserEntity;
import com.service.service.exception.NotFoundException;
import com.service.service.service.masterdata.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController extends CommonUtil {

    @Autowired
    UserService userService;

    String path = "users";

    @PostMapping
    ResponseEntity<ResponseUtils> create(@RequestBody @Valid UserDTO user) {
        UserEntity usermodel = userService.save(ConvertModel(user, UserEntity.class));
        UserDTO userRes = ConvertModel(usermodel, UserDTO.class);
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(
                        setGeneralResponse(
                                userRes,
                                path,
                                ResponRequestConstant.MethodConstant.POST));
    }

    @PutMapping()
    ResponseEntity<ResponseUtils> update(@RequestBody @Valid UserDTO user) {
        UserEntity usermodel = userService.update(user.getId(), ConvertModel(user, UserEntity.class));
        Object res = (usermodel == null ? (user.getId() + " Not Found") : ConvertModel(usermodel, UserDTO.class));
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(
                        setGeneralResponse(
                                res,
                                path,
                                ResponRequestConstant.MethodConstant.PUT));
    }

    @GetMapping()
    ResponseEntity<ResponseUtils> getAll() {
        ResponseUtils res = setGeneralResponse(
                userService.getAll(),
                path,
                ResponRequestConstant.MethodConstant.GET);
        setPage(res);
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(res);
    }

    @GetMapping("/{id}")
    ResponseEntity<ResponseUtils> getById(@PathVariable("id") String id) {
        ResponseUtils res = setGeneralResponse(
                (isNullOrEmpty(id) ? userService.getAll()
                        : userService
                                .getById(id)
                                .orElseThrow(() -> new NotFoundException(id + " Not Found"))),
                path,
                ResponRequestConstant.MethodConstant.GET);
        setPage(res);
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(res);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<ResponseUtils> deleteById(@PathVariable("id") String id) {
        Object res = userService.deleteById(id) ? "Delete Success" : id + " Not Found";
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(setGeneralResponse(
                        res,
                        path,
                        ResponRequestConstant.MethodConstant.DELETE));
    }
}
