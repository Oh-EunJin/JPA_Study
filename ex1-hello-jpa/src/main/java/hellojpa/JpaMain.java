package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            // INSERT SQL code
//            Member member = new Member();
//
//            member.setId(2L);
//            member.setName("HelloB");
//
//            // member 저장
//            em.persist(member);

            // SELECT SQL code
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember = " + findMember.getId());
//            System.out.println("findMember = " + findMember.getName());

            // DELETE SQL code
//            Member findMember = em.find(Member.class, 1L);
//            em.remove(findMember);

            // UPDATE SQL code
//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("HelloJPA");
            // JPA를 통해서 Entity를 가져오면 값이 변경된 경우
            // 알아서 Update 해줌

            // 전체 회원 조회
            List<Member> result =  em.createQuery("Select m from Member as m", Member.class)
                    .setFirstResult(1)
                    .setMaxResults(10)
                            .getResultList();
            for (Member member : result) {
                System.out.println("member.name = " + member.getName());
            }

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
