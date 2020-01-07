// BookController.aidl
package com.example.hero.aidlproject;
import com.example.hero.aidlproject.Book;
// Declare any non-default types here with import statements

interface BookController {
    List<Book> getBookList();
    void addBookInOut(inout Book book);
}
