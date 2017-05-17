package com.kurone.ireader.utils;

import com.kurone.ireader.R;
import com.kurone.ireader.app.App;
import com.kurone.ireader.entity.Book;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kurone on 2017/5/16.
 */

public class BookSearchManager {
    public static List<Book> getBookList() {
        List<Book> sourceList = new ArrayList<>();
        File bookPath = null;
        String[] bookFileName = null;
        try {
            bookFileName = App.app.getAssets().list("");
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String name : bookFileName) {
            if (name.contains("txt")){
                sourceList.add(new Book(R.drawable.icon_text_plain, name));
            }
        }
        return sourceList;
    }
}
