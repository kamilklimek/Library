package pl.maniaq.library.model;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

/**
 *  This is a model class to hold user informations
 *
 *  @author maniaq
 */

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="login")
    private String login;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private char[] password;


    public User(String login, String email, char[] password) {
        this.login = login;
        this.email = email;
        this.password = password;
    }

    private class UserBuilder{

        private String login;
        private String email;
        private char[] password;


        public UserBuilder setLogin(String login){
            this.login=login;
            return this;
        }

        public UserBuilder setEmail(String email){
            this.email=email;
            return this;
        }

        public UserBuilder setPassword(char[] password){
            this.password=password;
            return this;
        }

        public User createUser(){
            return new User(login, email, password);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(login, user.login) &&
                Objects.equals(email, user.email) &&
                Arrays.equals(password, user.password);
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(id, login, email);
        result = 31 * result + Arrays.hashCode(password);
        return result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }
}
