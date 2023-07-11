
/*#include<stdio.h>
int main()
{
   int x,y;
   int mymod(int a,int b);
   scanf("%d%d",&x,&y);
   printf("%d", mymod(x,y));
}
int mymod(int a,int b)
{
    int z;
    z=a%b;
    return z;
}*/
/*#include<stdio.h>
#include<math.h>
int main()
{
   int average3(int a,int b,int c);
   int x,y,z,average;
   scanf("%d%d%d",&x,&y,&z);
   printf("%d",average3(x,y,z));
}
int average3(int a,int b,int c)
{
    int i;
    i=(a+b+c)/3;
    return i;
}*/
/*#include<stdio.h>
int main()

{
    int fun2(int a,int b);
   char a,b,c,d,fun,m;
   scanf("%c%c%c%c",&a,&b,&c,&d);
   m=fun2(fun2(fun2(a,b),c),d);
   printf("%c",m);
}
int fun2(int a,int b)
{
    if(a>b)
        return a;
    else
        return b;
}*/
/*#include<stdio.h>
int main()
{
   int isprime(int a);
   int n,s;
   scanf("%d",&n);
   s=isprime(n);
   printf("%d",s);
}
int isprime(int a)
{
    int k,n;
    for(k=2;k<=n;k++)
    {
     if(k%a==0)
     break;
    }
    if(a==k) return 1;
    else return 0;
}*/
/*#include<stdio.h>
int main()
{
    char myupper(char ch);
   char ch;
   while((ch=getchar())!='@')
   {
       ch=myupper(ch);
       putchar(ch);
   }
   return 0;
}
char myupper(char ch)
{
    if(ch>='a'&&ch<='z')
        ch=ch-32;
    return ch;
}*/
/*#include<stdio.h>
int main()
{
    char myupper(char ch);
   char ch;
   int b;
   while((ch=getchar())!='@')
   {
    b=myupper(ch);
   }
   printf("%d",b);
}
char myupper(char ch)
{
    static int i=0;
    i++;
    return i;
}*/
/*#include<stdio.h>
int main()
{
    int n,i,sum=1;
    scanf("%d",&n);
    for(i=1;i<=n;i++)
    {
        sum*=i;
    }
    printf("%d",sum);
}*/
/*#include<stdio.h>
int main()
{
    int fac(int a);
    int n,i,sum;
    scanf("%d",&n);
    printf("%d",fac(n));
}
int fac(int a)
{
    int i,sum=1;
   for(i=1;i<=a;i++)
    {
        sum*=i;
    }
    return sum;
}*/
/*#include<stdio.h>
int main()
{
    int fac(int a);
    int n;
    scanf("%d",&n);
    printf("%d",fac(n));
}
int fac(int a)
{
    int i;
    if(a<0)
        printf("errror");
    else if(a==0||a==1)
        i=1;
    else i=fac(a-1)*a;
    return i;
}*/
/*#include<stdio.h>
int main()
{
    int fac(int a);
    int n;
    scanf("%d",&n);
    printf("%d",fac(n));
}
int fac(int a)
{
    int i;
    if(a<0)
        printf("errror");
    else if(a==0||a==1)
        i=1;
    else i=fac(a-1)*a;
    return i;
}*/
/*#include<stdio.h>
int main()
{
    int fac(int a);
    int n,j,c;
    scanf("%d",&n);
    for(j=1;j<=n;j++)
        c=fac(j);
    printf("%d",c);
}
int fac(int a)
{
     static int i=1;
     i=i*a;
    return i;
}*/
#include<stdio.h>
int main()
{
    int fac(int a,int b);
    int fun(int c,int d);
    int i,j,k,l;
    scanf("%d%d",&i,&j);
    k=fac(i,j);
    l=fun(i,j);
    printf("最大公约数%d，最小公倍数%d",l,k);
}
int fac(int a,int b)
{
     int x=1;
     for(x=2;;x++)
     {
         if(x%a==0&&x%b==0)
            break;
     }
    return x;
}
 int fun(int c,int d)
 {
     int x=1;
     for(x=c;;x--)
     {
         if(c%x==0&&d%x==0)
            break;
     }
    return x;
 }
















