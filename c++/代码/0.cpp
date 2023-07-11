#include<iostream>
using namespace std;
#include<new>
class Birthday
{
private:
    int year,month,day;
    char *name;
public:
    Birthday(int a=2000,int b=2,int c=4,char *p="li")
    {
        year=a;
        month=b;
        day=c;
        name==new char[20];
        name=p;
    }
    Birthday(const Birthday &b)
    {
        year=b.year;
        month=b.month;
        day=b.day;
        name=new char[20];//∑÷≈‰∂—ø’º‰
        *name=*(b.name);
    }
    ~Birthday()
    {
        cout<<year<<"Œˆππ"<<endl;
    }
    void change(int a,int b=2,int c=4,char *p="li")
    {
        year=a;
        month=b;
        day=c;
        name=p;
    }
    void printf()
    {
        cout<<name<<":"<<endl;
        cout<<year<<"-"<<month<<"-"<<day<<endl;
    }
};
main()
{
    Birthday a;
    Birthday b(a);
    b.change(0000);
    a.printf();
    b.printf();
}









/*#include<iostream>
#include<string>
using namespace std;
class Student
{
private:
    int num;
    string name;
    float score[3];
public:
    Student(int a,char *b,int c,int d,int e)
    {
        int i;
        num=a;
        name=b;
        score[0]=c;
        score[1]=d;
        score[2]=e;
    }
    float average()
    {
        return (score[0]+score[1]+score[2])/3;
    }
};
main()
{    Student s[2]={Student(10011,"wang",60,75,92),Student(10086,"li",82,75,90)};
    cout<<"average"<<endl;
    cout<<s[0].average()<<endl;
    cout<<s[1].average()<<endl;
}


*/















