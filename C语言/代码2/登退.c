#include<stdio.h>
struct wanjia
{
   int long num;
   char mima[15];
};
int main()
{
char a,b,c,d;
while(1)
{
int num;
printf("************************************************\n");
printf("******** 1、注册 ********\n");
printf("******** 2、登陆 ********\n");
printf("******** 3、退出 ********\n");
printf("************************************************\n");
if( scanf("%d",&num) == 1 )
{
switch(num)
{
case 1:
{
while(1)
{
int m;
printf("1,注册输入 2，退出注册\n");
if ( scanf(" %d",&m) == 1 )
{
if( m == 2 )
{
break;
}
else if ( m == 1 )
{
printf("注册账户：");
scanf(" %c",&a);
printf("注册密码：");
scanf(" %c",&b);
}
else
{
printf("input error\n");
}
}
else
{
printf("非法输入！重新运行!\n");
break;
}
}
break;
}
case 2:
{
while(1)
{
int n;
printf("1、登陆输入 2，退出登陆\n");
if ( scanf(" %d",&n) == 1 )
{
if( n == 2 )
{
break;
}
else if ( n == 1 )
{
printf("输入账户：");
scanf(" %c",&c);
printf("输入密码：");
scanf(" %c",&d);
if ( a == c && b == d )
{
printf("登陆成功！\n");
}
else
{
printf("账户或密码错误!\n");
}
}
else
{
printf("input error\n");
}
}
else
{
printf("非法输入！重新运行!\n");
break;
}
}
break;
}

case 3:
{
printf("退出成功！\n");
return 0;
}
default:
printf("input error!\n");
}
}
else
{
printf("非法输入！重新运行!\n");
break;
}
}


return 0;
}
