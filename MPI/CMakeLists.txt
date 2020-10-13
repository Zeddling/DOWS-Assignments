cmake_minimum_required(VERSION 3.15)
project(assignment)

set(CMAKE_CXX_STANDARD 14)
find_package(MPI REQUIRED)
add_executable(fix "trapezoidal/trapezoidal.h" "trapezoidal/trapezoidal.cpp" fix.cpp)
#add_executable(assignment_b tutorial.cpp)
#target_include_directories(assignment_a PRIVATE ${MPI_CXX_INCLUDE_PATH} src1.h src2.h)
#target_compile_options(assignment_a PRIVATE ${MPI_CXX_COMPILE_FLAGS})
#target_link_libraries(assignment_a ${MPI_CXX_LIBRARIES} ${MPI_CXX_LINK_FLAGS})

