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
   cout<<a<<" "<<b<<endl;//����
   swap(&a,&b);
   cout<<a<<" "<<b<<endl;//��ַ
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
    cout<<"���볤��"<<endl;
    cin>>l>>w>>h;
    cout<< miantiji(l,w)<<endl;//���
    cout<< miantiji(l,w,h)<<endl;//���
}
int miantiji(int a,int b,int c)
{
   return a*b*c;
}











