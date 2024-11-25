package vn.iostar.SpringSer.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.iostar.SpringSer.Entity.UserInfo;
@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo,Integer> {
Optional<UserInfo> findByName(String username);
}
