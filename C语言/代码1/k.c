/*#include<stdio.h>
int main()
{
    int a[10=]={1,2,3,4,5,6,7,8,9};
    int i,j,t;
    for(i=0;i<9;i++)
    {
        for(j=0;j<i-1;j++)
        if(a[i]>a[i+1])
        {
            t=a[i],a[i]=a[i+10],a[i+1]=t;
        }
    }
}*/
/*#include<stdio.h>
int main()
{
    int a[10]={1,2,3,4,5,6,7,8,9};
    int i,t;
    for(i=9;i>=0;i--)
    {
       printf("%d",a[i]);
    }
}*/
/*#include<stdio.h>
int main()
{
    int a[10];
    int i,max,j;
    for(i=0;i<=9;i++)
    {
        scanf("%d",&a[i]);
    }
    max=a[0];
    for(i=0;i<=9;i++)
    {
        if(a[i]>max)
            max=a[i];
    }
        printf("%d",a[i]);
}*/
#include<stdio.h>
#include<string.h>
int main()
{
    char m[10];
     char b[3][10];
        int i;
    for(i=0;i<3;i++)
    gets(b[i]);
    if(strcmp(b[0],b[1])>0)
      strcpy(m,b[0]);
    else
     strcpy(m[10],b[1]);
    if(strcmp(m[10],b[2])<0)
      strcpy(m,b[2]);
  printf("%s",m);
}







