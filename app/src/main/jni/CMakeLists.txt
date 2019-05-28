
cmake_minimum_required(VERSION 3.4.1)

add_library(HelloWorld SHARED
            HelloWorld.cpp)

# Include libraries needed for hello-jni lib
target_link_libraries(HelloWorld
                       android
                       log)
