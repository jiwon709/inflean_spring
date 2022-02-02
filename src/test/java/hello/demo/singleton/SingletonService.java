package hello.demo.singleton;

public class SingletonService {

    //static 영역에 자기 자신을 딱 하나 띄웠다.
    //자기 자신 객체를 생성해서 instance 에 넣어둔다.
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
