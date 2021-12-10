package find.cloud.user.converter;

import find.cloud.user.domain.User;
import find.cloud.user.domain.UserDetail;
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

    User userModelToUser(UserModel userModel);

    UserDetailModel userToUserDetailModel(User user);

    User userDetailModelToUser(UserDetailModel userDetailModel);

    UserDetail userDetailModelToUserDetail(UserDetailModel userDetailModel);
}
