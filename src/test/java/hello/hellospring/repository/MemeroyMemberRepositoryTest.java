package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

//다른곳에서 사용할게 아니기 때문에 굳이 public으로 설정하지 않아도 됨.
class MemeroyMemberRepositoryTest {

    //MemberRepository repository = new MemeroyMemberRepository();
    MemeroyMemberRepository repository = new MemeroyMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        //아래처럼 sysout으로해도 되지
        //System.out.println("result =" + (result = member));

        //아래 함수를 통해서도 db에서 가져온값과 앞에서 정의한 값이 같은지 확인해 볼 수 있다.
        //Assertions.assertEquals(member, result);

        //강사는 아래 함수를 씀
        assertThat(member).isEqualTo(result);

    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();
        assertThat(result).isEqualTo(member1);

    }

    @Test
    public void findAll() {
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
