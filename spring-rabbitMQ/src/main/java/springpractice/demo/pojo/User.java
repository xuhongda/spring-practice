package springpractice.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author xuhongda on 2018/8/2
 * springpractice.demo.pojo
 * spring-practice
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private String name;
    private int  age;

}
