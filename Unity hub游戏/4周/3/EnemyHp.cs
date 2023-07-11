using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class EnemyHp : MonoBehaviour {
    public float hp = 100;
    AudioClip clip;//爆炸音效
    GameObject explosion;//爆炸特效
    CreateEnemy create;
    private void Start()
    {
        clip = Resources.Load<AudioClip>("explosion");
        explosion = Resources.Load<GameObject>("Explosion");
        create = GameObject.Find("CreateEnemy").GetComponent<CreateEnemy>();
    }
    void Update () {
        if (hp <=0)
        {
            hp = 0;
            AudioSource.PlayClipAtPoint(clip,transform.position);
            GameObject explo = Instantiate(explosion,transform.position,Quaternion.identity);
            Destroy(explo,1);//销毁爆炸特效
            Destroy(gameObject);//销毁游戏对象
            create.RemoveEnmey(gameObject);
        }
	}
    public void TakeDamage(float value) {
        this.hp -= value;
    }
}
