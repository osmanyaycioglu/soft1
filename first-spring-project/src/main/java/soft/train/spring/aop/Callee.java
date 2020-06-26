package soft.train.spring.aop;

public class Callee {

    public String callMe(final String str) {
        System.out.println("callMe : " + str);
        return "Sen beni " + str + " çağırdın";
    }


    @LogAt(extraData = "test1")
    public String xyz(final String str) {
        System.out.println("xyz : " + str);
        return "Sen beni " + str + " çağırdın";
    }

    @LogAt(extraData = "test2")
    public String abc(final String str) {
        System.out.println("abc : " + str);
        return "Sen beni " + str + " çağırdın";
    }

}
