package com.xzc.demo.caffeine;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * @author :  xuzhicheng
 * @description :  高性能缓存caffeine case
 * @createDate :  2020/12/12 11:56
 */
public class TestCaffeine {

    public static void main(String[] args) {

//        Cache<Long, User> cache = Caffeine.newBuilder()
//                .expireAfterWrite(1, TimeUnit.MINUTES)
//                .maximumSize(2)
//                .build();
//        cache.put(1L, new User(1L, "小猴"));
//        cache.put(2L, new User(2L, "小猴"));
//        cache.put(3L, new User(3L, "小猴"));
//        System.out.println(cache.getIfPresent(1L));
//        System.out.println(cache.get(1L, k -> new User(k,"小徐")));
//
//        System.out.println(cache.asMap());

        LoadingCache<Long , User> loadingCache = Caffeine.newBuilder()
                .expireAfterWrite(1, TimeUnit.MINUTES)
                .maximumSize(2)
                .build(key -> new User(key));
        System.out.println(loadingCache.asMap());
        loadingCache.getAll(Arrays.asList(1L,2L,3L));
        System.out.println(loadingCache.asMap());
        System.out.println(loadingCache.estimatedSize());
        loadingCache.cleanUp();
        System.out.println(loadingCache.asMap());

    }
}
