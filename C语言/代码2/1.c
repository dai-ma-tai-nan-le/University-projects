/*#include<stdio.h>
int main ()
{
    int a=5,b=4,c=8;
    int *p1,*p2,*p3;
    p1=&b,p2=&c,p3=&a;
    printf("%d %d %d",*p1,*p2,*p3);
}*/
/*#include<stdio.h>
int main ()
{
    int a[5],i;
    int *p=a;
    for(i=0;i<5;i++)
        scanf("%d",p+i);
    for(i=0;i<5;i++)
        printf("%d\n",*(p+i));
}*/
#include<stdio.h>
int main ()
{
 int x[10],*p1,*p2,k;
 for(k=0;k<10;k++)
    scanf("%d",x+k);
 for(p1=x,p2=x;p1-x<10;p1++)
    {
        if(*p1>*p2)
        p2=p1;
    }
    printf("%d,%d",*p2,10-p1);
}
