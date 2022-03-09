package usergroup.model;

import javax.persistence.*;

@Entity
@Table(name = "userList")
public class User {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "surname", nullable = false)
    private String surname;
    @Column(name = "birthYear", nullable = false)
    private int birthYear;

    public User() {
    }

    public User(int id, String name, String surname, int birthYear) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
    }

    @Override
    public String toString() {
        return "User " +
                "id = " + id +
                ", name = " + name + '\'' +
                ", surname = " + surname + '\'' +
                ", birthYear = " + birthYear
                ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }
}
