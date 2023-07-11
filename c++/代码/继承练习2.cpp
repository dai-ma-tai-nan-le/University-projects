#include<iostream>
using namespace std;
class Shape
{
private:
    int x,y;
public:
    Shape()
    {
        x=y=0;
    }
    Shape(int a,int b)
    {
        x=a;
        y=b;
    }
    void GetArea()
    {
    }
    void show()
    {
    }
};
class Cirlce
{
private:
    Shape a,b;
    int r;
public:
    Cirlce()
    {
        r=0;
    }
    Cirlce(int a,int b,int c):Shape(a),r(a),a(b),b(c)
    {
    }
    void GetArea()
    {
        cout<<3.14*r*r<<endl;
    }
    void show()
    {
        cout<<"("<<a<<","<<b<<")"<<" "<<r<<endl;
    }
    void set(int x,int y,int z)
    {
        a=x;
        b=y;
        r=z;
    }
};
class Rectangle
{
private:
    int m,n;
public:
    Rectangle()
    {
        m=n=0;
    }
    Rectangle(int a,int b)
    {
        m=a;
        n=b;
    }
    void GetArea()
    {
        cout<<m*n<<endl;
    }
    void show()
    {
        cout<<m<<n<<endl;
    }
    void set(int x,int y)
    {
        m=x;
        n=y;
    }
};
class Triangle
{
private:
    Shape i,j,k;
public:

};





