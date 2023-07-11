        scanf("%d",&peo[i].xuhao);
        scanf("%s",peo[i].name);
        scanf("%c",&peo[i].minzu);
        scanf("%f",&peo[i].shengao);
        scanf("%f",&peo[i].tizhong);
        scanf("%ld",&peo[i].ele);
        scanf("%ld",&peo[i].shenfenzheng);
        scanf("%c",&peo[i].sex);
        scanf("%s",peo[i].address);
        scanf("%ld",&peo[i].qq);

        #include<stdio.h>
#include<stdlib.h>
struct people
{
    int xuhao;
    char name[20];
    char minzu;//以民族首字母表示。
    float shengao;//m
    float tizhong;//kg
    int long ele;
    int long shenfenzheng;
    char sex;//男：L 女：M
    int long qq;
    char buchong[100];
};
void input(struct people *peo,int n);
void output(struct people *peo,int n);
void chaxun(struct people *peo,int n);
void numchaxun(struct people *peo,int n);
void namechaxun(struct people *peo,int n);
void elechaxun(struct people *peo,int n);
void shenfenzhengchaxun(struct people *peo,int n);
int main()
{
    int meau();
    int aj,n;
    int long c,b;
    int x,y=1;
    int long c1=10086,b1=10011;
    struct people peo[100];
    while(y)
    {
            system("cls");
            printf("人物信息管理系统\n");
            printf("输入你的选择\n");
            printf("1.登录\n");
            printf("2.退出\n");
            printf("0.Exit\n");
            scanf("%d",&aj);
        switch(aj)
        {
        case 1:
            printf("输入你的账号和密码:\n");
            scanf("%ld %ld",&c,&b);
    if(c1==c&&b1==b)
    {
         printf("登陆成功\n");
         printf("请输有多少人<100\n");
         scanf("%d",&n);
         while(1)
         {
             system("cls");
             printf("人物信息管理系统\n");
             printf("输入你的选择\n");
             printf("1.输入人物信息\n");
             printf("2.输出人物信息\n");
             printf("3.查询并输出人物信息\n");
             printf("4.删除人物信息\n");
             printf("5.添加人物信息\n");
             printf("6.修改人物信息\n");
             printf("0.Exit\n");
             scanf("%d",&x);
             getchar();
             switch(x)
        {
        case 1:
            input(peo,n);
            break;
        case 2:
            output(peo,n);
            break;
        case 3:

            break;
        case 0:
            printf("end");
            exit(0);
        default :
            printf("error");
        }
         }
    }
        else
        {
            printf("登录失败\n");
            printf("请重新登录\n");
            scanf("%ld %ld",&c,&b);
        }
            break;
        case 2:
            y=0;
            printf("退出成功");
            break;
        case 0:
            printf("end");
            exit(0);
        default :
            printf("error");
        }
    }
}
void input(struct people *peo,int n)
{
     int i;
    printf("请输入序号,名字，民族(首字母),身高(m),体重(kg),电话,身份证,性别,QQ\n");
    for(i=0;i<n;i++)
    {
       scanf("%d %s %c %f %f %ld %ld %c %s",&peo[i].xuhao,peo[i].name,&peo[i].minzu,&peo[i].shengao,&peo[i].tizhong,&peo[i].ele,&peo[i].shenfenzheng,&peo[i].sex,&peo[i].qq);
    }
}
void output(struct people *peo,int n)
{
     int i;
     for(i=0;i<n;i++)
     {
         printf("序号，名字，民族(首字母),身高(m),体重(kg),电话,身份证,性别,QQ,补充\n");
         printf("%d %s %c %.0f %.0f %ld %ld %c %s %ld %s",peo[i].xuhao,peo[i].name,peo[i].minzu,peo[i].shengao,peo[i].tizhong,peo[i].ele,peo[i].shenfenzheng,peo[i].sex,peo[i].qq,peo[i].buchong);
     }
}
void chaxun(struct people *peo,int n)
{
      int a;
    printf("1.按序号查询");
    printf("2.按姓名查询");
    printf("3.按电话查询");
    printf("4.按身份证查询");
    scanf("%d",&a);
    getchar();
    switch(a)
    {
    case 1:
        numchaxun(peo,n);
        break;
    case 2:
        namechaxun(peo,n);
        break;
    case 3:
        elechaxun(peo,n);
        break;
    case 4:
        shenfenzhengchaxun(peo,n);
        break;
    case 0:
        exit(0);
        break;
    default:
        printf("error");
    }

}
void numchaxun(struct people *peo,int n)
{
    int a;
    int i;
    printf("输入查询的序号");
    scanf("%d",&a);
    for(i=0;i<n;i++)
    {
        if(a=peo[i].xuhao)
        {
            printf("%d %s %c %.0f %.0f %ld %ld %c %s %ld %s",peo[i].xuhao,peo[i].name,peo[i].minzu,peo[i].shengao,peo[i].tizhong,peo[i].ele,peo[i].shenfenzheng,peo[i].sex,peo[i].qq,peo[i].buchong);
            break;
            return;
        }
    }
     printf("Not found!\n");
}
void namechaxun(struct people *peo,int n)
{
    char a[20];
    int i;
    printf("输入查询的姓名");
    scanf("%s",a);
    for(i=0;i<n;i++)
    {
        if(peo[i].name=a[20])
        {
           printf("%d %s %c %.0f %.0f %ld %ld %c %s %ld %s",peo[i].xuhao,peo[i].name,peo[i].minzu,peo[i].shengao,peo[i].tizhong,peo[i].ele,peo[i].shenfenzheng,peo[i].sex,peo[i].qq,peo[i].buchong);
            break;
            return;
        }
    }
    printf("Not found!\n");
}
void elechaxun(struct people *peo,int n)
{
    int long a;
    int i;
    printf("输入查询的电话");
    scanf("%ld",&a);
    for(i=0;i<n;i++)
    {
        if(peo[i].ele=a)
        {
           printf("%d %s %c %.0f %.0f %ld %ld %c %s %ld %s",peo[i].xuhao,peo[i].name,peo[i].minzu,peo[i].shengao,peo[i].tizhong,peo[i].ele,peo[i].shenfenzheng,peo[i].sex,peo[i].qq,peo[i].buchong);
            break;
            return;
        }
    }
    printf("Not found!\n");

}
void shenfenzhengchaxun(struct people *peo,int n)
{
     int long a;
    int i;
    printf("输入查询的身份证");
    scanf("%ld",&a);
    for(i=0;i<n;i++)
    {
        if(peo[i].shengfenzheng=a)
        {
           printf("%d %s %c %.0f %.0f %ld %ld %c %s %ld %s",peo[i].xuhao,peo[i].name,peo[i].minzu,peo[i].shengao,peo[i].tizhong,peo[i].ele,peo[i].shenfenzheng,peo[i].sex,peo[i].qq,peo[i].buchong);
            break;
            return;
        }
    }
    printf("Not found!\n");
}











       if((fp=fopen("f1.txt","wb"))==NULL)
    {
        printf("can't open this file\n");
        exit(1);
    }
    printf("注册你的账号和密码:\n");
    scanf("%ld %ld",&(*wj).num,&(*wj).mima);
    fprintf(fp,"%ld %ld",(*wj).num,(*wj).mima);
    fclose(fp);
    if((fp=fopen("f1.txt","rb"))==NULL)
    {
        printf("can't open this file\n");
        exit(1);
    }
    fscanf(fp,"%ld %ld",&(*wj1).num,&(*wj1).mima);
    fclose(fp);
