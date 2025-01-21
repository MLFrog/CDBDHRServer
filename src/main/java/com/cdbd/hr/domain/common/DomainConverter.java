package com.cdbd.hr.domain.common;

public interface DomainConverter<A, B> {
	B convert(A a);
}
