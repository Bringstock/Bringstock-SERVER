package Majorpiece.bringstock.domain.user.domain.repository;


import Majorpiece.bringstock.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}