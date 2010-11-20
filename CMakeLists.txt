cmake_minimum_required (VERSION 2.6)
project (mdoms)

set (CMAKE_BUILD_TYPE debug)

add_library (deck STATIC
	libs/deck/domcard.cpp
	libs/deck/domdeck.cpp
	libs/deck/domhand.cpp)
