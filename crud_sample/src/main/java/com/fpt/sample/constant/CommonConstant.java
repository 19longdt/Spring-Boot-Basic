package com.fpt.sample.constant;

import java.util.Map;

public class CommonConstant {
    public static final String PRODUCT_URL = "/products";
    public static final String PRODUCT_LIST_BY_CATEGORY_URL = "/listProductsByCategory";
    public static final String PRODUCT_LIST_BY_SEARCH_URL = "/listProductsBySearch";

    public static final String CATEGORY_URL = "/categories";
    public static final String CATEGORY_LIST_URL = "/listCategory";

    public static final int SIZE_PER_PAGE = 3;

    public static final String STATUS_URL = "/status";
    public static final Map<Integer, String> MAP_STATUS = Map.ofEntries(Map.entry(0, "Reject"), Map.entry(1, "Waiting"), Map.entry(2, "Available"));
}
