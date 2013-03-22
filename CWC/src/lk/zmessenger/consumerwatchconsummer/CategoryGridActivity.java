package lk.zmessenger.consumerwatchconsummer;

import lk.zmessenger.consumerwatchconsummer.httpclient.CategoryList;
import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.widget.GridView;

public class CategoryGridActivity extends Activity {

	GridView gridview;

	private DisplayMetrics metrics;
	


	@Override
	protected void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_category_grid);
		// Show the Up button in the action bar.
		setupActionBar();

		gridview = (GridView) findViewById(R.id.gridview);
		metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		CategoryList clist = new CategoryList();
		clist.getCategoryList(CategoryGridActivity.this, gridview);

	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.category_grid, menu);
//		return true;
//	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onPause() {
		// Whenever this activity is paused (i.e. looses focus because another
		// activity is started etc)
		// Override how this activity is animated out of view
		// The new activity is kept still and this activity is pushed out to the
		// left
		overridePendingTransition(R.anim.hold, R.anim.push_out_to_left);
		super.onPause();
	}

}
