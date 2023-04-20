package codeReview;

/**
 * public class User {
 * String name;
 * String edad;
 * Boolean married;

 * public User() {
 * super();
 * }
 * public Booleean getMarried() {
 * return this.married;
 * }
 * }

 * edad should be renamed to age since other fields are english.
 * Using the wrapper class unnecessarily can impact performance so Boolean should be changed to boolean to use the primitive type for the married variable.
 * The constructor can be safely removed as it's not needed since it doesn't do anything.
 * The getMarried() method has a typo in its name (Booleean instead of Boolean).
 * I would suggest adding a constructor that takes parameters for the name, age, and married fields, for easy initialization.
 * I would suggest adding setters for each of the fields, to allow for updating the values of the User object after it has been created.
 * See class below with the stated changes
 */

public class User {
    private String name;
    private int age;
    private boolean married;

    public User(String name, int age, boolean married) {
        this.name = name;
        this.age = age;
        this.married = married;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isMarried() {
        return married;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }
}


