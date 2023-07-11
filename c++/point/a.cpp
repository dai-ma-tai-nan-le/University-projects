#include"a.h"
void point::setxy(int a,int b)
{
    x=a;
    y=b;
}
int point::getx()
{
    return x;
}
int point::gety()
{
    return y;
}
float line(point m,point n)
{
    return sqrt(pow(m.getx()-n.getx(),2)+pow(m.gety()-n.gety(),2));
}
