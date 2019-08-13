package com.ruoyi.exam.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.exam.domain.LibraryDetail;
import com.ruoyi.exam.mapper.LibraryDetailMapper;
import com.ruoyi.exam.service.ILibraryDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 题库内容 服务层实现
 *
 * @author ruoyi
 * @date 2019-06-17
 */
@Service
public class LibraryDetailServiceImpl implements ILibraryDetailService {
    @Autowired
    private LibraryDetailMapper libraryDetailMapper;

    /**
     * 查询题库内容信息
     *
     * @param id 题库内容ID
     * @return 题库内容信息
     */
    @Override
    public LibraryDetail selectLibraryDetailById(String id) {
        return libraryDetailMapper.selectLibraryDetailById(id);
    }

    /**
     * 查询题库内容列表
     *
     * @param libraryDetail 题库内容信息
     * @return 题库内容集合
     */
    @Override
    public List<LibraryDetail> selectLibraryDetailList(LibraryDetail libraryDetail) {
        return libraryDetailMapper.selectLibraryDetailList(libraryDetail);
    }

    /**
     * 新增题库内容
     *
     * @param libraryDetail 题库内容信息
     * @return 结果
     */
    @Override
    public int insertLibraryDetail(LibraryDetail libraryDetail) {
        return libraryDetailMapper.insertLibraryDetail(libraryDetail);
    }

    /**
     * 修改题库内容
     *
     * @param libraryDetail 题库内容信息
     * @return 结果
     */
    @Override
    public int updateLibraryDetail(LibraryDetail libraryDetail) {
        return libraryDetailMapper.updateLibraryDetail(libraryDetail);
    }

    /**
     * 删除题库内容对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLibraryDetailByIds(String ids) {
        return libraryDetailMapper.deleteLibraryDetailByIds(Convert.toStrArray(ids));
    }

    public static String ASCIISort(String str) {
        char[] test = new char[str.length()];
        StringBuilder sb = new StringBuilder();
        while (true) {
            String a = str;//直接读取这行当中的字符串。
            for (int i = 0; i < str.length(); i++) {
                test[i] = a.charAt(i);//字符串处理每次读取一位。
            }
            Arrays.sort(test);
            for (int i = 0; i < test.length; i++) {
                sb.append(test[i]);
            }
            String trim = sb.toString().trim();
            return trim;
        }
    }


    @Override
    public String importLibraryDetail(List<LibraryDetail> libraryDetails, String libId, String operName) {

        if (StringUtils.isNull(libraryDetails) || libraryDetails.size() == 0) {
            throw new BusinessException("导入数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (LibraryDetail libraryDetail : libraryDetails) {

            try {
                String libType = libraryDetail.getLibType();
                String answer = libraryDetail.getAnswer().toUpperCase();

                if (libType.equals("单选题")) {
                    libType = "1";
                    libraryDetail.setAnswer(ASCIISort(answer));
                } else if (libType.equals("多选题")) {
                    libType = "2";
                    libraryDetail.setAnswer(ASCIISort(answer));
                } else if (libType.equals("判断题")) {
                    libType = "4";
                } else if (libType.equals("填空题")) {
                    libType = "3";
                } else if (libType.equals("简答题")) {
                    libType = "5";
                }
                libraryDetail.setLibType(libType);
                libraryDetail.setLibId(libId);
                libraryDetail.setId(UUID.randomUUID().toString().replaceAll("-", ""));
                libraryDetail.setCreateBy(operName);
                libraryDetail.setCreateDate(new Date());
                int i = libraryDetailMapper.insertLibraryDetail(libraryDetail);
                if (i > 0) {
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、题目 " + libraryDetail.getTitle() + " 导入成功");
                }
            } catch (Exception e) {
                failureNum++;
                String msg = "<br/>" + failureNum + "、题目 " + libraryDetail.getTitle() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
            }
        }
        if (failureNum > 0) {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new BusinessException(failureMsg.toString());
        } else {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }

}
