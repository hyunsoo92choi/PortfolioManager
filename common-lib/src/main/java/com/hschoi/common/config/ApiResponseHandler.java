package com.hschoi.common.config;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.hschoi.common.code.httpstatus.HttpStatusType;
import com.hschoi.common.dto.ApiErrorResponseDTO;
import com.hschoi.common.dto.ApiResponseDTO;
import com.hschoi.common.exception.AccountNotFoundException;
import com.hschoi.common.exception.EntityAlreadyExistsException;

/**
 * <pre>
 * com.hschoi.common.config_ExceptionAdvisor.java
 * </pre>
 * @date : 2019. 6. 19.
 * @author : hychoi
 */
@ControllerAdvice
public class ApiResponseHandler implements ResponseBodyAdvice<Object> {
	
	private final Logger log = LoggerFactory.getLogger(ApiResponseHandler.class);
	
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
	
	@ExceptionHandler(value = {
            AccountNotFoundException.class
    })
    @ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
    protected ApiErrorResponseDTO handleAccountNotFoundException(AccountNotFoundException e) {
        final HttpStatusType accountNotFound = HttpStatusType.USER_NOT_FOUND;
        log.error(accountNotFound.getMessage());
        
        return buildError(accountNotFound);
    }
	


    @ExceptionHandler(EntityAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    protected ApiErrorResponseDTO handleConstraintViolationException(EntityAlreadyExistsException e) {
    	final HttpStatusType httpStatusCode = HttpStatusType.ACCOUNT_DUPLICATION;
    	log.debug("ACCOUNT_DUPLICATION occur! : {}", e.getMessage());        
        return buildError(httpStatusCode);
    }

	private List<ApiErrorResponseDTO.FieldError> getFieldErrors(BindingResult bindingResult) {
        
		final List<FieldError> errors = bindingResult.getFieldErrors();
        
		return errors.parallelStream()
                .map(error -> ApiErrorResponseDTO.FieldError.builder()
                        .reason(error.getDefaultMessage())
                        .field(error.getField())
                        .value((String) error.getRejectedValue())
                        .build())
                .collect(Collectors.toList());
    }

    private ApiErrorResponseDTO buildError(HttpStatusType status) {
        return ApiErrorResponseDTO.builder()
                .code(status.getCode())
                .status(status.getStatus())
                .message(status.getMessage())
                .build();
    }

    private ApiErrorResponseDTO buildFieldErrors(HttpStatusType status
    					, List<ApiErrorResponseDTO.FieldError> errors) {
        return ApiErrorResponseDTO.builder()
                .code(status.getCode())
                .status(status.getStatus())
                .message(status.getMessage())
                .errors(errors)
                .build();
    }
	
}
