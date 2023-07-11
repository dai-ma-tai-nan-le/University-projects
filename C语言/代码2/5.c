/*#include<stdio.h>
int main()
{
    int a(int x);
    int b(int y);
    int n,x,y;
    int (*p)(int);
    scanf("%d",&n);
    p=a;
    x=(*p)(n);
    p=b;
    y=(*p)(n);
    printf("%d %d",x,y);
}
int a(int x)
{
    int i,sum=0;
    for(i=1;i<=x;i++)
        sum=sum+i;
    return sum;
}
int b(int y)
{
     int i,s=1;
    for(i=1;i<=y;i++)
       s=s*i;
       return s;
}*/
#include <stdio.h>
#include <string.h>
char s[10];
int main()
{
    int x(int a,int b);
    int i;
    int j ;
    gets(s);
    i=strlen(s);
    j=x(0,i-1);
    if(j==1)
    printf("YES\n");
    else printf("NO\n");
}
int x(int a,int b)
{
    if(a==b||b<a)
    return 1;
    else if(s[a]==s[b])
    return x(a+1,b-1);
    else return 0;
}
/*#include <stdio.h>
#include <string.h>
int main()
{
     int b,i,a[10],*p=a;
     for(i=0;i<10;i++)
     scanf("%d",&a[i]);
     scanf("%d",&b);
     for(i=0;;i++)
    {
        if(b==*(p+i))
    {
        printf("%d\n",*(p+i));
        break;
    }
        if(i==9)
    {
         printf("No\n");
        break;
    }
    }
        return 0;
}*/

/*#include <stdio.h>
#include <string.h>
int main()
{
    int scomp(char *s1,char *s2);
    char a[10],b[10]  ;
    gets (a);
    gets (b);
    printf("%d",scomp(a,b));
}
int scomp(char *s1,char *s2)
{
    int i=0;
    while(s1[i]&&s2[i]&&s1[i]==s2[i])
    i++;
    return s1[i]-s2[i];
}*/




























