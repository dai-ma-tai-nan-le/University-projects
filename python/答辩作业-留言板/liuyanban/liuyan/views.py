from audioop import reverse

from django.http import HttpResponse
from django.shortcuts import render
from liuyan.models import LiuyanModel
# Create your views here.
# 留言模块
def liuyan(request):
    if request.method == 'GET':
        # 取出当前在models表中所有的留言信息 ,返回到前端
        liuyansget = LiuyanModel.objects.all()
        return render(request, "lyb.html", context={"liuyansget": liuyansget})
    else:
        # post请求
        print("post request")
        liuyanspost = LiuyanModel.objects.all()
        print (liuyanspost)
        liuyan = LiuyanModel()
        liuyan.name = request.POST.get("name")
        liuyan.email = request.POST.get("email")
        liuyan.address = str(request.POST.get("address").encode()).split('\'')[1]
        liuyan.message = request.POST.get("message")
        liuyan.save()  # 保存到models表中
        return HttpResponse("留言成功")

def lyClear(request):
    LiuyanModel.objects.filter().delete()
    return HttpResponse("全部被清理了")

