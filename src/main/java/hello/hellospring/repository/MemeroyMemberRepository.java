package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemeroyMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        //람다식활용(parameter로 넘어온 name이 같은 name인지 확인)
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    //메모리를 지우기 위한 메서드
    public void clearStore() {
        store.clear();
    }
}
