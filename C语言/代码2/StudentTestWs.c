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
    void List();                              //����б�
    void Input(STU stu[],int *n);             //����ѧ������
    void Sumandave(STU stu[],int n);          //����ƽ��ֵ
    void Hightolow(STU stu[],int n);          //�����ɴ�С
    void Smalltolarge(STU stu[],int n);       //ѧ����С����
    void Search(STU stu[],int n);             //����ĳ��ѧ����Ϣ
    void Percentage(STU stu[],int n);         //��ռ�����Ͱٷֱ�
    void Outputinformation(STU stu[],int n);  //�������ѧ����Ϣ
    int n=0;
    while(1)
    {
        system("cls");        //����
        List();               //����б�
        char c=getch();       //ͷ�ļ�conio,����ĳ���ַ�ʱ�������Զ���ȡ�����谴�س�.
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
            break;                     //exit(0)�˳�����
        }
    }

    return 0;
}

//����б�
void List()
{
    printf("*****************************************************************\t\t\t\n");
    printf("*\t\t��ӭʹ�ø�Уѧ���ɼ�����ϵͳws��\t\t*\n");
    printf("*\t\t\t  ��ѡ����\t\t\t\t*\n");
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

//����n��ѧ����Ϣ
void Input(STU stu[],int *n)        //ȡn��ַ����ʱ���������������Ա��������
{
    int m;
    static int i=0;
    printf("������Ҫ¼���ѧ��������");
    scanf("%d",&m);
    for(; i<m+*n; i++)
    {
        printf("������ѧ������:");
        scanf("%s",stu[i].name);
        printf("������ѧ��ѧ�ţ�");
        scanf("%ld",&stu[i].id);
        printf("������ѧ��������");
        scanf("%d",&stu[i].score);
        printf("***********************\n");
    }
    *n+=m;
    printf("ѧ����Ϣ¼��ɹ�������\n");
    system("pause");
}

//�����ֺܷ�ƽ����
void Sumandave(STU stu[],int n)
{
    int i,sum=0;
    float ave;
    for(i=0; stu[i].score; i++)
    {
        sum+=stu[i].score;
    }
    ave=(float)sum/n;
    printf("%d��ͬѧ��sum:%d\n",i,sum);
    printf("%d��ͬѧ��ave:%.2f\n",i,ave);
    system("pause");
}

//�����ɸߵ�������
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
    printf("%d��ͬѧ�����ɸߵ��ͣ�\n",n);
    printf("������");
    for(int p=0; p<n; p++)
    {
        printf("%10s",stu[p].name);
    }
    printf("\n");
    printf("������");
    for(int p=0; p<n; p++)
    {
        printf("%10d",stu[p].score);
    }
    printf("\n");
    printf("ѧ�ţ�");
    for(int p=0; p<n; p++)
    {
        printf("%10ld",stu[p].id);
    }
    printf("\n");
    system("pause");
}

//ѧ����С��������
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
    printf("%d��ͬѧѧ���ɵ͵��ߣ�\n",n);
    printf("������");
    for(int p=0; p<n; p++)
    {
        printf("%10s",stu[p].name);
    }
    printf("\n");
    printf("������");
    for(int p=0; p<n; p++)
    {
        printf("%10d",stu[p].score);
    }
    printf("\n");
    printf("ѧ�ţ�");
    for(int p=0; p<n; p++)
    {
        printf("%10ld",stu[p].id);
    }
    printf("\n");
    system("pause");
}

//����ѧ�Ų���ѧ�������Ӧ��Ϣ
void Search(STU stu[],int n)
{
    int i;
    long int p;
    printf("������Ҫ���ҵ�ѧ��ѧ�ţ�");
    scanf("%ld",&p);
    for(i=0; i<n; i++)
    {
        if(p==stu[i].id)
        {
            printf("��ѧ��������%s\n",stu[i].name);
            printf("��ѧ��ѧ�ţ�%d\n",stu[i].id);
            printf("��ѧ���ɼ���%d",stu[i].score);
            break;
        }
    }
    if(i==n)
        printf("Not found!\n");
    printf("\n");
    system("\npause");
}

//ÿ����������ռ�ٷֱ�
void Percentage(STU stu[],int n)
{
    int m;
    static int a[5]= {0},i=0;
    float b[i];
    for(; i<n; i++)           //�Ҹ�������ռ����
    {
        m=stu[i].score;
        m/=10;
        switch(m)              //�������������
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
    printf("������Ϊ:%d��\n",n);                          //�����������ٷֱ�
    printf("��������Ϊ%d�ˡ���ռ�ٷֱ�Ϊ��%.2f%%\n",a[4],(float)100*a[4]/n);
    printf("��������Ϊ%d�ˡ���ռ�ٷֱ�Ϊ��%.2f%%\n",a[3],(float)100*a[3]/n);
    printf("�е�����Ϊ%d�ˡ���ռ�ٷֱ�Ϊ��%.2f%%\n",a[2],(float)100*a[2]/n);
    printf("��������Ϊ%d�ˡ���ռ�ٷֱ�Ϊ��%.2f%%\n",a[1],(float)100*a[1]/n);
    printf("����������Ϊ%d�ˡ���ռ�ٷֱ�Ϊ��%.2f%%\n",a[0],(float)100*a[0]/n);  //%%���%
    system("pause");
}


//���ÿ��ѧ��ѧ�źͳɼ�
void Outputinformation(STU stu[],int n)
{
    int i;
    for(i=0; i<n; i++)                 //���n��ѧ�źͷ���
    {
        printf("\nѧ��������%s\nѧ�ţ�%ld\n������%d\n****************",stu[i].name,stu[i].id,stu[i].score);
    }
    printf("\n");
    system("pause");
}

