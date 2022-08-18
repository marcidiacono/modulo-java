public class User implements Comparable<User> {
    
    private String firstName;
    private String lastName;
    private int age;
    
    @Override
    public int compareTo(User o) {
        return this.lastName.compareTo(o.lastName);
    }



}
