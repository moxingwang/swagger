> 使用swagger-ui你应该要关注的问题

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


# 搞明白

[http://springfox.github.io/springfox/](http://springfox.github.io/springfox/)
[https://swagger.io/](https://swagger.io/)

# response泛型处理
问题
* [@ApiResponses and @ApiResponses in swagger ](https://stackoverflow.com/questions/43368627/apiresponses-and-apiresponses-in-swagger)


[Swagger 和 Springfox-Swagger 的关系](https://blog.csdn.net/kinginblue/article/details/78513029)



[[译]5.41 Swagger tutorial](https://www.cnblogs.com/JoiT/p/6378086.html)

[API管理工具Swagger介绍及Springfox原理分析](https://yq.aliyun.com/articles/599809?utm_content=m_1000002417)

[]()
[]()


