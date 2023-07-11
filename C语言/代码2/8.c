/*#include  <stdio.h>
struct student
{
    int num;
    float score;
};
int main()
{
    void input (struct student *stu1,int n);
   void x(struct student *stu2,int n);
    void y(struct student *stu3,int n);
    void z(struct student *stu4,int n);
    void a(struct student *stu5,int n);
    void b(struct student *stu6,int n);
    void output(struct student *stu7,int n);
  int n;
  printf("Input student number(n<30):\n");
  scanf("%d",&n);
  struct student stu[n];
  input(stu,n);
  x(stu,n);
  y(stu,n);
  z(stu,n);
  a(stu,n);
  b(stu,n);
  output(stu,n);
}
void input (struct student *stu1,int n)
{
    int i;
    for(i=0;i<n;i++)
          scanf("%1d %f",&stu1[i].num,&stu1[i].score);
}
void x(struct student *stu2,int n)
{
    int i;
    float sum=0;
     for(i=0;i<n;i++)
        sum=sum+stu2[i].score;
    printf("sum=%.0f,aver=%.2f\n",sum,sum/n);
}
void y(struct student *stu3,int n)
{
    int i,j,t,k;
    for(j=1;j<n;j++)
        for(i=0;i<n-j;i++)
            if(stu3[i+1].score>stu3[i].score)
    {
        t=stu3[i].score;
         k=stu3[i].num;
         stu3[i].num=stu3[i+1].num;
         stu3[i].score=stu3[i+1].score;
         stu3[i+1].score=t;
         stu3[i+1].num=k;
    }
    printf("Sort in descending order by score:\n");
      for(i=0;i<n;i++)
       printf("成绩%d名%1d %f\n",i+1, stu3[i].num,stu3[i].score);
}
void z(struct student *stu4,int n)
{
    int i,j,t,k;
    for(j=1;j<n;j++)
        for(i=0;i<n-j;i++)
            if(stu4[i+1].num>stu4[i].num)
    {
        t=stu4[i].score;
         k=stu4[i].num;
         stu4[i].num=stu4[i+1].num;
         stu4[i].score=stu4[i+1].score;
         stu4[i+1].score=t;
         stu4[i+1].num=k;
    }
     printf("Sort in ascending order by number:\n");
      for(i=0;i<n;i++)
       printf("学号%d名%1d %f\n",i+1, stu4[i].num,stu4[i].score);
}
void a(struct student *stu5,int n)
{
        int i,j,t,k,x;
    for(j=1;j<n;j++)
        for(i=0;i<n-j;i++)
            if(stu5[i+1].score>stu5[i].score)
    {
        t=stu5[i].score;
         k=stu5[i].num;
         stu5[i].num=stu5[i+1].num;
         stu5[i].score=stu5[i+1].score;
         stu5[i+1].score=t;
         stu5[i+1].num=k;
    }
    scanf("%d",&x);
      for(i=0;i<n;i++)
      {
       if(stu5[i].num==x)
       printf("学号%d名%1d %f\n",i+1, stu5[i].num,stu5[i].score);
       else  printf("Not found!\n");
}
 void b(struct student *stu6,int n)
{
    int A=0,B=0,C=0,D=0,E=0;
    for(i=0;i<n;i++)
    {
        switch ((int)stu6[i].score/10)
        {
        case 10:
        case 9:A=A+1;break;
        case 8:B=B+1;break;
        case 7:C=C+1;break;
        case 6:D=D+1;break;
        default:E=E+1;break;
    }
     printf("优秀的人数%d,优秀率%d\n",A,(100*A)/n);
    printf("良好的人数%d,良好率%d\n",B,(100*B)/n);
    printf("中等的人数%d,中等率%d\n",C,(100*C)/n);
    printf("及格的人数%d,及格率%d\n",D,(100*D)/n);
   output(struct student *stu7,int n)
{
   int i;
    for(i=0;i<n;i++)
       printf("学号%1d 成绩%f\n",stu7[i].num,stu7[i].score);
}
  printf("不及格的人数%d,不及格率%d\n",E,(100*E)/n);
}
void output(struct student *stu7,int n)
{
   int i;
    for(i=0;i<n;i++)
       printf("学号%1d 成绩%f\n",stu7[i].num,stu7[i].score);
}*/







