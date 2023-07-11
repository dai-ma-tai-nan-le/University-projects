#include<iostream>
using namespace std;
int main()
{
    void maopao(int a[][5],int n);
    int a[5][5];
    maopao(a,5);
}
void maopao(int a[][5],int n)
{
    int i,j,t;
    int *p;
    p=*a;
    cout<<"输入二维数组（5,5）"<<endl;
    for(i=0;i<5;i++)
    {
        for(j=0;j<5;j++)
        {
            cin>>a[i][j];
        }
    }
    for(i=0;i<25;i++)
    {
        for(j=0;j<25-i;j++)
        {
           if(*(p+j)>*(p+j+1))
           {
               t=*(p+j);
              *(p+j)=*(p+j+1);
              *(p+j+1)=t;
           }
        }
    }
    cout<<"输出二维数组（5,5）"<<endl;
     for(i=0;i<5;i++)
    {
        for(j=0;j<5;j++)
        {
           cout<<" "<<a[i][j];
        }
        cout<<endl;
    }
}
