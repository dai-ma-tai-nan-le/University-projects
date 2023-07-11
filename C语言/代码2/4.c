/*#include<stdio.h>
int main()
{
    int rank(int *p1,int *p2,int *p3);
    int a,b,c;
    scanf("%d %d %d",&a,&b,&c);
    rank(&a,&b,&c);
    printf("%d %d %d",a,b,c);
}
    int rank(int *p1,int *p2,int*p3)
    {
        int t;
        if(*p1<*p2)
        {
            t=*p1,*p1=*p2,*p2=t;
        }
        if(*p1<*p3)
        {
          t=*p1,*p1=*p3,*p3=t;
        }
         if(*p2<*p3)
        {
          t=*p2,*p2=*p3,*p3=t;
        }
    }*/
/*#include<stdio.h>
int main()
{
    int rank(int a[],int n);
    int a[10];
    int i,j,t;
    for(i=0;i<10;i++)
        scanf("%d",&a[i]);
        rank(a,10);
    for(i=0;i<10;i++)
    printf("%3d",a[i]);
}
int rank(int *p,int n)
{
    int i,j,t;
     for(j=0;j<n;j++)
     {
        for(i=0;i<n-1;i++)
        if(*(p+i)<*(p+i+1))
         {
          t = *(p+i);
           *(p+i) = *(p+i+1);
          *(p+i+1) = t;
         }
     }
}*/

#include<stdio.h>
int main()
{
     int rank(int a[],int n);
    int a[10];
    int i,j,t,min;
    for(i=0;i<10;i++)
        scanf("%d",&a[i]);
    rank(a,10);
    for(i=0;i<10;i++)
    printf("%3d",a[i]);
}
 int rank(int *p,int n)
 {
     int i,j,k,t;
    for(j=0;j<9;j++)
    {
        k=j;
        for(i=j+1;i<10;i++)
            if(*(p+k)<*(p+i))
                k=i;
        t=*(p+j);*(p+j)=*(p+k);*(p+k)=t;
    }

 }




















