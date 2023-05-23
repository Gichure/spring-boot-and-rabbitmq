package com.pgichure.springsamples.messaging.models;


@Data
@Builder
public class Order implements Serializable{

    private List<String> items;

    public BigDecimal cost;

    @override
    public String toString(){

        return this.items.concat("\n").concat(this.cost);

    }

}