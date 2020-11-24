package com.checkup.user;

import com.checkup.server.adapter.DozerAdapter;
import com.checkup.server.permission.Permission;
import com.checkup.server.permission.PermissionRepository;
import com.checkup.server.validation.exception.RegisterNotFoundException;
import com.checkup.user.form.UserFORM;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserService implements UserDetailsService {

    private UserRepository repository;
    private final PermissionRepository permissionRepository;

    @Inject
    public UserService(final UserRepository repository,
                       final PermissionRepository permissionRepository) {
        this.repository = repository;
        this.permissionRepository = permissionRepository;
    }

    @Override
    public UserDetails loadUserByUsername(final String userName) throws UsernameNotFoundException {
        final User byUserName = repository.findByUsername(userName);
        if (Objects.isNull(byUserName)) {
            throw new UsernameNotFoundException("UserName " + userName + " not found!");
        }
        return byUserName;
    }

    public UserVO findById(final UUID userId) {
        return DozerAdapter.parseObject(
                repository.findById(userId)
                        .orElseThrow(RegisterNotFoundException::new), UserVO.class);
    }

    public UserVO update(final UserVO userVO) {
        final User userFromDb = this.repository.findById(userVO.getId()).orElseThrow(RegisterNotFoundException::new);
        final User user = DozerAdapter.parseObject(userVO, User.class);
        this.doGenerateUpdateValues(user, userFromDb);
        return DozerAdapter.parseObject(this.repository.save(userFromDb), UserVO.class);
    }

    private void doGenerateUpdateValues(final User user, final User userFromDb) {
        userFromDb.setUserName(user.getUserName());
        userFromDb.setFullName(user.getFullName());
        userFromDb.getInformation().clear();
        userFromDb.getInformation().addAll(user.getInformation());
        userFromDb.setUpdatedAt(OffsetDateTime.now());
        userFromDb.setCreatedAt(userFromDb.getCreatedAt());
    }

    public UserVO insert(final UserFORM userFORM) {
        final User user = userFORM.toUser();
        insertPermissions(user);
        final User savedUser = repository.save(user);
        return DozerAdapter.parseObject(savedUser, UserVO.class);
    }

    private void insertPermissions(final User user) {
        permissionRepository.findById(UUID.fromString("51f92ea-7d17-4e97-adab-75e7e3ed1429"))
                .ifPresent(permission -> user.setPermissions(Stream.of(permission).collect(Collectors.toList())));
    }

//    private void doGenerateUpdateValues(final User user, final User userFromDb) {
//        userFromDb.getInformation().clear();
//        userFromDb.getInformation().addAll(user.getInformation());
//        userFromDb.setUpdatedAt(OffsetDateTime.now());
//        userFromDb.setCreatedAt(userFromDb.getCreatedAt());
//    }

}
