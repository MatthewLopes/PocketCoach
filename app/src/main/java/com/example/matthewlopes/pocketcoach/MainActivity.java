package com.example.matthewlopes.pocketcoach;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

/*//Beginning of added section
    //Setting up listeners
  public class MainActivity extends Activity {
        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
            bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
                @Override
                public void onTabSelected(@IdRes int tabId) {
                    if (tabId == R.id.tab_favorites) {
                        // The tab with id R.id.tab_favorites was selected,
                        // change your content accordingly.
                    }
                }
            });
        }


  bottomBar.setOnTabReselectListener(new OnTabReselectListener() {
        @Override
        public void onTabReSelected(@IdRes int tabId) {
            if (tabId == R.id.tab_favorites) {
                // The tab with id R.id.tab_favorites was reselected,
                // change your content accordingly.
            }
        }
    })

    //Intercepting tab selections
    bottomBar.setTabSelectionInterceptor(new TabSelectionInterceptor() {
    @Override
    public boolean shouldInterceptTabSelection(@IdRes int oldTabId, @IdRes int newTabId) {
        if (newTabId == R.id.tab_pro_feature && !userHasProVersion()) {
          startProVersionPurchaseFlow();
          return true;
        }

        return false;
    }
});

    //Changing icons based on selection state
<selector xmlns:android="http://schemas.android.com/apk/res/android">
    <item android:drawable="@drawable/ic_myicon_selected" android:state_selected="true" />
    <item android:drawable="@drawable/ic_myicon_default" android:state_selected="false" />
</selector>

    //Those color changing tabs look dope. Howdoidodat?
<tabs>
    <tab
        id="@+id/tab_favorites"
        icon="@drawable/ic_favorites"
        title="Favorites"
        barColorWhenSelected="#5D4037" />
    <!-- You can use @color resources too! -->
</tabs>

    //Finally, set bb_behavior to include the underNavbar flag and you're good to go!
<com.roughike.bottombar.BottomBar
    android:id="@+id/bottomBar"
    android:layout_width="match_parent"
    android:layout_height="56dp"
    android:layout_alignParentBottom="true"
    app:bb_tabXmlResource="@xml/my_awesome_bottombar_tabs"
    app:bb_behavior="underNavbar" />

    //End of added section */

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
