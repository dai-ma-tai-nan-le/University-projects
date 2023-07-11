#include<graphics.h>
#include<conio.h>
#include<stdio.h>
#include<time.h>
int STEP=10;
int a=13,b=7,c=3,d=4;
void main()
{
	initgraph(1000,1000);
	int i;
	IMAGE imgbj;
	IMAGE imgzq1;
	IMAGE imgzq2;
	IMAGE img;
	IMAGE imgqm[8];
	IMAGE img1[8];			// »ÀŒÔÕºœÒ
	setbkcolor(GREEN);		// ∫⁄…´«¯”ÚŒ™±≥æ∞…´
	cleardevice();
	loadimage(&imgbj, _T("Õº∆¨\\±≥æ∞11.jpg"), 1000, 1000);
	loadimage(&img, _T("Õº∆¨\\«Ú√≈»À.jpg"), 300,300);
	loadimage(&imgzq1, _T("Õº∆¨\\◊„«Ú1.jpg"), 22,22);
	loadimage(&imgzq2, _T("Õº∆¨\\◊„«Ú1.jpg"), 22,22);
	loadimage(&imgqm[0], _T("Õº∆¨\\ ÿ√≈1.jpg"), 300,300);
	loadimage(&imgqm[1], _T("Õº∆¨\\ ÿ√≈2.jpg"), 300,300);
	loadimage(&imgqm[2], _T("Õº∆¨\\ ÿ√≈3.jpg"), 300,300);
	loadimage(&imgqm[3], _T("Õº∆¨\\ ÿ√≈4.jpg"), 300,300);
	loadimage(&imgqm[4], _T("Õº∆¨\\ ÿ√≈5.jpg"), 300,300);
	loadimage(&imgqm[5], _T("Õº∆¨\\ ÿ√≈6.jpg"), 300,300);
	loadimage(&imgqm[6], _T("Õº∆¨\\ ÿ√≈7.jpg"), 300,300);
	loadimage(&imgqm[7], _T("Õº∆¨\\ ÿ√≈8.jpg"), 300,300);
	loadimage(&img1[0], _T("Õº∆¨\\move8_1.jpg"), 70, 100);
	loadimage(&img1[1], _T("Õº∆¨\\move8_2.jpg"), 70, 100);
	loadimage(&img1[2], _T("Õº∆¨\\move8_3.jpg"), 70, 100);
	loadimage(&img1[3], _T("Õº∆¨\\move8_4.jpg"), 70, 100);
	loadimage(&img1[4], _T("Õº∆¨\\move8_5.jpg"), 70, 100);
	loadimage(&img1[5], _T("Õº∆¨\\move8_6.jpg"), 70, 100);
	loadimage(&img1[6], _T("Õº∆¨\\move8_7.jpg"), 70, 100);
	loadimage(&img1[7], _T("Õº∆¨\\move8_8.jpg"), 70, 100);
	getch();
	putimage(0,0,&imgbj);

    int times;
    times=(getmaxx())/STEP;
    for (i=0;i<times-75;i++)
    {putimage(700,320,&img);
switch(i%8)
{ case 0:
putimage(0,0,&imgbj);
putimage(700,320,&img);
putimage(270+(i+1)*STEP,520,&img1[4]);
putimage(290+(i+1)*STEP,370+(i+1)*STEP,&imgzq1);
	 putimage(150+(i+1)*STEP,250+(i+1)*STEP,&img1[4]);Sleep(100);


	break;

 case 1:
putimage(0,0,&imgbj);
putimage(700,320,&img);
putimage(270+(i+1)*STEP,520,&img1[5]);
putimage(280+(i+1)*STEP,365+(i+1)*STEP,&imgzq2);
	 putimage(150+(i+1)*STEP,250+(i+1)*STEP,&img1[5]);Sleep(100);
	 break;
 case 2:
   putimage(0,0,&imgbj);
putimage(700,320,&img);
putimage(270+(i+1)*STEP,520,&img1[6]);
putimage(260+(i+1)*STEP,360+(i+1)*STEP,&imgzq1);
	 putimage(150+(i+1)*STEP,250+(i+1)*STEP,&img1[6]);Sleep(100);

	 break;
 case 3:
putimage(0,0,&imgbj);
putimage(700,320,&img);
putimage(270+(i+1)*STEP,520,&img1[7]);
putimage(240+(i+1)*STEP,355+(i+1)*STEP,&imgzq2);
	 putimage(150+(i+1)*STEP,250+(i+1)*STEP,&img1[7]);Sleep(100);


	 break;
 case 4:
putimage(0,0,&imgbj);
putimage(700,320,&img);
putimage(270+(i+1)*STEP,520,&img1[0]);
putimage(220+(i+1)*STEP,350+(i+1)*STEP,&imgzq1);
   putimage(150+(i+1)*STEP,250+(i+1)*STEP,&img1[0]);Sleep(100);

	 break;
 case 5:
putimage(0,0,&imgbj);
putimage(700,320,&img);
putimage(270+(i+1)*STEP,520,&img1[1]);
putimage(240+(i+1)*STEP,355+(i+1)*STEP,&imgzq2);
putimage(150+(i+1)*STEP,250+(i+1)*STEP,&img1[1]);Sleep(100);


	 break;
 case 6:
putimage(0,0,&imgbj);
   putimage(700,320,&img);
putimage(270+(i+1)*STEP,520,&img1[2]);
putimage(260+(i+1)*STEP,360+(i+1)*STEP,&imgzq1);
putimage(150+(i+1)*STEP,250+(i+1)*STEP,&img1[2]);Sleep(100);

	 break;
 case 7:
putimage(0,0,&imgbj);
putimage(700,320,&img);
putimage(270+(i+1)*STEP,520,&img1[3]);
putimage(280+(i+1)*STEP,365+(i+1)*STEP,&imgzq2);
	 putimage(150+(i+1)*STEP,250+(i+1)*STEP,&img1[3]);Sleep(100);


	 break;

  }
  }
	times=(getmaxx())/STEP;
    for (i=0;i<times-85;i++)
    {putimage(700,320,&img);
switch(i%8)
{ case 0:
putimage(0,0,&imgbj);
putimage(700,320,&img);
putimage(520+(i+1)*STEP,520+(i+1)*c,&img1[4]);
putimage(540+(i+1)*a,610-(i+1)*b,&imgzq1);
	 putimage(400+(i+1)*STEP,500+(i+1)*d,&img1[5]);Sleep(100);


	break;

 case 1:
putimage(0,0,&imgbj);
putimage(700,320,&img);
putimage(520+(i+1)*STEP,520+(i+1)*c,&img1[5]);
putimage(540+(i+1)*a,610-(i+1)*b,&imgzq1);
	 putimage(400+(i+1)*STEP,500+(i+1)*d,&img1[6]);Sleep(100);
	 break;
 case 2:
   putimage(0,0,&imgbj);
putimage(700,320,&img);
putimage(520+(i+1)*STEP,520+(i+1)*c,&img1[6]);
putimage(540+(i+1)*a,610-(i+1)*b,&imgzq1);
	 putimage(400+(i+1)*STEP,500+(i+1)*d,&img1[7]);Sleep(100);

	 break;
 case 3:
putimage(0,0,&imgbj);
putimage(700,320,&img);
putimage(520+(i+1)*STEP,520+(i+1)*c,&img1[7]);
putimage(540+(i+1)*a,610-(i+1)*b,&imgzq1);
	 putimage(400+(i+1)*STEP,500+(i+1)*d,&img1[0]);Sleep(100);


	 break;
 case 4:
putimage(0,0,&imgbj);
putimage(700,320,&img);
putimage(520+(i+1)*STEP,520+(i+1)*c,&img1[0]);
putimage(540+(i+1)*a,610-(i+1)*b,&imgzq1);
   putimage(400+(i+1)*STEP,500+(i+1)*d,&img1[1]);Sleep(100);

	 break;
 case 5:
putimage(0,0,&imgbj);
putimage(700,320,&img);
putimage(520+(i+1)*STEP,520+(i+1)*c,&img1[1]);
putimage(540+(i+1)*a,610-(i+1)*b,&imgzq1);
putimage(400+(i+1)*STEP,500+(i+1)*d,&img1[2]);Sleep(100);


	 break;
 case 6:
putimage(0,0,&imgbj);
   putimage(700,320,&img);
putimage(520+(i+1)*STEP,520+(i+1)*c,&img1[2]);
putimage(540+(i+1)*a,610-(i+1)*b,&imgzq1);
putimage(400+(i+1)*STEP,500+(i+1)*d,&img1[3]);Sleep(100);

	 break;
 case 7:
putimage(0,0,&imgbj);
putimage(700,320,&img);
putimage(520+(i+1)*STEP,520+(i+1)*c,&img1[3]);
putimage(540+(i+1)*a,610-(i+1)*b,&imgzq1);
	 putimage(400+(i+1)*STEP,500+(i+1)*d,&img1[4   ]);Sleep(100);


	 break;

  }
  }

putimage(0,0,&imgbj);
	putimage(700,320,&img);
	for(i=0;i<8;i++)
    {
switch(i%8)
{ case 0:
putimage(0,0,&imgbj);
 putimage(700,320,&imgqm[i]);
 putimage(670+(i+1)*STEP,565+(i+1)*c,&img1[4]);
	 putimage(550+(i+1)*STEP,560+(i+1)*d,&img1[5]);
	Sleep(100);


	break;

 case 1:
putimage(0,0,&imgbj);
putimage(700,320,&imgqm[i]);
putimage(670+(i+1)*STEP,565+(i+1)*c,&img1[5]);
	 putimage(550+(i+1)*STEP,560+(i+1)*d,&img1[6]);
	 Sleep(100);
	 break;
 case 2:
   putimage(0,0,&imgbj);
putimage(700,320,&imgqm[i]);
putimage(670+(i+1)*STEP,565+(i+1)*c,&img1[6]);
	 putimage(550+(i+1)*STEP,560+(i+1)*d,&img1[7]);
	 Sleep(100);

	 break;
 case 3:
putimage(0,0,&imgbj);
putimage(700,320,&imgqm[i]);
putimage(670+(i+1)*STEP,565+(i+1)*c,&img1[7]);
	 putimage(550+(i+1)*STEP,560+(i+1)*d,&img1[0]);
Sleep(100);


	 break;
 case 4:
putimage(0,0,&imgbj);
putimage(700,320,&imgqm[i]);
putimage(670+(i+1)*STEP,565+(i+1)*c,&img1[0]);
   putimage(550+(i+1)*STEP,560+(i+1)*d,&img1[1]);
   Sleep(100);

	 break;
 case 5:
putimage(0,0,&imgbj);
putimage(700,320,&imgqm[i]);
putimage(670+(i+1)*STEP,565+(i+1)*c,&img1[1]);
putimage(550+(i+1)*STEP,560+(i+1)*d,&img1[2]);
Sleep(100);


	 break;
 case 6:
putimage(0,0,&imgbj);
putimage(700,320,&imgqm[i]);
putimage(670+(i+1)*STEP,565+(i+1)*c,&img1[2]);
putimage(550+(i+1)*STEP,560+(i+1)*d,&img1[3]);
Sleep(100);

	 break;
 case 7:
putimage(0,0,&imgbj);
putimage(700,320,&imgqm[i]);
putimage(670+(i+1)*STEP,565+(i+1)*c,&img1[3]);
	 putimage(550+(i+1)*STEP,560+(i+1)*d,&img1[4]);
	 Sleep(100);


	 break;

  }
  }

	getch();

	closegraph();
}
