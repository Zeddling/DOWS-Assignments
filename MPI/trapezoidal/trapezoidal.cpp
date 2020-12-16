#include "trapezoidal.h"

float trapezoidal::trapezoidal_func(float lower, float upper, int number_of_intervals) {
    float height = ( upper - lower ) / number_of_intervals;
    float integral = 0.5 * height * ((4+5) + 2*(6+6+4+4));
    return integral;
}


float* trapezoidal::manageProgram() {
    float *data = new float[3];
    std::cout<<"Enter lower limit of integration: ";
    std::cin>>data[0];
    std::cout<<"\nEnter upper limit of integration: ";
    std::cin>>data[1];
    std::cout<<"\nEnter number of sub intervals: ";
    std::cin>>data[2];
    float* pointer = data;
    return pointer;
}