/*#include  <stdio.h>
struct student
{
    long num;
    float score;
};
int main()
{
    void input (struct student *stu1,int n);
    void x(struct student *stu2,int n);
    void y(struct student *stu3,int n);
    void z(struct student *stu4,int n);
    void a(struct student *stu5,int n);
    void b(struct student *stu6,int n);
    void output(struct student *stu7,int n);
    int n;
    printf("Input student number(n<30):\n");
    scanf("%d",&n);
    struct student stu[n];
    input(stu,n);
    x(stu,n);
    y(stu,n);
    z(stu,n);
    a(stu,n);
    b(stu,n);
    output(stu,n);
}
void input (struct student *stu1,int n)
{
    printf("Input student's ID and score:\n");
   long i;
    for(i=0;i<n;i++)
          scanf("%1d %f",&stu1[i].num,&stu1[i].score);
}
void x(struct student *stu2,int n)
{
    int i;
    float sum=0;
     for(i=0;i<n;i++)
        sum=sum+stu2[i].score;
    printf("sum=%f,aver=%f\n",sum,sum/n);
}
void y(struct student *stu3,int n)
{
    int i,j;
    long k;
    float t;
    for(j=1;j<n;j++)
        for(i=0;i<n-j;i++)
            if(stu3[i+1].score>stu3[i].score)
    {
        t=stu3[i].score;
         k=stu3[i].num;
         stu3[i].num=stu3[i+1].num;
         stu3[i].score=stu3[i+1].score;
         stu3[i+1].score=t;
         stu3[i+1].num=k;
    }
    printf("Sort in descending order by score:\n");
      for(i=0;i<n;i++)
       printf("成绩%d名%1d %f\n",i+1, stu3[i].num,stu3[i].score);
}
void z(struct student *stu4,int n)
{
    int i,j;
    long k;
    float t;
    for(j=1;j<n;j++)
        for(i=0;i<n-j;i++)
            if(stu4[i+1].num>stu4[i].num)
    {
        t=stu4[i].score;
         k=stu4[i].num;
         stu4[i].num=stu4[i+1].num;
         stu4[i].score=stu4[i+1].score;
         stu4[i+1].score=t;
         stu4[i+1].num=k;
    }
     printf("Sort in ascending order by number:\n");
      for(i=0;i<n;i++)
       printf("学号%d名%1d %f\n",i+1, stu4[i].num,stu4[i].score);
}
void a(struct student *stu5,int n)
{
        int i,j;
        long k,x;
      float t;
    for(j=1;j<n;j++)
        for(i=0;i<n-j;i++)
            if(stu5[i+1].score>stu5[i].score)
    {
        t=stu5[i].score;
         k=stu5[i].num;
         stu5[i].num=stu5[i+1].num;
         stu5[i].score=stu5[i+1].score;
         stu5[i+1].score=t;
         stu5[i+1].num=k;
    }
    scanf("%d",&x);
      for(i=0;i<n;i++)
      {
       if(stu5[i].num==x)
       printf("学号%d名%1d %f\n",i+1, stu5[i].num,stu5[i].score);
       else  printf("Not found!\n");
    }
}
 void b(struct student *stu6,int n)
{
    int i;
    int A=0,B=0,C=0,D=0,E=0;
    for(i=0;i<n;i++)
    {
        switch ((int)stu6[i].score/10)
        {
        case 10:
        case 9:A=A+1;break;
        case 8:B=B+1;break;
        case 7:C=C+1;break;
        case 6:D=D+1;break;
        default:E=E+1;break;
        }
    printf("优秀的人数%d,优秀率%d\n",A,(100*A)/n);
    printf("良好的人数%d,良好率%d\n",B,(100*B)/n);
    printf("中等的人数%d,中等率%d\n",C,(100*C)/n);
    printf("及格的人数%d,及格率%d\n",D,(100*D)/n);
    }
}
void output(struct student *stu7,int n)
{
   int i;
    for(i=0;i<n;i++)
       printf("学号%1d 成绩%f\n",stu7[i].num,stu7[i].score);
}*/






