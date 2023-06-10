
package com.service.service.controller.masterdata.workflow;


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
import jakarta.validation.Valid;
 
import com.service.service.Util.CommonUtil;
import com.service.service.Util.response.ResponseUtils;
import com.service.service.constant.ResponRequestConstant;
import com.service.service.exception.NotFoundException;


import com.service.service.service.masterdata.workflow.WorkflowService;
import com.service.service.dto.masterdata.workflow.WorkflowDTO;
import com.service.service.entity.masterdata.workflow.WorkflowEntity;


@RestController
@RequestMapping("/workflow")
public class WorkflowController extends CommonUtil { 
 
     @Autowired
    WorkflowService service;

    String path = "workflow";

    @PostMapping
    ResponseEntity<ResponseUtils> create(@RequestBody @Valid WorkflowDTO dto) {
        WorkflowEntity entity = service.save(ConvertModel(dto, WorkflowEntity.class));
        WorkflowDTO res = ConvertModel(entity, WorkflowDTO.class);
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(
                        setGeneralResponse(
                                res,
                                path,
                                ResponRequestConstant.MethodConstant.POST));
    }

    @PutMapping()
    ResponseEntity<ResponseUtils> update(@RequestBody @Valid WorkflowDTO dto) {
        WorkflowEntity entity = service.update(dto.getId(),
                ConvertModel(dto, WorkflowEntity.class));
        Object res = (entity == null ? (dto.getId() + " Not Found")
                : ConvertModel(entity, WorkflowDTO.class));
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
                service.getAll(),
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
                (isNullOrEmpty(id) ? service.getAll()
                        : service
                                .getByIdOpt(id)
                                .orElseThrow(() -> new NotFoundException(
                                        id + " Not Found"))),
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