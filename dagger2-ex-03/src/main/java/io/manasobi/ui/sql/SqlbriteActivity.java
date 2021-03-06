package io.manasobi.ui.sql;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.squareup.sqlbrite.BriteDatabase;

import javax.inject.Inject;

import io.manasobi.R;
import io.manasobi.base.activity.BaseActivity;
import io.manasobi.internal.di.component.ActivityComponent;
import io.manasobi.ui.sql.fragment.ItemsFragment;
import io.manasobi.ui.sql.fragment.ListsFragment;
import io.manasobi.ui.sql.fragment.NewItemFragment;
import io.manasobi.ui.sql.fragment.NewListFragment;

public class SqlbriteActivity extends BaseActivity implements ListsFragment.OnListsFragmentListener, ItemsFragment.OnItemsFragmentListener {

    @Inject
    BriteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frame_container, ListsFragment.newInstance())
                    .commit();
        }
    }

    @Override
    protected int getContentViewResource() {
        return R.layout.activity_sqlbrite;
    }

    @Override
    protected ActivityComponent getInitializeCompoent() {
        return DaggerSqlbriteActivityComponent.builder()
                    .applicationComponent(getApplicationComponent())
                    .sqlbriteActivityModule(new SqlbriteActivityModule())
                    .build();
    }

    @Override
    protected void onInject(@Nullable ActivityComponent component) {
        if (component != null) {
            ((SqlbriteActivityComponent) component).inject(this);
        }
    }

    @Override
    public void onListClicked(long id) {
        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left,
                        R.anim.slide_out_right)
                .replace(android.R.id.content, ItemsFragment.newInstance(id))
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onNewListClicked() {
        NewListFragment.newInstance().show(getSupportFragmentManager(), "new-list");
    }

    @Override
    public void onNewItemClicked(long listId) {
        NewItemFragment.newInstance(listId).show(getSupportFragmentManager(), "new-item");
    }
}
