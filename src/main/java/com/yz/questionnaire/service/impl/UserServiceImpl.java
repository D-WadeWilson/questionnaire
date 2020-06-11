package com.yz.questionnaire.service.impl;

import com.yz.questionnaire.entity.User;
import com.yz.questionnaire.dao.UserDao;
import com.yz.questionnaire.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2020-06-01 17:36:07
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Integer id) {
        return this.userDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<User> queryAllByLimit(int offset, int limit) {
        return this.userDao.queryAllByLimit(offset, limit);
    }

    @Override
    public List<User> queryAll(User user) {
        return this.userDao.queryAll(user);
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insert(User user) {
        this.userDao.insert(user);
        return user;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        this.userDao.update(user);
        return this.queryById(user.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.userDao.deleteById(id) > 0;
    }

    /**
     * 新增数据
     *
     * @param
     * @return 实例对象
     */
    @Override
    public int queryCountUser(Map<String, String>map) {
        User user = new User();
        user.setType(map.get("type")!=null?Integer.valueOf(map.get("type")):null);
        user.setCity(map.get("city"));
        if(map.get("house")!=null&&!map.get("town").equals("全部")){
            user.setTown(map.get("town"));
        }
        if(map.get("house")!=null&&!map.get("house").equals("全部")){
            user.setTown(map.get("house"));
        }
        return this.userDao.queryCountUser(user);
    }

    @Override
    public int queryCountUserType(List<String> typeList) {
        return this.userDao.queryCountUserType(typeList);
    }


}