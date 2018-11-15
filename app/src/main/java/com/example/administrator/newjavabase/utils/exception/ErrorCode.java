package com.example.administrator.newjavabase.utils.exception;

/**
 * 错误码 错误码类覆盖整个APP生命周期的全部异常类型 主要是为了交易过程中的异常做区分 主要分过程与类型 1开头的表示程序类异常 2开头的交易类异常
 * 3开头的表示设备类异常 5开头的表示服务器相关异常 错误编码6位， 第1位表示1,2，3,5等的类型 第2,3位表示模块类型 01表示交易模块
 * 02表示登录模块 03表示绑定设备与手机号模块 04设备管理模块 第4,5,6位表示详细分支类型
 *
 * @author Administrator
 */
public class ErrorCode {

    /**
     * 通用程序类错误
     */
    public static final int ERR_COMM_REF = 100000;

    /**
     * （绑定设备时）获取验证码失败
     */
    public static final int BOND_DEVICE_OBTAIN_AUTH_FAILED = 103000;
    /**
     * 签到程序类异常
     */
    public static final int SIGN_UP_REF = 101000;

    /**
     * 通用交易类错误
     */
    public static final int ERR_TRADE_REF = 200000;

    /**
     * 交易预处理通用异常
     */
    public static final int ERR_TRADE_PRE_EXCEPTION = 201100;

    /**
     * 交易预处理-签到异常
     */
    public static final int ERR_TRADE_SIGN_REF = 201101;

    /**
     * 交易通信通用异常
     */
    public static final int ERR_TRADE_COMM_REF = 201102;
    /**
     * 服务器交互（交易模块:01）签到服务器返回签到失败（第六位为1表示服务器返回签到失败）
     */
    public static final int SIGN_UP_ERR_SERVER_FAIL = 201103;

    /**
     * 交易模块 解析8583文件 解析器配置异常
     */
    public static final int XML_8583_PARSE_CONFIG_EXCEPTION = 201104;

    /**
     * 交易模块 解析8583文件 SAX解析异常
     */
    public static final int XML_8583_SAX_EXCEPTION = 201105;

    /**
     * 交易模块 读取8583文件 IO异常
     */
    public static final int XML_8583_IO_EXCEPTION = 201106;

    /**
     * 交易模块 解析8583报文 通用异常
     */
    public static final int XML_8583_EXCEPTION = 201107;

    /**
     * 交易模块 服务器返回登录异常
     */
    public static final int LOGIN_FAIL = 202000;

    /**
     * 通用设备类错误
     */
    public static final int ERR_DEVICE_REF = 300000;

    /**
     * @category 交易step1 设备连接失败
     */
    public static final int ERR_DEVICE_CONN_FAILED = 301000;

    /**
     * @category 交易step1 设备连接异常
     */
    public static final int ERR_DEVICE_CONN_EXCEPTION = 301001;
    /**
     * @category 交易step1 设备更新pik、mak、tdk失败
     */
    public static final int UPDATE_WORKKEY_FAILED = 301002;
    /**
     * @category 交易step1 设备更新批次号、流水号失败
     */
    public static final int UPDATE_PNUM_FAILED = 301003;
    /**
     * 交易模块 获取刷卡信息时报
     */
    public static final int OBTAIN_SWIP_CARD_FAIL = 301004;
    /**
     * 交易模块 获取密码失败
     */
    public static final int OBTAIN_PWD_FAIL = 301005;
    /**
     * 交易模块 获取mac失败
     */
    public static final int OBTAIN_MAC_FAIL = 301006;
    /**
     * 交易模块 获取批次号、流水号失败
     */
    public static final int OBTAIN_PNUM_AND_SERNUM_FAIL = 301007;
    /**
     * 交易模块 交易失败
     */
    public static final int TRADE_FAIL = 301008;
    /**
     * 交易模块 交易时获取金额失败
     */
    public static final int TRADE_OBT_MONEY_FAIL = 301009;
    /**
     * 交易模块 交易时取消
     */
    public static final int TRADE_CANCEL = 301010;
    /**
     * @category 登录step1 设备写商户号终端号失败
     */
    public static final int UPDATE_MER_TER_FAILED = 302000;