/*#include  <stdio.h>
struct student
{
    long num;
    float score;
};
int main()
{
    void input (struct student *stu1,int n);
    void x(struct student *stu2,int n);
    void y(struct student *stu3,int n);
    void z(struct student *stu4,int n);
    void a(struct student *stu5,int n);
    void b(struct student *stu6,int n);
    void output(struct student *stu7,int n);
    int n;
    printf("Input student number(n<30):\n");
    scanf("%d",&n);
    struct student stu[n];
    input(stu,n);
    x(stu,n);
    y(stu,n);
    z(stu,n);
    a(stu,n);
    b(stu,n);
    output(stu,n);
}
void input (struct student *stu1,int n)
{
    printf("Input student's ID and score:\n");
    int i;
    for(i=0;i<n;i++)
          scanf("%1d,%f",&stu1[i].num,&stu1[i].score);
}
void x(struct student *stu2,int n)
{
   void input (struct student *stu1,int n);
   input(stu2,n);
    int i;
    float sum=0;
     for(i=0;i<n;i++)
        sum=sum+stu2[i].score;
    printf("sum=%.0f,aver=%.2f\n",sum,sum/n);
}
void y(struct student *stu3,int n)
{
    int i,j,t,k;
    for(j=1;j<n;j++)
        for(i=0;i<n-j;i++)
            if(stu3[i+1].score>stu3[i].score)
    {
        t=stu3[i].score;
         k=stu3[i].num;
         stu3[i].num=stu3[i+1].num;
         stu3[i].score=stu3[i+1].score;
         stu3[i+1].score=t;
         stu3[i+1].num=k;
    }
    printf("Sort in descending order by score:\n");
      for(i=0;i<n;i++)
       printf("成绩%d名%1d %f\n",i+1, stu3[i].num,stu3[i].score);
}
void z(struct student *stu4,int n)
{
    int i,j,t,k;
    for(j=1;j<n;j++)
        for(i=0;i<n-j;i++)
            if(stu4[i+1].num>stu4[i].num)
    {
        t=stu4[i].score;
         k=stu4[i].num;
         stu4[i].num=stu4[i+1].num;
         stu4[i].score=stu4[i+1].score;
         stu4[i+1].score=t;
         stu4[i+1].num=k;
    }
     printf("Sort in ascending order by number:\n");
      for(i=0;i<n;i++)
       printf("学号%d名%1d %f\n",i+1, stu4[i].num,stu4[i].score);
}
void a(struct student *stu5,int n)
{
     void input (struct student *stu1,int n);
   input(stu5,n);
        int i,j,t,k,x;
    for(j=1;j<n;j++)
        for(i=0;i<n-j;i++)
            if(stu5[i+1].score>stu5[i].score)
    {
        t=stu5[i].score;
         k=stu5[i].num;
         stu5[i].num=stu5[i+1].num;
         stu5[i].score=stu5[i+1].score;
         stu5[i+1].score=t;
         stu5[i+1].num=k;
    }
    scanf("%d",&x);
      for(i=0;i<n;i++)
      {
       if(stu5[i].num==x)
       printf("学号%d名%1d %f\n",i+1, stu5[i].num,stu5[i].score);
       else  printf("Not found!\n");
    }
}
 void b(struct student *stu6,int n)
{
    int i;
    int A=0,B=0,C=0,D=0,E=0;
    for(i=0;i<n;i++)
    {
        switch ((int)stu6[i].score/10)
        {
        case 10:
        case 9:A=A+1;break;
        case 8:B=B+1;break;
        case 7:C=C+1;break;
        case 6:D=D+1;break;
        default:E=E+1;break;
        }
    printf("优秀的人数%d,优秀率%d\n",A,(100*A)/n);
    printf("良好的人数%d,良好率%d\n",B,(100*B)/n);
    printf("中等的人数%d,中等率%d\n",C,(100*C)/n);
    printf("及格的人数%d,及格率%d\n",D,(100*D)/n);
    }
}
void output(struct student *stu7,int n)
{
   int i;
    for(i=0;i<n;i++)
       printf("学号%1d 成绩%f\n",stu7[i].num,stu7[i].score);
}*/



