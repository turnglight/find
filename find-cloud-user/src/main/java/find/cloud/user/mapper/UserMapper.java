package find.cloud.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import find.cloud.user.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends BaseMapper<User> {

    IPage<User> findPage(IPage<User> page,
                     @Param("name") String name,
                     @Param("nickname") String nickname,
                     @Param("sno") String sno,
                     @Param("gender") Integer genter,
                     @Param("phone") String phone,
                     @Param("wxno") String wxno,
                     @Param("status") Integer status,
                     @Param("vipState") Integer vipState,
                     @Param("vipLevel") Integer vipLevel);
}
