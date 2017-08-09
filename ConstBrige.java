package debug.bridge;

import debug.Config;
import debug.debug.DebugConst;
import debug.production.Const;

/**
 *  Created by 谭健 2017年8月3日 15:37:02
 *  
 *  配置桥
 *  
 *  配置桥是桥接debug配置和production配置的从控制器
 *  从控制器接受总控制器配置
 *  从控制器也可以自己配置，并且从控制器的配置优先级高于总控制器
 *  	也就是说，如果从控制器选择了debug环境，那么总控制器是不是debug都对从控制器没有影响
 */
public class ConstBrige extends Config {
	
	/**
	 * 从控制器的 初始化开关 属性
	 * 由该字段来决定，初始化出来的环境是debug环境还是prodution环境
	 */
	private static boolean SELF_ON_OFF = initEnvironment();

	/**
	 * 从控制器的公开配置集合
	 * 
	 * 项目的配置从这里配置出去
	 */
	public static String HOST_NAME;
	public static String PASSWORD;
	public static int COUNT;
	public static boolean ISADMIN;

	static {
		
//     如果需要单独开启从控制器，脱离总控制器的控制，调用以下方法即可
//		openDebug();
//		closeDebug();

		/**
		 * 静态加载块
		 * 通过初始化开关来决定返回给项目的配置是debug环境还是production环境
		 */
		if (SELF_ON_OFF) {
			HOST_NAME = Const.HostName.stringValue();
			PASSWORD = Const.Password.stringValue();
			COUNT = Const.Count.intValue();
			ISADMIN = Const.IsAdmin.booleanValue();
		} else {
			HOST_NAME = DebugConst.HostName.stringValue();
			PASSWORD = DebugConst.Password.stringValue();
			COUNT = DebugConst.Count.intValue();
			ISADMIN = DebugConst.IsAdmin.booleanValue();
		}
	}

	/**
	 * 开启从控制器的debug模式
	 * 
	 * 从控制器是最高优先级
	 * 如果需要启动该模式，只需要在static块里面调用该方法即可
	 * @since 1.6 从Java1.6版本开始支持该模式
	 */
	private static void openDebug() {
		SELF_ON_OFF = false;
	}

	/**
	 * 关闭从控制器的debug模式
	 * 
	 * 从控制器是最高优先级
	 * 如果需要启动该模式，只需要在static块里面调用该方法即可
	 * @since 1.6 从Java1.6版本开始支持该模式
	 */
	private static void closeDebug() {
		SELF_ON_OFF = true;
	}

}