#include  <stdio.h>
#include  <stdlib.h>
struct student
{
    long int num;
    float score;
};
int main()
{
    int meun();
    void input (struct student *stu,int n);
    void x(struct student *stu,int n);
    void y(struct student *stu,int n);
    void z(struct student *stu,int n);
    void a(struct student *stu,int n);
    void b(struct student *stu,int n);
    void output(struct student *stu,int n);
    int n,aj;
    struct student stu[30];
    printf("Input student number(n<30):\n");
    scanf("%d",&n);
    while(1)
    {
        aj=meun();
        switch(aj)
    {
    case 1:input(stu,n);break;
    case 2:x(stu,n);break;
    case 3:y(stu,n);
           printf("Sort in descending order by score:\n");
           output(stu,n);break;
    case 4:z(stu,n);
           printf("Sort in ascending order by number:\n");
           output(stu,n);break;
    case 5:a(stu,n);break;
    case 6:b(stu,n);break;
    case 7:output(stu,n);break;
    case 0:printf("end");exit(0);
    default :printf("error");
    }
    }
}
int meun()
{
    int it;
    printf("Management for Students' scores\n");
    printf("1.Input record\n");
    printf("2.Calculate total and average score of course\n");
    printf("3.Sort in descending order by score\n");
    printf("4.Sort in ascending order by number\n");
    printf("5.Search by number\n");
    printf("6.Statistic analysis\n");
    printf("7.List record\n");
    printf("0.Exit\n");
    printf("Please Input your choice:\n");
    scanf("%d",&it);
    return it;
}
void input (struct student *stu,int n)
{
    printf("Input student's ID and score:\n");
  int i;
    for(i=0;i<n;i++)
          scanf("%ld %f",&stu[i].num,&stu[i].score);
}
void x(struct student *stu,int n)
{
    int i;
    float sum=0;
     for(i=0;i<n;i++)
        sum=sum+stu[i].score;
    printf("sum=%.0f,aver=%.2f\n",sum,n>0?sum/n:0);
}
void y(struct student *stu,int n)
{
    int i,j,max;
   struct student t;
   for(i=0;i<n-1;i++)
   {
       max=i;
       for(j=i+1;j<n;j++)
       {
             if(stu[j].score>stu[max].score);
             max=j;
       }
   if(max!=i)
    {
        t=stu[max];
         stu[max]=stu[i];
         stu[i]=t;
    }
    }
}
void z(struct student *stu,int n)
{
    int i,j;
  struct student t;
    for(i=n-1;i>0;i--)
    {
        for(j=0;j<i;j++)
        {
            if(stu[j+1].num<stu[j].num)
    {
        t=stu[i];
         stu[i]=stu[i+1];
         stu[i+1]=t;
    }
        }
    }
}
void a(struct student *stu,int n)
{
        long num;
        int i;
        printf("input you search\n");
        scanf("%d",&num);
        for(i=0;i<n;i++)
        {
           if(stu[i].num==num)
           {
             printf("%ld\t%.0f\n",stu[i].num,stu[i].score);
             break;
             return;
           }
        }
        printf("Not found!\n");
}
 void b(struct student *stu,int n)
{
    int i,t[6]={0};
    for(i=0;i<n;i++)
    {
        switch ((int)stu[i].score/10)
        {
        case 10:t[0]++;
        case 9:t[1]++;
        case 8:t[2]++;
        case 7:t[3]++;
        case 6:t[4]++;
        case 5:
        case 4:
        case 3:
        case 2:
        case 1:
        case 0:t[5]++;
        default:printf("error");
        }
      for(i=0;i<6;i++)
      {
          if(i==0) printf("%d\t%d\t%.2f%%\n",100,t[i],(float)t[i]/n*100);
          else if(i==5) printf("<60\t%d\t%.2f%%\n",t[i],(float)t[i]/n*100);
          else   printf("%d-%d\t%d\t%.2f%%\n",(10-i)*10,(10-i)*10+9,t[i],(float)t[i]/n*100);
      }
    }
}
void output(struct student *stu,int n)
{
     int i;
    for(i=0;i<n;i++)
    printf("%ld%\t%.0f\n",stu[i].num,stu[i].score);
}











