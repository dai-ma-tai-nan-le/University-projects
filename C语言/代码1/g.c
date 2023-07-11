/*#include<stdio.h>
int main()
{
    int i,n,sum=0;
    for(i=0,n=1000;i<=n;i++)
    {
        if(i%2!=0) continue;
        else sum=sum+i;
    }
    printf("%d",sum);
    return 0;
}*/
/*#include<stdio.h>
int main()
{
    int i=0,n=1000,sum=0;
    while (i<=n)
    {
        if(i%2==0) sum=sum+i;
        else printf("");
        i++;
    }
     printf("%d",sum);
    return 0;
}*/
/*#include<stdio.h>
int main()
{
    int i=0,n=1000,sum=0;
    do
    {
       if(i%2==0) sum=sum+i;
        else ;
        i++;
    }while(i<=n);
     printf("%d",sum);
    return 0;
}*/
#include<stdio.h>
int main()
{
    int i,n;
    for(i=0,n=1000;i<=n;i++)
    {
        if(i%3==0&&i%10==6)
         printf("%d\n",i);
    }

    return 0;
}

