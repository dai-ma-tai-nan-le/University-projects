#include<iostream>
using namespace std;
class A
{
private:
    int x;
public:
    A(int a=0)
    {
        x=a;
    }
    int getx()
    {
        return x;
    }
};
class B:public A
{
protected:
    int y;
public:
    B(int b=0)
    {
        y=b;
    }
};
int main()
{
    B b;
   cout<<b.getx()<<endl;
}



















#include<iostream>
using namespace std;
class A
{
private:
	int x;
public:
	A(int temp=0):x(temp){}
	int getX()
	{
		return x;
	}
};
class B:protected A
{
protected:
	int y;
public:
	B(int temp=0)
	{
		y = temp;
	}
	int getX()
	{
		return A::getX();
	}
};
int main()
{
	B b;
	cout<<b.getX()<<endl;
}
