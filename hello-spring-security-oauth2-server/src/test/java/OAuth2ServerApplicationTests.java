import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Description：
 *
 * @version v1.0.0
 * @author：zj
 * @date：2021­03­05 9:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OAuth2ServerApplicationTests {

    @Test
    public void sum(){
        Student student=new Student();
        student.setId(1);
        student.setAge(10);

        Student student1=new Student();
        student1.setId(2);
        student1.setAge(20);

        List<Student> list=new ArrayList<>();
        list.add(student);
        list.add(student1);

        Integer collect = list.stream().collect(Collectors.summingInt(Student::getId));
        Long collect1 = list.stream().collect(Collectors.counting());
        System.out.println(collect);
        System.out.println(collect1);
    }

    public static void main(String[] args) {
        Student student=new Student(1,10,100);
        Student student1=new Student(2,20,200);
        List<Student> list=new ArrayList<>();
        list.add(student);
        list.add(student1);
        new Sum(1,10);

            //List<Map<String,List<Integer>>>     1    10    20
        Map<Integer, Sum> collect =
                list.stream()
                .collect(Collectors.groupingBy(Student::getId, null));
                        //new Sum(Collectors.summingInt(Student::getAge),Collectors.summingInt(Student::getAge))));
        //.collect(Collectors.toMap(  (e) ->  e.getId(),
                //        (e) -> e.getAge()))
                //  .collect(Collectors.toList());

        //Integer collect = list.stream().collect(Collectors.summingInt(s->
        //     s.getAge()+s.getId()
        //));
    }

    private static String fetchGroupKey(Student user){
        return user.getId() +"#"+ user.getAge();
    }
}
