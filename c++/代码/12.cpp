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
		cout<<"������"<<name<<" "<<"���䣺"<<age<<" "<<"�Ա�"<<sex<<"��ַ��"<<address<<" "<<"�绰��"<<tele<<" "<<"ְ�ƣ�"<<title<<endl;
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
        cout<<"������"<<name<<" "<<"���䣺"<<age<<" "<<"�Ա�"<<sex<<" "<<"��ַ��"<<address<<" "<<"�绰��"<<tele<<" "<<"ְ��"<<post<<endl;
	}
};
class Teacher_Cadre:public Teacher,public Cadre
{
protected:
    int wages;
public:
    Teacher_Cadre(string a = "zhang", int b = 20, string c = "male", string d = "Build 305-503", int e = 6081202,string f = "tutor",string g="��ͨԱ��",int h=100):Teacher(a,b,c,d,e,f), Cadre(a,b,c,d,e,g)
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
   Teacher_Cadre t[3] = {Teacher_Cadre("zhang ",20,"male","Build 305-503",6081202,"tutor","��ְͨ��"),
		Teacher_Cadre("chen",38,"male","Build 3A-302",6088132,"associate professor","��Ժ��"),
		Teacher_Cadre("fan",30,"female","Build 2A-202",6088099,"lectuer","����������")};
    for(int i=0;i<3;i++)
    {
        cout<<"�����"<<i+1<<"����Ա�����������䡢�Ա𡢵�ַ���绰��ְ�ơ�ְ��" << endl;
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
    Salesperson(string a="zhang",int b=10086,int c=2000,string d="�ֻ�",int e=10)
    {
        cout << "�������Ϊ��������ţ���ְʱ�䣬�������࣬������..." << endl;
        name=a;
        number=b;
        time=c;
        kind=d;
        sale=e;
    }
    void Calculation()
    {
        if(kind=="�ֻ�")
        {
            wages= (2020-time)*100+0.02*sale;
        }
         if(kind=="����")
        {
            wages=(2020-time)*100+0.008*sale;
        }
         if(kind=="��ӡ��")
        {
            wages=(2020-time)*100+0.03*sale;
        }
         if(kind=="���")
        {
            wages=(2020-time)*100+0.02*sale;
        }
         if(kind=="ƽ�����")
        {
            wages=(2020-time)*100+0.03*sale;
        }
         if(kind=="����")
        {
            wages=(2020-time)*100+0.08*sale;
        }
    }
    void display()
    {
        cout<<"����:"<<name<<" "<<"���:"<<number<<" "<<"��ְʱ��:"<<time<<" "<<"����:"<<wages<<endl;
    }
};
class Manager : private Salesperson_Manager
{
    int grade;
public:
    Manager(string a="zhang",int b=10011,int c=2000,int d=1)
    {
        cout << "���������Ϊ��������ţ���ְʱ�䣬����..." << endl;
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
         cout<<"����:"<<name<<" "<<"���:"<<number<<" "<<"��ְʱ��:"<<time<<" "<<"����:"<<wages<<endl;
    }
};
int main()
{
    Salesperson a("����",10086,2010,"�ֻ�",20);
	a.Calculation();
	a.display();
    Manager b("����",10011,2010,3);
	b.Calculation();
	b.display();
    return 0;
}
























