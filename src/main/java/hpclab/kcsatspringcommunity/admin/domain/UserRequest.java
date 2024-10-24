package hpclab.kcsatspringcommunity.admin.domain;

import hpclab.kcsatspringcommunity.BaseTimeEntity;
import hpclab.kcsatspringcommunity.admin.dto.RequestType;
import jakarta.persistence.Column;
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
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest extends BaseTimeEntity {

    @Id @GeneratedValue
    private Long id;

    private RequestType type;

    @Column(length = 2048)
    private String content;

    private String username;
    private Long qId;
}
