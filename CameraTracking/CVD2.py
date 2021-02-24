# -*- coding: utf-8 -*-
"""
Created on Sat Feb 13 13:01:36 2021

@author: phjlj
"""

import cv2 
import numpy as nm
from datetime import datetime
import os
import sys

body_cascade = cv2.CascadeClassifier(r'C:\Users\phjlj\Documents\Python Scripts\haarcascade_fullbody.xml')
upper_cascade = cv2.CascadeClassifier(r'C:\Users\phjlj\Documents\Python Scripts\haarcascade_upperbody.xml')
lower_cascade = cv2.CascadeClassifier(r'C:\Users\phjlj\Documents\Python Scripts\haarcascade_lowerbody.xml')
face_cascade = cv2.CascadeClassifier(r'C:\Users\phjlj\Documents\Datasets\haarcascade_frontalface_default.xml')

cap = cv2.VideoCapture(0)
cap.set(8,640) # set Width
cap.set(8,640) # set Height

def computer_vision_moldule():
    while True:
        ret, img = cap.read()
        gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)
        faces = face_cascade.detectMultiScale(
            gray,     
            scaleFactor=1.2,
            minNeighbors=5,     
            minSize=(20, 20)
        )
        lower = lower_cascade.detectMultiScale(
            gray,     
            scaleFactor=1.2,
            minNeighbors=1,     
            minSize=(20, 20)
        )
        upper = upper_cascade.detectMultiScale(
            gray,     
            scaleFactor=1.2,
            minNeighbors=5,     
            minSize=(20, 20)
        )
        bodies = body_cascade.detectMultiScale(
            gray,     
            scaleFactor=3.4,
            minNeighbors=1,     
            minSize=(20, 20)
        )
        
        for (x,y,w,h) in faces:
                cv2.rectangle(img,(x,y),(x+w,y+h),(255,0,0),3)
                roi_gray = gray[y:y+h, x:x+w]
                roi_color = img[y:y+h, x:x+w]  
            
        for (x,y,w,h) in lower:
                cv2.rectangle(img,(x,y),(x+w,y+h),(0,0,255),3)
                roi_gray = gray[y:y+h, x:x+w]
                roi_color = img[y:y+h, x:x+w]
        
        for (x,y,w,h) in upper:
                cv2.rectangle(img,(x,y),(x+w,y+h),(0,0,300),3)
                roi_gray = gray[y:y+h, x:x+w]
                roi_color = img[y:y+h, x:x+w]
            
        for (x,y,w,h) in bodies:
                cv2.rectangle(img,(x,y),(x+w,y+h),(0,0,255),2)
                roi_gray = gray[y:y+h, x:x+w]
                roi_color = img[y:y+h, x:x+w]   
            
            
        cv2.imshow('video',img)
        k = cv2.waitKey(30) & 0xff
        if k == 27: # press 'ESC' to quit
            break
        
    cap.release()
    cv2.destroyAllWindows()

#main statement
if __name__ == "__main__":
    computer_vision_moldule()
    