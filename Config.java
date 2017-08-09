package debug;

/**
 * Created by 谭健 2017年8月2日 14:14:42 
 * 本设计参考于IOS开发IDE的released模式快速切换 
 * 
 * 为了更好的在debug模式和production模式下进行切换 设计此接口
 * 为了让JAVA的也拥有如此方便的功能，设计该模式
 * 为了防止切换错误，减少切换繁琐工作量，提高切换效率
 * 
 * debug模式下的数据都配置在debug包中
 * production模式下的数据都配置在production包中
 * 两者由bridge包中的公开配置桥来配置和向项目提供数据
 * 
 * 该Config让项目能够快速的切换线上线下配置
 * 使用方法开控制，是借鉴了函数式编程设计思想，更能保证安全性
 * 本设计适用于综合配置，如果项目的所有配置都在一个类中，则只需要一个从控制器即可
 * 如果项目的配置细分到不同的配置中，则使用总 - 分控制器
 * 并且每一个配置类对应一个debug类，一个production类，一个桥接类
 * 
 * Tips ： 编写完debug类后，只需要复制一份debug类，修改他的值即可。
 */
public class Config {

	// 总控制器静态加载，选择加载模式，可选debug和production
	static {
		openDebug();
	}

	/**
	 * debug / 让程序运行在debug模式下 在该模式下，程序的所有运行都遵从debug设定
	 * 
	 * 本模式属于开发模式
	 */
	private static final boolean DEBUG = false;

	/**
	 * production / 让程序运行在production模式下 在该模式下，程序的所有运行都遵从production设定
	 * 
	 * 本模式属于生产模式
	 */
	private static final boolean PRODUCTION = true;

	/**
	 * 初始化开关 属性
	 * 由该字段来决定，初始化出来的环境是debug环境还是prodution环境
	 */
	private static boolean ON_OFF;

	/**
	 * 初始化总控制器
	 * 
	 * 总控制器方法由配置桥初始化调用
	 * 配置桥是带bridge字样结束的配置类
	 * 配置桥的解释详细见ConstBridge
	 * @return 返回初始化的环境，是debug环境还是prodution环境
	 */
	protected static boolean initEnvironment() {
		if (ON_OFF) {
			return DEBUG;
		} else {
			return PRODUCTION;
		}
	};

	/**
	 * 开启总控制器的debug模式
	 * 
	 * 总控制器不是最高优先级
	 * 如果需要启动该模式，只需要在static块里面调用该方法即可
	 * @since 1.6 从Java1.6版本开始支持该模式
	 */
	private static void openDebug() {
		ON_OFF = true;
	}

	/**
	 * 关闭总控制器的debug模式
	 * 
	 * 总控制器不是最高优先级
	 * 如果需要启动该模式，只需要在static块里面调用该方法即可
	 * @since 1.6 从Java1.6版本开始支持该模式
	 */
	private static void closeDebug() {
		ON_OFF = false;
	}

}
