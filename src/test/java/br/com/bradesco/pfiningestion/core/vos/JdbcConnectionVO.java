package br.com.bradesco.pfiningestion.core.vos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName = "of")
public class JdbcConnectionVO {
    private String url;
    private String driver;
    private String username;
    private String password;
}
