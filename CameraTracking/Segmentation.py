# -*- coding: utf-8 -*-
"""
Created on Wed Feb 17 18:43:45 2021
@author: phjlj
"""

#imports
import matplotlib.pyplot as plt
import cv2
import skimage

image = r"C:\Users\phjlj\Documents\Datasets\single.jpg"

#class: segmentMap
class segmentMap:
    #instance function
    def __init__(self, dir):
        self.dir = dir
        self.image = cv2.imread(self.dir) #uses cv2 to read the image
    
    #segment with watershed
    def segment(self, enhancement_factor=5):
        self.image = cv2.cvtColor(self.image, cv2.COLOR_BGR2GRAY) #converts from RGB to grayscale
        self.image = skimage.exposure.adjust_gamma(self.image) #segments the image via adjusting the gamma
    
    #show gray segment
    def show(self):
        plt.imshow(self.image, cmap="binary")
        
test = segmentMap(image)
test.segment()
test.show()