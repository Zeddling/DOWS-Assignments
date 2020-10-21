#include "trapezoidal/trapezoidal.h"
int main(int argc, char** argv) {

    trapezoidal *tr = new trapezoidal();
    float* array = tr->manageProgram();
    for (int i = 0; i < 3; i++)
    {
        std::cout<<array[i]<<std::endl;
    }
    float integral = tr->trapezoidal_func(array[0], array[1], array[2]);
    std::cout << "Integral: " << integral <<std::endl;
    return 0;

}