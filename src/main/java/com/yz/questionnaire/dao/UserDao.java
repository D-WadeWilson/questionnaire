package com.yz.questionnaire.dao;

import com.yz.questionnaire.entity.User;
import com.yz.questionnaire.entity.UserExportDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * (User)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-01 17:36:06
 */
@Mapper
public interface UserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    User queryById(Integer id);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param user 实例对象
     * @return 对象列表
     */
    List<User> queryAll(User user);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<User> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);



    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 影响行数
     */
    int insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 影响行数
     */
    int update(User user);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 查询条件返回数量
     * @param user
     * @return
     */
    int queryCountUser(User user);

    int queryCountUserType(Map<String,Object> paramsMap);

    int queryCountNotUndef(Map<String,Object> paramsMap);

    List<UserExportDTO> userInfoExport(Map<String,String> paramsMap);
}