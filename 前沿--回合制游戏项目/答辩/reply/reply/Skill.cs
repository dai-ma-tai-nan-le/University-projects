using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace reply
{
    class Skill
    {
        //技能名
        private string name;
        //物理攻击力
        private int physicsAttack;
        //魔法攻击力
        private int magicAttack;

        public string Name { get => name; set => name = value; }
        public int PhysicsAttack { get => physicsAttack; set => physicsAttack = value; }
        public int MagicAttack { get => magicAttack; set => magicAttack = value; }
    }
}
