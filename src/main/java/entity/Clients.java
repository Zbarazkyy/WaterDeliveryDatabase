package entity;

public class Clients {
    private int clientId;
    private String fName;
    private String lName;
    private String addressCity;
    private String addressStreet;
    private String addressHouse;
    private String addressFlat;
    private String addressNotes;
    private int phone1;
    private int phone2;
    private int phone3;
    private int userId;

    public Clients() {
    }

    public Clients(String fName, String lName, String addressCity, String addressStreet, String addressHouse, String addressFlat, String addressNotes, int phone1, int phone2, int phone3) {
        this.fName = fName;
        this.lName = lName;
        this.addressCity = addressCity;
        this.addressStreet = addressStreet;
        this.addressHouse = addressHouse;
        this.addressFlat = addressFlat;
        this.addressNotes = addressNotes;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.phone3 = phone3;
    }

    public Clients(String lName) {
        this.lName = lName;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public String getAddressHouse() {
        return addressHouse;
    }

    public void setAddressHouse(String addressHouse) {
        this.addressHouse = addressHouse;
    }

    public String getAddressFlat() {
        return addressFlat;
    }

    public void setAddressFlat(String addressFlat) {
        this.addressFlat = addressFlat;
    }

    public String getAddressNotes() {
        return addressNotes;
    }

    public void setAddressNotes(String addressNotes) {
        this.addressNotes = addressNotes;
    }

    public int getPhone1() {
        return phone1;
    }

    public void setPhone1(int phone1) {
        this.phone1 = phone1;
    }

    public int getPhone2() {
        return phone2;
    }

    public void setPhone2(int phone2) {
        this.phone2 = phone2;
    }

    public int getPhone3() {
        return phone3;
    }

    public void setPhone3(int phone3) {
        this.phone3 = phone3;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clients clients = (Clients) o;
        return phone1 == clients.phone1 && fName.equals(clients.fName) && lName.equals(clients.lName) && addressCity.equals(clients.addressCity) && addressStreet.equals(clients.addressStreet);
    }

    @Override
    public int hashCode() {
        int result = 31;
        result = 31 * result + ((phone1 != 0) ? phone1 : 0);
        result = 31 * result + ((fName != null) ? fName.hashCode() : 0);
        result = 31 * result + ((lName != null) ? lName.hashCode() : 0);
        result = 31 * result + ((addressCity != null) ? addressCity.hashCode() : 0);
        result = 31 * result + ((addressStreet != null) ? addressStreet.hashCode() : 0);
        return result;


    }
}
