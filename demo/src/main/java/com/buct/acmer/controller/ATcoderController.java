package com.buct.acmer.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.buct.acmer.entity.ATcoder;
import com.buct.acmer.entity.ContestInfo;
import com.buct.acmer.entity.PublicProperty;
import com.buct.acmer.service.impl.ATcoderServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author BUCT
 * @since 2022-06-14
 */
@Api(tags = "ATCoder")
@RestController
@RequestMapping("/acmer/atcoder")
public class ATcoderController {

    @Resource
    private ATcoderServiceImpl atcoderService;

    @ApiOperation("查询全部学生AtCoder信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage",value = "当前页数",required = true),
            @ApiImplicitParam(name = "pageSize",value = "页面大小",required = true)
    })
    @GetMapping("/all/{currentPage}/{pageSize}")
    public PublicProperty<Page<ATcoder>> selectAll(@PathVariable("currentPage") Integer currentPage,
                                                   @PathVariable("pageSize") Integer pageSize){

        Page<ATcoder> page = new Page<>(currentPage,pageSize);
        return new PublicProperty(200,"success",atcoderService.page(page));
    }

}