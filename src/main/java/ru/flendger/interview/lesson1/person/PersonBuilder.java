package ru.flendger.interview.lesson1.person;

public interface PersonBuilder <T extends Person>{
    T build();
    PersonBuilder<T> setFirstName(String firstName);
    PersonBuilder<T> setLastName(String lastName);
    PersonBuilder<T> setMiddleName(String middleName);
    PersonBuilder<T> setCountry(String country);
    PersonBuilder<T> setAddress(String address);
    PersonBuilder<T> setPhone(String phone);
    PersonBuilder<T> setAge(int age);
    PersonBuilder<T> setGender(String gender);
}
