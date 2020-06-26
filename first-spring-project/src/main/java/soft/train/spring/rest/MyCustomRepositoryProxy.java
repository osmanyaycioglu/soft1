package soft.train.spring.rest;

public class MyCustomRepositoryProxy extends MyCustomRepository {

    private MyCustomRepository mcr;

    public MyCustomRepositoryProxy(final MyCustomRepository mcrParam) {
        this.mcr = mcrParam;
    }

    @Override
    public void xyz(final Person per) {
        this.mcr.xyz(per);
    }

}
