package com.ruoyi.train.domain;

import com.ruoyi.activiti.domain.TaskVO;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 付款审批表 approve
 * 
 * @author ruoyi
 * @date 2019-07-24
 */
public class Approve extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** ID */
	private String id;
	/** 审请单位 */
	private String sqdw;
	/** 合同金额 */
	private String htje;
	/** 合同编号 */
	private String htbh;
	/** 合同价款 */
	private String htjk;
	/** 合同名称 */
	private String htmc;
	/** 累计已付款 */
	private String ljyfk;
	/** 款项用途 */
	private String kxyt;
	/** 本次申请金额 */
	private String bcsqje;
	/** 收款单位 */
	private String skdw;
	/** 实际付款金额 */
	private String sjfkje;
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
	/** 本次付款申请比例 */
	private String bcsqfkbl;
	/** 尚需支付金额 */
	private String sxzfje;
	/** 经办人 */
	private String jbr;
	/** 技术支撑部负责人 */
	private String jszcbfzr;
	/** 维护部门负责人 */
	private String whbmfzr;
	/** 办公室负责人 */
	private String bgsfzr;
	/** 主管副总经理 */
	private String zgfzjl;
	/** 总经理 */
	private String zjl;
	/** 财务部负责人 */
	private String cwbfzr;
	/** 申请编号 */
	private String spbh;
	/** 是否阅卷 0否1是 */
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
	/**  */
	private String libId;
	/** 流程编号 */
	private String processInstanceId;
	/** 申请状态1暂存2申请中 */
	private String approveStatus;
	TaskVO task=new TaskVO();

	public TaskVO getTask() {
		return task;
	}

	public void setTask(TaskVO task) {
		this.task = task;
	}
	public void setId(String id) 
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	public void setSqdw(String sqdw) 
	{
		this.sqdw = sqdw;
	}

	public String getSqdw() 
	{
		return sqdw;
	}
	public void setHtje(String htje) 
	{
		this.htje = htje;
	}

	public String getHtje() 
	{
		return htje;
	}
	public void setHtbh(String htbh) 
	{
		this.htbh = htbh;
	}

	public String getHtbh() 
	{
		return htbh;
	}
	public void setHtjk(String htjk) 
	{
		this.htjk = htjk;
	}

	public String getHtjk() 
	{
		return htjk;
	}
	public void setHtmc(String htmc) 
	{
		this.htmc = htmc;
	}

	public String getHtmc() 
	{
		return htmc;
	}
	public void setLjyfk(String ljyfk) 
	{
		this.ljyfk = ljyfk;
	}

	public String getLjyfk() 
	{
		return ljyfk;
	}
	public void setKxyt(String kxyt) 
	{
		this.kxyt = kxyt;
	}

	public String getKxyt() 
	{
		return kxyt;
	}
	public void setBcsqje(String bcsqje) 
	{
		this.bcsqje = bcsqje;
	}

	public String getBcsqje() 
	{
		return bcsqje;
	}
	public void setSkdw(String skdw) 
	{
		this.skdw = skdw;
	}

	public String getSkdw() 
	{
		return skdw;
	}
	public void setSjfkje(String sjfkje) 
	{
		this.sjfkje = sjfkje;
	}

	public String getSjfkje() 
	{
		return sjfkje;
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
	public void setBcsqfkbl(String bcsqfkbl) 
	{
		this.bcsqfkbl = bcsqfkbl;
	}

	public String getBcsqfkbl() 
	{
		return bcsqfkbl;
	}
	public void setSxzfje(String sxzfje) 
	{
		this.sxzfje = sxzfje;
	}

	public String getSxzfje() 
	{
		return sxzfje;
	}
	public void setJbr(String jbr) 
	{
		this.jbr = jbr;
	}

	public String getJbr() 
	{
		return jbr;
	}
	public void setJszcbfzr(String jszcbfzr) 
	{
		this.jszcbfzr = jszcbfzr;
	}

	public String getJszcbfzr() 
	{
		return jszcbfzr;
	}
	public void setWhbmfzr(String whbmfzr) 
	{
		this.whbmfzr = whbmfzr;
	}

	public String getWhbmfzr() 
	{
		return whbmfzr;
	}
	public void setBgsfzr(String bgsfzr) 
	{
		this.bgsfzr = bgsfzr;
	}

	public String getBgsfzr() 
	{
		return bgsfzr;
	}
	public void setZgfzjl(String zgfzjl) 
	{
		this.zgfzjl = zgfzjl;
	}

	public String getZgfzjl() 
	{
		return zgfzjl;
	}
	public void setZjl(String zjl) 
	{
		this.zjl = zjl;
	}

	public String getZjl() 
	{
		return zjl;
	}
	public void setCwbfzr(String cwbfzr) 
	{
		this.cwbfzr = cwbfzr;
	}

	public String getCwbfzr() 
	{
		return cwbfzr;
	}
	public void setSpbh(String spbh) 
	{
		this.spbh = spbh;
	}

	public String getSpbh() 
	{
		return spbh;
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
	public void setLibId(String libId) 
	{
		this.libId = libId;
	}

	public String getLibId() 
	{
		return libId;
	}
	public void setProcessInstanceId(String processInstanceId) 
	{
		this.processInstanceId = processInstanceId;
	}

	public String getProcessInstanceId() 
	{
		return processInstanceId;
	}
	public void setApproveStatus(String approveStatus) 
	{
		this.approveStatus = approveStatus;
	}

	public String getApproveStatus() 
	{
		return approveStatus;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("sqdw", getSqdw())
            .append("htje", getHtje())
            .append("htbh", getHtbh())
            .append("htjk", getHtjk())
            .append("htmc", getHtmc())
            .append("ljyfk", getLjyfk())
            .append("kxyt", getKxyt())
            .append("bcsqje", getBcsqje())
            .append("skdw", getSkdw())
            .append("sjfkje", getSjfkje())
            .append("createBy", getCreateBy())
            .append("createDate", getCreateDate())
            .append("updateBy", getUpdateBy())
            .append("updateDate", getUpdateDate())
            .append("remark", getRemark())
            .append("delFlag", getDelFlag())
            .append("bcsqfkbl", getBcsqfkbl())
            .append("sxzfje", getSxzfje())
            .append("jbr", getJbr())
            .append("jszcbfzr", getJszcbfzr())
            .append("whbmfzr", getWhbmfzr())
            .append("bgsfzr", getBgsfzr())
            .append("zgfzjl", getZgfzjl())
            .append("zjl", getZjl())
            .append("cwbfzr", getCwbfzr())
            .append("spbh", getSpbh())
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
            .append("libId", getLibId())
            .append("processInstanceId", getProcessInstanceId())
            .append("approveStatus", getApproveStatus())
            .toString();
    }
}
