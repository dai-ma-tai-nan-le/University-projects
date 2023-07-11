import pandas as pd
from sklearn.preprocessing import MinMaxScaler
#按文件读取整个文件
data=pd.read_csv('LTtest.csv',low_memory=False)
#去除唯一属性
data=data.drop('user_id',axis=1)
#删除含空的行和列：缺失值
data=data.dropna()
com=data.columns
data=MinMaxScaler().fit_transform(data)
data=pd.DataFrame(data)
data.columns=com
data.head()