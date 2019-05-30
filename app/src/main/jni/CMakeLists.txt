
cmake_minimum_required(VERSION 3.4.1)

#添加C/C++文件到HelloWorld文件镜像内
add_library(HelloWorld SHARED
            HelloWorld.cpp)

# 添加依赖  HelloWorld为镜像名
target_link_libraries(HelloWorld
                       android
                       log)
