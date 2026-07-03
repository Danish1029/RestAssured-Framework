package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    public Long id;

    public Long petId;

    public Integer quantity;

    public String shipDate;

    public String status;

    public Boolean complete;

}