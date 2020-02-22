package person;

import java.text.SimpleDateFormat;
import java.util.*;

/*2) Написать класс "Группа", для отображения учебной группы в Hillel, который содержит поля:
    - название курса
    - дата старта занятий
    - суммарное количество занятий курса
    - количество занятий в неделю
    - список учащихся типа Person
    Написать методы:
    - метод который печатает название группы на основе даты старта и названия курса, например: "Java21.12"
    - печатает нумерованный список студентов, например:
    1.	Иванов
    2.	Петров
    3.	Сидоров
    - добавить студента
2.1*)
    - метод который выдает дату старта последней недели курса
    - удалить студента по фамилии или по номеру
    - узнать если ли студент с такой фамилией в группе
2.2*) Реализовать конструктор копирования для класса Person и Group
*/
public class Group {
    private String nameCourse;
    private String classStartDate;
    private int nuberLessOfCouerse;
    private int nuberLessOfWeek;
    private List<Person> list = new ArrayList<>();

    public Group(String nameCourse, String classStartDate, int nuberLessOfCouerse, int nuberLessOfWeek, List<Person> list) {
        this.nameCourse = nameCourse;
        this.classStartDate = classStartDate;
        this.nuberLessOfCouerse = nuberLessOfCouerse;
        this.nuberLessOfWeek = nuberLessOfWeek;
        this.list = list;
    }

    // Конструктор копирования
    public Group(Group otherGroup) {
        this(otherGroup.nameCourse, otherGroup.classStartDate, otherGroup.nuberLessOfCouerse, otherGroup.nuberLessOfWeek, otherGroup.list);
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    // название группы
    public String nameGroup() {
        return this.nameCourse + this.classStartDate.substring(3);
    }

    // нумерованный список студентов
    public void printStudents(List<Person> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + 1 + ". " + list.get(i).getSurName() + " " + list.get(i).getName());
        }

    }

    // добавить студента
    public void addStudent(Person person) {
        list.add(person);
    }

    // датa старта последней недели курса
    public String dateOfLastWeekGroup() {
        String[] tmpStr = this.classStartDate.split("\\.");
        int[] tmpInt = new int[tmpStr.length];
        for (int i = 0; i < tmpStr.length; i++) {
            tmpInt[i] = Integer.parseInt(tmpStr[i]);
        }
        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yy");
        Calendar calendar = new GregorianCalendar(tmpInt[2], tmpInt[1] - 1, tmpInt[0]);
        int week = this.nuberLessOfCouerse / this.nuberLessOfWeek - 1;
        calendar.add(Calendar.WEEK_OF_MONTH, +week);
        return "Дата старта последней недели курса: " + df.format(calendar.getTime());
    }

    // удалить студента по фамилии
    public void deleteStudent(String surName) {
        for (Person person : list) {
            if (person.getSurName().equals(surName)) {
                list.remove(person);
                break;
            }
        }
    }

    // удалить студента по номеру
    public void deleteStudent(int index) {
        list.remove(index-1);
    }

    // проверить студента по фамилии в группе
    public boolean checkStudent(String surName) {
        for (Person person : list) {
            if (person.getSurName().equals(surName)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return
                nameCourse + " " +
                        classStartDate + " " +
                        nuberLessOfCouerse + " " +
                        nuberLessOfWeek + " " +
                        list
                ;
    }
}
