package hello.demo;

import hello.demo.discount.DiscountPolicy;
import hello.demo.member.MemberRepository;
import hello.demo.member.MemoryMemberRepository;
import hello.demo.order.OrderService;
import hello.demo.order.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
//스프링 빈을 쫙 긁어가지고 자동으로 스프링 빈으로 끌어올리기 위함
//@Component 가 붙은 클래스를 찾아서 자동으로 스프링 빈으로 등록해줌
@ComponentScan(

        //이 위치에서부터 시작
        //basePackages = "hello.demo.member",
        //basePackageClasses = AutoAppConfig.class,

        //빼줄거 체크
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

/*    @Autowired
    MemberRepository memberRepository;
    @Autowired
    DiscountPolicy discountPolicy;

    //아 나 지금 수동으로 빈 등록해야되는데.. 멤버리포지토리 추가해야되나.. 하면 Autowired 로 해결 가능
    @Bean
    OrderService orderService() {
        return new OrderServiceImpl(memberRepository, discountPolicy);
    }*/

   /* @Bean(name = "memoryMemberRepository")
    MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }*/

}
