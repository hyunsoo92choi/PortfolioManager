package com.hschoi.common.config;

import java.lang.annotation.Annotation;

import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.hschoi.common.code.httpstatus.HttpStatusType;
import com.hschoi.common.dto.ApiErrorResponseDTO;
import com.hschoi.common.dto.ApiResponseDTO;
import com.hschoi.common.exception.InvalidAccessException;
import com.hschoi.common.exception.PasswordConfirmNotMatching;

/**
 * <pre>
 * com.hschoi.common.config_ApiResponseHandler.java
 * </pre>
 * @date : 2019. 6. 17.
 * @author : hychoi
 */
@ControllerAdvice
public class ApiResponseHandler implements ResponseBodyAdvice<Object> {

	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		return true;
	}

	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
			ServerHttpResponse response) {
		
		HttpStatus httpStatus = HttpStatus.OK;

        Object ret = null;
        
        if (body instanceof ApiResponseDTO) {
        	
        	ApiResponseDTO apiResponse = (ApiResponseDTO) body;

            try {
                
            	httpStatus = HttpStatus.valueOf(apiResponse.getCode());
                response.setStatusCode(httpStatus);

                ret = response;
            }
            catch (IllegalArgumentException ex) {}
        }
        else {
            
        	for (Annotation annotation : returnType.getMethodAnnotations()) {
                
        		if (annotation instanceof ResponseStatus) {
                    ResponseStatus responseStatus = (ResponseStatus) annotation;
                    httpStatus = responseStatus.value();
                    break;
                }
            }
            ret = new ApiResponseDTO(httpStatus.value(), httpStatus.getReasonPhrase(), body);
        }

        return ret;
    }
	@ExceptionHandler(value = {PasswordConfirmNotMatching.class})
	@ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrorResponseDTO handleNotFoundException (final Exception e) {
		
        return new ApiErrorResponseDTO(e.getMessage(),HttpStatus.NOT_FOUND.toString() ,HttpStatusType.USERNAME_NOT_FOUND.getStatus());
    }

	@ExceptionHandler(value = { InvalidAccessException.class
			                  }
					 )
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiErrorResponseDTO handleBadRequestException(final Exception e) {
		 return new ApiErrorResponseDTO(e.getMessage(),HttpStatus.BAD_REQUEST.toString() ,HttpStatusType.USERNAME_NOT_FOUND.getStatus());
	}

}
