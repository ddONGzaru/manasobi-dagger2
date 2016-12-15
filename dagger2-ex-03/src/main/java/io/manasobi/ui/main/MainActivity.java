package io.manasobi.ui.main;

import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.OnClick;
import io.manasobi.R;
import io.manasobi.base.activity.BaseActivity;
import io.manasobi.base.model.Bike;
import io.manasobi.base.model.Vehicle;
import io.manasobi.internal.di.component.ActivityComponent;
import io.manasobi.internal.di.module.BikeModule;

public class MainActivity extends BaseActivity {

    @Bind(R.id.text_vehicle_result)
    TextView textVehicleResult;

    @Bind(R.id.text_bike_result)
    TextView textBikeResult;

    @Inject
    Vehicle vehicle;

    @Inject
    Bike bike;

    @Override
    protected int getContentViewResource() {
        return R.layout.activity_main;
    }

    @Override
    protected ActivityComponent getInitializeCompoent() {
        return DaggerMainActivityComponent.builder()
                .applicationComponent(getApplicationComponent())
                .mainActivityModule(new MainActivityModule(this))
                .bikeModule(new BikeModule())
                .build();
    }

    @Override
    protected void onInject(@Nullable ActivityComponent component) {
        if (component != null) {
            ((MainActivityComponent) component).inject(this);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.button_vehicle_increase_speed)
    public void onSpeedIncreaseClick() {
        this.vehicle.increaseSpeed(10);
        this.textVehicleResult.setText("vehicle speed : " + vehicle.getSpeed());
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.button_vehicle_brake)
    public void onVehicleBrake() {
        this.vehicle.stop();
        this.textVehicleResult.setText("vehicle speed : " + vehicle.getSpeed());
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.button_bike_increase_speed)
    public void onBikeIncreaseSpeed() {
        this.bike.increaseSpped();
        this.textBikeResult.setText("bike speed : " + bike.getSpeed());
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.button_bike_decrease_speed)
    public void onBikeDecreaseSpeed() {
        this.bike.decreaseSpeed();
        this.textBikeResult.setText("bike speed : " + bike.getSpeed());
    }
}
