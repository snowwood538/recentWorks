package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestModel {

    private String duration;
    private String method;
    private String name;
    private String startTime;
    private String endTime;
    private String status;

    @SuppressWarnings("Overriden")
    public String getStartTime() {
        return startTime;
    }
}
