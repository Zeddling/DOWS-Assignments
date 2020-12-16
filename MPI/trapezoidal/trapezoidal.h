#pragma once 
#include "math.h"
#include <iostream>
#define f(x) 1/(1+pow(x,2))

class trapezoidal{
public:
    float trapezoidal_func(float lower, float upper, int number_of_intervals);
    float* manageProgram();
};
