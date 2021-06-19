package demo.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class QueryForm {
    @NotBlank(message = "RA cannot be EMPTY")
    //@NonNull
    private String ra;

    @NotBlank(message = "DEC cannot be EMPTY")
    //@NonNull
    private String dec;

}
