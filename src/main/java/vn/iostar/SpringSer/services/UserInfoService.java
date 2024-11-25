package vn.iostar.SpringSer.services;
import java.util.Optional;

import org. springframework.beans. factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org. springframework.security.core.userdetails.UsernameNotFoundException;

import vn.iostar.SpringSer.Entity.UserInfo;
import vn.iostar.SpringSer.Repository.UserInfoRepository;
import vn.iostar.SpringSer.configs.UserInfoUserDetails;



public class UserInfoService implements UserDetailsService {
@Autowired
UserInfoRepository repository;

public UserInfoService(UserInfoRepository userInfoRepository) {
this.repository = userInfoRepository;
}
@Override
public UserDetails loadUserByUsername(String username) throws
UsernameNotFoundException {
Optional<UserInfo> userInfo = repository.findByName(username);
return userInfo.map(UserInfoUserDetails :: new).orElseThrow(() -> new UsernameNotFoundException("user not found: " +username));
}

}