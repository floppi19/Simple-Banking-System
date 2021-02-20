class User {
    private String firstName;
    private String lastName;

    public User() {
        this.firstName = "";
        this.lastName = "";
    }

    public void setFirstName(String firstName) {
        if (firstName != null) {
            this.firstName = firstName;
        } else {
            this.firstName = "";
        }
    }

    public void setLastName(String lastName) {
        if (lastName != null) {
            this.lastName = lastName;
        } else {
            this.lastName = "";
        }
    }

    public String getFullName() {
        if ("".equals(firstName) && "".equals(lastName)) {
            return "Unknown";
        } else if ("".equals(firstName)) {
            return lastName;
        } else if ("".equals(lastName)) {
            return firstName;
        } else {
            return firstName + " " + lastName;
        }
    }
}