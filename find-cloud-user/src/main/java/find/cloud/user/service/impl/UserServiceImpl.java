package find.cloud.user.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import find.cloud.user.controller.vo.UserQueryVo;
import find.cloud.user.entity.User;
import find.cloud.user.service.UserService;
import find.cloud.user.mapper.UserMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public IPage<User> findPage(UserQueryVo userQueryVo) {
        // 设置分页参数
        Page<User> page = new Page<>(userQueryVo.getPageNo(), userQueryVo.getPageSize());
        // 设置排序字段
        String orderField = userQueryVo.getOrderField();
        if(StringUtils.isNotBlank(orderField)){
            List<OrderItem> orderItems = Arrays.stream(orderField.split(",")).map(field -> {
                OrderItem orderItem = new OrderItem();
                orderItem.setColumn(field);
                // 设置排序方式
                orderItem.setAsc("ASC".equals(userQueryVo.getOrderType())?true:false);
                return orderItem;
            }).collect(Collectors.toList());
            page.setOrders(orderItems);
        }
        return userMapper.findPage(page,
                userQueryVo.getName(),
                userQueryVo.getNickname(),
                userQueryVo.getSno(),
                userQueryVo.getGender(),
                userQueryVo.getPhone(),
                userQueryVo.getWxno(),
                userQueryVo.getStatus(),
                userQueryVo.getVipState(),
                userQueryVo.getVipLevel());
    }

    @Override
    public long create(User user) {
        return userMapper.insert(user);
    }

    @Override
    public User update(User user) {
        long id = userMapper.updateById(user);
        if(id > 0){
            return userMapper.selectById(id);
        }
        return null;
    }
}
