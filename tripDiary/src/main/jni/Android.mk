LOCAL_PATH:=$(call my-dir)
include $(CLEAR_VARS)
LOCAL_SRC_FILES := TripDiary.cpp
LOCAL_MODULE := TripDiary
include $(BUILD_SHARED_LIBRARY)
