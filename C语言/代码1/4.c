#include<stdio.h>
int main()
{
    char a=0,ch;
    while((ch=getchar())!='\n')
    {
        if(a%2!=0&&(ch>='a'&&ch<='z'))
            ch=ch-'a'+'A';
        a++;
        putchar(ch);
    }
    printf("\n");
}
/*#include<stdio.h>
int main()
{
    int f,f1,f2,i;
    f1=0;f2=1;
       printf("%d %d",f1,f2);
       for(i=3;i<=5;i++)
       {
           f=f1+f2;
              printf("%d",f);
              f1=f2;
              f2=f;
       }
    printf("\n");
}*/
/*#include<stdio.h>
int main()
{
    int m,n;
   scanf("%d%d",&m,&n);
   while(m!=n)
   {
       while(m>n)
        m=m-n;
       while(m<n)
        n=n-m;
   }
    printf("%d\n",m);
}*/
/*#include<stdio.h>
int main()
{
    int y=10;
    while(y--);
    printf("y=%d\n",y);
}*/



