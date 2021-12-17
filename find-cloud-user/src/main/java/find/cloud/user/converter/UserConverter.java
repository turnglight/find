package find.cloud.user.converter;

import find.cloud.user.domain.entity.User;
import find.cloud.user.persistence.model.UserDetailModel;
import find.cloud.user.persistence.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author 01407975
 * @description 用户模型转换器
 * @date 2021/12/9
 */
@Mapper
public interface UserConverter {

    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

    UserModel userToUserModel(User user);

    UserDetailModel userToUserDetailModel(User user);

}
