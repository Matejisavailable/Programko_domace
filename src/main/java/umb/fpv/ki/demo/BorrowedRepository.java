package umb.fpv.ki.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowedRepository extends CrudRepository<BorrowedEntity,String> {
}