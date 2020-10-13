#include "trapezoidal/trapezoidal.h"
#include "mpi.h"
int main(int argc, char** argv) {
    std::cout<<"Starting....\n";
    MPI_Init(&argc, &argv);

    trapezoidal *tr = new trapezoidal();
    int rank;
    MPI_Comm_rank(MPI_COMM_WORLD, &rank);

    int world_size=2;
    MPI_Comm_size(MPI_COMM_WORLD, &world_size);

      // We are assuming 2 processes for this task
    if (world_size != 2) {
        fprintf(stderr, "World size must be two for %s\n", argv[0]);
        MPI_Abort(MPI_COMM_WORLD, 1);
    }

    if (rank==0) {
        //  Send array pointer to process 1
        float *data = tr->manageProgram();
        float array[] = {data[0], data[1], data[2]};
        MPI_Send(array, 3, MPI_FLOAT, 1, 0, MPI_COMM_WORLD);
        std::cout<<"Sent array"<<std::endl;
        float integ;
        MPI_Recv(&integ, 1, MPI_FLOAT, 1, 1, MPI_COMM_WORLD, MPI_STATUS_IGNORE);
        std::cout<<"Received Integral: "<<integ<<std::endl;

    } else if(rank==1) {
        float receive[3];
        MPI_Recv(&receive, 3, MPI_FLOAT, 3, 0, MPI_COMM_WORLD, MPI_STATUS_IGNORE);
        std::cout<<"Received array"<<std::endl;
        float integral = tr->trapezoidal_func(receive[0], receive[1], receive[3]);
        MPI_Send(&integral, 1, MPI_FLOAT, 0, 1, MPI_COMM_WORLD);
        std::cout<<"Integral sent"<<std::endl;
    }
    
    MPI_Finalize();
    return 0;

}