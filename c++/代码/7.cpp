/*#include<iostream>
using namespace std;
main()
{
    int add(int n);
    int add(int n,int m);
    int add(int n,int m,int k);
    int n=1,m=2,k=3;
    cout<<"add(n)="<<add(n)<<endl;
    cout<<"add(n,m)="<<add(n,m)<<endl;
    cout<<"add(n,m,k)="<<add(n,m,k)<<endl;
}
int add(int n)
{
   return n;
}
int add(int n,int m)
{
    return n+m;
}
int add(int n,int m,int k)
{
    return n+m+k;
}*/

/*#include<iostream>
using namespace std;
const int num=10;
int fun(int a,int b,int c=num);
main()
{
   int a,b;
   cout<<"输入两个数"<<endl;
   cin>>a>>b;
   cout<<"fun(a,b,c)="<<fun(a,b)<<endl;
}
int fun(int a,int b,int c)
{
   return a+b+c;
}
*/

/*#include<iostream>
using namespace std;
const int num=10;
template <class T>
T fun(T a,T b,T c=num)
{
   return a+b+c;
}
main()
{
   int a,b;
   cout<<"输入两个数"<<endl;
   cin>>a>>b;
   cout<<"fun(a,b,c)="<<fun(a,b)<<endl;
}*/

#include<iostream>
using namespace std;
const int num=10;
template <class T>
T fun(T a,T b,T c)
{
   return a+b+c;
}
main()
{
   int a,b;
   cout<<"输入两个数"<<endl;
   cin>>a>>b;
   cout<<"fun(a,b,c)="<<fun(a,b,num)<<endl;
}














