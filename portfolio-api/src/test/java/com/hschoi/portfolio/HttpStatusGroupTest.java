package com.hschoi.portfolio;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hschoi.common.code.httpstatus.HttpStatusType;
import com.hschoi.common.code.mapper.EnumMapperFactory;
import com.hschoi.common.code.mapper.EnumMapperValue;

/**
 * <pre>
 * _HttpStatusGroupTest.java
 * </pre>
 * @date : 2019. 6. 14.
 * @author : hychoi
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HttpStatusGroupTest.class)
public class HttpStatusGroupTest {
	
	private EnumMapperFactory enumMapperFactory;

	@Before
    public void setup () {
        enumMapperFactory = new EnumMapperFactory();
    }
	
	@Test
    public void HttpStatusType_show() throws Exception {
        //given
        final String KEY_HTTPSTATUS = "HTTPSTATUS";
        enumMapperFactory.put(KEY_HTTPSTATUS, HttpStatusType.class);

        //when
        List<EnumMapperValue> enumValues = enumMapperFactory.get(KEY_HTTPSTATUS);

        //then
        assertThat(enumValues.size()).isEqualTo(9);

        enumValues.forEach(e -> System.out.println(e.toString()));
    }
}
