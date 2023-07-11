/*#include<iostream>
using namespace std;
int max(int a,int b);
int main()
{
   int a,b;
   cin>>a>>b;
   cout<<max(a,b)<<endl;
}
int max(int a,int b)
{
   return a>b?a:b;
}
*/




/*#include<iostream>
using namespace std;
float add(float a,float b);
main()
{
    float a,b;
    cout<<"输入两个实数"<<endl;
    cin>>a>>b;
    cout<<add(a,b)<<endl;
}
float add(float a,float b)
{
    return (float(a+b));
}*/



#include<iostream>
using namespace std;
void hanoi(int n,char a,char b,char c);
main()
{
    char a='A',b='B',c='C';
    int n;
    cout<<"输入盘子个数"<<endl;
    cin>>n;
    hanoi(n,a,b,c);
    return 0;
}
void hanoi(int n,char a,char b,char c)
{
    if(n==1)
    {
        cout<<a<<"->"<<c<<endl;
        return;
    }
    else
    {
        hanoi(n-1,a,b,c);
        cout<<a<<"->"<<c<<endl;
        hanoi(n-1,b,a,c);
        return;
    }
}














