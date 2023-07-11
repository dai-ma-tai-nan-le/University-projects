/*#include<iostream>
using namespace std;
#include<string.h>
template<class numtype>
class Employee
{
private:
    const string name;
    numtype salary;
public:
    Employee(string a,numtype b):name(a)
    {
        salary=b;
    }
    void exchange(numtype b)
    {
        salary=b;
    }
    void put()
    {
        cout<<"姓名:"<<name<<","<<"工资:"<<salary<<endl;
    }
};
int main()
{
    Employee<int> a("张三",10000);
    a.put();
    Employee<float> b("李四",15000);
    float x;
    cout<<"输入修改后的工资"<<endl;
    cin>>x;
    b.exchange(x);
    b.put();
}
*/


#include<iostream>
using namespace std;
class Time
{
private:
    int hour,min,sec;
public:
    Time(int a=0,int b=0,int c=0)
    {
        hour=a;
        min=b;
        sec=c;
    }
    void exchange(int a,int b,int c)
    {
         hour=a;
        min=b;
        sec=c;
    }
    friend void addSecond(Time &t,int s);
    friend class B;
};
void addSecond(Time &t,int s)
    {
        t.sec+=s;
	    if (t.sec>=60)
        {
		    t.sec -= 60;
            t.min++;
	    }
    }
class B
{
public:
    Time t;
    void display()
    {
        cout<<t.hour<<":"<<t.min<<":"<<t.sec<<endl;
    }
};
int main()
{
    Time t;
    addSecond(t,100);
    B *p=new B;
    p->t=t;
    p->display();
    delete p;
    return 0;
}





/*#include<iostream>
using namespace std;
class Time
{
	int hour, min, sec;
public:
	Time():hour(0),min(0),sec(0){}
	void AcquireAll(int a, int b, int c)
	{
		hour = a;
		min = b;
		sec = c;
	}
	friend void addSecond(Time& t, int s);
	friend class B;
};
void addSecond(Time &t,int s)
{
	t.sec += s;
	if (t.sec>=100)
	{
		t.sec -= 60;
		t.min++;
	}
}
class B
{
public:
	Time t;
	void Display()
	{
		cout << t.hour << " :" << t.min << " :" << t.sec << endl;
	}
};
int main()
{
	Time t;
	addSecond(t, 100);
	B* t1 = new B;
	t1->t = t;
	t1->Display();
	delete t1;
	system("pause");
	return 0;
}
*/




