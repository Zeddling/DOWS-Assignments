#include "trapezoidal/trapezoidal.h"
int main(int argc, char** argv) {

    trapezoidal *tr = new trapezoidal();
    float* array = tr->manageProgram();
    std::cout << "Integral" << tr->trapezoidal_func(array[0], array[1], array[2]);
    return 0;

}