package model;

import java.util.Objects;

public class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString(){
        return "User{"+
               "username:" + '\''+
               ", password ='" + password+'\''+
               "}";
   }

   public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof User)) return false;
        User user = (User)o;
        return Objects.equals(getUsername(), user.getUsername())&& Objects.equals(getPassword(), user.getPassword());
   }

   public int hashCode(){return Objects.hash(getUsername(), getPassword());};
}

