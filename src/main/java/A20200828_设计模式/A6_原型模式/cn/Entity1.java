package A20200828_设计模式.A6_原型模式.cn;

/**
 * @author : Mr huangye
 * @URL : CSDN 皇夜_
 * @createTime : 2020/8/29 11:17
 * @Description :
 */
public class Entity1 extends BaseEntity{

    public Entity1() {
        System.err.println("entity1...instance!!!");
    }

    @Override
    void print() {
        System.err.println("entity1=====");
    }
}
