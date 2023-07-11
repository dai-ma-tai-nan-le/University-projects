from django.db import models

# Create your models here.
# 创建一个留言信息表
class LiuyanModel(models.Model):
    id = models.AutoField(primary_key=True)
    name = models.CharField(max_length=50)
    email = models.EmailField()
    address = models.CharField(max_length=50)
    message = models.TextField()
    add_time = models.DateTimeField(auto_now=True)

    def __repr__(self):
        return 'LiuyanModel<name = %s ,email=%s ,address = %s,message =%s,addtime =%s>' % (
        self.name, self.email, self.address, self.message, self.add_time)