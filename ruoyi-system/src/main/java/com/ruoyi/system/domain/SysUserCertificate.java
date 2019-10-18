package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 证书管理对象 sys_user_certificate
 * 
 * @author ruoyi
 * @date 2019-10-18
 */
public class SysUserCertificate extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String id;

    /** 证书级别 */
    @Excel(name = "证书级别")
    private String certLevel;

    /** 证书类型 */
    @Excel(name = "证书类型")
    private String certType;

    /** 证书名称 */
    @Excel(name = "证书名称")
    private String name;

    /** 姓名 */
    @Excel(name = "姓名")
    private String userName;

    /** 证书编号 */
    @Excel(name = "证书编号")
    private String certNo;

    /** 用户ID */
    @Excel(name = "用户ID")
    private String userId;

    /** 颁发日期 */
    @Excel(name = "颁发日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date certTime;

    /** 有效期至 */
    @Excel(name = "有效期至", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 证书扫描件 */
    @Excel(name = "证书扫描件")
    private String certImg;

    /** 扩展3 */
    private String remark3;

    /** 扩展4 */
    private String remark4;

    /** 扩展5 */
    private String remark5;

    /** 扩展6 */
    private String remark6;

    /** 扩展7 */
    private String remark7;

    /** 扩展8 */
    private String remark8;

    /** 扩展9 */
    private String remark9;

    /** 扩展10 */
    private String remark10;

    /** 扩展3 */
    private String remark2;

    /** 创建时间 */
    private Date createDate;

    /** 更新时间 */
    private Date updateDate;

    /** 删除标记 */
    private String delFlag;

    /** 扩展1 */
    private String remark1;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setCertLevel(String certLevel) 
    {
        this.certLevel = certLevel;
    }

    public String getCertLevel() 
    {
        return certLevel;
    }
    public void setCertType(String certType) 
    {
        this.certType = certType;
    }

    public String getCertType() 
    {
        return certType;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }
    public void setCertNo(String certNo) 
    {
        this.certNo = certNo;
    }

    public String getCertNo() 
    {
        return certNo;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setCertTime(Date certTime) 
    {
        this.certTime = certTime;
    }

    public Date getCertTime() 
    {
        return certTime;
    }
    public void setEndTime(Date endTime) 
    {
        this.endTime = endTime;
    }

    public Date getEndTime() 
    {
        return endTime;
    }
    public void setCertImg(String certImg) 
    {
        this.certImg = certImg;
    }

    public String getCertImg() 
    {
        return certImg;
    }
    public void setRemark3(String remark3) 
    {
        this.remark3 = remark3;
    }

    public String getRemark3() 
    {
        return remark3;
    }
    public void setRemark4(String remark4) 
    {
        this.remark4 = remark4;
    }

    public String getRemark4() 
    {
        return remark4;
    }
    public void setRemark5(String remark5) 
    {
        this.remark5 = remark5;
    }

    public String getRemark5() 
    {
        return remark5;
    }
    public void setRemark6(String remark6) 
    {
        this.remark6 = remark6;
    }

    public String getRemark6() 
    {
        return remark6;
    }
    public void setRemark7(String remark7) 
    {
        this.remark7 = remark7;
    }

    public String getRemark7() 
    {
        return remark7;
    }
    public void setRemark8(String remark8) 
    {
        this.remark8 = remark8;
    }

    public String getRemark8() 
    {
        return remark8;
    }
    public void setRemark9(String remark9) 
    {
        this.remark9 = remark9;
    }

    public String getRemark9() 
    {
        return remark9;
    }
    public void setRemark10(String remark10) 
    {
        this.remark10 = remark10;
    }

    public String getRemark10() 
    {
        return remark10;
    }
    public void setRemark2(String remark2) 
    {
        this.remark2 = remark2;
    }

    public String getRemark2() 
    {
        return remark2;
    }
    public void setCreateDate(Date createDate) 
    {
        this.createDate = createDate;
    }

    public Date getCreateDate() 
    {
        return createDate;
    }
    public void setUpdateDate(Date updateDate) 
    {
        this.updateDate = updateDate;
    }

    public Date getUpdateDate() 
    {
        return updateDate;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }
    public void setRemark1(String remark1) 
    {
        this.remark1 = remark1;
    }

    public String getRemark1() 
    {
        return remark1;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("certLevel", getCertLevel())
            .append("certType", getCertType())
            .append("name", getName())
            .append("userName", getUserName())
            .append("certNo", getCertNo())
            .append("userId", getUserId())
            .append("certTime", getCertTime())
            .append("endTime", getEndTime())
            .append("certImg", getCertImg())
            .append("remark3", getRemark3())
            .append("remark4", getRemark4())
            .append("remark5", getRemark5())
            .append("remark6", getRemark6())
            .append("remark7", getRemark7())
            .append("remark8", getRemark8())
            .append("remark9", getRemark9())
            .append("remark10", getRemark10())
            .append("remark2", getRemark2())
            .append("createBy", getCreateBy())
            .append("createDate", getCreateDate())
            .append("updateBy", getUpdateBy())
            .append("updateDate", getUpdateDate())
            .append("remark", getRemark())
            .append("delFlag", getDelFlag())
            .append("remark1", getRemark1())
            .toString();
    }
}
