package org.dyndns.esternet.db;

import java.sql.SQLException;
import java.util.List;

import org.dyndns.esternet.model.TopicList;

import android.content.Context;

public class DatabaseManager {

	static private DatabaseManager instance;

	static public void init(Context ctx) {
		if (null == instance) {
			instance = new DatabaseManager(ctx);
		}
	}

	static public DatabaseManager getInstance() {
		return instance;
	}

	private DatabaseHelper helper;

	private DatabaseManager(Context ctx) {
		helper = new DatabaseHelper(ctx);
	}

	private DatabaseHelper getHelper() {
		return helper;
	}

	public List<TopicList> getAllTopicLists() {
		List<TopicList> topicLists = null;
		try {
			topicLists = getHelper().getTopicListDao().queryForAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return topicLists;
	}

}
