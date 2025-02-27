package com.cdbd.hr.domain.common;

public interface DomainConverter<A, B> {
	
	B convert(A a);
	B convert(A a, Object obj); 

}
