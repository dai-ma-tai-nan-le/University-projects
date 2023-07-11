#include<iostream>
using namespace std;
#include<math.h>
class point
{
private:
    int x,y;
public:
    void setxy(int a,int b);
    int getx();
    int gety();
};
class line
{
    point p1,p2;
private:
    int a=p1.getx()-p2.getx();
    int b=p1.gety()-p2.gety();
public:
    void setl(int a,int b);
};
float line(line m,line n);
class triangle
{
   class Triangle
{
private:
    double i,j,k;
public:
    Triangle();
    Triangle(double a1,double b1,double c1);
};

