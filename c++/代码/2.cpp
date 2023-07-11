/*#include<iostream>
using namespace std;
main()
{
    cout<<sizeof(int)<<endl;
    cout<<sizeof(float)<<endl;
    cout<<sizeof(char)<<endl;
    cout<<sizeof(bool)<<endl;
    cout<<sizeof(double)<<endl;
}*/
#include<iostream>
#include<stdio.h>
#include<string.h>
using namespace std;
main()
{
    char p[]={'a','b'},q[]="ab";
   printf("%d %d\n",strlen(p),strlen(q));
}
