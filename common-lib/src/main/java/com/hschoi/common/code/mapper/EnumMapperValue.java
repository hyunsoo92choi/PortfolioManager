package com.hschoi.common.code.mapper;

import lombok.Getter;
import lombok.ToString;

/**
 * <pre>
 * code.mapper_EnumMapperValue.java
 * </pre>
 * @date : 2019. 6. 11.
 * @author : hychoi
 */
@Getter
@ToString
public class EnumMapperValue {

	private String code;
    private String title;

    public EnumMapperValue(EnumMapperType enumMapperType) {
        code = enumMapperType.getCode();
        title = enumMapperType.getTitle();
    }
    
}
