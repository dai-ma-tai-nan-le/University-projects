/*#include<stdio.h>
int main()
{
    int a[10];
    int i;
    for(i=0;i<=9;i++)
      scanf("%d",&a[i]);
    for(i=9;i>=0;i--)
    {
        printf("%d\n",a[i]);
    }
}*/
/*#include<stdio.h>
int main()
{
    int a[20];
    int i,y=0,s=0;
    for(i=0;i<=19;i++)
      scanf("%d",&a[i]);
    for(i=0;i<=19;i++)
    {
       if(a[i]<0)
       {
           y=y+1;
           s=s+a[i];
       }

    }
     printf("%d\n%d",y,s);
}*/
/*#include<stdio.h>
int main()
{
    int a[5][5];
    int i,j,s=0,y=0,x=0,sum=0;
    for(i=0;i<5;i++)
    for(j=0;j<5;j++)
    {
       scanf("%d",&a[i][j]);
    }
    printf("每一行之和");
     for(i=0;i<5;i++)
    {s=0;
    for(j=0;j<5;j++)
    {
        s=s+a[i][j];
    }
     printf("%4d",s);
    }
     printf("每一列之和");
      for(j=0;j<5;j++)
      {y=0;
        for(i=0;i<5;i++)
        {
            y=y+a[j][i];
        }
         printf("%4d",y);
      }
     printf("对角线之和");
     for(i=0;i<5;i++)
     {x=0;
         for(j=0;j<5;j++)
         {
             if(i==j||i+j==4)
             {
                x=x+a[i][j];
             }
         }
         printf("%4d",x);
     }
   printf("两条对角线上行、列下标均为偶数的各元素之和");
        for(i=0;i<5;i++)
     {sum=0;
         for(j=0;j<5;j++)
         {
             if(i==j||i==5-1-j)
                sum=sum+a[i][j];
         }
         printf("%4d",sum);
     }
}*/
#include<stdio.h>
int main()
{
    int a[10];
    int i,t,max,min;
    for(i=0;i<=9;i++)
      scanf("%d",&a[i]);
    min=max=a[0];
    for(i=0;i<=9;i++)
    {
     if(a[i]>max)
        max=a[i];
    if(a[i]<min)
        min=a[i];
      t=min;
      min=max;
      max=t;
    }
    for(i=0;i<=9;i++)
        printf("%4d",a[i]);
}
