package hello.hellospring.domain;

public class Member {

    //시스템이 정해준느 이름
    private Long id;
    //회원가입할 떄 적는이름
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
