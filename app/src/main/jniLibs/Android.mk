LOCAL_PATH_TOP := $(call my-dir)

include $(CLEAR_VARS)
LOCAL_PATH := $(LOCAL_PATH_TOP)/../jniLibs/$(TARGET_ARCH_ABI)
LOCAL_MODULE := EasyAR
LOCAL_SRC_FILES := libEasyAR.so
include $(PREBUILT_SHARED_LIBRARY)

include $(CLEAR_VARS)
LOCAL_PATH := $(LOCAL_PATH_TOP)
LOCAL_LDLIBS += -llog -lGLESv2 -lEGL
LOCAL_SHARED_LIBRARIES += EasyAR
LOCAL_CPP_EXTENSION := .cc
LOCAL_MODULE := HelloAR
LOCAL_SRC_FILES := jni.cc helloar.cc boxrenderer.cc renderer.cc
include $(BUILD_SHARED_LIBRARY)
