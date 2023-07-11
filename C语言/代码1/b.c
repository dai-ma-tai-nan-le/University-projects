#include<math.h>
int main()
{
    float a,b,c,x1,x2;
    scanf("%f,%f,%f",&a,&b,&c);
    x1=(-b+aqrt(b*b-4*a*c))/2/a;
    x2=(-b-aqrt(b*b-4*a*c))/2/a;
    printf("%f,%f",x1,x2);
    return 0;
}
