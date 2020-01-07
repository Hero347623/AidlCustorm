// RequestCallBack.aidl
package com.example.hero.aidlproject;
//必须申明包含进来,只要有用到它
import com.example.hero.aidlproject.BeanClass;

//接口回调
interface RequestCallBack {
   void onRecall(inout BeanClass beans);
}
