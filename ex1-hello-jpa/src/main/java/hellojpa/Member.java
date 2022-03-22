package hellojpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
// DB Table명이 다른 경우 명시해줘야 함
//@Table(name = "USER")
public class Member {

    @Id
    private Long id;
    // DB의 컬럼명이 다른경우 명시해줘야 함
//    @Column(name="username")
    private String name;
    private int age;

    public Member() {

    }

    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }

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
