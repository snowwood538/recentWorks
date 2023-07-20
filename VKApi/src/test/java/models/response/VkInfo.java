package models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class VkInfo {
    @JsonProperty("post_id")
    private Integer postId;
    @JsonProperty("from_id")
    private String fromId;
    private String text;
    @JsonProperty("upload_url")
    private String uploadUrl;
    private Integer id;
    private Likes likes;
}
