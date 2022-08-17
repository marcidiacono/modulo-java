public class User {

    private static Integer idAuto = 1;
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;

    public User() {
        this.id = idAuto;
        idAuto++;
    }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = idAuto;
        idAuto++;
    }

    public User(String firstName, String lastName, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.id = idAuto;
        idAuto++;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    
    public static User[] getAll() throws Exception {
        // Se llama al método que trae todos los usuarios
        // return DAOUser.getAll();
        return null;
    } 

    public boolean save() throws Exception {
        // Se llama al método que guarda el objeto
        // return DAOUser.save(this);
        return true;
    }


    @Override
    public String toString() {
        return this.firstName + "|" + this.lastName + "|" + (this.age != null ? this.age : "");
    }
    
}
