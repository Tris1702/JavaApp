from PIL import Image
import cv2 as cv
import csv
import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
from matplotlib import cm
from sklearn import linear_model
from sklearn.metrics import accuracy_score

#training data
dat = pd.read_csv("traingame.csv").to_numpy()
xtrain = dat[..., 1:]
train_label = dat[..., 0]
logreg = linear_model.LogisticRegression(C=1e5, solver = 'lbfgs', multi_class = 'multinomial')
logreg.fit(xtrain, train_label)

#processing
pre_signal = 2
while (True):
    f = open("output.txt", "r")
    data = f.read()
    f.close()
    data = np.fromstring(data, dtype = int, sep = ' ')
    # print(data.shape)
    # continue
    # if (pre_signal == 3) or ((data.size > 0) and (data[0] != pre_signal)):
    if (data.size > 0) and (data[0] != pre_signal):
        pre_signal = data[0]
    else:
        continue
    arr = np.array(data[1:])
    arr.resize(28, 28)
    arr = np.swapaxes(arr, 0, 1)
    # plt.imshow(arr)
    flat_arr = arr.ravel()
    pre = str(logreg.predict([flat_arr]))[1]
    f = open("predict.txt", "w")
    f.write(pre)
    f.close()
    if pre == '0':
        print('nguoc')
    elif pre == '1':
        print('tamgiac')
    elif pre == '2':
        print('thang')
    elif pre == '3':
        print('xoan')
    elif pre == '4':
        print('z')

    # plt.show()
