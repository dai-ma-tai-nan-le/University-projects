/*#include<iostream>
using namespace std;
int main()
{
    int ban;
    char name[10];
    cout<<"输入班级和姓名"<<endl;
    cin>>ban>>name;
    cout<<"\"我是软件"<<ban<<"班的学生。\""<<endl;
    cout<<"\"我叫"<<name<<"\""<<endl;
}*/

/*#include<iostream>
using namespace std;
main()
{
   char a[10],b,c;
   int i;
   cout<<"输入一行字符"<<endl;
   for(i=0;i<10;i++)
   {
       cin>>a[i];
   }
   for(i=0;i<10;i++)
   {
       if(a[i]>='a'&&a[i]<='z')
       {
           b=a[i]-32;
           cout<<b;
       }
       else if(a[i]>='A'&&a[i]<='Z')
       {
           c=a[i]+32;
           cout<<c;
       }
       else
        cout<<a[i];
   }
}*/

/*#include<iostream>
using namespace std;
main()
{
    int number;
    cout<<"输入月份的数字"<<endl;
    cin>>number;
    while(1)
    {
        switch(number)
        {
        case 1:cout<<"January"<<endl;break;
        case 2:cout<<"February"<<endl;break;
        case 3:cout<<"March"<<endl;break;
        case 4:cout<<"April"<<endl;break;
        case 5:cout<<"May"<<endl;break;
        case 6:cout<<"June"<<endl;break;
        case 7:cout<<"July"<<endl;break;
        case 8:cout<<"August"<<endl;break;
        case 9:cout<<"September"<<endl;break;
        case 10:cout<<"October"<<endl;break;
        case 11:cout<<"November"<<endl;break;
        case 12:cout<<"December"<<endl;break;
        default:cout<<"Wrong number!"<<endl;
        }
    cin>>number;
    }
}*/

/*#include<iostream>
using namespace std;
#include<math.h>
#define s(a,b,c) (1.0/2)*(a+b+c)
#define area(a,b,c) sqrt(s(a,b,c)*(s(a,b,c)-a)*(s(a,b,c)-b)*(s(a,b,c)-c))
int main()
{
    int a,b,c;
    cout<<"输入三角形的三边"<<endl;
    cin>>a>>b>>c;
    if(a+b>c&&a+c>b&&b+c>a)
    {
        cout<<"s="<<s(a,b,c)<<endl;
        cout<<"area="<<area(a,b,c)<<endl;
    }
    else
        cout<<"不是三角形"<<endl;
    return 0;
}
*/

#include<iostream>
using namespace std;
class student
{
    public:
    char name[20];
    int score[3];
};
int main()
{
    class student stu[2];
    int i;
    for(i=0;i<2;i++)
    {
        cout<<"输入第"<<i+1<<"个人的计算机的成绩"<<endl;
        cin>>stu[i].score[1];
    }
    for(i=0;i<2;i++)
    {
        cout<<"第"<<i+1<<"个人的信息"<<endl;
        cout<<"计算机："<<stu[i].score[1]<<endl;
    }
}




















