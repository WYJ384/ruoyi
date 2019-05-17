package com.ruoyi.taskdomain;

public class ScoreActivityVO {
    //部门
    private String deptName;
    //省公司考核得分
    private Double shenggongsikaohe;
    //总经理考核
    private Double zongjingliScore;
    //分管领导考核
    private Double fenguanScore1;
    //分管领导考核
    private Double fenguanScore2;
    //分管领导考核
    private Double fenguanScore3;
    //省市一体化考核
    private Double shengshiyitihuaScore;
    //    安全生产考核
    private Double anquanshengchanScore;
    //    政企支撑考核
    private Double zhengqizhicheng;
    //    监控工单考核
    private Double jiankonggongdan;
    //    党建工作考核
    private Double dangjiangongzuo;
    //    网络安全得分
    private Double wangluoanquan;
    //    资源
    private Double ziyuan;
    //    基础
    private Double jichu;
    //    总经理加扣分
    private Double zongjinglijiafen;
    //    省公司月度考核
    private Double shenggongsiyuedukaohe;
    //    总分
    private Double totalScore;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Double getShenggongsikaohe() {
        return shenggongsikaohe;
    }

    public void setShenggongsikaohe(Double shenggongsikaohe) {
        this.shenggongsikaohe = shenggongsikaohe;
    }

    public Double getZongjingliScore() {
        return zongjingliScore;
    }

    public void setZongjingliScore(Double zongjingliScore) {
        this.zongjingliScore = zongjingliScore;
    }

    public Double getFenguanScore1() {
        return fenguanScore1;
    }

    public void setFenguanScore1(Double fenguanScore1) {
        this.fenguanScore1 = fenguanScore1;
    }

    public Double getFenguanScore2() {
        return fenguanScore2;
    }

    public void setFenguanScore2(Double fenguanScore2) {
        this.fenguanScore2 = fenguanScore2;
    }

    public Double getFenguanScore3() {
        return fenguanScore3;
    }

    public void setFenguanScore3(Double fenguanScore3) {
        this.fenguanScore3 = fenguanScore3;
    }

    public Double getShengshiyitihuaScore() {
        return shengshiyitihuaScore;
    }

    public void setShengshiyitihuaScore(Double shengshiyitihuaScore) {
        this.shengshiyitihuaScore = shengshiyitihuaScore;
    }

    public Double getAnquanshengchanScore() {
        return anquanshengchanScore;
    }

    public void setAnquanshengchanScore(Double anquanshengchanScore) {
        this.anquanshengchanScore = anquanshengchanScore;
    }

    public Double getZhengqizhicheng() {
        return zhengqizhicheng;
    }

    public void setZhengqizhicheng(Double zhengqizhicheng) {
        this.zhengqizhicheng = zhengqizhicheng;
    }

    public Double getJiankonggongdan() {
        return jiankonggongdan;
    }

    public void setJiankonggongdan(Double jiankonggongdan) {
        this.jiankonggongdan = jiankonggongdan;
    }

    public Double getDangjiangongzuo() {
        return dangjiangongzuo;
    }

    public void setDangjiangongzuo(Double dangjiangongzuo) {
        this.dangjiangongzuo = dangjiangongzuo;
    }

    public Double getWangluoanquan() {
        return wangluoanquan;
    }

    public void setWangluoanquan(Double wangluoanquan) {
        this.wangluoanquan = wangluoanquan;
    }

    public Double getZiyuan() {
        return ziyuan;
    }

    public void setZiyuan(Double ziyuan) {
        this.ziyuan = ziyuan;
    }

    public Double getJichu() {
        return jichu;
    }

    public void setJichu(Double jichu) {
        this.jichu = jichu;
    }

    public Double getZongjinglijiafen() {
        return zongjinglijiafen;
    }

    public void setZongjinglijiafen(Double zongjinglijiafen) {
        this.zongjinglijiafen = zongjinglijiafen;
    }

    public Double getShenggongsiyuedukaohe() {
        return shenggongsiyuedukaohe;
    }

    public void setShenggongsiyuedukaohe(Double shenggongsiyuedukaohe) {
        this.shenggongsiyuedukaohe = shenggongsiyuedukaohe;
    }

    public Double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore() {
        if (shenggongsikaohe == null) {
            shenggongsikaohe = 0D;
        }
        if (zongjingliScore == null) {
            zongjingliScore = 0D;
        }
        if (fenguanScore1 == null) {
            fenguanScore1 = 0D;
        }
        if (fenguanScore2 == null) {
            fenguanScore2 = 0D;
        }
        if (fenguanScore3 == null) {
            fenguanScore3 = 0D;
        }
        if (shengshiyitihuaScore == null) {
            shengshiyitihuaScore = 0D;
        }
        if (anquanshengchanScore == null) {
            anquanshengchanScore = 0D;
        }
        if (zhengqizhicheng == null) {
            zhengqizhicheng = 0D;
        }
        if (jiankonggongdan == null) {
            jiankonggongdan = 0D;
        }
        if (dangjiangongzuo == null) {
            dangjiangongzuo = 0D;
        }
        if (wangluoanquan == null) {
            wangluoanquan = 0D;
        }
        if (zongjinglijiafen == null) {
            zongjinglijiafen = 0D;
        }
        if (shenggongsiyuedukaohe == null) {
            shenggongsiyuedukaohe = 0D;
        }
        this.totalScore = shenggongsikaohe * (zongjingliScore + fenguanScore1 + fenguanScore2 + fenguanScore3 +
                shengshiyitihuaScore + anquanshengchanScore + zhengqizhicheng + jiankonggongdan + dangjiangongzuo + wangluoanquan) / 100 + zongjinglijiafen + shenggongsiyuedukaohe;

    }
}
