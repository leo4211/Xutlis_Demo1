package test.liuyang.com.xutlis_demo.pojo;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

/**
 * Created by Administrator on 2016/8/10.
 */

@Table(name ="stu" )
public class Student {
    @Column(name = "id",isId = true)   //isId  代表的是是否是主键
    private  int id;
    @Column(name = "name")
    private  String  name;
    @Column(name = "gender")
    private   String gender;
    @Column(name = "age")
    private   int  age;








}
