#include<stdio.h>
int main()
{
   int isprime(int a);
   int n,s;
   scanf("%d",n);
   s=isprime(n);
   if(s)
   printf("������%d",s);
   else
    printf("��������%d",s);
}
int isprime(int a)
{
    int k=2;
    while(k<a)
    {
        if(a%k==0)
            return 0;
        k++;
    }
    return 1;
}
