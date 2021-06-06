package ru.flendger.interview.lesson1.person;

public class PersonDemo {
    public static void main(String[] args) {
        PersonBuilder<Person> personBuilder = new PersonBuilderImpl();
        Person person = personBuilder.setFirstName("Иван")
                .setLastName("Иванов")
                .setMiddleName("Иванович")
                .setCountry("Russia")
                .setAddress("Local address")
                .setAge(25)
                .setPhone("+79999999")
                .setGender("male")
                .build();
        System.out.println(person);
    }
}
