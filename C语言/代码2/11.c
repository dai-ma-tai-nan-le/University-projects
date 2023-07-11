
#include<stdio.h>
#include<stdlib.h>
int main()
{
    struct student
    {
        int num;
        char name[10];
        float score;
        char sex;
    }stu,stu1;
    FILE *fp;
    if((fp=fopen("f2.txt","w"))==NULL)
    {
        printf("can't open this file\n");
        exit(1);
    }
    scanf("%d %s %f %c",&stu.num,stu.name,&stu.score,&stu.sex);
    fprintf(fp,"%d %s %f %c",stu.num,stu.name,stu.score,stu.sex);
    fclose(fp);
     if((fp=fopen("f2.txt","r"))==NULL)
    {
        printf("can't open this file\n");
        exit(1);
    }
    fscanf(fp,"%d %s %f %c",&stu1.num,stu1.name,&stu1.score,&stu1.sex);
    fclose(fp);
    printf("%d %s %.1f %c",stu1.num,stu1.name,stu1.score,stu1.sex);
}



/*#include<stdio.h>
#include<stdlib.h>
int main()
{
    FILE *fp1,*fp2;
    char c;
    if((fp1=fopen("f1.txt","r"))==NULL)
    {
        printf("can't open this file\n");
        exit(1);
    }
    if((fp2=fopen("f2.txt","w"))==NULL)
    {
        printf("can't open this file\n");
        exit(1);
    }
    c=fgetc(fp1);
    while(c!=EOF)
    {
        if(c>'a'&&c<'z')
            c=c-32;
        fputc(c,fp2);
        c=fgetc(fp1);
    }
    fclose(fp1);
    fclose(fp2);
}
*/


