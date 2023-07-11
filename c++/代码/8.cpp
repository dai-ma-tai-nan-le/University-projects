/*
#include<iostream>
using namespace std;
void swap(int &x,int &y);
void swap(int *x,int *y);
main()
{
   int a,b;
   cin>>a>>b;
   swap(a,b);
   cout<<a<<" "<<b<<endl;//引用
   swap(&a,&b);
   cout<<a<<" "<<b<<endl;//地址
}
void swap(int &x,int &y)
{
    int t;
    t=x;
    x=y;
    y=t;
}
void swap(int *x,int *y)
{
    int t=*x;
    *x=*y;
    *y=t;
}
*/



#include<iostream>
using namespace std;
const int h=1;
int miantiji(int a,int b,int c=h);
main()
{
    int l,w,h;
    cout<<"输入长宽"<<endl;
    cin>>l>>w>>h;
    cout<< miantiji(l,w)<<endl;//面积
    cout<< miantiji(l,w,h)<<endl;//体积
}
int miantiji(int a,int b,int c)
{
   return a*b*c;
}











