package io.manasobi.ui.sql;

import android.support.annotation.NonNull;

import dagger.Component;
import io.manasobi.internal.di.PerActivity;
import io.manasobi.internal.di.component.ActivityComponent;
import io.manasobi.internal.di.component.ApplicationComponent;
import io.manasobi.ui.sql.fragment.ItemsFragment;
import io.manasobi.ui.sql.fragment.ListsFragment;
import io.manasobi.ui.sql.fragment.NewItemFragment;

@PerActivity
@Component(
        dependencies = ApplicationComponent.class,
        modules = {
                SqlbriteActivityModule.class
        }
)
public interface SqlbriteActivityComponent extends ActivityComponent {

        void inject(@NonNull SqlbriteActivity sqlbriteActivity);

        void inject(@NonNull ListsFragment fragment);

        void inject(@NonNull NewItemFragment newItemFragment);

        void inject(@NonNull ItemsFragment itemsFragment);
}
