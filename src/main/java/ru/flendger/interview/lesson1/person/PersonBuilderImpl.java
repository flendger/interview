package ru.flendger.interview.lesson1.person;

public class PersonBuilderImpl implements PersonBuilder<Person>{
    private String firstName;
    private String lastName;
    private String middleName;
    private String country;
    private String address;
    private String phone;
    private int age;
    private String gender;

    @Override
    public Person build() {
        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setMiddleName(middleName);
        person.setCountry(country);
        person.setAddress(address);
        person.setPhone(phone);
        person.setAge(age);
        person.setGender(gender);
        return person;
    }

    @Override
    public PersonBuilder<Person> setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Override
    public PersonBuilder<Person> setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Override
    public PersonBuilder<Person> setMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    @Override
    public PersonBuilder<Person> setCountry(String country) {
        this.country = country;
        return this;
    }

    @Override
    public PersonBuilder<Person> setAddress(String address) {
        this.address = address;
        return this;
    }

    @Override
    public PersonBuilder<Person> setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    @Override
    public PersonBuilder<Person> setAge(int age) {
        this.age = age;
        return this;
    }

    @Override
    public PersonBuilder<Person> setGender(String gender) {
        this.gender = gender;
        return this;
    }
}
