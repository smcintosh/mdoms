cmake_minimum_required (VERSION 2.6)
project (mdoms)

set (CMAKE_BUILD_TYPE debug)
include_directories(${CMAKE_CURRENT_SOURCE_DIR}/include)

add_library (deck STATIC
	libs/deck/domcard.cpp
	libs/deck/domdeck.cpp
	libs/deck/domhand.cpp)
