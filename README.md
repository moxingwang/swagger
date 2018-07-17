> 项目中你可能已经使用到了swagger，或许你并没有对它过于留意，比如说springfox、swagger-springmvc、swagger-ui他们之间的关系是什么，springfox原理是什么。

# 先看一个pull下来就能启动的spring-boot，swagger-ui集成demo
> git项目地址 [https://github.com/moxingwang/swagger.git](https://github.com/moxingwang/swagger.git)

* 获取代码
````
git pull https://github.com/moxingwang/swagger.git
````
* 启动
````
cd swagger
mvn spring-boot:run
````
* 访问

[http://localhost:8080/sw/swagger-ui.html](http://localhost:8080/sw/swagger-ui.html)

![](https://github.com/moxingwang/swagger/blob/master/souce/swagger-index.png?raw=true)

自此一个非常方便又简单的swagger-ui集成好了，写完业务逻辑代码可以立马公布restful api给前端调用。

# 具体使用
* 基于springfox使用swagger非常简单，只需要maven依赖以及少量config配置就可以实现，上面的demo中都有体现，或者直接访问springfox的github上面的demo[springfox/springfox-demos](https://github.com/springfox/springfox-demos) 。
* springfox更详细配置请参考官方文档[Springfox Reference Documentation](https://springfox.github.io/springfox/docs/current/#introduction)。
* swagger annotation具体使用 [Swagger-Core Annotations](https://github.com/swagger-api/swagger-core/wiki/annotations-1.5.x)，这里面有详细的annotation描述。

#### 特别注意事项
虽然说swagger是个好东西，但是使用中切不可以忽略的一个问题--【安全】。dev uat1环境中你可以开放swagger给前端或者测试，千万不要把它开放给了生产，如果你的swagger ui不小心放到了生产，那是一件多么可怕的事情，真可以来个‘一锅端’，切记切记。官网文档有相关的安全配置[http://springfox.github.io/springfox/docs/current/#configuring-security-schemes-and-contexts-an-overview](http://springfox.github.io/springfox/docs/current/#configuring-security-schemes-and-contexts-an-overview)。也可以在不同环境配置中添加要给变量来控制，swagger ui是否可用([https://github.com/moxingwang/swagger.git](https://github.com/moxingwang/swagger.git))。
````
    @Value("${swagger.switch}")
    private boolean swaggerSwitch;

    @Bean
    public Docket api() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        if (swaggerSwitch) {
            docket.enable(true);
        } else {
            docket.enable(false);
        }

        docket.apiInfo(apiInfo()).select().paths(PathSelectors.any()).build();

        return docket;
    }
````

#### 其他
如若你在spring-boot中使用swagger还嫌麻烦，想要直接一个注解搞定，建议你看[SpringForAll/spring-boot-starter-swagger](https://github.com/SpringForAll/spring-boot-starter-swagger)这个项目。


# 搞明白swagger，springfox是什么
#### swagger
> Swagger 是一款目前世界最流行的API管理工具，是一个规范和完整的框架，用于生成、描述、调用和可视化 RESTful 风格的 Web 服务。文档提供了一个方法，我们可以用指定的 JSON 或者 YAML 摘要来描述你的 API，包括了比如 names、order 等 API 信息。你可以通过一个文本编辑器来编辑 Swagger 文件，或者你也可以从你的代码注释中自动生成。各种工具都可以使用 Swagger 文件来生成互动的 API 文档。你需要具体阅读这里[What Is Swagger?](https://swagger.io/docs/specification/2-0/what-is-swagger/)来理解。

Swagger拥有众多不同语言和平台的开源实现与工具，他有很多实现方式，非常方便，并且支持语言特别多，详细请查看（一定要看一眼，就知道他有多强大）[Tools and Integrations](https://swagger.io/tools/open-source/open-source-integrations/)。

![](https://github.com/moxingwang/swagger/blob/master/souce/swagger-intergrations.png?raw=true)

这里也可以参考[Swagger Annotation 详解（建议收藏）](https://www.jianshu.com/p/b0b19368e4a8)这篇文章查看相关几个组件的中文介绍。


#### springfox
> springfox是java对swagger的一个具体实现。springfox的前身是swagger-springmvc，用于springmvc与swagger的整合。它内部会自动解析Spring容器中Controller暴露出的接口，并且也提供了一个界面用于展示或调用这些API。

要分分钟了解springfox的原理，请参考阿里云社区[API管理工具Swagger介绍及Springfox原理分析](https://yq.aliyun.com/articles/599809?utm_content=m_1000002417)这篇文章。

最后再来看一篇文章[Swagger 和 Springfox-Swagger 的关系](https://blog.csdn.net/kinginblue/article/details/78513029)，加深你对Swagger和Springfox-Swagger的理解。

# 总结
* 如果你后台开发，提供restful接口给前端。建议你使用swagger-ui提供restful的接口文档描述。
* 如果你是接口设计者，建议你使用Swagger Editor设计。
* 如果你是接口调用方，想快速生成接口调用代码，很简单，你只需要使用Swagger Editor生存client代码就行了，十分方便。


# 参考
* [@ApiResponses and @ApiResponses in swagger ](https://stackoverflow.com/questions/43368627/apiresponses-and-apiresponses-in-swagger)
* [Swagger 和 Springfox-Swagger 的关系](https://blog.csdn.net/kinginblue/article/details/78513029)
* [[译]5.41 Swagger tutorial](https://www.cnblogs.com/JoiT/p/6378086.html)
* [API管理工具Swagger介绍及Springfox原理分析](https://yq.aliyun.com/articles/599809?utm_content=m_1000002417)
* [Swagger Annotation 详解（建议收藏）](https://www.jianshu.com/p/b0b19368e4a8)
* [SpringForAll/spring-boot-starter-swagger](https://github.com/SpringForAll/spring-boot-starter-swagger)