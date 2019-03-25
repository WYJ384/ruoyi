package com.ruoyi.worktask.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 附件表 work_task_file
 * 
 * @author ruoyi
 * @date 2019-03-25
 */
public class WorkTaskFile extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private Integer id;
	/** 任务的id */
	private String workTaskId;
	/** 附件路径 */
	private String filePath;
	/** 创建人 */
	private String createBy;
	/** 创建时间 */
	private Date createTime;
	/** 更新者 */
	private String updateBy;
	/** 更新时间 */
	private Date updateTime;
	/** 删除标志（0代表存在 2代表删除）,默认0 */
	private String delFlag;
	/** 备注 */
	private String remark;
	/** 文件名 */
	private String fileName;
	/** 扩展名 */
	private String extension;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setWorkTaskId(String workTaskId) 
	{
		this.workTaskId = workTaskId;
	}

	public String getWorkTaskId() 
	{
		return workTaskId;
	}
	public void setFilePath(String filePath) 
	{
		this.filePath = filePath;
	}

	public String getFilePath() 
	{
		return filePath;
	}
	public void setCreateBy(String createBy) 
	{
		this.createBy = createBy;
	}

	public String getCreateBy() 
	{
		return createBy;
	}
	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
	}

	public Date getCreateTime() 
	{
		return createTime;
	}
	public void setUpdateBy(String updateBy) 
	{
		this.updateBy = updateBy;
	}

	public String getUpdateBy() 
	{
		return updateBy;
	}
	public void setUpdateTime(Date updateTime) 
	{
		this.updateTime = updateTime;
	}

	public Date getUpdateTime() 
	{
		return updateTime;
	}
	public void setDelFlag(String delFlag) 
	{
		this.delFlag = delFlag;
	}

	public String getDelFlag() 
	{
		return delFlag;
	}
	public void setRemark(String remark) 
	{
		this.remark = remark;
	}

	public String getRemark() 
	{
		return remark;
	}
	public void setFileName(String fileName) 
	{
		this.fileName = fileName;
	}

	public String getFileName() 
	{
		return fileName;
	}
	public void setExtension(String extension) 
	{
		this.extension = extension;
	}

	public String getExtension() 
	{
		return extension;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("workTaskId", getWorkTaskId())
            .append("filePath", getFilePath())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("delFlag", getDelFlag())
            .append("remark", getRemark())
            .append("fileName", getFileName())
            .append("extension", getExtension())
            .toString();
    }
}
