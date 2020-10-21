#pragma once 
#include "math.h"
#include <iostream>
#define f(x) 1/(1+pow(x,2))

class trapezoidal{
public:
    float trapezoidal_func(float lower, float upper, int subInterval);
    float* manageProgram();
};
