#include<stdio.h>
int main()
{
    int a,n,x=0;
    scanf("%d%d",&a,&n);
    while(a<=n)
    {
        x=x*10+a;
        n=n+x;
        a++;
    }
    printf("%d",n);
    return 0;
}

/*#include<stdio.h>
int main()
{
    char c;
    c=getchar();
    while(c!='?')
    {
        putchar(c);
        c=getchar();
    }
    return 0;
}*/
