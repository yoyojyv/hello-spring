package spring.sample.hello;

/**
 * Created by yoyojyv on 2014. 2. 18..
 */
public class MorningGreetingService implements GreetingService {

    @Override
    public String greeting() {
        return "좋은 아침이에요!";
    }

}
