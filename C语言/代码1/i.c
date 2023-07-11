#include<stdio.h>
int main()
{
    int i=1,sum=0;
    while(i<=101)
    {
        sum=sum+i;
        i+=2;
    }
    printf("%d",sum);
}
/*#include<stdio.h>
int main()
{
    int i=1,sum=0,sign=1;
    while(i<=101)
    {
        sum=sum+i*sign;
        sign=-sign;
        i+=2;
    }
    printf("%d",sum);
}*/
/*#include<stdio.h>
int main()
{
    int i=1,sum=0,s;
    for(;i<=99;i+=2)
    {
        s=i*(i+1)*(i+2);
        sum=sum+s;
    }
    printf("%d",sum);
}*/
/*#include<stdio.h>
int main()
{
    int i=1,sum=0,s,j;
    for(;i<=10;i++)
    {
        s=1;
        for(j=1;j<=i;j++)
        {
            s=s*j;
        }
        sum=sum+s;
    }
    printf("%d",sum);
}*/
/*#include<stdio.h>
int main()
{
    int n=0,sum=1;
  while(sum<=10000)
    {
        sum=sum+n*n;
        n++;
    }
    printf("%d\n",n);
    printf("%d",sum);
}*/
/*#include<stdio.h>
#include<math.h>
int main()
{
    float a=1,b=1,sum=0,sign=1;
    int i;
    while(fabs(a)>=1e-6)
    {
        sum+=a;
         b+=2;
        sign=-sign;
        a=sign/b;
    }
    sum*=4;
    printf("%10.8f",sum);
}*/
/*#include<stdio.h>
int main()
{
    int i=1,s=0;
    for(;;i++)
    {
        s=s+i;
        if(s>5000) break;
        else continue;
    }
    printf("%d\n",s);
    printf("%d",i);
}*/
/*#include<stdio.h>
int main()
{
    int i=2,j;
    for(;i<=100;i++)
    {
        for(j=2;j<=i-1;j++)
            {if(i%j==0) break;}
        if(j==i) printf("%d\n",i);}

}*/
/*#include<stdio.h>
#define  pi 3.14
int main()
{
    float r,s;
    for(r=0.5;r<=2.5;r+=0.5)
    {
       s=pi*r*r;
        printf("%f\n",s);
        }

}*/
/*#include<stdio.h>
int main()
{
    int year,i=0;
    for(year=2000;year<=3000;year++)
    {
       if(year%4==0&&year%100!=0||year%400==0)
        {
            printf("  %d",year);
            i++;
         if(i%10==0)
           printf("\n");
        }
    }
}*/
/*#include<stdio.h>
int main()
{
    int i,n;
    double sum=1,t=1;
    scanf("%d",&n);
    for(i=1;i<=n;i++)
    {
       t=t*i;
       sum=sum+1/t;
    }
    printf("e=%1f",sum);
}*/
/*#include<stdio.h>
#include<math.h>
int main()
{
    int i;
    double sum=1,t=1;
    while(fabs(1.0/t)>1e-6)
    {
       t=t*i;
       sum=sum+1/t;
       i++;
    }
    printf("e=%1f",sum);
}*/

/*#include<stdio.h>
int main()
{
    int f=20;
    float c;
    for(;f<=300;f++)
    {
        if(f%20!=0) continue;
        c=5.0/9*(f-32);
        printf("%f\n",c);
    }
}*/










