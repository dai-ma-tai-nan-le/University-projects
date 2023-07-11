#include<stdio.h>
#define PI 3.14
int main()
{
    float r,s;
    scanf("%f",&r);
    s=PI*r*r;
    printf("%f",s);
    return 0;
}
/*#include<stdio.h>
int main()
{
    int year,month;
    scanf("%d%d",&year,&month);
    switch (month)
      {
          case 1:
          case 3:
          case 5:
          case 7:
          case 8:
          case 12:
          case 10:printf("month=31");break;
          case 2:if(year%400==0)
          printf("month=29");
          else
            printf("month=28");break;
          case 4:
          case 6:
          case 9:
          case 11:printf("month=30");break;
          default:printf("error");
      }
     return 0;
}*/




