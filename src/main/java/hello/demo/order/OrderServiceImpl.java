package hello.demo.order;

import hello.demo.annotation.MainDiscountPolicy;
import hello.demo.discount.DiscountPolicy;
import hello.demo.discount.FixDiscountPolicy;
import hello.demo.discount.RateDiscountPolicy;
import hello.demo.member.Member;
import hello.demo.member.MemberRepository;
import hello.demo.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
//@RequiredArgsConstructor    //final이 붙은 생성자 만들어줌, 생성자 하나면서 의존자 자동으로 주입
public class OrderServiceImpl implements OrderService{

    //불변, 필수 -> 바꾸는 메소드(setMemberRepository) 있으면 안되고, 이 값은 꼭 넣어줘.
    //생성자에서만 값을 바꿔줄 수 있다.
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;  //인터페이스에만 의존


    //new OrderServiceImpl(memberRepository, discountPolicy);
    //생성자는 어쩔 수 없이 스프링라이프사이클 스프링빈 등록할 때 어쩔 수 없이 일어난다.
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        //System.out.println("memberRepository = " + memberRepository);
        //System.out.println("discountPolicy = " + discountPolicy);
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;   //this로 값 할당
    }


/*    @Autowired
    public void setMemberRepository(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Autowired
    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }*/

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
