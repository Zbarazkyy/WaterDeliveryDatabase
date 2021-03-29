package entity;

public class Users {
    private int userId;
    private String userName;
    private String password;
    private boolean admin;

    public Users() {
    }

    public Users(int userId, String userName, String password, boolean admin) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.admin = admin;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() == this.getClass()) {
            Users users = (Users) obj;
            return users.userName.equals(userName);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 31;
        result = 31 * result + ((userName != null) ? userName.hashCode() : 0);
        return result;
    }

}
