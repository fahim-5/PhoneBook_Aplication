package phonebook;

public class Person {
    private String name;
    private int id;
    private String address;

    public Person(String name, int id, String address) {
        this.name = name;
        this.id = id;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nPhone Number: " + id + "\nAddress: " + address;
    }
}
