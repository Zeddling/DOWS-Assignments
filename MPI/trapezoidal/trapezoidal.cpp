#include "trapezoidal.h"

float trapezoidal::trapezoidal_func(float lower, float upper, int subInterval) {
    stepSize = ( upper - lower ) / subInterval;    //  Find step size
    integration = f(lower) + f(upper);  //  Find integration value
    for(i=1; i<=subInterval-1; i++) {
        k = lower + i*stepSize;
        integration = integration + 2 * (f(k));
    }
    return integration * stepSize/2;
}


float* trapezoidal::manageProgram() {
    float data[3];
    std::cout<<"Enter lower limit of integration: ";
    std::cin>>data[0];
    std::cout<<"\nEnter upper limit of integration: ";
    std::cin>>data[1];
    std::cout<<"\nEnter number of sub intervals: ";
    std::cin>>data[2];
    float* pointer = data;
    return pointer;
}