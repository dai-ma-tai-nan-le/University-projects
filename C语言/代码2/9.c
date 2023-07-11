#include<stdio.h>
int main()
{
    int a[6],*p,i;
    for(p=a;p<a+6;p++)
      scanf("%d",p);
     for(p=a;p<a+3;p++)
      {
          int *t;
          t=*p;
          *p=*(p+6);
          *(p+6)=t;
      }
      for(p=a;p<a+6;p++)
      printf("%d",*p);
}


/*#include<stdio.h>
int main()
{
    char delchar(char *s,int pos);
   char str[]="ABCDEFG",c;
   int n;
    scanf("%d",&n);
    c=delchar(str,n);
    putchar(c);
    printf("\n");
    puts(str);
}
char delchar(char *s,int pos)
{
   int i;
   char ch=s[pos];
   if(pos>strlen(s)||pos<0)
    return 0;
   else
   {
       for(i=pos;s[i]!='\0';i++)
       s[i]=s[i+1];
       return ch;
   }
}*/
