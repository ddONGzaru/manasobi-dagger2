package io.manasobi.internal.di.module;

import com.squareup.sqlbrite.BriteDatabase;
import com.squareup.sqlbrite.SqlBrite;

import android.content.Context;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.manasobi.base.database.DbOpenHelper;

@Module
public class DataBaseModule {

    private Context context;

    public DataBaseModule(@NonNull Context context) {

        this.context = context;
    }

    @Singleton
    @Provides
    public DbOpenHelper provideDataBaseHelper() {
        return new DbOpenHelper(this.context);
    }

    @Singleton
    @Provides
    public SqlBrite provideSqlBrite() {
        return SqlBrite.create();
    }

    @Singleton
    @Provides
    public BriteDatabase provideBriteDataBase(SqlBrite sqlBrite, DbOpenHelper helper) {
        return sqlBrite.wrapDatabaseHelper(helper);
    }
}
