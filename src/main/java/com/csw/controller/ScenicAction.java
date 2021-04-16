package com.csw.controller;

import com.csw.entity.Province;
import com.csw.entity.Scenic;
import com.csw.service.ProvinceService;
import com.csw.service.ScenicService;
import com.sun.mail.imap.protocol.ID;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2019/10/23.
 */
@Controller
@Scope(value = "prototype")
public class ScenicAction {
    HttpSession session = ServletActionContext.getRequest().getSession();
    @Autowired
    private ScenicService scenicService;
    @Autowired
    private ProvinceService provinceService;
    private Integer countPage;
    private Integer currPage;
    private Integer pageSize = 2;
    private Integer pid;
    private List<Scenic> scenicList;
    private Scenic scenic;
    private List<Province> provinceList;
    private Province province;
    private File cover;
    private String coverFileName;

    public File getCover() {
        return cover;
    }

    public void setCover(File cover) {
        this.cover = cover;
    }

    public String getCoverFileName() {
        return coverFileName;
    }

    public void setCoverFileName(String coverFileName) {
        this.coverFileName = coverFileName;
    }

    public List<Province> getProvinceList() {
        return provinceList;
    }

    public void setProvinceList(List<Province> provinceList) {
        this.provinceList = provinceList;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public List<Scenic> getScenicList() {
        return scenicList;
    }

    public void setScenicList(List<Scenic> scenicList) {
        this.scenicList = scenicList;
    }

    public Scenic getScenic() {
        return scenic;
    }

    public void setScenic(Scenic scenic) {
        this.scenic = scenic;
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

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String queryAndPage() {
        /**
         * pid判空验证，这里的pid是省份的id
         */
        System.out.println("pid:" + pid);
        if (pid != null) {
            session.setAttribute("pid", pid);
        }
        if (pid == null) {
            pid = (Integer) session.getAttribute("pid");
            System.out.println("pid:" + pid);
        }
        /**
         *
         */
        System.out.println("进queryAndPage");
        countPage = scenicService.countPage(pageSize, pid);
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
        /**
         *传值
         */

        scenicList = scenicService.queryAllAndByPage(currPage, pageSize, countPage, pid);
        province = provinceService.queryById(pid);
        /**
         *currPage后续处理
         */
        int t = currPage;///分页
        currPage = t;///分页
        System.out.println("出queryAndPage");
        return "viewspotlist";
    }

    public String deleteView() {
        scenicService.deleteView(pid);
        province = provinceService.queryById((Integer) session.getAttribute("pid"));///
        province.setSpots(province.getSpots() - 1);///
        provinceService.updateSpots(province);///
        return "queryAndPage";
    }

    public String updateFirst() {
        System.out.println("updateFirst????????????????????????????????????");
        scenic = scenicService.queryById(pid);
        System.out.println("scenic//:" + scenic);
        province = provinceService.queryById(pid);
        System.out.println("province//:" + province);
        provinceList = provinceService.queryAll();
        for (Province province1 : provinceList) {
            System.out.println("provinceList" + province1);
        }
        return "updateviewspot";
    }

    public String updateView() throws IOException {
        System.out.println("updateView????????????????????????????????????");
        /**
         * pid是景点id
         */
        scenic.setId(pid);
        System.out.println("cover:" + cover);
        String path = ServletActionContext.getServletContext().getRealPath(
                "/img");
        if (cover != null) {
            FileUtils.copyFile(cover, new File(path + "//" + coverFileName));
            scenic.setCover(coverFileName);
        }
        System.out.println("scenic//:" + scenic);
        scenicService.updateView(scenic, cover);
        /**
         *数量改变
         */
        if (scenic.getSid() != (Integer) session.getAttribute("pid")) {
            /**
             * 本省份减1
             */
            province = provinceService.queryById((Integer) session.getAttribute("pid"));///
            province.setSpots(province.getSpots() - 1);///
            provinceService.updateSpots(province);///
            /**
             * 其他省份加一
             */
            province = provinceService.queryById(scenic.getSid());///
            province.setSpots(province.getSpots() + 1);///
            provinceService.updateSpots(province);///
            /**
             * 更新到其他省份的pid
             */
            session.setAttribute("pid", scenic.getSid());
        }

        return "queryAndPage";
    }

    public String addFirst() {
        provinceList = provinceService.queryAll();
        return "addviewspot";
    }

    public String addLast() throws IOException {
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAALLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL");
        System.out.println("cover addLast:" + cover);
        /**
         * cover判空
         */
        if (cover == null) {
            return "addFirst";
        }
        String path = ServletActionContext.getServletContext().getRealPath(
                "/img");
        FileUtils.copyFile(cover, new File(path + "//" + coverFileName));
        scenic.setCover(coverFileName);
        //scenic.setSid((Integer) session.getAttribute("pid"));
        System.out.println("scenic addLast://" + scenic);
        scenicService.addView(scenic);

        /**
         *数量改变
         */
        if (scenic.getSid() != (Integer) session.getAttribute("pid")) {
           /* *//**
             * 本省份减1
             *//*
            province = provinceService.queryById((Integer) session.getAttribute("pid"));///
            province.setSpots(province.getSpots() - 1);///
            provinceService.updateSpots(province);///*/
            /**
             * 其他省份加一
             */
            province = provinceService.queryById(scenic.getSid());///
            province.setSpots(province.getSpots() + 1);///
            provinceService.updateSpots(province);///
        }else {
            province = provinceService.queryById((Integer) session.getAttribute("pid"));///
            province.setSpots(province.getSpots() + 1);///
            provinceService.updateSpots(province);///*/
        }
        /**
         * 更新到其他省份的pid
         */
        session.setAttribute("pid", scenic.getSid());

        /**
         * 更新本省数目
         *//*
        province = provinceService.queryById((Integer) session.getAttribute("pid"));///
        province.setSpots(province.getSpots() + 1);///
        provinceService.updateSpots(province);///*/
        return "queryAndPage";
    }
}
