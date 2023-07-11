
from django.urls import path
from liuyan.views import liuyan
from liuyan.views import lyClear

urlpatterns = [
    path('liuyan/',liuyan),
    path('lyClear/',lyClear),
]