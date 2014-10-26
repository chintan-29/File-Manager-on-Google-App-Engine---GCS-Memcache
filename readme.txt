For java

compile code using:javac program.java
run code using : java programname

For multinode you have to pass the condition, for example 
for 4 thread code 
$ java wc_mul 4
for 16 thread code
$ java wc_mul 16
for 8 thread code
$ java wc_mul 8

For hadoop

You can run jar file as well as the same wordcount-hadoop.java file as we run in java.

For swift

Install python and libcloud library. Since we are using an Ubuntu instance:
$ sudo apt-get install python python-pip
$ sudo pip install apache-libcloud

Get the cloud-tutorials repository from git

First Install git using
$ sudo apt-get install git
$ git clone https://github.com/yadudoc/cloud-tutorials.git

Go to ec2 directory to setup cluster
$ cd cloud-tutorials/ec2

Must source the setup script.
$ source setup.sh

Check AWS management console for  the status of the cluster. If every instance is ready (i.e. shows "2/2 ...."), then enter the command 
$ connect headnode", 
and you'll ssh to the headnode.
and change directory read-write permission then go to count and
Run  $ swift wordcount.swift 

For MPI

To compile your code : $mpicc mpi.c -o m1
To run your code : $mpirun -np 16 ./m1