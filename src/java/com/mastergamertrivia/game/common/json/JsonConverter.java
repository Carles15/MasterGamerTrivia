package com.mastergamertrivia.game.common.json;

public interface JsonConverter {
    public String toJson(Object object);
    public Object fromJson(String json, Class clazz);
}
