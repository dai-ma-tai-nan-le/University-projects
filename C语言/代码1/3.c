#include<stdio.h>
int main()
{
    int i,j;
    for(i=1;i<=9;i++)
    {
        for(j=0;j<i-1;j++)
            printf("    ");
        for(j=i;j<=9;j++)
             printf("%4d",j*i);
         printf("\n");
    }
    printf("\n");
}
