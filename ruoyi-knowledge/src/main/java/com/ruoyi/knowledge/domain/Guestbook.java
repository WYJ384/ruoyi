package com.ruoyi.knowledge.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 留言板表 cms_guestbook
 * 
 * @author ruoyi
 * @date 2019-07-02
 */
public class Guestbook extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 编号 */
	private String id;
	/** 留言分类 */
	private String type;
	/** 留言内容 */
	private String content;
	/** 姓名 */
	private String name;
	/** 邮箱 */
	private String email;
	/** 电话 */
	private String phone;
	/** 单位 */
	private String workunit;
	/** IP */
	private String ip;
	/** 回复人 */
	private String reUserId;
	/** 回复时间 */
	private Date reDate;
	/** 回复内容 */
	private String reContent;
	/** 创建者 */
	private String createBy;
	/** 创建时间 */
	private Date createDate;
	/** 更新者 */
	private String updateBy;
	/** 更新时间 */
	private Date updateDate;
	/** 备注信息 */
	private String remark;
	/** 删除标记 */
	private String delFlag;
	/** 扩展1 */
	private String remark1;
	/** 扩展2 */
	private String remark2;
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

	public void setId(String id) 
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	public void setType(String type) 
	{
		this.type = type;
	}

	public String getType() 
	{
		return type;
	}
	public void setContent(String content) 
	{
		this.content = content;
	}

	public String getContent() 
	{
		return content;
	}
	public void setName(String name) 
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getEmail() 
	{
		return email;
	}
	public void setPhone(String phone) 
	{
		this.phone = phone;
	}

	public String getPhone() 
	{
		return phone;
	}
	public void setWorkunit(String workunit) 
	{
		this.workunit = workunit;
	}

	public String getWorkunit() 
	{
		return workunit;
	}
	public void setIp(String ip) 
	{
		this.ip = ip;
	}

	public String getIp() 
	{
		return ip;
	}
	public void setReUserId(String reUserId) 
	{
		this.reUserId = reUserId;
	}

	public String getReUserId() 
	{
		return reUserId;
	}
	public void setReDate(Date reDate) 
	{
		this.reDate = reDate;
	}

	public Date getReDate() 
	{
		return reDate;
	}
	public void setReContent(String reContent) 
	{
		this.reContent = reContent;
	}

	public String getReContent() 
	{
		return reContent;
	}
	public void setCreateBy(String createBy) 
	{
		this.createBy = createBy;
	}

	public String getCreateBy() 
	{
		return createBy;
	}
	public void setCreateDate(Date createDate) 
	{
		this.createDate = createDate;
	}

	public Date getCreateDate() 
	{
		return createDate;
	}
	public void setUpdateBy(String updateBy) 
	{
		this.updateBy = updateBy;
	}

	public String getUpdateBy() 
	{
		return updateBy;
	}
	public void setUpdateDate(Date updateDate) 
	{
		this.updateDate = updateDate;
	}

	public Date getUpdateDate() 
	{
		return updateDate;
	}
	public void setRemark(String remark) 
	{
		this.remark = remark;
	}

	public String getRemark() 
	{
		return remark;
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
	public void setRemark2(String remark2) 
	{
		this.remark2 = remark2;
	}

	public String getRemark2() 
	{
		return remark2;
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

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("type", getType())
            .append("content", getContent())
            .append("name", getName())
            .append("email", getEmail())
            .append("phone", getPhone())
            .append("workunit", getWorkunit())
            .append("ip", getIp())
            .append("reUserId", getReUserId())
            .append("reDate", getReDate())
            .append("reContent", getReContent())
            .append("createBy", getCreateBy())
            .append("createDate", getCreateDate())
            .append("updateBy", getUpdateBy())
            .append("updateDate", getUpdateDate())
            .append("remark", getRemark())
            .append("delFlag", getDelFlag())
            .append("remark1", getRemark1())
            .append("remark2", getRemark2())
            .append("remark3", getRemark3())
            .append("remark4", getRemark4())
            .append("remark5", getRemark5())
            .append("remark6", getRemark6())
            .append("remark7", getRemark7())
            .append("remark8", getRemark8())
            .append("remark9", getRemark9())
            .append("remark10", getRemark10())
            .toString();
    }
}
