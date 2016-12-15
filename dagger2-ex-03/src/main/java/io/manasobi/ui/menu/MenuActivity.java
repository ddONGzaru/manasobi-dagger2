package io.manasobi.ui.menu;

import android.content.Intent;
import android.support.annotation.Nullable;

import butterknife.OnClick;
import io.manasobi.R;
import io.manasobi.base.activity.BaseActivity;
import io.manasobi.internal.di.component.ActivityComponent;
import io.manasobi.ui.main.MainActivity;
import io.manasobi.ui.sql.SqlbriteActivity;

public class MenuActivity extends BaseActivity {

    @Override
    protected int getContentViewResource() {
        return R.layout.activity_menu;
    }

    @Override
    protected ActivityComponent getInitializeCompoent() {
        return null;
    }

    @Override
    protected void onInject(@Nullable ActivityComponent component) {

    }

    @SuppressWarnings("unused")
    @OnClick(R.id.button_dagger_ex)
    public void onDagger2Exclick() {
        onStartActivity(MainActivity.class);
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.button_sqlbrite_ex)
    public void onSqlbriteExClick() {
        onStartActivity(SqlbriteActivity.class);
    }

    private void onStartActivity(Class<?> cls) {
        Intent intent = new Intent(this, cls);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
