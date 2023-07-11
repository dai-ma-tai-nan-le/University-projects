/*#include<stdio.h>
int main()
{
    int a[3][4];
    int i,j,b[i],x=0,max;
    for(i=0;i<3;i++)
    {
    for(j=0;j<4;j++)
       scanf("%d",&a[i][j]);
    }
         for(i=0;i<3;i++)
         {
             for(j=1;j<4;j++)
             {
                 if(a[i][j+1]>a[i][j])
                b[i]=a[i][j+1];
             }
         }
         for(i=0;i<3;i++)
            {
            x=x+b[i];
         printf("%d",b[i]);
         printf("%d",x);
            }
}*/
/*#include<stdio.h>
int main()
{
    char a[5][20];
    int i,j,b[i],x;
    for(i=0;i<5;i++)
   gets(a[i]);
    for(i=0;i<5;i++)
    {
        x=i;
        strcpy(b[i],a[i]);
    for(j=i+1;j<5;j++)
    {
        if(strcmp(a[i],b)<0)
            x=j;
        if(x!=i)
        {
            strcpy(b,a[i]);
            strcpy(a[i],a[x]);
            strcpy(a[x],b);
        }
        puts(a[i]);
        printf("\n");
    }
    }
}*/
/*#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int main()
{
    char str[5][30];
    int i,j;
    for(i=0;i<5;i++) scanf("%s",str[i]);
    for(i=0;i<5;i++)
    for(j=1;j<5-i;j++)
    {
        char temp[30];
        if(strcmp(str[j-1],str[j])>0)
        {
            strcpy(temp,str[j]);
            strcpy(str[j],str[j-1]);
            strcpy(str[j-1],temp);
        }
    }
    for(i=0;i<5;i++) printf("%s\n",str[i]);
}*/
/*#include<stdio.h>
 void main()
 {
     int a[3][4],b[3],i,j,s;
     for ( i=0;i<3;i++ )
        for ( j=0;j<4;j++ )
        scanf("%d",&a[i][j]);
     for ( i=0;i<3;i++ )
        {
            b[i]=a[i][0];
     for ( j=1;j<4;j++ )
        if ( a[i][j]>b[i] )
         b[i]=a[i][j];
     }
     for ( i=0;i<3;i++ )
        printf("%d ",b[i]);
     printf("\n");
     s=b[0]+b[1]+b[2];
     printf("%d ",s);
     }*/
#include<stdio.h>
#define M 30
int main()
{ int s[M],i,k=1;
for(i=0;i<M;i++) {s[i]=k;k+=2;}
printf("\nSequence Output:\n");
for(i=0;i<M;i++)
{ printf("%4d",s[i]);
if((i+1)%10==0) printf("\n");
}
printf("\nInvert Output:\n");
for(i=M-1;i>=0;i--)
printf("%d%c",s[i],(i%10==0)?'\n':' ');
printf("\n");
}




















