package repository;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class MemoryMemberRepositoryTest {  //전체적인 test

    MemoryMemberRepository repository = new MemoryMemberRepository();

    //한개씩 test 하고 난 후 전체적인 test 하게 된다면 기존 test 한 것들은 clear 하기 위한 동작
    //test 후 clear 안하게 되면 에러 남
    @AfterEach
    public void afterEach(){

        repository.clearStore();
    }

    @Test

    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

       Member result = repository.findById(member.getId()).get();
       //Assertions.assertEquals(member, result);
        assertThat(member).isEqualTo(result);
       //alt + enter -> static

    }
    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result =repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);


    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);

    }
}
