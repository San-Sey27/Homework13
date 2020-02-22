package person;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/*1) Написать класс Person, у которого если следующие поля:
- Фамилия, Имя, Отчество, дата рождения.
Написать конструкторы:
- на все поля,
- только на ФИО
- который принимает 1 параметр - строку с полным именем "Иванов Иван Иванович", и задает отдельные значения в поля Фамилия, Имя, Отчество.
Написать методы:
- который возвращает полное ФИО типа "Иванов Иван Иванович"
- краткое ФИО типа "Иванов И. И."
- который на основе даты рождения выводит количество полных лет.

1.1*) Дата рождения задается как строка типа "18.12.1985"
*/

public class Person {
    private String name;
    private String surName;
    private String patronymic;
    private String dateOfBirth;

    public Person(String surName, String name, String patronymic, String dateOfBirth) {
        this.surName = surName;
        this.name = name;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
    }

    // Конструктор копирования
    public Person(Person otherPerson) {
        this(otherPerson.surName, otherPerson.name, otherPerson.patronymic, otherPerson.dateOfBirth);
    }

    public Person(String surName, String name, String patronymic) {
        this.surName = surName;
        this.name = name;
        this.patronymic = patronymic;
    }

    public Person(String AllName) {
        String[] tmp = AllName.split("\\s+");
        this.name = tmp[0];
        this.surName = tmp[1];
        this.patronymic = tmp[2];
    }

    public String AllName() {
        return this.surName + " " + this.name + " " + this.patronymic;
    }

    public String shortName() {
        return this.surName + " " + this.name.charAt(0) + ". " + this.patronymic.charAt(0) + ". ";
    }

    public String numberOfYears() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate startDate = LocalDate.parse(new SimpleDateFormat("dd.MM.yyyy").format(new Date()), df);
        LocalDate endDate = LocalDate.parse(this.dateOfBirth, df);
        Period period = Period.between(endDate, startDate);
        return "Полных лет: " + period.getYears();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return
                surName + ' ' +
                        name + ' ' +
                        patronymic + ' ' +
                        dateOfBirth;
    }
}
