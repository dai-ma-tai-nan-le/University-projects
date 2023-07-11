using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerMove : MonoBehaviour {
    GameObject bullet;
    Transform fire;
    AudioClip explosion;
    GameObject Explosion;
    AudioClip weaponClip;
	void Start () {
        //子弹
        bullet = Resources.Load<GameObject>("bullet");
        //发射位置
        fire = transform.GetChild(0).GetChild(0).GetChild(0);
        //攻击音效
        weaponClip = Resources.Load("weapon_enemy") as AudioClip;
        //爆炸特效
        Explosion = Resources.Load("Explosion") as GameObject;
        //爆炸音效
        explosion = Resources.Load<AudioClip>("explosion");
    }

    public float hp = 200;
	void Update () {
        float hor = Input.GetAxis("Horizontal");
        float ver = Input.GetAxis("Vertical");
        transform.position += transform.forward * ver * Time.deltaTime * 10f;
        transform.Rotate(transform.up*hor*Time.deltaTime*60f);
        if (Input.GetMouseButtonDown(0))
        {
            //生成子弹:
            GameObject obj = Instantiate(bullet,fire.position,transform.rotation);
            AudioSource.PlayClipAtPoint(weaponClip,transform.position);
            Destroy(obj,2f);
        }
        //死亡:
        if (hp<=0)
        {
            hp = 0;
            GameObject obj = Instantiate(Explosion, transform.position, transform.rotation);
            AudioSource.PlayClipAtPoint(explosion,transform.position);
            Destroy(obj,1f);
            Destroy(gameObject);
            Time.timeScale = 0;//游戏暂停,而且是能暂停和时间相关的
        }
	}


    public void BeiAttack(float value) {
        this.hp -= value;
    }
}