    /**
     * @category 登录step1 获取固件版本失败
     */
    public static final int GET_DEVICE_VER_FAILED = 302001;
    /**
     * 更新设备rsa公钥失败
     */
    public static final int UPDATE_DEVICE_RSA_PUBKEY_FAIL = 302002;
    /**
     * 更新设备主秘钥失败
     */
    public static final int UPDATE_DEVICE_TMK_FAIL = 302003;
    /**
     * 更新工作密钥失败
     */
    public static final int UPDATE_WORK_KEYS_FAILED = 302004;
    /**
     * 更新工作密钥失败
     */
    public static final int DEVICE_NO_CONNECT = 302005;
    /**
     * @category 登录获取pn号失败
     */
    public static final int GET_PN_FAILED = 302006;
    /**
     * @category 登录获取pn号不是app需要的类型
     */
    public static final int DEVICE_PN_ERR = 302007;

    // /**
    // * 服务器下发的工作密钥长度不正确
    // */
    // public static final int WORK_KEYS_LENGTH_ERROR = 302000;
    /**
     * 通用服务器类错误
     */
    public static final int ERR_SERVER_REF = 500000;
    /**
     * 通用服务器类连接超时错误
     */
    public static final int ERR_SERVER_CONN_TIME_OUT = 500001;
    /**
     * 通用服务器类响应超时错误
     */
    public static final int ERR_SERVER_COMM_TIME_OUT = 500002;
    /**
     * 连接服务器失败
     */
    public static final int ERR_SERVER_CONN_FAIL = 500003;
    /**
     * 服务器交易时返回数据，但获取不到39域
     */
    public static final int TRADE_ERR_SERVER_REF = 501000;
    /**
     * 服务器交互（交易模块:01）签到连接超时
     */
    public static final int SIGN_UP_ERR_SERVER_TIME_OUT = 501001;

    /**
     * 服务器交互（交易模块:01）签到下发62域数据不对
     */
    public static final int SIGN_UP_ERR_SERVER_REF = 501002;
    /**
     * 服务器交互（交易模块:01）签到下发批次号、流水号失败
     */
    public static final int SERVER_SEND_PNUM_FAILED = 501003;
    /**
     * 服务器上传电子签名时，网络异常
     */
    public static final int TRADE_UPLOAD_PICTURE_ERR_SERVER_REF = 501004;
    /**
     * 服务器上传电子签名时服务器响应异常，获取不到39域
     */
    public static final int REPONSE_SIGN_PICTURE_ERR_SERVER_REF = 501005;
    /**
     * 服务器上传电子签名时服务器响应异常，获取不到小票地址
     */
    public static final int NO_REPONSE_URL__ERR_SERVER_REF = 501006;
    /**
     * 服务器查询交易记录时连接失败
     */
    public static final int NO_REPONSE_QUERY_TICKET_ERR_SERVER_REF = 501007;
    /**
     * 服务器获取签名信息的55域数据时连接异常
     */
    public static final int NO_REPONSE_QUERY_55_DATA_ERR_SERVER_REF = 501008;
    /**
     * 服务器获取签名信息的55域数据时未返回数据
     */
    public static final int NO_REPONSE_QUERY_55_DATA_ERR = 501009;
    /**
     * 服务器交互（登录时:02）错误
     */
    public static final int LOGIN_ERR_SERVER_REF = 502000;
    /**
     * 服务器（登录时:02）网络正常，但无返回
     */
    public static final int LOGIN_NO_RESULT_ERR_SERVER_REF = 502001;
    /**
     * 登录时查询默认收款人无响应
     */
    public static final int DEFAULT_BENEFICIARY = 502003;
    /**
     * 服务器（登录时:02）网络正常，但返回失败
     */
    public static final int LOGIN_RESULT_ERR_SERVER_REF = 502002;
    /**
     * 更新app时服务器连接超时
     */
    public static final int NET_EXCEPTION = 502004;
    /**
     * 服务器交互（绑定设备时:03）错误
     */
    public static final int BOND_DEVICE_ERR_SERVER_REF = 503000;
    /**
     * 服务器交互（注册）激活失败
     */
    public static final int BOND_DEVICE_ACT_ERR_SERVER_REF = 503001;
    /**
     * 服务器交互（注册）上传资料失败
     */
    public static final int UPLOAD_INFO_ERR_SERVER_REF = 503002;
    /**
     * 服务器交互查询认证进度失败
     */
    public static final int QUERY_PROGRESS_ERR_SERVER_REF = 503003;
    /**
     * 服务器交互查询认证进度,结果为未通过
     */
    public static final int QUREY_PROGRESS_RESPONSE_FAIL = 503004;
    /**
     * 服务器交互获取验证码异常
     */
    public static final int OBTAIN_AUTH_NUM_RESPONSE_FAIL = 503005;
    public static final int OBTAIN_IS_REGISTER_NO_RES = 503006;

