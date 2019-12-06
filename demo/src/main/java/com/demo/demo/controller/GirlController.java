package com.demo.demo.controller;


import com.demo.demo.domain.GirlAll;
import com.demo.demo.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {

    @Autowired
    private GirlRepository gr;

    /**
     * 查询女生所有列表
     * @return
     */
    @GetMapping(value = "/findGirls")
    public List<GirlAll> gitlList(){
        return gr.findAll();
    }

    /**
     * 保存女生信息
     * @param cupSize
     * @param age
     * @return
     */
    @PostMapping(value = "girlAdd")
    public GirlAll girlAdd(@Valid GirlAll girl, BindingResult br){
        if(br.hasErrors()){
            System.out.println(br.getFieldError().getDefaultMessage());//获取验证不通过的信息
            return null;
        }
        girl.setAge(35);
        girl.setCupSize("F");

       return gr.save(girl);
    }

    /**
     * 根据ID查询
     * @return
     */
    @GetMapping(value = "/findById/{id}")
    public GirlAll findGirlById(@PathVariable("id") Integer id){
        return gr.getOne(id);
    }
    /**
     * 根据年龄查询
     * @return
     */
    @GetMapping(value = "/findByAge/{age}")
    public List<GirlAll> findGirlByAge(@PathVariable("age") Integer age){
        return gr.findByAge(age);
    }

    /**
     * 更新
     * @return
     */
    @PutMapping(value = "/updateById/{id}")
    public GirlAll updateGirlById(@PathVariable("id") Integer id){
        GirlAll ga = new GirlAll();
        ga.setCupSize("A");
        ga.setId(id);
        ga.setAge(11);

        return gr.save(ga);
    }

    /**
     * 删除
     * @return
     */
    @GetMapping(value = "/deleteById/{id}")
    public void deleteGirlById(@PathVariable("id") Integer id){
        gr.deleteById(id);
    }
}
