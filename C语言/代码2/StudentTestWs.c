#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <string.h>
typedef struct student
{
    char name[20];
    long int id;
    int score;
} STU;
STU stu1[100];
int main()
{
    void List();                              //输出列表
    void Input(STU stu[],int *n);             //输入学生数据
    void Sumandave(STU stu[],int n);          //和与平均值
    void Hightolow(STU stu[],int n);          //分数由大到小
    void Smalltolarge(STU stu[],int n);       //学号由小到大
    void Search(STU stu[],int n);             //查找某个学生信息
    void Percentage(STU stu[],int n);         //所占人数和百分比
    void Outputinformation(STU stu[],int n);  //输出所以学生信息
    int n=0;
    while(1)
    {
        system("cls");        //清屏
        List();               //输出列表
        char c=getch();       //头文件conio,按下某个字符时，函数自动读取，无需按回车.
        switch(c)
        {
        case '1':
            Input(&stu1,&n);
            break;
        case '2':
            Sumandave(&stu1,n);
            break;
        case '3':
            Hightolow(&stu1,n);
            break;
        case '4':
            Smalltolarge(stu1,n);
            break;
        case '5':
            Search(stu1,n);
            break;
        case '6':
            Percentage(&stu1,n);
            break;
        case '7':
            Outputinformation(&stu1,n);
            break;
        case '0':
            exit(0);
            break;                     //exit(0)退出程序
        }
    }

    return 0;
}

//输出列表
void List()
{
    printf("*****************************************************************\t\t\t\n");
    printf("*\t\t欢迎使用高校学生成绩管理系统ws版\t\t*\n");
    printf("*\t\t\t  请选择功能\t\t\t\t*\n");
    printf("*****************************************************************\t\t\t\n");
    printf("*\t  1.Input record\t\t\t\t\t*\n");
    printf("*\t  2.Caculate total and average socre of course\t\t*\n");
    printf("*\t  3.Sort in descending older by score\t\t\t*\n");
    printf("*\t  4.Sort in ascending older by number\t\t\t*\n");
    printf("*\t  5.Search by number\t\t\t\t\t*\n");
    printf("*\t  6.Statistic analysis\t\t\t\t\t*\n");
    printf("*\t  7.List record\t\t\t\t\t\t*\n");
    printf("*\t  0.Exit\t\t\t\t\t\t*\n");
    printf("*****************************************************************\t\t\t\n");
}

//输入n个学生信息
void Input(STU stu[],int *n)        //取n地址，及时更新人数数量，以便更新数据
{
    int m;
    static int i=0;
    printf("请输入要录入的学生人数：");
    scanf("%d",&m);
    for(; i<m+*n; i++)
    {
        printf("请输入学生姓名:");
        scanf("%s",stu[i].name);
        printf("请输入学生学号：");
        scanf("%ld",&stu[i].id);
        printf("请输入学生分数：");
        scanf("%d",&stu[i].score);
        printf("***********************\n");
    }
    *n+=m;
    printf("学生信息录入成功！！！\n");
    system("pause");
}

//计算总分和平均分
void Sumandave(STU stu[],int n)
{
    int i,sum=0;
    float ave;
    for(i=0; stu[i].score; i++)
    {
        sum+=stu[i].score;
    }
    ave=(float)sum/n;
    printf("%d名同学的sum:%d\n",i,sum);
    printf("%d名同学的ave:%.2f\n",i,ave);
    system("pause");
}

