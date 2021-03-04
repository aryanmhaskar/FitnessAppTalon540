
import cv2 
import numpy as nm
from datetime import datetime
from os.path import dirname, join
import os
import sys

body_cascade = cv2.CascadeClassifier(cv2.data.haarcascades + 'haarcascade_fullbody.xml')
upper_cascade = cv2.CascadeClassifier(cv2.data.haarcascades + 'haarcascade_upperbody.xml')
lower_cascade = cv2.CascadeClassifier(cv2.data.haarcascades + 'haarcascade_lowerbody.xml')
face_cascade = cv2.CascadeClassifier(cv2.data.haarcascades + 'haarcascade_frontalface_default.xml')

cap = cv2.VideoCapture(0)
cap.set(8,1000) # set Width
cap.set(8,1000) # set Height

def poseDetector(frame):
    bodyParts = { "Nose": 0, "Neck": 1, "RShoulder": 2, "RElbow": 3, "RWrist": 4,
               "LShoulder": 5, "LElbow": 6, "LWrist": 7, "RHip": 8, "RKnee": 9,
               "RAnkle": 10, "LHip": 11, "LKnee": 12, "LAnkle": 13, "REye": 14,
               "LEye": 15, "REar": 16, "LEar": 17, "Background": 18 }

    posePairs = [ ["Nose", "Neck"], ["Neck", "RShoulder"], ["Neck", "LShoulder"], ["RShoulder", "RElbow"],
                   ["RElbow", "RWrist"], ["LShoulder", "LElbow"], ["LElbow", "LWrist"],
                   ["Neck", "RHip"], ["RHip", "RKnee"], ["RKnee", "RAnkle"], ["Neck", "LHip"],
                   ["LHip", "LKnee"], ["LKnee", "LAnkle"], ["LHip", "RHip"], ["LShoulder", "RShoulder"] ]
    
    width, inWidth = 368, 368
    height, inHeight = 368, 368

    graph_opt = join(dirname(__file__), "graph_opt.pb")
    convNet = cv2.dnn.readNetFromTensorflow(graph_opt)
    thr = 0.2
    
    frameWidth = frame.shape[1]
    frameHeight = frame.shape[0]
    
    convNet.setInput(cv2.dnn.blobFromImage(frame, 1.0, (inWidth, inHeight), (127.5, 127.5, 127.5), swapRB=True, crop=False))
    out = convNet.forward()
    out = out[:, :19, :, :]  # MobileNet output [1, 57, -1, -1], we only need the first 19 elements

    assert(len(bodyParts) == out.shape[1])

    points = []
    for i in range(len(bodyParts)):
        # Slice heatmap of corresponging body's part.
        heatMap = out[0, i, :, :]

        _, conf, _, point = cv2.minMaxLoc(heatMap)
        x = (frameWidth * point[0]) / out.shape[3]
        y = (frameHeight * point[1]) / out.shape[2]
        points.append((int(x), int(y)) if conf > thr else None)

    for pair in posePairs:
        partFrom = pair[0]
        partTo = pair[1]
        assert(partFrom in bodyParts)
        assert(partTo in bodyParts)

        idFrom = bodyParts[partFrom]
        idTo = bodyParts[partTo]

        if points[idFrom] and points[idTo]:
            cv2.line(frame, points[idFrom], points[idTo], (0, 250, 0), 5)
            cv2.ellipse(frame, points[idFrom], (3, 3), 0, 0, 360, (225, 0, 0), cv2.FILLED)
            cv2.ellipse(frame, points[idTo], (3, 3), 0, 0, 360, (225, 0, 0), cv2.FILLED)

    t, _ = convNet.getPerfProfile()
    return frame

def computer_vision_module():
    while True:
        ret, img = cap.read()
        faces = face_cascade.detectMultiScale(
            img,     
            scaleFactor=1.2,
            minNeighbors=5,     
            minSize=(20, 20)
        )
        lower = lower_cascade.detectMultiScale(
            img,     
            scaleFactor=1.2,
            minNeighbors=1,     
            minSize=(20, 20)
        )
        upper = upper_cascade.detectMultiScale(
            img,     
            scaleFactor=1.2,
            minNeighbors=5,     
            minSize=(20, 20)
        )
        bodies = body_cascade.detectMultiScale(
            img,     
            scaleFactor=3.4,
            minNeighbors=1,     
            minSize=(20, 20)
        )
        
        for (x,y,w,h) in faces:
                cv2.rectangle(img,(x,y),(x+w,y+h),(255,0,0),3)
                roi_gray = img[y:y+h, x:x+w]
                roi_color = img[y:y+h, x:x+w]  
            
        for (x,y,w,h) in lower:
                cv2.rectangle(img,(x,y),(x+w,y+h),(0,0,255),3)
                roi_gray = img[y:y+h, x:x+w]
                roi_color = img[y:y+h, x:x+w]
        
        for (x,y,w,h) in upper:
                cv2.rectangle(img,(x,y),(x+w,y+h),(0,0,300),3)
                roi_gray = img[y:y+h, x:x+w]
                roi_color = img[y:y+h, x:x+w]
            
        for (x,y,w,h) in bodies:
                cv2.rectangle(img,(x,y),(x+w,y+h),(0,0,255),2)
                roi_gray = img[y:y+h, x:x+w]
                roi_color = img[y:y+h, x:x+w]   
            
        img = poseDetector(img)
        cv2.imshow('video',img)
        k = cv2.waitKey(30) & 0xff
        if k == 27: # press 'ESC' to quit
            break
        
    cap.release()
    cv2.destroyAllWindows()

#main statement
if __name__ == "__main__":
    computer_vision_module()
