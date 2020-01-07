// CatContronller.aidl
package com.example.hero.aidlproject;

//必须申明包含进来,只要有用到它
import com.example.hero.aidlproject.RequestCallBack;

interface CatContronller {
   void request(in RequestCallBack callBack);
   void alertData(String something);
}
