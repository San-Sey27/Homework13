package person;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Person> listJava = new ArrayList<>();
        List<Person> listJs = new ArrayList<>();
        Person pers1 = new Person("Иванов", "Иван", "Иванович", "15.05.2000");
        Person pers2 = new Person("Петров", "Петр", "Петрович", "15.03.2010");
        Person pers3 = new Person("Максименко", "Максим", "Максимович", "15.10.2005");
        Person pers4 = new Person("Новиков", "Борис", "Олегович", "02.02.2002");
        Person pers5 = new Person("Смирнов", "Степан", "Васильевич", "17.05.2003");
        Person pers6 = new Person("Устинов", "Николай", "Сергеевич", "16.02.2001");
        Person pers7 = new Person("Авдеев", "Виктор", "Петрович", "13.08.2005");
        Person pers8 = new Person("Бирюков", "Игорь", "Андреевич", "02.05.2001");

        listJava.add(pers1);
        listJava.add(pers2);
        listJava.add(pers3);
        listJava.add(pers4);

        listJs.add(pers5);
        listJs.add(pers6);
        listJs.add(pers7);

        Person pers1Clone = new Person(pers1);
        pers1Clone.setName("Макар");
        System.out.println(pers1Clone.toString());
        System.out.println(pers1.toString());


        Group java = new Group("Java", "14.10.19", 32, 2, listJava);
        Group js = new Group("JS", "25.03.19", 22, 2, listJs);

        Group javaClone = new Group(java);
        javaClone.setNameCourse("JavaClone");
        System.out.println(javaClone.toString());
        System.out.println(java.toString());


        System.out.println(pers3.shortName());
        System.out.println(pers3.numberOfYears());
        System.out.println(pers3.AllName());


        System.out.println(java.nameGroup());
        java.printStudents(listJava);
        java.addStudent(pers8);
        java.addStudent(pers1Clone);
        System.out.println("==============");

        System.out.println(java.dateOfLastWeekGroup());
        java.deleteStudent("Петров");
        java.deleteStudent(1);
        java.printStudents(listJava);
        System.out.println("==============");

        System.out.println(java.checkStudent("Иванов"));

    }
}