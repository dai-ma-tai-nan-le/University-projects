using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace reply
{
    class BattleControl
    {
        //单例类
        private BattleControl() { }
        private static BattleControl instance;
        public static BattleControl Instance
        {
            get
            {
                if (instance == null)
                {
                    instance = new BattleControl();
                }
                return instance;
            }
        }
        //泛型
        List<Hero> ours = new List<Hero>();
        List<Hero> enemy = new List<Hero>();
        List<Weapon> weapons = new List<Weapon>();
        List<Skill> skills = new List<Skill>();
        //记录回合数
        public int round;
        //记录大招开启需要的能量
        public int sum,num;

        //随机数
        Random r = new Random();
        //初始化
        public void init()
        {
            #region 定义武器
            Weapon w1 = new Weapon();
            w1.Name = "奥特手镯";
            w1.Hp = 100;
            w1.Mp = 300;
            weapons.Add(w1);
            Weapon w2 = new Weapon();
            w2.Name = "骑士气息";
            w2.MagicAttack = 20;
            weapons.Add(w2);
            Weapon w3 = new Weapon();
            w3.Name = "头镖";
            w3.PhysicsAttack = 30;
            weapons.Add(w3);
            Weapon w4 = new Weapon();
            w4.Name = "帕拉吉之盾";
            w4.MagicAttack = 30;
            weapons.Add(w4);
            Weapon w5 = new Weapon();
            w5.Name = "艾斯长剑";
            w5.PhysicsAttack = 20;
            weapons.Add(w5);
            #endregion

            #region 定义英雄技能
            Skill s1 = new Skill();
            s1.Name = "普通攻击";
            s1.PhysicsAttack = r.Next(0, 50);
            skills.Add(s1);
            Skill s2 = new Skill();
            s2.Name = "飞起一脚";
            s2.PhysicsAttack = r.Next(0, 50);
            skills.Add(s2);
            Skill s3 = new Skill();
            s3.Name = "认真一拳";
            s3.PhysicsAttack = r.Next(0, 50);
            skills.Add(s3);
            Skill s4 = new Skill();
            s4.Name = "哉佩利敖光线";
            s4.MagicAttack = r.Next(50, 100);
            skills.Add(s4);
            Skill s5 = new Skill();
            s5.Name = "骑士射线";
            s5.MagicAttack = r.Next(50, 100);
            skills.Add(s5);
            Skill s6 = new Skill();
            s6.Name = "艾梅利姆光线";
            s6.MagicAttack = r.Next(50, 100);
            skills.Add(s6);
            Skill s7 = new Skill();
            s7.Name = "集束射线";
            s7.MagicAttack = r.Next(50, 100);
            skills.Add(s7);
            Skill s8 = new Skill();
            s8.Name = "八分光轮";
            s8.MagicAttack = r.Next(50, 100);
            skills.Add(s8);
            Skill s9 = new Skill();
            s9.Name = "奥特屏障";
            skills.Add(s9);
            #endregion

            #region 定义怪兽技能
            Skill s10 = new Skill();
            s10.Name = "踹击";
            s10.PhysicsAttack = r.Next(0, 30);
            skills.Add(s10);
            Skill s11 = new Skill();
            s11.Name = "冲撞";
            s11.PhysicsAttack = r.Next(0, 30);
            skills.Add(s11);
            Skill s12 = new Skill();
            s12.Name = "臂击";
            s12.PhysicsAttack = r.Next(0, 30);
            skills.Add(s12);
            Skill s13 = new Skill();
            s13.Name = "火球攻击";
            s13.MagicAttack = r.Next(50, 100);
            skills.Add(s13);
            Skill s14 = new Skill();
            s14.Name = "光线攻击";
            s14.MagicAttack = r.Next(50, 100);
            skills.Add(s14);
            Skill s15 = new Skill();
            s15.Name = "闪避";
            skills.Add(s15);
            #endregion

            #region 定义我方英雄
            Hero h1 = new Hero();
            h1.Name = "迪迦";
            h1.PhysicsAttack = r.Next(20, 40);
            ours.Add(h1);
            Hero h2 = new Hero();
            h2.Name = "希卡利";
            h2.PhysicsAttack = r.Next(20, 40);
            ours.Add(h2);
            Hero h3 = new Hero();
            h3.Name = "赛文";
            h3.PhysicsAttack = r.Next(20, 40);
            ours.Add(h3);
            Hero h4 = new Hero();
            h4.Name = "赛罗";
            h4.PhysicsAttack = r.Next(20, 40);
            ours.Add(h4);
            Hero h5 = new Hero();
            h5.Name = "艾斯";
            h5.PhysicsAttack = r.Next(20, 40);
            ours.Add(h5);
            #endregion

            #region 定义敌方英雄
            Hero h6 = new Hero();
            h6.Name = "哥尔赞";
            h6.PhysicsAttack = r.Next(30, 50);
            enemy.Add(h6);
            Hero h7 = new Hero();
            h7.Name = "美尔巴";
            h7.PhysicsAttack = r.Next(30, 50);
            enemy.Add(h7);
            Hero h8 = new Hero();
            h8.Name = "加恩Q";
            h8.PhysicsAttack = r.Next(30, 50);
            enemy.Add(h8);
            Hero h9 = new Hero();
            h9.Name = "超戈布";
            h9.PhysicsAttack = r.Next(30, 50);
            enemy.Add(h9);
            Hero h10 = new Hero();
            h10.Name = "雷丘巴斯";
            h10.PhysicsAttack = r.Next(30, 50);
            enemy.Add(h10);
            #endregion

            #region 显示我方英雄，敌方英雄
            Console.WriteLine("我方英雄：{0}\t\t{1}\t\t{2}\t\t{3}\t\t{4}", h1.Name, h2.Name, h3.Name, h4.Name, h5.Name);
            Console.WriteLine("敌方英雄：{0}\t{1}\t\t{2}\t\t{3}\t\t{4}", h6.Name, h7.Name, h8.Name, h9.Name, h10.Name);
            print();
            #endregion

            #region 为我方英雄附加武器
            Console.WriteLine();
            Console.WriteLine("===============游戏开始===============");
            Console.WriteLine();

            h1.Hp += w1.Hp;
            h1.Mp += w1.Mp;
            Console.WriteLine(h1.Name + "获得的武器是：" + weapons[0].Name + "!血量成长为：" + h1.Hp + "\t!魔法值成长为：" + h1.Mp);
            h2.MagicAttack += w2.MagicAttack;
            Console.WriteLine(h2.Name + "获得的武器是：" + weapons[1].Name + "!魔法攻击力成长为：" + h2.MagicAttack);
            h3.PhysicsAttack = +w3.PhysicsAttack;
            Console.WriteLine(h3.Name + "获得的武器是：" + weapons[2].Name + "!物理攻击力成长为：" + h3.PhysicsAttack);
            h4.MagicAttack += w4.MagicAttack;
            Console.WriteLine(h4.Name + "获得的武器是：" + weapons[3].Name + "!魔法攻击力成长为：" + h4.MagicAttack);
            h5.PhysicsAttack = +w5.PhysicsAttack;
            Console.WriteLine(h5.Name + "获得的武器是：" + weapons[4].Name + "!物理攻击力成长为：" + h5.PhysicsAttack);
            print();
            #endregion

            #region 循环攻击开始
            AttackStart();
            #endregion
            Console.ReadKey();
        }
        //循环攻击
        public void AttackStart()
        {
            int i = 0;
            while (true)
            {
                Console.WriteLine();
                Console.WriteLine();
                Console.WriteLine("===============第" + (++i) + "回合===============");
                Console.WriteLine();
                Wfgj();
                Console.WriteLine();
                Dfgj();
                Console.WriteLine();
                if (ours.Count == 0)
                {
                    Console.WriteLine();
                    Console.WriteLine();
                    Console.ForegroundColor = ConsoleColor.Red;
                    round = i;
                    print();
                    Console.WriteLine("\t\t经过" + round + "回合的戮战: 怪兽小队胜利");
                    break;
                }
                if (enemy.Count == 0)
                {
                    Console.WriteLine();
                    Console.WriteLine();
                    Console.ForegroundColor = ConsoleColor.Red;
                    print();
                    round = i;
                    Console.WriteLine("\t\t经过" + round + "回合的戮战: 奥特小队胜利");
                    break;
                }
            }
        }
        //我方攻击
        public void Wfgj()
        {
            #region 我方攻击
            for (int j = 0; j < ours.Count; j++)
            {
                int x1 = 0;
                //随机一个敌人
                if (enemy.Count != 0)
                {
                    x1 = r.Next(0, enemy.Count);
                }
                //我方英雄此回合获取的技能
                int h = r.Next(0, 3);
                //是否产生暴击
                int y1 = r.Next(0, 5);
                //y==0产生暴击
                if (y1 == 0)
                {
                    //此回合的攻击力
                    int a1 = ours[j].PhysicsAttack + skills[h].PhysicsAttack + r.Next(0, 30);
                    //是否闪避
                    int b = r.Next(0, 10);
                    if (enemy.Count == 0) break;
                    if (b == 0)
                    {
                        Console.Write("【" + ours[j].Name + "】对【" + enemy[x1].Name + "】发动【" + skills[h].Name + "】");
                        Console.WriteLine("【" + enemy[x1].Name + "】发动【" + skills[14].Name + "】【" + enemy[x1].Name + "】的血量还有" + enemy[x1].Hp);
                        continue;
                    }
                    int hp = enemy[x1].Hp - a1;
                    sum++;
                    if (hp <= 0)
                    {
                        if (sum == 4)
                        {
                            if (ours[j].Mp - skills[3].MagicAttack <= 0 || ours[j].Mp - skills[4].MagicAttack <= 0 || ours[j].Mp - skills[5].MagicAttack <= 0 || ours[j].Mp - skills[6].MagicAttack <= 0 || ours[j].Mp - skills[7].MagicAttack <= 0)
                            {
                                ours[j].Mp = 0;
                                Console.WriteLine("【" + ours[j].Name + "】的大招被【" + enemy[x1].Name + "】打断");
                                sum = 0;
                                continue;
                            }
                            int aa1, aa2, aa3, aa4, aa5;
                            if (ours[j].Name == "迪迦")
                            {
                                //此回合的攻击力
                                aa1 = ours[j].MagicAttack + skills[3].MagicAttack + r.Next(0, 30);
                                ours[j].Mp -= skills[3].MagicAttack;
                                enemy[x1].Hp = 0;
                                Console.WriteLine("【" + ours[j].Name + "】对【" + enemy[x1].Name + "】发动【" + skills[3].Name + "】，产生了暴击，造成【" + aa1 + "】伤害，【" + enemy[x1].Name + "】的血量还有" + (enemy[x1].Hp + a1) + "  【" + ours[j].Name + "】的魔力还有" + ours[j].Mp);
                                enemy.Remove(enemy[x1]);
                                Console.Write("怪兽死了一个，我方全体");
                                add(ours);
                            }
                            if (ours[j].Name == "希卡利")
                            {
                                aa2 = ours[j].MagicAttack + skills[4].MagicAttack + r.Next(0, 30);
                                ours[j].Mp -= skills[4].MagicAttack;
                                enemy[x1].Hp = 0;
                                Console.WriteLine("【" + ours[j].Name + "】对【" + enemy[x1].Name + "】发动【" + skills[4].Name + "】，产生了暴击，造成【" + aa2 + "】伤害，【" + enemy[x1].Name + "】的血量还有" + (enemy[x1].Hp + a1) + "  【" + ours[j].Name + "】的魔力还有" + ours[j].Mp);
                                enemy.Remove(enemy[x1]);
                                Console.Write("怪兽死了一个，我方全体");
                                add(ours);
                            }
                            if (ours[j].Name == "赛文")
                            {
                                aa3 = ours[j].MagicAttack + skills[5].MagicAttack + r.Next(0, 30);
                                ours[j].Mp -= skills[5].MagicAttack;
                                enemy[x1].Hp = 0;
                                Console.WriteLine("【" + ours[j].Name + "】对【" + enemy[x1].Name + "】发动【" + skills[5].Name + "】，产生了暴击，造成【" + aa3 + "】伤害，【" + enemy[x1].Name + "】的血量还有" + (enemy[x1].Hp + a1) + "  【" + ours[j].Name + "】的魔力还有" + ours[j].Mp);
                                enemy.Remove(enemy[x1]);
                                Console.Write("怪兽死了一个，我方全体");
                                add(ours);
                            }
                            if (ours[j].Name == "赛罗")
                            {
                                aa4 = ours[j].MagicAttack + skills[6].MagicAttack + r.Next(0, 30);
                                ours[j].Mp -= skills[6].MagicAttack;
                                enemy[x1].Hp = 0;
                                Console.WriteLine("【" + ours[j].Name + "】对【" + enemy[x1].Name + "】发动【" + skills[6].Name + "】，产生了暴击，造成【" + aa4 + "】伤害，【" + enemy[x1].Name + "】的血量还有" + (enemy[x1].Hp + a1) + "  【" + ours[j].Name + "】的魔力还有" + ours[j].Mp);
                                enemy.Remove(enemy[x1]);
                                Console.Write("怪兽死了一个，我方全体");
                                add(ours);
                            }
                            if (ours[j].Name == "艾斯")
                            {
                                aa5 = ours[j].MagicAttack + skills[7].MagicAttack + r.Next(0, 30);
                                ours[j].Mp -= skills[7].MagicAttack;
                                enemy[x1].Hp = 0;
                                Console.WriteLine("【" + ours[j].Name + "】对【" + enemy[x1].Name + "】发动【" + skills[7].Name + "】，产生了暴击，造成【" + aa5 + "】伤害，【" + enemy[x1].Name + "】的血量还有" + (enemy[x1].Hp + a1) + "  【" + ours[j].Name + "】的魔力还有" + ours[j].Mp);
                                enemy.Remove(enemy[x1]);
                                Console.Write("怪兽死了一个，我方全体");
                                add(ours);
                            }
                            sum = 0;
                        }
                        else
                        {
                            enemy[x1].Hp = 0;
                            Console.WriteLine("【" + ours[j].Name + "】对【" + enemy[x1].Name + "】发动【" + skills[h].Name + "】，产生了暴击，造成【" + a1 + "】伤害，【" + enemy[x1].Name + "】的血量还有" + enemy[x1].Hp);
                            enemy.Remove(enemy[x1]);
                            Console.Write("怪兽死了一个，我方全体");
                            add(ours);
                        }
                    }
                    else
                    {
                        if (sum == 4)
                        {
                            if (ours[j].Mp - skills[3].MagicAttack <= 0 || ours[j].Mp - skills[4].MagicAttack <= 0 || ours[j].Mp - skills[5].MagicAttack <= 0 || ours[j].Mp - skills[6].MagicAttack <= 0 || ours[j].Mp - skills[7].MagicAttack <= 0)
                            {
                                ours[j].Mp = 0;
                                Console.WriteLine("【" + ours[j].Name + "】的大招被【" + enemy[x1].Name + "】打断");
                                sum = 0;
                                continue;
                            }
                            int aa1, aa2, aa3, aa4, aa5;
                            if (ours[j].Name == "迪迦")
                            {
                                //此回合的攻击力
                                aa1 = ours[j].MagicAttack + skills[3].MagicAttack + r.Next(0, 30); ;
                                ours[j].Mp -= skills[3].MagicAttack;
                                Console.WriteLine("【" + ours[j].Name + "】对【" + enemy[x1].Name + "】发动【" + skills[3].Name + "】，产生了暴击，造成【" + aa1 + "】伤害，【" + enemy[x1].Name + "】的血量还有" + (hp - aa1 + a1) + "  【" + ours[j].Name + "】的魔力还有" + ours[j].Mp);
                                enemy[x1].Hp = (hp - aa1 + a1);
                            }
                            if (ours[j].Name == "希卡利")
                            {
                                aa2 = ours[j].MagicAttack + skills[4].MagicAttack + r.Next(0, 30);
                                ours[j].Mp -= skills[4].MagicAttack;
                                Console.WriteLine("【" + ours[j].Name + "】对【" + enemy[x1].Name + "】发动【" + skills[4].Name + "】，产生了暴击，造成【" + aa2 + "】伤害，【" + enemy[x1].Name + "】的血量还有" + (hp - aa2 + a1) + "  【" + ours[j].Name + "】的魔力还有" + ours[j].Mp);
                                enemy[x1].Hp = (hp - aa2 + a1);
                            }
                            if (ours[j].Name == "赛文")
                            {
                                aa3 = ours[j].MagicAttack + skills[5].MagicAttack + r.Next(0, 30);
                                ours[j].Mp -= skills[5].MagicAttack;
                                Console.WriteLine("【" + ours[j].Name + "】对【" + enemy[x1].Name + "】发动【" + skills[5].Name + "】，产生了暴击，造成【" + aa3 + "】伤害，【" + enemy[x1].Name + "】的血量还有" + (hp - aa3 + a1) + "  【" + ours[j].Name + "】的魔力还有" + ours[j].Mp);
                                enemy[x1].Hp = (hp - aa3 + a1);
                            }
                            if (ours[j].Name == "赛罗")
                            {
                                aa4 = ours[j].MagicAttack + skills[6].MagicAttack + r.Next(0, 30);
                                ours[j].Mp -= skills[6].MagicAttack;
                                Console.WriteLine("【" + ours[j].Name + "】对【" + enemy[x1].Name + "】发动【" + skills[6].Name + "】，产生了暴击，造成【" + aa4 + "】伤害，【" + enemy[x1].Name + "】的血量还有" + (hp - aa4 + a1) + "  【" + ours[j].Name + "】的魔力还有" + ours[j].Mp);
                                enemy[x1].Hp = (hp - aa4 + a1);
                            }
                            if (ours[j].Name == "艾斯")
                            {
                                aa5 = ours[j].MagicAttack + skills[7].MagicAttack + r.Next(0, 30);
                                ours[j].Mp -= skills[7].MagicAttack;
                                Console.WriteLine("【" + ours[j].Name + "】对【" + enemy[x1].Name + "】发动【" + skills[7].Name + "】，产生了暴击，造成【" + aa5 + "】伤害，【" + enemy[x1].Name + "】的血量还有" + (hp - aa5 + a1) + "  【" + ours[j].Name + "】的魔力还有" + ours[j].Mp);
                                enemy[x1].Hp = (hp - aa5 + a1);
                            }
                            sum = 0;
                        }
                        else
                        {
                            Console.WriteLine("【" + ours[j].Name + "】对【" + enemy[x1].Name + "】发动【" + skills[h].Name + "】，产生了暴击，造成【" + a1 + "】伤害，【" + enemy[x1].Name + "】的血量还有" + hp);
                            enemy[x1].Hp = hp;
                        }
                    }
                }
                else
                {
                    //此回合的攻击力
                    int a1 = ours[j].PhysicsAttack + skills[h].PhysicsAttack;
                    //是否闪避
                    int b = r.Next(0, 10);
                    if (enemy.Count == 0) break;
                    if (b == 0)
                    {
                        Console.Write("【" + ours[j].Name + "】对【" + enemy[x1].Name + "】发动【" + skills[h].Name + "】");
                        Console.WriteLine("【" + enemy[x1].Name + "】发动【" + skills[14].Name + "】【" + enemy[x1].Name + "】的血量还有" + enemy[x1].Hp);
                        continue;
                    }
                    int hp = enemy[x1].Hp - a1;
                    sum++;
                    if (hp <= 0)
                    {
                        if (sum == 4)
                        {
                            if (ours[j].Mp - skills[3].MagicAttack <= 0 || ours[j].Mp - skills[4].MagicAttack <= 0 || ours[j].Mp - skills[5].MagicAttack <= 0 || ours[j].Mp - skills[6].MagicAttack <= 0 || ours[j].Mp - skills[7].MagicAttack <= 0)
                            {
                                ours[j].Mp = 0;
                                Console.WriteLine("【" + ours[j].Name + "】的大招被【" + enemy[x1].Name + "】打断");
                                sum = 0;
                                continue;
                            }
                            int aa1, aa2, aa3, aa4, aa5;
                            if (ours[j].Name == "迪迦")
                            {
                                //此回合的攻击力
                                aa1 = ours[j].MagicAttack + skills[3].MagicAttack;
                                ours[j].Mp -= skills[3].MagicAttack;
                                enemy[x1].Hp = 0;
                                Console.WriteLine("【" + ours[j].Name + "】对【" + enemy[x1].Name + "】发动【" + skills[3].Name + "】，产生了暴击，造成【" + aa1 + "】伤害，【" + enemy[x1].Name + "】的血量还有" + (enemy[x1].Hp + a1) + "  【" + ours[j].Name + "】的魔力还有" + ours[j].Mp);
                                enemy.Remove(enemy[x1]);
                                Console.Write("怪兽死了一个，我方全体");
                                add(ours);
                            }
                            if (ours[j].Name == "希卡利")
                            {
                                aa2 = ours[j].MagicAttack + skills[4].MagicAttack;
                                ours[j].Mp -= skills[4].MagicAttack;
                                enemy[x1].Hp = 0;
                                Console.WriteLine("【" + ours[j].Name + "】对【" + enemy[x1].Name + "】发动【" + skills[4].Name + "】，产生了暴击，造成【" + aa2 + "】伤害，【" + enemy[x1].Name + "】的血量还有" + (enemy[x1].Hp + a1) + "  【" + ours[j].Name + "】的魔力还有" + ours[j].Mp);
                                enemy.Remove(enemy[x1]);
                                Console.Write("怪兽死了一个，我方全体");
                                add(ours);
                            }
                            if (ours[j].Name == "赛文")
                            {
                                aa3 = ours[j].MagicAttack + skills[5].MagicAttack;
                                ours[j].Mp -= skills[5].MagicAttack;
                                enemy[x1].Hp = 0;
                                Console.WriteLine("【" + ours[j].Name + "】对【" + enemy[x1].Name + "】发动【" + skills[5].Name + "】，产生了暴击，造成【" + aa3 + "】伤害，【" + enemy[x1].Name + "】的血量还有" + (enemy[x1].Hp + a1) + "  【" + ours[j].Name + "】的魔力还有" + ours[j].Mp);
                                enemy.Remove(enemy[x1]);
                                Console.Write("怪兽死了一个，我方全体");
                                add(ours);
                            }
                            if (ours[j].Name == "赛罗")
                            {
                                aa4 = ours[j].MagicAttack + skills[6].MagicAttack;
                                ours[j].Mp -= skills[6].MagicAttack;
                                enemy[x1].Hp = 0;
                                Console.WriteLine("【" + ours[j].Name + "】对【" + enemy[x1].Name + "】发动【" + skills[6].Name + "】，产生了暴击，造成【" + aa4 + "】伤害，【" + enemy[x1].Name + "】的血量还有" + (enemy[x1].Hp + a1) + "  【" + ours[j].Name + "】的魔力还有" + ours[j].Mp);
                                enemy.Remove(enemy[x1]);
                                Console.Write("怪兽死了一个，我方全体");
                                add(ours);
                            }
                            if (ours[j].Name == "艾斯")
                            {
                                aa5 = ours[j].MagicAttack + skills[7].MagicAttack;
                                ours[j].Mp -= skills[7].MagicAttack;
                                enemy[x1].Hp = 0;
                                Console.WriteLine("【" + ours[j].Name + "】对【" + enemy[x1].Name + "】发动【" + skills[7].Name + "】，产生了暴击，造成【" + aa5 + "】伤害，【" + enemy[x1].Name + "】的血量还有" + (enemy[x1].Hp + a1) + "  【" + ours[j].Name + "】的魔力还有" + ours[j].Mp);
                                enemy.Remove(enemy[x1]);
                                Console.Write("怪兽死了一个，我方全体");
                                add(ours);
                            }
                            sum = 0;
                        }
                        else
                        {
                            enemy[x1].Hp = 0;
                            Console.WriteLine("【" + ours[j].Name + "】对【" + enemy[x1].Name + "】发动【" + skills[h].Name + "】，造成【" + a1 + "】伤害，【" + enemy[x1].Name + "】的血量还有" + enemy[x1].Hp);
                            enemy.Remove(enemy[x1]);
                            Console.Write("怪兽死了一个，我方全体");
                            add(ours);
                        }
                    }
                    else
                    {
                        if (sum == 4)
                        {
                            if (ours[j].Mp - skills[3].MagicAttack <= 0 || ours[j].Mp - skills[4].MagicAttack <= 0 || ours[j].Mp - skills[5].MagicAttack <= 0 || ours[j].Mp - skills[6].MagicAttack <= 0 || ours[j].Mp - skills[7].MagicAttack <= 0)
                            {
                                ours[j].Mp = 0;
                                Console.WriteLine("【" + ours[j].Name + "】的大招被【" + enemy[x1].Name + "】打断");
                                sum = 0;
                                continue;
                            }
                            int aa1, aa2, aa3, aa4, aa5;
                            if (ours[j].Name == "迪迦")
                            {
                                //此回合的攻击力
                                aa1 = ours[j].MagicAttack + skills[3].MagicAttack;
                                ours[j].Mp -= skills[3].MagicAttack;
                                Console.WriteLine("【" + ours[j].Name + "】对【" + enemy[x1].Name + "】发动【" + skills[3].Name + "】，产生了暴击，造成【" + aa1 + "】伤害，【" + enemy[x1].Name + "】的血量还有" + (hp - aa1 + a1) + "  【" + ours[j].Name + "】的魔力还有" + ours[j].Mp);
                                enemy[x1].Hp = (hp - aa1 + a1);
                            }
                            if (ours[j].Name == "希卡利")
                            {
                                aa2 = ours[j].MagicAttack + skills[4].MagicAttack;
                                ours[j].Mp -= skills[4].MagicAttack;
                                Console.WriteLine("【" + ours[j].Name + "】对【" + enemy[x1].Name + "】发动【" + skills[4].Name + "】，产生了暴击，造成【" + aa2 + "】伤害，【" + enemy[x1].Name + "】的血量还有" + (hp - aa2 + a1) + "  【" + ours[j].Name + "】的魔力还有" + ours[j].Mp);
                                enemy[x1].Hp = (hp - aa2 + a1);
                            }
                            if (ours[j].Name == "赛文")
                            {
                                aa3 = ours[j].MagicAttack + skills[5].MagicAttack;
                                ours[j].Mp -= skills[5].MagicAttack;
                                Console.WriteLine("【" + ours[j].Name + "】对【" + enemy[x1].Name + "】发动【" + skills[5].Name + "】，产生了暴击，造成【" + aa3 + "】伤害，【" + enemy[x1].Name + "】的血量还有" + (hp - aa3 + a1) + "  【" + ours[j].Name + "】的魔力还有" + ours[j].Mp);
                                enemy[x1].Hp = (hp - aa3 + a1);
                            }
                            if (ours[j].Name == "赛罗")
                            {
                                aa4 = ours[j].MagicAttack + skills[6].MagicAttack;
                                ours[j].Mp -= skills[6].MagicAttack;
                                Console.WriteLine("【" + ours[j].Name + "】对【" + enemy[x1].Name + "】发动【" + skills[6].Name + "】，产生了暴击，造成【" + aa4 + "】伤害，【" + enemy[x1].Name + "】的血量还有" + (hp - aa4 + a1) + "  【" + ours[j].Name + "】的魔力还有" + ours[j].Mp);
                                enemy[x1].Hp = (hp - aa4 + a1);
                            }
                            if (ours[j].Name == "艾斯")
                            {
                                aa5 = ours[j].MagicAttack + skills[7].MagicAttack;
                                ours[j].Mp -= skills[7].MagicAttack;
                                Console.WriteLine("【" + ours[j].Name + "】对【" + enemy[x1].Name + "】发动【" + skills[7].Name + "】，产生了暴击，造成【" + aa5 + "】伤害，【" + enemy[x1].Name + "】的血量还有" + (hp - aa5 + a1) + "  【" + ours[j].Name + "】的魔力还有" + ours[j].Mp);
                                enemy[x1].Hp = (hp - aa5 + a1);
                            }
                            sum = 0;
                        }
                        else
                        {
                            Console.WriteLine("【" + ours[j].Name + "】对【" + enemy[x1].Name + "】发动【" + skills[h].Name + "】，造成【" + a1 + "】伤害，【" + enemy[x1].Name + "】的血量还有" + hp);
                            enemy[x1].Hp = hp;
                        }
                    }
                }
            }
            #endregion
        }
        //敌方攻击
        public void Dfgj()
        {
            #region 敌方攻击
            for (int l = 0; l < enemy.Count; l++)
            {
                int x2 = 0;
                //随机一个我方英雄
                if (ours.Count != 0)
                {
                    x2 = r.Next(0, ours.Count);
                }
                //敌方英雄此回合获取的技能
                int hh = r.Next(9, 12);
                //是否产生暴击
                int y2 = r.Next(0, 5);
                //y==0产生暴击
                if (y2 == 0)
                {
                    //此回合的攻击力
                    int a2 = enemy[l].PhysicsAttack + skills[hh].PhysicsAttack + r.Next(0, 30);
                    //是否闪避
                    int b1 = r.Next(0, 10);
                    if (ours.Count == 0) break;
                    if (b1 == 0)
                    {
                        Console.Write("【" + enemy[l].Name + "】对【" + ours[x2].Name + "】发动【" + skills[hh].Name + "】");
                        Console.WriteLine("【" + ours[x2].Name + "】发动【" + skills[8].Name + "】【" + ours[x2].Name + "】的血量还有" + ours[x2].Hp);
                        continue;
                    }

                    int hp1 = ours[x2].Hp - a2;
                    num++;
                    if (hp1 <= 0)
                    {
                        if (num == 4)
                        {
                            int q = r.Next(13, 14);
                            if (enemy[l].Mp - skills[q].MagicAttack <= 0)
                            {
                                enemy[l].Mp = 0;
                                Console.WriteLine("【" + enemy[l].Name + "】的大招被【" + ours[x2].Name + "】打断");
                                num = 0;
                                continue;
                            }
                            int aa6 = enemy[l].MagicAttack + skills[q].MagicAttack + r.Next(0, 30);
                            enemy[l].Mp -= skills[q].MagicAttack;
                            ours[x2].Hp = 0;
                            Console.WriteLine("【" + enemy[l].Name + "】对【" + ours[x2].Name + "】发动【" + skills[q].Name + "】，产生了暴击，造成【" + aa6 + "】伤害，【" + ours[x2].Name + "】的血量还有" + ours[x2].Hp + "  【" + enemy[l].Name + "】的魔力还有" + enemy[l].Mp);
                            ours.Remove(ours[x2]);
                            Console.Write("奥特曼死了一个，怪兽全体");
                            add(enemy);
                            num = 0;
                        }
                        else
                        {
                            ours[x2].Hp = 0;
                            Console.WriteLine("【" + enemy[l].Name + "】对【" + ours[x2].Name + "】发动【" + skills[hh].Name + "】，产生了暴击，造成【" + a2 + "】伤害，【" + ours[x2].Name + "】的血量还有" + ours[x2].Hp);
                            ours.Remove(ours[x2]);
                            Console.Write("奥特曼死了一个，怪兽全体");
                            add(enemy);
                        }
                    }
                    else
                    {
                        if (num == 4)
                        {
                            int q = r.Next(13, 14);
                            if (enemy[l].Mp - skills[q].MagicAttack <= 0)
                            {
                                enemy[l].Mp = 0;
                                Console.WriteLine("【" + enemy[l].Name + "】的大招被【" + ours[x2].Name + "】打断");
                                num = 0;
                                continue;
                            }
                            int aa6 = enemy[l].MagicAttack + skills[q].MagicAttack;
                            enemy[l].Mp -= skills[q].MagicAttack;
                            Console.WriteLine("【" + enemy[l].Name + "】对【" + ours[x2].Name + "】发动【" + skills[q].Name + "】，产生了暴击，造成【" + aa6 + "】伤害，【" + ours[x2].Name + "】的血量还有" + (hp1 - aa6 + a2) + "  【" + enemy[l].Name + "】的魔力还有" + enemy[l].Mp);
                            ours[x2].Hp = hp1 - aa6 + a2;
                            num = 0;
                        }
                        else
                        {
                            Console.WriteLine("【" + enemy[l].Name + "】对【" + ours[x2].Name + "】发动【" + skills[hh].Name + "】，产生了暴击，造成【" + a2 + "】伤害，【" + ours[x2].Name + "】的血量还有" + hp1);
                            ours[x2].Hp = hp1;
                        }
                    }
                }
                else
                {
                    //此回合的攻击力
                    int a2 = enemy[l].PhysicsAttack + skills[hh].PhysicsAttack;
                    //是否闪避
                    int b1 = r.Next(0, 10);
                    if (ours.Count == 0) break;
                    if (b1 == 0)
                    {
                        Console.Write("【" + enemy[l].Name + "】对【" + ours[x2].Name + "】发动【" + skills[hh].Name + "】");
                        Console.WriteLine("【" + ours[x2].Name + "】发动【" + skills[8].Name + "】【" + ours[x2].Name + "】的血量还有" + ours[x2].Hp);
                        continue;
                    }
                    int hp1 = ours[x2].Hp - a2;
                    num++;
                    if (hp1 <= 0)
                    {
                        if (num == 4)
                        {
                            int q = r.Next(13, 14);
                            if (enemy[l].Mp - skills[q].MagicAttack <= 0)
                            {
                                enemy[l].Mp = 0;
                                Console.WriteLine("因为魔力值不够，所以【" + enemy[l].Name + "】没有攻击");
                                num = 0;
                                continue;
                            }
                            int aa6 = enemy[l].MagicAttack + skills[q].MagicAttack;
                            enemy[l].Mp -= skills[q].MagicAttack;
                            ours[x2].Hp = 0;
                            Console.WriteLine("【" + enemy[l].Name + "】对【" + ours[x2].Name + "】发动【" + skills[q].Name + "】，产生了暴击，造成【" + aa6 + "】伤害，【" + ours[x2].Name + "】的血量还有" + ours[x2].Hp + "  【" + enemy[l].Name + "】的魔力还有" + enemy[l].Mp);
                            ours.Remove(ours[x2]);
                            Console.Write("奥特曼死了一个，怪兽全体");
                            add(enemy);
                            num = 0;
                        }
                        else
                        {
                            ours[x2].Hp = 0;
                            Console.WriteLine("【" + enemy[l].Name + "】对【" + ours[x2].Name + "】发动【" + skills[hh].Name + "】，造成【" + a2 + "】伤害，【" + ours[x2].Name + "】的血量还有" + ours[x2].Hp);
                            ours.Remove(ours[x2]);
                            Console.Write("奥特曼死了一个，怪兽全体");
                            add(enemy);
                        }
                    }
                    else
                    {
                        if (num == 4)
                        {
                            int q = r.Next(13, 14);
                            if (enemy[l].Mp - skills[q].MagicAttack <= 0)
                            {
                                enemy[l].Mp = 0;
                                Console.WriteLine("因为魔力值不够，所以【" + enemy[l].Name + "】没有攻击");
                                num = 0;
                                continue;
                            }
                            int aa6 = enemy[l].MagicAttack + skills[q].MagicAttack + r.Next(0, 30);
                            enemy[l].Mp -= skills[q].MagicAttack;
                            Console.WriteLine("【" + enemy[l].Name + "】对【" + ours[x2].Name + "】发动【" + skills[q].Name + "】，产生了暴击，造成【" + aa6 + "】伤害，【" + ours[x2].Name + "】的血量还有" + (hp1 - aa6 + a2) + "  【" + enemy[l].Name + "】的魔力还有" + enemy[l].Mp);
                            ours[x2].Hp = hp1 - aa6 + a2;
                            num++;
                        }
                        else
                        {
                            Console.WriteLine("【" + enemy[l].Name + "】对【" + ours[x2].Name + "】发动【" + skills[hh].Name + "】，造成【" + a2 + "】伤害，【" + ours[x2].Name + "】的血量还有" + hp1);
                            ours[x2].Hp = hp1;
                        }
                    }
                }
            }
            #endregion
        }

        //加血加buff
        public void add(List<Hero> array)
        {
            int a = r.Next(0, 2);
            if (array.Count == 0) return;
            if (a==0)
            {
                Console.WriteLine("加血50");
                for (int i = 0; i < array.Count; i++)
                {
                    array[i].Hp += 50;
                }
                }
            else
            {
                Console.WriteLine("加魔力50");
                for (int j = 0; j < array.Count; j++)
                {
                    array[j].Mp += 50;
                }
            }
        }
        //输出血量
        public void print()
        {
            Console.WriteLine();
            for (int c = 0; c < ours.Count; c++)
            {
                Console.WriteLine(ours[c].Name + "\t\t血量：" + ours[c].Hp + "\t魔力量：" + ours[c].Mp + "\t物理攻击力：" + ours[c].PhysicsAttack + "\t魔法攻击力：" + ours[c].MagicAttack);
            }
            Console.WriteLine();
            for (int c = 0; c < enemy.Count; c++)
            {

                if (enemy[c].Name== "雷丘巴斯")
                {
                    Console.WriteLine(enemy[c].Name + "\t血量：" + enemy[c].Hp + "\t魔力量：" + enemy[c].Mp + "\t物理攻击力：" + enemy[c].PhysicsAttack + "\t魔法攻击力：" + enemy[c].MagicAttack);
                    continue;
                }
                Console.WriteLine(enemy[c].Name + "\t\t血量：" + enemy[c].Hp + "\t魔力量：" + enemy[c].Mp + "\t物理攻击力：" + enemy[c].PhysicsAttack + "\t魔法攻击力：" + enemy[c].MagicAttack);
            }
        }
    }
}

