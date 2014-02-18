package spring.sample.hello;

/**
 * Created by yoyojyv on 2014. 2. 18..
 */
public class LunchGreetingService implements GreetingService {

    @Override
    public String greeting() {
        return "점심 맛나게 드세요!";
    }

}
