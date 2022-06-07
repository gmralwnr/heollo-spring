package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;


public interface MemberRepository {

    Member save(Member member);  //회원이 저장
  Optional<Member> findById(Long id);  //find 를 통해 id를 찾고
  Optional<Member> findByName(String name); //이름을 찾음
  List<Member> findAll();


}
