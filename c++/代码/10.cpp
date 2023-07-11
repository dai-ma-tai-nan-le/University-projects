/*#include<iostream>
using namespace std;
class Point
{
private:
    int x,y;
public:
    Point()
    {
        x=0;
        y=0;
    }
    Point(int a)
    {
        x=a;
        y=0;
    }
    Point(int a,int b)
    {
        x=a;
        y=b;
    }
    void input()
    {
        cout<<"x,yµã×ø±ê"<<"("<<x<<","<<y<<")"<<endl;
        cout<<endl;
    }
};
main()
{
    Point p1;
    Point p2(1);
    Point p3(1,1);
    p1.input();
    p2.input();
    p3.input();
}
*/


#include<iostream>
using namespace std;
#include<new>
class Birthday
{
private:
    int year,month,day;
    char *name;
public:
    Birthday(int a=2000,int b=2,int c=4,char *p="li")
    {
        year=a;
        month=b;
        day=c;
        name==new char[20];
        name=p;
    }
    Birthday(const Birthday &s2)
    {
        year=s2.year;
        month=s2.month;
        day=s2.day;
        name=new char[20];//分配堆空间
        *name=*s2.name;
    }
    ~Birthday()
    {
        cout<<year<<"析构"<<endl;
    }
    void change(int a,int b,int c,char *p)
    {
        year=a;
        month=b;
        day=c;
        name=p;
    }
    void printf()
    {
        cout<<name<<":"<<endl;
        cout<<year<<"-"<<month<<"-"<<day<<endl;
    }
};
main()
{
    Birthday s1;
    Birthday s2(s1);
    int a,b,c;
    char p[20];
    cout<<"输入年月日姓名"<<endl;
    cin>>a>>b>>c>>p;
    s2.change(a,b,c,p);
    s1.printf();
    s2.printf();
}

































