/*#include<iostream>
using namespace std;
class Teacher
{
protected:
    string name;
    int age;
    string sex;
    string address;
    int tele;
    string title;
public:
    Teacher(string a="zhang", int b=20, string c="male", string d="Build 305-503", int e= 6081202, string f="tutor")
	{
		name=a;
        age=b;
        sex=c;
        address=d;
        tele=e;
        title=f;
	}
    void display()
    {
		cout<<"姓名："<<name<<" "<<"年龄："<<age<<" "<<"性别："<<sex<<"地址："<<address<<" "<<"电话："<<tele<<" "<<"职称："<<title<<endl;
	}
};
class Cadre
{
protected:
    string name;
    int age;
    string sex;
    string address;
    int tele;
   string post;
public:
    Cadre(string a = "zhang", int b = 20, string c = "male", string d = "Build 305-503", int e = 6081202,string f = "associate professor")
	{
		name=a;
		 age=b;
		 sex=c;
		 address=d;
		 tele=e;
		 post=f;
	}
    void display()
    {
        cout<<"姓名："<<name<<" "<<"年龄："<<age<<" "<<"性别："<<sex<<" "<<"地址："<<address<<" "<<"电话："<<tele<<" "<<"职务："<<post<<endl;
	}
};
class Teacher_Cadre:public Teacher,public Cadre
{
protected:
    int wages;
public:
    Teacher_Cadre(string a = "zhang", int b = 20, string c = "male", string d = "Build 305-503", int e = 6081202,string f = "tutor",string g="普通员工",int h=100):Teacher(a,b,c,d,e,f), Cadre(a,b,c,d,e,g)
	{
		wages = h;
	}
    void show()
    {
        Teacher::display();
    }
};
int main()
{
   Teacher_Cadre t[3] = {Teacher_Cadre("zhang ",20,"male","Build 305-503",6081202,"tutor","普通职工"),
		Teacher_Cadre("chen",38,"male","Build 3A-302",6088132,"associate professor","副院长"),
		Teacher_Cadre("fan",30,"female","Build 2A-202",6088099,"lectuer","教研室主任")};
    for(int i=0;i<3;i++)
    {
        cout<<"输出第"<<i+1<<"个人员的姓名、年龄、性别、地址、电话、职称、职务" << endl;
        t[i].show();
    }
    return 0;
}
*/





#include<iostream>
using namespace std;
class Salesperson_Manager
{
public:
    string name;
	int number;
	int time;
	float wages;
};
class Salesperson : private Salesperson_Manager
{
private:
    string kind;
    int sale;
public:
    Salesperson(string a="zhang",int b=10086,int c=2000,string d="手机",int e=10)
    {
        cout << "请输入的为姓名，编号，入职时间，销售种类，销售量..." << endl;
        name=a;
        number=b;
        time=c;
        kind=d;
        sale=e;
    }
    void Calculation()
    {
        if(kind=="手机")
        {
            wages= (2020-time)*100+0.02*sale;
        }
         if(kind=="电脑")
        {
            wages=(2020-time)*100+0.008*sale;
        }
         if(kind=="打印机")
        {
            wages=(2020-time)*100+0.03*sale;
        }
         if(kind=="相机")
        {
            wages=(2020-time)*100+0.02*sale;
        }
         if(kind=="平板电脑")
        {
            wages=(2020-time)*100+0.03*sale;
        }
         if(kind=="外设")
        {
            wages=(2020-time)*100+0.08*sale;
        }
    }
    void display()
    {
        cout<<"姓名:"<<name<<" "<<"编号:"<<number<<" "<<"入职时间:"<<time<<" "<<"工资:"<<wages<<endl;
    }
};
class Manager : private Salesperson_Manager
{
    int grade;
public:
    Manager(string a="zhang",int b=10011,int c=2000,int d=1)
    {
        cout << "依次输入的为姓名，编号，入职时间，级别..." << endl;
		name=a;
        number=b;
        time=c;
        grade=d;
    }
    void Calculation()
    {
       wages=(2020-time)*200+10000+(grade-1)*5000;
    }
    void display()
    {
         cout<<"姓名:"<<name<<" "<<"编号:"<<number<<" "<<"入职时间:"<<time<<" "<<"工资:"<<wages<<endl;
    }
};
int main()
{
    Salesperson a("张三",10086,2010,"手机",20);
	a.Calculation();
	a.display();
    Manager b("李四",10011,2010,3);
	b.Calculation();
	b.display();
    return 0;
}
























