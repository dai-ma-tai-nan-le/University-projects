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
printf("******** 1��ע�� ********\n");
printf("******** 2����½ ********\n");
printf("******** 3���˳� ********\n");
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
printf("1,ע������ 2���˳�ע��\n");
if ( scanf(" %d",&m) == 1 )
{
if( m == 2 )
{
break;
}
else if ( m == 1 )
{
printf("ע���˻���");
scanf(" %c",&a);
printf("ע�����룺");
scanf(" %c",&b);
}
else
{
printf("input error\n");
}
}
else
{
printf("�Ƿ����룡��������!\n");
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
printf("1����½���� 2���˳���½\n");
if ( scanf(" %d",&n) == 1 )
{
if( n == 2 )
{
break;
}
else if ( n == 1 )
{
printf("�����˻���");
scanf(" %c",&c);
printf("�������룺");
scanf(" %c",&d);
if ( a == c && b == d )
{
printf("��½�ɹ���\n");
}
else
{
printf("�˻����������!\n");
}
}
else
{
printf("input error\n");
}
}
else
{
printf("�Ƿ����룡��������!\n");
break;
}
}
break;
}

case 3:
{
printf("�˳��ɹ���\n");
return 0;
}
default:
printf("input error!\n");
}
}
else
{
printf("�Ƿ����룡��������!\n");
break;
}
}


return 0;
}
