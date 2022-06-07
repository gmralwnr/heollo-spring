package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository  implements  MemberRepository{

    private  static Map<Long, Member> store = new HashMap<>();  //save를 할때 저장을 해야하기 때문에 Map을 씀
    //long 은 저장 할 수 있는 문자 / 변수는 Member
    private static  long sequence =0L;
    //키값에 번호를 생성 할 수 있는 sequence


    @Override
    public Member save(Member member) {  //Member 에는  id와 name 이있습니다
        //id는 임의로 정해진 값
         member.setId(++sequence); //id를 셋팅하고
        store.put(member.getId() , member);  //store저장 하면 map에 저장 됨
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
        //결과가 없으면 Null이 반환 될까봐 Optional.ofNullable 를 사용
    }

    @Override
    public Optional<Member> findByName(String name) {
       return  store.values().stream()
                .filter(member -> member.getName().equals(name))
                //getName이 파라미터 넘어온 name 과 같은지 확인
                .findAny(); //찾으면 반환

    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    //추가 기존 test했던건 삭제
    public  void clearStore(){
        store.clear();

    }
}
