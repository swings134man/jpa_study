package second;

import javax.persistence.*;

/************
* @info : 연관관계 매핑을 위한 Member Entity Class
* @name : TMember
* @date : 2022/09/22 6:08 PM
* @author : SeokJun Kang(swings134@gmail.com)
* @version : 1.0.0
************/
@Entity
@Table(name = "TMember")
public class TMember {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String name;
    private int age;

//    @Column(name = "TEAM_ID")
//    private Long teamId;

    // jpa 에게 연관관계를 알려줘야함 -> 1:N , N:1 어떤건지
    // member 입장에서는 N , Team 입장에선 1, 하나의 팀에는 여러명의 선수가 존재하기 때문
    // 관계를 알려줬으면 외래키로 등록해야하는 컬럼은 뭔지 -> @JoinColumn
    // 연관관계의 주인 -> 양방향 관계의 주인임.
    @ManyToOne
    @JoinColumn(name = "TEAM_ID") //Team 테이블의 PK인 TEAM_ID와 매핑이 됨.
    private Team team;

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
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public Team getTeam() {
        return team;
    }

    // SET -> 연관관계 편의 메서드 -> 로직이 들어가 있는 set 은 이름 변경하여 관리 .
    public void changeTeam(Team team) {
        this.team = team;
        team.getMembers().add(this); // this 는 TMember 객체 자체. JPA 값 세팅시 역방향 관계의 값을 세팅을 자동으로 해줌.
    }
}
