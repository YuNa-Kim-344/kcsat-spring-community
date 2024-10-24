package hpclab.kcsatspringcommunity.question.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Choice {

    @Id
    @GeneratedValue
    private Long id;

    private String choice;

    public Choice(String choice) {
        this.choice = choice;
    }
}