    /**
     * @category 上传信用卡信息失败
     */
    public static final int UPLOAD_CREDITCARD_INFO_FAIL = 504000;
    /**
     * 商户号为空或超出长度15位
     */
    public static final int UPLOAD_CREDITCARD_INFO_MERCODE_ERROR = 504001;
    /**
     * 信用卡卡号为空或超出长度21位
     */
    public static final int UPLOAD_CREDITCARD_INFO_CREDITCARD_ERROR = 504002;
    /**
     * 图片数据为空
     */
    public static final int UPLOAD_CREDITCARD_INFO_PICTURE_NULL = 504003;
    /**
     * 图片数据过大
     */
    public static final int UPLOAD_CREDITCARD_INFO_PICTURE_TOO_LARGE = 504004;
    /**
     * MD5加密 错误
     */
    public static final int UPLOAD_CREDITCARD_INFO_MD5_ERROR = 504005;
    /**
     * 刷卡头号对应信用卡卡号已存在
     */
    public static final int UPLOAD_CREDITCARD_INFO_CREDITCARD_ALREADY_EXIT = 504006;
    /**
     * 图片过多
     */
    public static final int UPLOAD_CREDITCARD_PHOTO_MORE = 504010;
    /**
     * 上传失败
     */
    public static final int UPLOAD_CREDITCARD_INFO_UPLOAD_FAIL = 504007;
    /**
     * 持卡人姓名为空
     */
    public static final int UPLOAD_CREDITCARD_INFO_NAME_NULL = 504008;
    /**
     * 信用卡过期时间已过期
     */
    public static final int UPLOAD_CREDITCARD_INFO_CREDITCARD_EXPIRED = 504009;
    /**
     * 上传异常
     */
    public static final int UPLOAD_CREDITCARD_INFO_UPLOAD_EXCEPTION = 504099;
    /**
     * @category 秒到卡认证查询失败
     */
    public static final int CREDIT_CARD_QUERY_FAIL = 505000;

