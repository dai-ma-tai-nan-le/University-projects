using System;
using System.Collections.Generic;

class Program
{
    struct Soldier//战士+
    {
        private string name;//用户名
        private int attack;//攻击力
        private int defense;//防御力
        private int hP;//血量

        public string Name { get => name; set => name = value; }
        public int Attack { get => attack; set => attack = value; }
        public int Defense { get => defense; set => defense = value; }
        public int HP { get => hP; set => hP = value; }
    }
    struct Weapon//武器
    {
        private string weaponname;//武器名
        private int attack;//攻击力

        public string Name { get => name; set => name = value; }
        public int Attack { get => attack; set => attack = value; }
    }
    struct Skill//技能
    {
        private string name;//技能名
        private int attack;//攻击力

        public string Name { get => name; set => name = value; }
        public int Attack { get => attack; set => attack = value; }
    }

    static void Main(string[] args)
    {
        Random r = new Random();

        #region 武器库
        List<Weapon> Weapons = new List<Weapon>();
        Weapon w1 = new Weapon();
        w1.Name = "拉格尼尔";
        w1.Attack = 22;
        Weapons.Add(w1);

        Weapon w2 = new Weapon();
        w2.Name = "艾尔塔鲁德";
        w2.Attack = 28;
        Weapons.Add(w2);

        Weapon w3 = new Weapon();
        w3.Name = "瓦尔邦";
        w3.Attack = 34;
        Weapons.Add(w3);

        Weapon w4 = new Weapon();
        w4.Name = "雷基里";
        w4.Attack = 40;
        Weapons.Add(w4);
        #endregion

        #region 技能库
        List<Skill> Skills = new List<Skill>();
        Skill sk1 = new Skill();
        sk1.Name = "普通攻击";
        sk1.Attack = 20;
        Skills.Add(sk1);

        Skill sk2 = new Skill();
        sk2.Name = "追击";
        sk2.Attack = 50;
        Skills.Add(sk2);

        Skill sk3 = new Skill();
        sk3.Name = "必杀";
        sk3.Attack = 100;
        Skills.Add(sk3);

        Skill sk4 = new Skill();
        sk4.Name = "天空";
        sk4.Attack = 200;
        Skills.Add(sk4);
        #endregion

        #region 输入俩战士名字，战士初始化
        Soldier s1 = new Soldier();
        Console.Write("请输入第一个战士的名字：");
        s1.Name = Console.ReadLine();
        s1.Attack = 100;
        s1.Defense = 20;
        s1.HP = 1000;

        Soldier s2 = new Soldier();
        Console.Write("请输入第二个战士的名字：");
        s2.Name = Console.ReadLine();
        s2.Attack = 100;
        s2.Defense = 20;
        s2.HP = 1000;
        #endregion

        #region 游戏开始，玩家武器刷新
        Console.WriteLine();
        Console.WriteLine("===============游戏开始===============");
        Console.WriteLine();
        int s1_w = r.Next(0, Weapons.Count);//为战士一随机获取一个武器
        s1.Attack += Weapons[s1_w].Attack;//战士一的攻击力更新
        Console.WriteLine(s1.Name + "获得的武器是：" + Weapons[s1_w].Name + "!攻击力成长为：" + s1.Attack);

        int s2_w = r.Next(0, Weapons.Count);//为战士二随机获取一个武器
        s2.Attack += Weapons[s2_w].Attack;//战士二的攻击力更新
        Console.WriteLine(s2.Name + "获得的武器是：" + Weapons[s2_w].Name + "!攻击力成长为：" + s2.Attack);
        Console.WriteLine();
        #endregion

        #region 循环攻击开始
        int i = 0;
        while (true)
        {
            Console.WriteLine("===============第" + (++i) + "回合===============");
            Console.WriteLine();
            int s1_s = r.Next(0, Skills.Count);//战士一此回合获取的技能
            int s1_a = s1.Attack + Skills[s1_s].Attack + r.Next(0, 101);//战士一此回合的攻击力(战士一的攻击力+技能攻击力+0到100的攻击力浮动)
            s2.HP -= (s1_a - s2.Defense);//战士二剩余血量
            if (s1_s == 0)//输出颜色随技能改变
                Console.ForegroundColor = ConsoleColor.Blue;
            else if (s1_s == 1)
                Console.ForegroundColor = ConsoleColor.Yellow;
            else if (s1_s == 2)
                Console.ForegroundColor = ConsoleColor.Green;
            else if (s1_s == 3)
                Console.ForegroundColor = ConsoleColor.Cyan;
            Console.WriteLine("【" + s1.Name + "】对【" + s2.Name + "】发动【" + Skills[s1_s].Name + "】，造成【" + s1_a + "】伤害，【" + s2.Name + "】的血量还有" + s2.HP);
            Console.ForegroundColor = ConsoleColor.White;

            int s2_s = r.Next(0, Skills.Count);//战士一此回合获取的技能
            int s2_a = s2.Attack + Skills[s2_s].Attack + r.Next(0, 101);//战士一此回合的攻击力(战士一的攻击力+技能攻击力+0到100的攻击力浮动)
            s1.HP -= (s2_a - s1.Defense);//战士二剩余血量
            if (s2_s == 0)
                Console.ForegroundColor = ConsoleColor.Blue;
            else if (s2_s == 1)
                Console.ForegroundColor = ConsoleColor.Yellow;
            else if (s2_s == 2)
                Console.ForegroundColor = ConsoleColor.Green;
            else if (s2_s == 3)
                Console.ForegroundColor = ConsoleColor.Cyan;
            Console.WriteLine("【" + s2.Name + "】对【" + s1.Name + "】发动【" + Skills[s2_s].Name + "】，造成【" + s2_a + "】伤害，【" + s1.Name + "】的血量还有" + s1.HP);
            Console.ForegroundColor = ConsoleColor.White;
            Console.WriteLine();
            //判断战斗结果
            if (s1.HP <= 0 && s2.HP <= 0)
            {
                Console.ForegroundColor = ConsoleColor.Red;
                Console.WriteLine("同归于尽！");
                break;
            }
            else if (s1.HP <= 0)
            {
                Console.ForegroundColor = ConsoleColor.Red;
                Console.WriteLine(s2.Name + "战胜！");
                break;
            }
            else if (s2.HP <= 0)
            {
                Console.ForegroundColor = ConsoleColor.Red;
                Console.WriteLine(s1.Name + "战胜！");
                break;
            }
            System.Threading.Thread.Sleep(1000);
        }
        #endregion

        Console.ReadLine();
    }
}
