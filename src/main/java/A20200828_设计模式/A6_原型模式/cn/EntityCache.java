package A20200828_设计模式.A6_原型模式.cn;

import java.util.Hashtable;

/**
 * @author : Mr huangye
 * @URL : CSDN 皇夜_
 * @createTime : 2020/8/29 11:17
 * @Description :
 */
public class EntityCache {

    private static Hashtable<Integer, BaseEntity> shapeMap
            = new Hashtable<Integer, BaseEntity>();

    public static BaseEntity getShape(int id) {
        BaseEntity cachedShape = shapeMap.get(id);
        return (BaseEntity) cachedShape.clone();
    }

    public static void loadCache(BaseEntity baseEntity) {
        shapeMap.put(baseEntity.getId(),baseEntity);
    }
}
