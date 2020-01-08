package com.example.hero.aidlcustom

import android.app.Activity
import android.content.ComponentName
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.View
import com.example.hero.aidlproject.*

class CustomActivity :Activity(), RequestCallBack {
    override fun asBinder(): IBinder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onRecall(beans: BeanClass?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private val TAG="ClientPrint"
    private var catContronller:CatContronller?=null
    private var connected=false
    private var books:List<Book>?=null
    private var num=1
    private var bookController: BookController?=null

    private val serviceConnection = object : ServiceConnection {
        override fun onServiceConnected(componentName: ComponentName, service: IBinder) {
            catContronller=CatContronller.Stub.asInterface(service)
            connected=true
            Log.e(TAG, "链接成功:connected=$connected")
        }

        override fun onServiceDisconnected(componentName: ComponentName) {
            connected=false
            Log.e(TAG, "链接失败:connected=$connected")
        }
    }

    private val clickListener= View.OnClickListener { view ->
        when(view.id){
            R.id.bt_get_content->{
                if (connected){
                    Log.e(TAG, "尝试获取书籍:connected=$connected")
                    try {
                        books=bookController!!.bookList
                    }catch (e:Exception){
                        e.printStackTrace()
                        Log.e(TAG,"获取书籍遇到问题了:${e.message}")
                    }
                    printBooks(books)
                }
            }
            R.id.bt_add->{
                if (connected){
                    Log.e(TAG, "尝试添加书籍:connected=$connected")
                    val book=Book("这是一本新书InOut:$num",200)
                    try {
                        Log.e(TAG,"往服务端以InOut方式添加了一本新书:"+book.name)
                        bookController!!.addBookInOut(book)
                        Log.e(TAG,"添加书籍之后,服务端改书名为:"+book.name)
                    }catch (e:Exception){
                        e.printStackTrace()
                        Log.e(TAG,"添加书籍遇到问题了:${e.message}")
                    }
                }
            }
        }
    }

    private fun printBooks(books: List<Book>?) {
        if (books!=null){
            Log.e(TAG, "获取到书了!")
            books.forEach{
                Log.i(TAG,"书:$it")
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custorm)
    }
}