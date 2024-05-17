package br.com.fernandaslomp.casenotafiscalsystem.enums;

import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;
@Getter
@ToString
public enum PaymentTypeEnum {

    BOLETO(1L);

    private static Map<Long,PaymentTypeEnum> BY_ID = new HashMap<>();

    static {
        for (PaymentTypeEnum paymentTypeEnum : PaymentTypeEnum.values()){

            BY_ID.put(paymentTypeEnum.getId(), paymentTypeEnum);

        }
    }

    private Long id;
    PaymentTypeEnum(Long id){this.id = id;}

}
