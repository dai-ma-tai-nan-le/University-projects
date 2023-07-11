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
float line(point m,point n);
