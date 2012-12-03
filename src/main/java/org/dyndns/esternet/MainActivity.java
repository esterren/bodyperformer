package org.dyndns.esternet;

import java.util.ArrayList;
import java.util.List;

import org.dyndns.esternet.db.DatabaseManager;
import org.dyndns.esternet.model.TopicList;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

	private static String TAG = "bodyperformer";

	/**
	 * Called when the activity is first created.
	 * 
	 * @param savedInstanceState
	 *            If the activity is being re-initialized after previously being
	 *            shut down then this Bundle contains the data it most recently
	 *            supplied in onSaveInstanceState(Bundle). <b>Note: Otherwise it
	 *            is null.</b>
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i(TAG, "onCreate");
		// setContentView(R.layout.main);

		DatabaseManager.init(this);

		// String[] values = new String[] { "Scan Product", "Create Entry",
		// "Change weight" };
		// ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
		// R.layout.main, R.id.label, values);
		final List<TopicList> topicList = DatabaseManager.getInstance().getAllTopicLists();
		List<String> titles = new ArrayList<String>();
		for (TopicList t1 : topicList) {
			titles.add(t1.getName());
		}
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.main, R.id.label, titles);

		setListAdapter(adapter);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		String item = (String) getListAdapter().getItem(position);
		Toast.makeText(this, item + " selected", Toast.LENGTH_LONG).show();
	}
}