//分数由高到低排序
void Hightolow(STU stu[],int n)
{
    char x[100];
    int i,j;
    long int t;
    for(i=0; i<n-1; i++)
    {
        for(j=i; j<n; j++)
        {
            if(stu[i].score<stu[j].score)
            {
                t=stu[i].score;
                stu[i].score=stu[j].score;
                stu[j].score=t;
                t=stu[i].id;
                stu[i].id=stu[j].id;
                stu[j].id=t;
                strcpy(x,stu[i].name);
                strcpy(stu[i].name,stu[j].name);
                strcpy(stu[j].name,x);
            }
        }
    }
    printf("%d名同学分数由高到低：\n",n);
    printf("姓名：");
    for(int p=0; p<n; p++)
    {
        printf("%10s",stu[p].name);
    }
    printf("\n");
    printf("分数：");
    for(int p=0; p<n; p++)
    {
        printf("%10d",stu[p].score);
    }
    printf("\n");
    printf("学号：");
    for(int p=0; p<n; p++)
    {
        printf("%10ld",stu[p].id);
    }
    printf("\n");
    system("pause");
}

//学号由小到大排序
void Smalltolarge(STU stu[],int n)
{
    char x[100];
    int i,j;
    long int t;
    for(i=0; i<n-1; i++)
    {
        for(j=i; j<n; j++)
        {
            if(stu[i].id>stu[j].id)
            {
                t=stu[i].score;
                stu[i].score=stu[j].score;
                stu[j].score=t;
                t=stu[i].id;
                stu[i].id=stu[j].id;
                stu[j].id=t;
                strcpy(x,stu[i].name);
                strcpy(stu[i].name,stu[j].name);
                strcpy(stu[j].name,x);
            }
        }
    }
    printf("%d名同学学号由低到高：\n",n);
    printf("姓名：");
    for(int p=0; p<n; p++)
    {
        printf("%10s",stu[p].name);
    }
    printf("\n");
    printf("分数：");
    for(int p=0; p<n; p++)
    {
        printf("%10d",stu[p].score);
    }
    printf("\n");
    printf("学号：");
    for(int p=0; p<n; p++)
    {
        printf("%10ld",stu[p].id);
    }
    printf("\n");
    system("pause");
}

//输入学号查找学生输出对应信息
void Search(STU stu[],int n)
{
    int i;
    long int p;
    printf("请输入要查找的学生学号：");
    scanf("%ld",&p);
    for(i=0; i<n; i++)
    {
        if(p==stu[i].id)
        {
            printf("该学生姓名：%s\n",stu[i].name);
            printf("该学生学号：%d\n",stu[i].id);
            printf("该学生成绩：%d",stu[i].score);
            break;
        }
    }
    if(i==n)
        printf("Not found!\n");
    printf("\n");
    system("\npause");
}

//每级别人数所占百分比
void Percentage(STU stu[],int n)
{
    int m;
    static int a[5]= {0},i=0;
    float b[i];
    for(; i<n; i++)           //找各级别所占人数
    {
        m=stu[i].score;
        m/=10;
        switch(m)              //计算各级别人数
        {
        case 10:
        case  9:
            a[4]++;
            break;
        case  8:
            a[3]++;
            break;
        case  7:
            a[2]++;
            break;
        case  6:
            a[1]++;
            break;
        default:
            a[0]++;
            break;
        }
    }
    printf("总人数为:%d人\n",n);                          //各级别人数百分比
    printf("优秀人数为%d人。所占百分比为：%.2f%%\n",a[4],(float)100*a[4]/n);
    printf("良好人数为%d人。所占百分比为：%.2f%%\n",a[3],(float)100*a[3]/n);
    printf("中等人数为%d人。所占百分比为：%.2f%%\n",a[2],(float)100*a[2]/n);
    printf("及格人数为%d人。所占百分比为：%.2f%%\n",a[1],(float)100*a[1]/n);
    printf("不及格人数为%d人。所占百分比为：%.2f%%\n",a[0],(float)100*a[0]/n);  //%%打出%
    system("pause");
}


//输出每个学生学号和成绩
void Outputinformation(STU stu[],int n)
{
    int i;
    for(i=0; i<n; i++)                 //输出n个学号和分数
    {
        printf("\n学生姓名：%s\n学号：%ld\n分数：%d\n****************",stu[i].name,stu[i].id,stu[i].score);
    }
    printf("\n");
    system("pause");
}

