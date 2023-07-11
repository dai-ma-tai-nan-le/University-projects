using System.Collections;
using System.Collections.Generic;
using UnityEngine;
//实现敌人巡逻,敌人AI
public class EnemyMove : MonoBehaviour {
    //巡逻位置管理器:
    List<Transform> targetPoints = new List<Transform>();
    //2:巡逻点的父物体:
    Transform points;
    //3:目标位置:
    Transform target;
    int index = 0;
    //移动速度:
    public float moveSpeed = 5f;
    //旋转速度:
    public float rotateSpeed = 45f;
    Transform player;
    Vector3 offset;
    EnemyAttack attack;
    float timer = 0;
	void Start () {
        attack = GetComponent<EnemyAttack>();
        player = GameObject.Find("Player").transform;
        points = GameObject.Find("points").transform;
        for (int i = 0; i < points.childCount; i++)
        {   //添加到集合当中
            targetPoints.Add(points.GetChild(i));
        }
        //指定巡逻初始位置:
        target = targetPoints[index];
	}
	void Update () {
        if (player == null)
        {
            return;
        }
        offset = player.position - transform.position;
        //敌人和主角距离<3--->攻击
        if (offset.magnitude <= 4)
        {   //强制看向人物
            transform.LookAt(player.position);
            timer += Time.deltaTime;
            if (timer >=0.8f)
            {
                timer = 0;
                //攻击:
                attack.CreateBullet();
            } 
        }
        else if (offset.magnitude >4 && offset.magnitude <= 8)//追击
        {
            Quaternion qua = Quaternion.LookRotation(offset);
            transform.rotation = Quaternion.Lerp(transform.rotation, qua, 0.5f);
            transform.position = Vector3.MoveTowards(transform.position, player.position, Time.deltaTime * moveSpeed);
        }
        else {
            //旋转:
            Quaternion qua = Quaternion.LookRotation(target.position - transform.position);
            transform.rotation = Quaternion.Lerp(transform.rotation,qua,0.5f);
            //巡逻
            transform.position = Vector3.MoveTowards(transform.position, target.position, Time.deltaTime * moveSpeed);
        }
        //判断角色和目标的距离
        if (Vector3.Distance(transform.position,target.position)<0.02f)
        {//切换目标:
            target = targetPoints[++index % targetPoints.Count];
        }
	}
}
