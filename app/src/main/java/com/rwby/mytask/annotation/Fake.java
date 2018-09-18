package com.rwby.mytask.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * 假数据
 * Created by JZL on 2017/9/8.
 */
@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Fake {
}
