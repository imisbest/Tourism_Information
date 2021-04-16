package com.csw.controller;

import com.csw.entity.Province;
import com.csw.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by Administrator on 2019/10/23.
 */
@Controller
@Scope(value = "prototype")
public class ProvinceAction {
    @Autowired
    private ProvinceService provinceService;
    private List<Province> provinceList;
    private Integer countPage;
    private Integer currPage;
    private Integer pageSize = 2;
    private Integer pid;
    private Province province;

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getCountPage() {
        return countPage;
    }

    public void setCountPage(Integer countPage) {
        this.countPage = countPage;
    }

    public Integer getCurrPage() {
        return currPage;
    }

    public void setCurrPage(Integer currPage) {
        this.currPage = currPage;
    }

    public List<Province> getProvinceList() {
        return provinceList;
    }

    public void setProvinceList(List<Province> provinceList) {
        this.provinceList = provinceList;
    }

    public String queryAndPage() {
        System.out.println("进queryAndPage");
        countPage = provinceService.countPage(pageSize);
        System.out.println("countPage" + countPage);
        if (currPage == -1) {///分页
            currPage = 0;///分页
        }///分页
        if (currPage == 0) {///分页
            currPage = 1;///分页
        }///分页
        if (currPage == countPage + 1) {///分页
            currPage = countPage;///分页
        }///分页
        provinceList = provinceService.queryAllAndByPage(currPage, pageSize, countPage);
        int t = currPage;///分页
        currPage = t;///分页
        System.out.println("出queryAndPage");
        return "provincelist";
    }

    public String deleteAction() {
        provinceService.deleteById(pid);
        return "queryAndPage";
    }

    public String updateprovince() {
        province = provinceService.queryById(pid);
        return "updateprovince";
    }

    public String updateOver() {

        System.out.println("pid//:"+pid);
        provinceService.updateById(new Province(pid, province.getProvince(), province.getTaglib(), null));
        return "queryAndPage";
    }

    public String addProvince() {
        province.setId(null);
        province.setSpots(0);
        provinceService.addProvince(province);
        return "queryAndPage";
    }

}