    /**
     * 8583报文交互类错误码
     */
    public static final int MSG_8583_RES_CODE_ERROR = 600000;
    /**
     * 请联系发卡行，或核对卡信息后重新输入
     */
    public static final int MSG_8583_RES_CODE_01 = 601001;
    /**
     * 请联系发卡行
     */
    public static final int MSG_8583_RES_CODE_02 = 601002;
    /**
     * 无效商户
     */
    public static final int MSG_8583_RES_CODE_03 = 601003;
    /**
     * 无效终端
     */
    public static final int MSG_8583_RES_CODE_04 = 601004;
    /**
     * 不予承兑，或核对卡信息后重新输入
     */
    public static final int MSG_8583_RES_CODE_05 = 601005;
    /**
     * 出错
     */
    public static final int MSG_8583_RES_CODE_06 = 601006;
    /**
     * 特定条件下没收卡
     */
    public static final int MSG_8583_RES_CODE_07 = 601007;
    /**
     * 请求正在处理中
     */
    public static final int MSG_8583_RES_CODE_09 = 601009;
    /**
     * 无效交易，或核对卡信息后重新输入
     */
    public static final int MSG_8583_RES_CODE_12 = 601012;
    /**
     * 无效金额,交易金额不在许可的范围内
     */
    public static final int MSG_8583_RES_CODE_13 = 601013;
    /**
     * 无效卡号（无此号），或核对卡信息后重新输入
     */
    public static final int MSG_8583_RES_CODE_14 = 601014;
    /**
     * 无此发卡方
     */
    public static final int MSG_8583_RES_CODE_15 = 601015;
    /**
     * 找不到原始交易
     */
    public static final int MSG_8583_RES_CODE_25 = 601025;
    /**
     * 格式错误
     */
    public static final int MSG_8583_RES_CODE_30 = 601030;
    /**
     * 不支持该发卡银行
     */
    public static final int MSG_8583_RES_CODE_31 = 600031;
    /**
     * 商户不受理的卡
     */
    public static final int MSG_8583_RES_CODE_32 = 601032;
    /**
     * 过期的卡
     */
    public static final int MSG_8583_RES_CODE_33 = 601033;
    /**
     * 有作弊嫌疑
     */
    public static final int MSG_8583_RES_CODE_34 = 601034;
    /**
     * 受限制的卡
     */
    public static final int MSG_8583_RES_CODE_36 = 601036;
    /**
     * 风险卡
     */
    public static final int MSG_8583_RES_CODE_37 = 601037;
    /**
     * 超过允许的试输入
     */
    public static final int MSG_8583_RES_CODE_38 = 601038;
    /**
     * 无贷记账户
     */
    public static final int MSG_8583_RES_CODE_39 = 601039;
    /**
     * 请求的功能尚不支持
     */
    public static final int MSG_8583_RES_CODE_40 = 601040;
    /**
     * 挂失卡
     */
    public static final int MSG_8583_RES_CODE_41 = 601041;
    /**
     * 无此账户
     */
    public static final int MSG_8583_RES_CODE_42 = 601042;
    /**
     * 被窃卡
     */
    public static final int MSG_8583_RES_CODE_43 = 601043;
    /**
     * 无此投资账户
     */
    public static final int MSG_8583_RES_CODE_44 = 601044;
    /**
     * 降级交易
     */
    public static final int MSG_8583_RES_CODE_45 = 601045;
    /**
     * 资金不足
     */
    public static final int MSG_8583_RES_CODE_51 = 601051;
    /**
     * 无此支票账户
     */
    public static final int MSG_8583_RES_CODE_52 = 601052;
    /**
     * 无此储蓄卡账户
     */
    public static final int MSG_8583_RES_CODE_53 = 601053;
    /**
     * 过期的卡
     */
    public static final int MSG_8583_RES_CODE_54 = 601054;
    /**
     * 密码错误
     */
    public static final int MSG_8583_RES_CODE_55 = 601055;
    /**
     * 无此卡记录
     */
    public static final int MSG_8583_RES_CODE_56 = 601056;
    /**
     * 不允许持卡人进行的交易
     */
    public static final int MSG_8583_RES_CODE_57 = 601057;
    /**
     * 不允许终端进行的交易
     */
    public static final int MSG_8583_RES_CODE_58 = 601058;
    /**
     * 有作弊嫌疑
     */
    public static final int MSG_8583_RES_CODE_59 = 601059;
    /**
     * 超出取款转账金额限制
     */
    public static final int MSG_8583_RES_CODE_61 = 601061;
    /**
     * 受限制的卡
     */
    public static final int MSG_8583_RES_CODE_62 = 601062;
    /**
     * 侵犯安全
     */
    public static final int MSG_8583_RES_CODE_63 = 601063;
    /**
     * 原始金额错误
     */
    public static final int MSG_8583_RES_CODE_64 = 601064;
    /**
     * 超出取款次数限制
     */
    public static final int MSG_8583_RES_CODE_65 = 601065;
    /**
     * 请联系发卡行
     */
    public static final int MSG_8583_RES_CODE_66 = 601066;
    /**
     * 请插 IC 卡交易
     */
    public static final int MSG_8583_RES_CODE_69 = 601069;
    /**
     * 本地区不支持普通秒到，请使用VIP秒到
     */
    public static final int MSG_8583_RES_CODE_70 = 601070;
    /**
     * 允许输入密码次数超限
     */
    public static final int MSG_8583_RES_CODE_75 = 601075;
    /**
     * 发卡方或交换中心不能操作
     */
    public static final int MSG_8583_RES_CODE_91 = 601091;
    /**
     * 网络暂时无法达到，请稍后重试
     */
    public static final int MSG_8583_RES_CODE_92 = 601092;
    /**
     * 交易违法、不能完成
     */
    public static final int MSG_8583_RES_CODE_93 = 601093;
    /**
     * 重复交易
     */
    public static final int MSG_8583_RES_CODE_94 = 601094;
    /**
     * 核对差错
     */
    public static final int MSG_8583_RES_CODE_95 = 601095;
    /**
     * 系统异常、失效
     */
    public static final int MSG_8583_RES_CODE_96 = 601096;
    /**
     * ATM/POS 终端号找不到
     */
    public static final int MSG_8583_RES_CODE_97 = 601097;
    /**
     * 交换中心收不到发卡方应答
     */
    public static final int MSG_8583_RES_CODE_98 = 601098;
    /**
     * 密码格式错
     */
    public static final int MSG_8583_RES_CODE_99 = 601099;
    /**
     * mac校验失败
     */
    public static final int MSG_8583_RES_CODE_A0 = 601100;

}
