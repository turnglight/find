package find.cloud.user.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import find.cloud.user.domain.entity.User;
import find.cloud.user.persistence.model.UserModel;
import org.apache.ibatis.annotations.Select;

/**
 * @author turnglight
 * @description 用户
 * @date 2021/11/29
 */
public interface UserMapper extends BaseMapper<UserModel> {

    /**
     * 分页查询用户信息
     * @param page
     * @param user
     * @return
     */
    IPage<User> queryPage(Page page, User user);
}
