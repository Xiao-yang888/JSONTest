package com.btc.connect;

import com.alibaba.fastjson.JSONObject;

public class JSONDemo {
    public static void main(String[] args) {
        System.out.println("hello world");

        Student student = new Student();
        student.setName("下铺老周");
        student.setAge(20);
        student.setSex("male");

        System.out.println("学生姓名：" + student.name);
        System.out.println("学生年龄：" + student.age);
        System.out.println("学生性别：" + student.sex);

        //序列化操作
        JSONObject object = (JSONObject) JSONObject.toJSON(student);
        String objStr = object.toJSONString();
        System.out.println(objStr);

        //反序列化
        Student laozhou = JSONObject.parseObject(objStr, Student.class);
        System.out.println(laozhou.name);


        //第二种序列化的方式
        //实例化一个程序员的json实例
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","小洋");
        jsonObject.put("sex","男");
        jsonObject.put("slogn","小手一撮，又是一个人过冬哦");
        jsonObject.put("languages","java,go,python");
        String codeJson = jsonObject.toJSONString();
        System.out.println(codeJson);
    }
    static class Student {
        private String name;//姓名
        private int age;//年龄
        private String sex;//性别

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }
    }
}
