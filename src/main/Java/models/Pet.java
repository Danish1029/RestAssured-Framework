package models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pet {

    public Long id;

    public Category category;

    public String name;

    public List<String> photoUrls;

    public List<Tag> tags;

    public String status;

}