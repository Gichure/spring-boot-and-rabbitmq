package com.pgichure.springsamples.messaging.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Order implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<String> items;

    public BigDecimal cost;

    @Override
    public String toString(){
        return "All items - ".concat(String.valueOf(items.size())).concat("shall costs ").concat(String.valueOf(this.cost));
    }

}