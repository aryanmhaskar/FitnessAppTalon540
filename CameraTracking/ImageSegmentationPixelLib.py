import pixellib
import ctypes
hlldll = ctypes.WinDLL(C:\Users\pajam\PycharmProjects\PixelLib\libraries\cuda\bin\cudnn64_8.dll)

from pixellib.semantic import semantic_segmentation

segment_image = semantic_segmentation()
segment_image.load_ade20k_model("deeplabv3_xception65_ade20k.h5")
segment_image.segmentAsAde20k("path_to_image", output_image_name= "path_to_output_image")
