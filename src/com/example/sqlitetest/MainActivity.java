package com.example.sqlitetest;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends Activity {

	private DatabaseHelper databaseHelper;
	private SQLiteDatabase database = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		databaseHelper = new DatabaseHelper(this);
		database = databaseHelper.getReadableDatabase();
		//注意：只有调用databaseHelper.getReadableDatabase()的时候才会将数据库创建（如果原来没有数据库，有的话直接打开），new DatabaseHelper(this)是不
		//会创建数据库的，创建的数据库可以在DDMS中看见。
		databaseHelper.deleteDatabase(this);
		//注意：加了这句话后，就可以删除数据库，在DDMS中就看不到了。
	}
}
