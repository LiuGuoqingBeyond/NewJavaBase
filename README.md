## 新中付代理商App

### 项目架构

- MVP

### 开发语言

- Java + kotlin

**开发原则**
1. 尽量用kotlin开发
2. 尽量使用fragement替代Activity
3. 字段名称、方法名称、对象名称命名可视化
4. 不同对象分包对应存放
5. 代码简化,建议一般超过10行的重复代码抽成一个公用方法调用,避免代码冗余。
6. 一个类代码实现不要超过600行代码，一个方法不要超过一屏。
7. 项目开发之前写项目的结构图和项目接口文档

**项目结构**
agentapp: 项目主工程
appFrameLib: 项目基础依赖库

- config: 项目配置包
 - 主要存放项目的配置文件,比如项目请求路径,静态常量参数等...

- entity: Model层
 - 主要存放项目的对象类。

- present: p层
 - 主要存放项目中定义的一些接口和接口实现类的文件。

- ui：View 层
 - 主要存放项目的View视图显示文件

- utils:
 - 主要存放一些项目第三方工具类,供其它对象调用





