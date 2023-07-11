#include"a.h"
#define PI 3.14
int main()
{
	Circle c1;
	float r;
	cout<<"please input r"<<endl;
    cin>>r;
	c1.set(r);
	cout<<"栅栏的费用："<<c1.Girth(c1.get())*35<<endl;
	cout<<"过道费用："<<c1.Area(c1.get())*20<<endl;    
	return 0;
}
