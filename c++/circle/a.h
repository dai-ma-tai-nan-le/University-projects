#include<iostream>
using namespace std;
#include<math.h>
#define PI 3.14
class Circle
{
private:
		float r;
public:
        void set(float r);
        int get();
		int Girth(float r);
		int Area(float r);//小圆面积 
};
