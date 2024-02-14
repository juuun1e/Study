package com.eazybytes.repository;

import com.eazybytes.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //데이터베이스 상호작용 관련 로직
public interface CustomerRepository extends CrudRepository<Customer,Long>{
  //derived method name query : Repository인터페이스에정의하여 놓은 메소드 명칭 기반
  List<Customer> findByEmail(String email);
               //fingBy - JAP에게 select쿼리를 활용하여 기록을 반환해 오라는 것
}
