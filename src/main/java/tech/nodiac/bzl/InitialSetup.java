package tech.nodiac.bzl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import tech.nodiac.bzl.data.UserEntity;
import tech.nodiac.bzl.data.UsersRepository;


@Component
public class InitialSetup {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @EventListener
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent event) {
        UserEntity user = new UserEntity(
                1L,
                "qswe3mg84mfjtu",
                "Sergey",
                "Kargopolov",
                "test2@test.com",
                bCryptPasswordEncoder.encode("sergey"),
                "",
                false);

        usersRepository.save(user);
    }
}
