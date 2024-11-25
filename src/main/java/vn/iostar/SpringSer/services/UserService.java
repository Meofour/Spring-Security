package vn.iostar.SpringSer.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import vn.iostar.SpringSer.Entity.UserInfo;
import vn.iostar.SpringSer.Repository.UserInfoRepository;

@Service
public record UserService(UserInfoRepository repository,
PasswordEncoder passwordEncoder) {
public String addUser(UserInfo userInfo) {
userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
repository.save(userInfo);
return "Thêm user thanh công!";

}

}
