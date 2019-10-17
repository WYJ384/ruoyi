package com.ruoyi.projectmanage.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 设备入网工程管理模板对象 project_junction_circuit
 * 
 * @author ruoyi
 * @date 2019-10-17
 */
public class ProjectJunctionCircuit extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String id;

    /** 扩容设备名称 */
    @Excel(name = "扩容设备名称")
    private String name;

    /** 扩容设备IP */
    @Excel(name = "扩容设备IP")
    private String ip;

    /** 扩容时间 */
    @Excel(name = "扩容时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date time;

    /** 设备厂家及型号 */
    @Excel(name = "设备厂家及型号")
    private String port;

    /** 工程设计全称 */
    @Excel(name = "工程设计全称")
    private String proFullName;

    /** 扩容节点 */
    @Excel(name = "扩容节点")
    private String loc;

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
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setIp(String ip) 
    {
        this.ip = ip;
    }

    public String getIp() 
    {
        return ip;
    }
    public void setTime(Date time) 
    {
        this.time = time;
    }

    public Date getTime() 
    {
        return time;
    }
    public void setPort(String port) 
    {
        this.port = port;
    }

    public String getPort() 
    {
        return port;
    }
    public void setProFullName(String proFullName) 
    {
        this.proFullName = proFullName;
    }

    public String getProFullName() 
    {
        return proFullName;
    }
    public void setLoc(String loc) 
    {
        this.loc = loc;
    }

    public String getLoc() 
    {
        return loc;
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
            .append("name", getName())
            .append("ip", getIp())
            .append("time", getTime())
            .append("port", getPort())
            .append("proFullName", getProFullName())
            .append("loc", getLoc())
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
