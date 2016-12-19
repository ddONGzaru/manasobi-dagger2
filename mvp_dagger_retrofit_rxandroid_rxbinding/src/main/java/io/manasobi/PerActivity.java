package io.manasobi;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by tw.jang on 2016-12-19.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {}
