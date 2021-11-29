package find.cloud.user.service.impl;

import find.cloud.user.controller.vo.UserQueryVo;
import find.cloud.user.entity.User;
import find.cloud.user.repository.UserRepository;
import find.cloud.user.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public Page<User> findPage(UserQueryVo userQueryVo) {
        // 设置排序字段
        String orderField = userQueryVo.getOrderField();
        List<Sort.Order> sorts = new ArrayList<Sort.Order>();
        if(StringUtils.isNotBlank(orderField)){
            sorts = Arrays.stream(orderField.split(",")).map(field -> {
                Sort.Order orderItem = new Sort.Order("ASC".equals(userQueryVo.getOrderType())?  Sort.Direction.ASC:  Sort.Direction.DESC, field);
                return orderItem;
            }).collect(Collectors.toList());
        }
        Sort sort = Sort.by(sorts);
        // 设置分页参数
        Pageable pageable = PageRequest.of(userQueryVo.getPageNo(), userQueryVo.getPageSize(),sort);
        return userRepository.findPage(
                userQueryVo.getName(),
                userQueryVo.getNickname(),
                userQueryVo.getSno(),
                userQueryVo.getGender(),
                userQueryVo.getPhone(),
                userQueryVo.getWxno(),
                userQueryVo.getStatus(),
                userQueryVo.getVipState(),
                userQueryVo.getVipLevel(),pageable);
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }
}
