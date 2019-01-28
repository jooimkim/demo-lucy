package com.example.demo;

import com.nhncorp.lucy.security.xss.XssSaxFilter;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LucyTest {

	@Test
	public void xssEscapeTest() {
		String dirty = "<script>alert('dirty');</script>";

		// IMG element는 허용하나 SRC attribute 안의 javascript는 검출함
//		String dirty1 = "<IMG SRC=\"javascript:alert('XSS');\">";

		String clean = XssSaxFilter.getInstance().doFilter(dirty);

		System.out.println("dirty: " + dirty);
		System.out.println("clean: " + clean);

		assertThat(clean).isNotEqualTo(dirty);
	}
}
