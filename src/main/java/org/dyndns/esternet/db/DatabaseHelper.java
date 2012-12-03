package org.dyndns.esternet.db;

import java.util.ArrayList;
import java.util.List;

import org.dyndns.esternet.model.TopicItem;
import org.dyndns.esternet.model.TopicList;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

	private static final String DATABASE_NAME = "bodyperformer.sqlite";
	private static final int DATABASE_VERSION = 1;
	private final String LOG_NAME = getClass().getName();
	// the DAO object we use to access the SimpleData table
	private Dao<TopicList, Integer> topicListDao = null;
	private Dao<TopicItem, Integer> topicItemDao = null;

	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
		try {
			TableUtils.createTable(connectionSource, TopicList.class);
			TableUtils.createTable(connectionSource, TopicItem.class);
			insertStaticTopicListEntries();
		} catch (SQLException e) {
			Log.e(LOG_NAME, "Can't create database", e);
			throw new RuntimeException(e);
		} catch (java.sql.SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

		try {
			List<String> allSql = new ArrayList<String>();
			switch (oldVersion) {
			case 1:
				// allSql.add("alter table AdData add column `new_col` VARCHAR");
				// allSql.add("alter table AdData add column `new_col2` VARCHAR");
			}
			for (String sql : allSql) {
				database.execSQL(sql);
			}
		} catch (SQLException e) {
			Log.e(LOG_NAME, "exception during onUpgrade", e);
			throw new RuntimeException(e);
		}

	}

	public Dao<TopicList, Integer> getTopicListDao() {
		if (null == topicListDao) {
			try {
				topicListDao = getDao(TopicList.class);
			} catch (java.sql.SQLException e) {
				e.printStackTrace();
			}
		}
		return topicListDao;
	}

	public Dao<TopicItem, Integer> getTopicItemDao() {
		if (null == topicItemDao) {
			try {
				topicItemDao = getDao(TopicItem.class);
			} catch (java.sql.SQLException e) {
				e.printStackTrace();
			}
		}
		return topicItemDao;

	}

	private void insertStaticTopicListEntries() {
		TopicList tl1 = new TopicList();
		tl1.setName("Route tracking");
		TopicList tl2 = new TopicList();
		tl2.setName("Change weight");
		try {
			this.getTopicListDao().create(tl1);
			this.getTopicListDao().create(tl2);
		} catch (java.sql.SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
