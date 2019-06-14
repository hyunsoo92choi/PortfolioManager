package com.hschoi.common.code.httpstatus;
/**
 * <pre>
 * code.httpstatus_HttpStatusGroup.java
 * </pre>
 * @date : 2019. 6. 14.
 * @author : hychoi
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum HttpStatusGroup {
	CLIENT("Cleint", Arrays.asList(HttpStatusType.PASSWORD_CONFIRM_NOT_MATCHING
			      , HttpStatusType.USERNAME_NOT_FOUND, HttpStatusType.BAD_CREDENTIIALS
				  , HttpStatusType.INPUT_VALUE_INVALID, HttpStatusType.INVALID_ACCESS))
  , SERVER("Server", Arrays.asList(HttpStatusType.SERVICE_UNAVAILABLE))
  , SUCCESS("Success", Arrays.asList(HttpStatusType.OK, HttpStatusType.ACCEPTED))
  , EMPTY("없음", Collections.emptyList());

    private String title;
    private List<HttpStatusType> httpStatusList;

    HttpStatusGroup(String title, List<HttpStatusType> httpStatusList) {
        this.title = title;
        this.httpStatusList = httpStatusList;
    }

    public static HttpStatusGroup findByPayType(HttpStatusType httpStatusType){
        
    	return Arrays.stream(HttpStatusGroup.values())
                .filter(httpStatusGroup -> httpStatusGroup.hasHttpStatusCode(httpStatusType))
                .findAny()
                .orElse(EMPTY);
    }

    public boolean hasHttpStatusCode(HttpStatusType httpStatusType){
        return httpStatusList.stream()
                .anyMatch(httpStatus -> httpStatus == httpStatusType);
    }

    public String getTitle() {
        return title;
    }

}
