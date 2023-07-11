using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace reply
{
    class Hero
    {
        //英雄名字
        private string name;
        //血量
        private int hp = 200;
        //魔法值
        private int mp = 100;
        //物理攻击力
        private int physicsAttack;
        //魔法攻击力
        private int magicAttack;

        public string Name { get => name; set => name = value; }
        public int PhysicsAttack { get => physicsAttack; set => physicsAttack = value; }
        public int MagicAttack { get => magicAttack; set => magicAttack = value; }
        public int Hp { get => hp; set => hp = value; }
        public int Mp { get => mp; set => mp = value; }
    }
}
