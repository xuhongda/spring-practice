package springpractice.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author xuhongda on 2018/8/2
 * springpractice.demo.pojo
 * spring-practice
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String name;
    private int  age;

}
