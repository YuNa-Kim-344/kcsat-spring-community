package hpclab.kcsatspringcommunity.community.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostWriteForm {
    private String title;
    private String content;
    private Long qId;
}
