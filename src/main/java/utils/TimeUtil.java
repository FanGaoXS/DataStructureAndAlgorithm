package utils;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/08/15/16:35
 * @Description:
 */
public class TimeUtil implements ITimeUtil{

    private final String name;      //方法名称

    private final ITimeUtil target; //方法接口

    public TimeUtil(String name,ITimeUtil timeUtil){
        this.name = name;
        this.target = timeUtil;
    }

    @Override
    public void execute() {
        System.out.println("--------------------------------------");
        long beforeTimestamp = System.currentTimeMillis(); //执行方法前时间戳
        //System.out.println("beforeTimestamp = " + beforeTimestamp);
        this.target.execute();
        long afterTimestamp = System.currentTimeMillis();  //执行方法后时间戳
        //System.out.println("afterTimestamp = " + afterTimestamp);
        long ms = afterTimestamp - beforeTimestamp;
        System.out.println(this.name + "耗时" + ms + "ms"); //计算方法耗时
        System.out.println("--------------------------------------");
    }
}
