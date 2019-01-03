# cetty-docker
使用docker运行cetty-demo程序

# 环境准备
本地环境：docker 18.03.1-ce


# 第一步
编写自己的爬虫程序

# 第二步
在项目当前目录下执行构建镜像命令
``` shell
    docker build -t cetty-docker-demo:0.1.0 .
```
其中 cetty-docker-demo:0.1.0 为: 镜像名:镜像版本，可以自定义

# 第三步
执行查看镜像命令，查看我们的镜像是否构建成功
``` shell
    docker images
```
示例：
``` shell
REPOSITORY                                    TAG                 IMAGE ID            CREATED             SIZE
cetty-docker-demo                             0.1.0               7a076a75e052        18 minutes ago      657MB
```

# 第四步
在项目当前目录执行启动容器命令
``` shell
    docker run -d cetty-docker-demo:0.1.0 tail -f /dev/null
```
其中 -d 为后台运行，由于docker 要求命令在前台继续运行，否则，它会认为我们的应用程序停止并关闭该容器，
故我们在命令后面加上tail -f /dev/null

# 第五步
``` shell
    docker ps
```
查看容器是否启动成功

示例：
``` shell
CONTAINER ID        IMAGE                     COMMAND                  CREATED             STATUS              PORTS               NAMES
63b9fec5374f        cetty-docker-demo:0.1.0   "java -jar crawler.j…"   8 minutes ago       Up 8 minutes                            nostalgic_euler
```

