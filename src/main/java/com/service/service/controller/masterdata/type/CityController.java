
package com.service.service.controller.masterdata.type;


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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.validation.Valid;
import jakarta.servlet.http.HttpServletRequest;
 
import com.service.service.Util.CommonUtil;
import com.service.service.Util.PaginationUtil;
import com.service.service.Util.response.ResponseUtils;
import com.service.service.constant.ResponRequestConstant;
import com.service.service.exception.NotFoundException;


import com.service.service.service.masterdata.type.CityService;
import com.service.service.dto.masterdata.type.CityDTO;
import com.service.service.entity.masterdata.type.CityEntity;


@RestController
@RequestMapping("/city")
public class CityController extends CommonUtil { 
 
     @Autowired
    CityService service;

    String path = "city";

    @PostMapping
    ResponseEntity<ResponseUtils> create(@RequestBody @Valid CityDTO dto) {
        CityEntity entity = service.save(ConvertModel(dto, CityEntity.class));
        CityDTO res = ConvertModel(entity, CityDTO.class);
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
    ResponseEntity<ResponseUtils> update(@RequestBody @Valid CityDTO dto) {
        CityEntity entity = service.update(dto.getId(),
                ConvertModel(dto, CityEntity.class));
        Object res = (entity == null ? (dto.getId() + " Not Found")
                : ConvertModel(entity, CityDTO.class));
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
        ResponseEntity<ResponseUtils> getAll(
                        @RequestParam(name = "page", required = false) Integer page,
                        @RequestParam(name = "page_size", required = false) Integer pageSize,
                        @RequestParam(name = "order_by", required = false) String orderBy,
                        @RequestParam(name = "sort_by", required = false) String sortBy,
                        HttpServletRequest request) {

                Object res = null;
                Page<CityEntity> dataPage = null;
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
                                .orElseThrow(() -> new NotFoundException(
                                        id + " Not Found"))),
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