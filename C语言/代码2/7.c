/*#include<stdio.h>
int main()
{
    int *x(int *p,int n);
    int a[20],*p;
     int i,n;
     scanf("%d",&n);
     for(i=0;i<n;i++)
        scanf("%d",&a[i]);
      p=a;
     x(a,n);
     for(i=0;i<n;i++)
    printf("%d",a[i]);
}
int *x(int *p,int n)
{
    int i,j;
    for(i=0;i<n;i++)
    {
        if(*(p+i)==0)
           {for(j=i;j<n-1;j++)
              *(p+j)=*(p+j+1);
              *(p+n-1)=0;
              n--;
           }
    }
}*/
#include<stdio.h>
#include <string.h>
int main()
{
     int fun(char *p[4],int n);
    char a[4][10];
    int i;
    for(i=0;i<4;i++)
     scanf("%s",a[i]);
    int *p[4]={a[0],a[1],a[2],a[3]};
    fun(p,4);
    for(i=0;i<4;i++)
    printf("%3s\n",p[i]);
}
 int fun(char *p[4],int n)
 {
     char *t;
	int i,j;
	for(i=0;i<3;i++)
	{
		for(j=i+1;j<4;j++)
		{
			if(strcmp(p[i],p[j])==1)
			{
				t=p[i];
				p[i]=p[j];
				p[j]=t;
			}
		}
	}
}



















