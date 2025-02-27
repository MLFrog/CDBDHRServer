package com.cdbd.hr.domain.att.Shift;

import java.sql.Timestamp;

import com.cdbd.hr.domain.common.DomainEntity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@DomainEntity
public class Shift {

    private String shiftId;
    private String shiftName;
    private String baseDay;
    private String useYn;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
