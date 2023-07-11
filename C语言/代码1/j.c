/*#include<stdio.h>
int main()
{
    int i=1,j,sum;
    for(;i<=100;i++)
    {
        for(j=1;j<=i-1;j++)
            {if(i%j==0) break;}
        if(j==i)
           sum=sum+i;
    }
     printf("%d",sum);

}*/
/*#include<stdio.h>
int main()
{
    int i=0,j,sum=0;
    for(;i<=100;i++)
    {
        for(j=2;j<=i-1;j++)
            {if(i%j==0) break;}
        if(j==i)
            sum=sum+i;
    }
  printf("%d",sum);
}*/
/*#include<stdio.h>
int main()
{
    int i,j,k,x=1;
    scanf("%d%d%d",&i,&j,&k);
    while(x)
    {
        if(x%i==0&&x%j==0&&x%k==0)
            break;
        else
            x++;
    }
  printf("%d",x);
}*/

/*#include<stdio.h>
int main()
{
     float fun(int,int);
    float a,b,c,d,e;
    scanf("%d%d%d%d%d",&a,&b,&c,&d,&e);
  fun(a,b);
  printf("%d",fun);
}
float fun(int,int)
{
    float x;
   float j,k,l,m,n;
    x=fun(j,k);
    x=fun(x,l);
    x=fun(x,m);
    x=fun(x,n);
    return x;

}*/















