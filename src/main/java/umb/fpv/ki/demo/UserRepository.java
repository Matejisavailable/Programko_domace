package umb.fpv.ki.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface UserRepository extends CrudRepository<UserEntity, Long>{

    @Override
    List<UserEntity> findAll();

}
