/*#include<stdio.h>
int main()
{
    int a,n,a1;
    a1=1,n=51;
    a=n*a1+n*(n-1);
    printf("%d",a);

}*/
#include<stdio.h>
int main()
{
    int a,b,c,t,x1,x2;
    scanf("%d%d%d",&a,&b,&c);
    t=b*b-4*a*c;
    x1=(-b+sqrt(t))/2/a;
    x2=(-b-sqrt(t))/2/a;
    printf("%d,%d",x1,x2);
}









