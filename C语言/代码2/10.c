#include <stdio.h>
int main()
{
	int i,n,b=0,y=0;
	int *p=&b;
	printf("Input a number:\n");
    for (i=1;;i++)
	{
	    scanf("%d",&n);
		if(n>0)
		{
			b=*p+n;
			y++;
		}
		if(n<0)
		{
			continue;
		}
		if(n==0)
		{
			break;
		}
	}
	printf("sum=%d,count=%d\n",b,y);
	return 0;
}




/*#include <stdio.h>
struct date
 {
     int year;
     int month;
     int day;
 };
 void main()
 {
     int aj(int a);
     int bj(struct date a);
     struct date a;
     int n;
     printf("\n请输入日期（年 月 日）\n");
     scanf("%d%d%d",&a.year,&a.month,&a.day);
     n=bj(a);
     printf("该日在本年中是第%d天\n",n);
 }
 int aj(int a)
 {
     if(a%400==0||(a%4==0&&a%100!=0))
         return 1;
     else
         return 0;
 }
 int bj(struct date a)
 {
     int i;
     int sum=0,b[]={0,31,28,31,30,31,30,31,31,30,31,30,31} ;
     for(i=0;i<a.month;i++)
     {
         sum+=b[i];
     if(a.month>2)
         sum=sum+a.day+aj(a.year);
     else
         sum=sum+a.day;
     }
     return sum;
 }*/



/* #include<stdio.h>
struct date
{
	int mouth;
	int year;
	int day;
};
int main()
{
	int days(struct date a);
	struct date a;
	printf("请输入年月日\n");
	scanf("%d%d%d",&a.year,&a.mouth,&a.day);
	printf("%d\n",days(a));
	return 0;
}
int days(struct date a)
{
	int i,sum;
	int a[13]={0,31,28,31,30,31,30,31,31,30,31,30,31};
	sum=a.day;
	for(i=0;i<a.mouth;i++)
	{
		sum+=a[i];
	}
	if(a.mouth>2)
	{
	    if((a.year&4==0&&a.year%100!=0)||a.year%400==0)
		sum++;
	}
	return(sum);
}*/

