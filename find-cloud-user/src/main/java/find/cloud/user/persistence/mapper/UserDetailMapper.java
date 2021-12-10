package find.cloud.user.persistence.mapper;

import find.cloud.user.persistence.model.UserDetailModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * @description  用户详情Repository
 * @author turnglight
 * @date  2021-11-30
 */
public interface UserDetailMapper extends CrudRepository<UserDetailModel, Long> {

    /**
     * 用户分页查询
     * @param name 用户名
     * @param nickname  昵称
     * @param sno   用户序列号
     * @param gender    性别
     * @param phone 电话号码
     * @param wxno  微信号码
     * @param status    状态
     * @param vipState  vip状态
     * @param vipLevel  vip等级
     * @param pageable  分页插件
     * @return
     */
    @Query(value = "SELECT u FROM user_detail u")
    Page<UserDetailModel> findPage(String name, String nickname, String sno, Integer gender, String phone, String wxno, Integer status, Integer vipState, Integer vipLevel, Pageable pageable);

    /**
     * 查找指定用户
     * @param userId
     * @return
     */
    Optional<UserDetailModel> findByUserId(Long userId);
}
